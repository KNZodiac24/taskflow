package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import vista.JFLogin;
import vista.JPCrearCuenta;

public class UsuarioController implements ActionListener{
    private JFLogin frmLogin;

    public UsuarioController(JFLogin frmLogin){
        this.frmLogin = frmLogin;
        this.frmLogin.jPLogin.jBIniciarSesion.addActionListener(this);
        this.frmLogin.jPLogin.jLCrearCuenta.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frmLogin.remove(frmLogin.jPLogin);
                frmLogin.setContentPane(frmLogin.jPCrearCuenta);
                frmLogin.revalidate();
            }
        });

        this.frmLogin.jPCrearCuenta.jBCrearCuenta.addActionListener(this);
        this.frmLogin.jPCrearCuenta.jLRegresar.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                frmLogin.remove(frmLogin.jPCrearCuenta);
                frmLogin.setContentPane(frmLogin.jPLogin);
                frmLogin.revalidate();
            }
        });
    }
   
    @Override
    public void actionPerformed(ActionEvent e) {
        // Si presionó en el boton de Ingresar
        if(e.getSource() == frmLogin.jPLogin.jBIniciarSesion){
            System.out.println("crear cuenta");
        } 
    }
}
