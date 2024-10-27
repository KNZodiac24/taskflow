package vista;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class JFLogin extends JFrame {
    public JPLogin jPLogin;
    public JPCrearCuenta jPCrearCuenta;

    public JFLogin(){
        //initEstilo();

        this.setTitle("Iniciar sesión - TaskFlow");
        //this.getContentPane().setPreferredSize(new Dimension(500, 500));
        //this.getContentPane().setMinimumSize(new Dimension(600, 600));
        //this.setMinimumSize(new Dimension(600, 600));
        //this.getContentPane().setLayout(null);

        initComponentes();

        this.setResizable(false);
        this.pack();
        this.setLocationRelativeTo(null); 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initComponentes(){
        this.jPLogin = new JPLogin();
        this.jPCrearCuenta = new JPCrearCuenta();
        this.setContentPane(this.jPLogin);
    }

    private void initEstilo(){
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (UnsupportedLookAndFeelException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        } catch (InstantiationException e) {
            System.out.println(e);  
        } catch (IllegalAccessException e) {
            System.out.println(e);
        }
    }

    public void mostrar(){
        this.setVisible(true);
    }
}
