package vista;

import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import bd.UsuarioBD;
import controlador.UsuarioController;

public class JFLogin extends JFrame {
    public JPLogin jPLogin;
    public JPCrearCuenta jPCrearCuenta;
    public JPSplash jPSplash;

    public JFLogin(){
        this.setTitle("Iniciar sesión - TaskFlow");

        initComponentes();

        this.setResizable(false);
        this.pack();
        this.setLocationRelativeTo(null); 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setIconImage(new ImageIcon(System.getProperty("user.home")+File.separator+".taskflow"+File.separator+"rsc"+File.separator+"img"+File.separator+"logo.png").getImage());   
    }

    private void initComponentes(){
        this.jPSplash = new JPSplash(this);
        this.jPCrearCuenta = new JPCrearCuenta();
        this.setContentPane(this.jPSplash);
    }

    public void mostrar(){
        this.setVisible(true);
    }

    public void configPanelLogin(){
        this.jPLogin = new JPLogin();
        this.setContentPane(this.jPLogin);
        this.revalidate();
        this.repaint();

        new UsuarioController(this, new UsuarioBD());
    }
}
