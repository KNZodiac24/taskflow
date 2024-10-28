package vista;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class JFLogin extends JFrame {
    public JPLogin jPLogin;
    public JPCrearCuenta jPCrearCuenta;

    public JFLogin(){
        this.setTitle("Iniciar sesión - TaskFlow");

        initComponentes();

        this.setResizable(false);
        this.pack();
        this.setLocationRelativeTo(null); 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setIconImage(new ImageIcon("rsc/img/icono.png").getImage());   
    }

    private void initComponentes(){
        this.jPLogin = new JPLogin();
        this.jPCrearCuenta = new JPCrearCuenta();
        this.setContentPane(this.jPLogin);
    }

    public void mostrar(){
        this.setVisible(true);
    }
}
