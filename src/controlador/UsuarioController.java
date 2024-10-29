package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

import bd.TareaBD;
import bd.UsuarioBD;
import controlador.TareaController;
import modelo.Usuario;
import vista.JDAgregarTarea;
import vista.JFLogin;
import vista.JFTaskFlow;
import vista.JPCrearCuenta;

public class UsuarioController implements ActionListener{
    private JFLogin frmLogin;
    private UsuarioBD usuarioBD;

    public UsuarioController(JFLogin frmLogin, UsuarioBD usuarioBD){
        this.frmLogin = frmLogin;
        this.usuarioBD = usuarioBD;
        this.frmLogin.jPLogin.jBIniciarSesion.addActionListener(this);
        this.frmLogin.jPLogin.jLCrearCuenta.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frmLogin.remove(frmLogin.jPLogin);
                frmLogin.setContentPane(frmLogin.jPCrearCuenta);
                frmLogin.setTitle("Crear cuenta - TaskFlow");
                frmLogin.revalidate();
            }
        });

        this.frmLogin.jPCrearCuenta.jBCrearCuenta.addActionListener(this);
        this.frmLogin.jPCrearCuenta.jLRegresar.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                frmLogin.remove(frmLogin.jPCrearCuenta);
                frmLogin.setContentPane(frmLogin.jPLogin);
                frmLogin.setTitle("Iniciar sesión - TaskFlow");
                frmLogin.revalidate();
            }
        });
    }
   
    @Override
    public void actionPerformed(ActionEvent e) {
        // Si presionó en el botón de Ingresar
        if(e.getSource() == frmLogin.jPLogin.jBIniciarSesion){
            String username = frmLogin.jPLogin.jTFUsername.getText();
            String contrasenia = String.valueOf(frmLogin.jPLogin.jPFContrasenia.getPassword());
        
            if(usuarioBD.validarExistencia(username, contrasenia)){
                Usuario usuarioActual = new Usuario();
                usuarioActual.obtenerDatos(username);
                JFTaskFlow frmTaskFlow = new JFTaskFlow(usuarioActual);
                JDAgregarTarea dialogAgregarTarea = new JDAgregarTarea();
                TareaBD tareaBD = new TareaBD();
                TareaController tareaCtr = new TareaController(frmTaskFlow, dialogAgregarTarea, tareaBD);
                frmLogin.dispose();
                frmTaskFlow.mostrar();
            }else{
                JOptionPane.showMessageDialog(null, "Nombre de usuario o contraseña incorrectos.", "Inicio de sesión", JOptionPane.ERROR_MESSAGE);
                frmLogin.jPLogin.jTFUsername.requestFocus();
            }
        }

        // Si presionó en el botón de Crear Cuenta
        if(e.getSource() == frmLogin.jPCrearCuenta.jBCrearCuenta){
            String nuevoUsername = frmLogin.jPCrearCuenta.jTFNuevoUsername.getText();
            String nuevoNombrePreferido = frmLogin.jPCrearCuenta.jTFNuevoNombrePreferido.getText();
            String nuevaContrasenia = String.valueOf(frmLogin.jPCrearCuenta.jPFNuevaContrasenia.getPassword());
        
            if(usuarioBD.registrarUsuario(nuevoUsername, nuevoNombrePreferido, nuevaContrasenia)){
                JOptionPane.showMessageDialog(null, "¡Creación de cuenta exitosa!", "Creación de cuenta", JOptionPane.INFORMATION_MESSAGE);
                frmLogin.jPCrearCuenta.jTFNuevoUsername.setText("");
                frmLogin.jPCrearCuenta.jTFNuevoNombrePreferido.setText("");
                frmLogin.jPCrearCuenta.jPFNuevaContrasenia.setText("");
                frmLogin.remove(frmLogin.jPCrearCuenta);
                frmLogin.setContentPane(frmLogin.jPLogin);
                frmLogin.revalidate();
            }else{
                JOptionPane.showMessageDialog(null, "No se pudo crear la cuenta.", "Creación de cuenta", JOptionPane.ERROR_MESSAGE);
                frmLogin.jPCrearCuenta.jTFNuevoUsername.setText("");
                frmLogin.jPCrearCuenta.jTFNuevoNombrePreferido.setText("");
                frmLogin.jPCrearCuenta.jPFNuevaContrasenia.setText("");
                frmLogin.jPCrearCuenta.jTFNuevoUsername.requestFocus();
            }
        }
    }
}
