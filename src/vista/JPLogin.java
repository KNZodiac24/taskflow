package vista;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.font.TextAttribute;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

public class JPLogin extends JPanel{
    public JTextField jTFUsername;
    public JPasswordField jPFContrasenia;
    public JButton jBIniciarSesion;
    public JLabel jLCrearCuenta;

    public JPLogin(){
        this.setPreferredSize(new Dimension(500, 500));
        this.setBackground(Color.WHITE);
        this.setLayout(null);

        initComponentes();
    }

    private void initComponentes(){
        //////////// Titulo    
        JLabel jLNombreApp = new JLabel("TaskFlow", SwingConstants.CENTER);
        jLNombreApp.setBounds(75, 38, 350, 100);
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        try {
            File f = new File("rsc/fuentes/RemachineScript.ttf");
            Font fuente = Font.createFont(Font.TRUETYPE_FONT, f);
            ge.registerFont(fuente);

            f = new File("rsc/fuentes/YouTubeSansMedium.otf");
            fuente = Font.createFont(Font.TRUETYPE_FONT, f);
            ge.registerFont(fuente);
 
            f = new File("rsc/fuentes/YouTubeSansSemibold.otf");
            fuente = Font.createFont(Font.TRUETYPE_FONT, f);
            ge.registerFont(fuente);
        } catch (Exception e){
            System.out.println(e);
        }
        jLNombreApp.setFont(new Font("Remachine Script Personal Use", Font.PLAIN, 100));
        jLNombreApp.setForeground(Color.BLACK);
        this.add(jLNombreApp);

        //////////// Ingreso de nombre de usuario
        JLabel jLUsername = new JLabel("Nombre de usuario");
        jLUsername.setBounds(75, 160, 350, 20);
        jLUsername.setFont(new Font("YouTube Sans", Font.PLAIN, 20));
        this.add(jLUsername);

        this.jTFUsername = new JTextField();
        this.jTFUsername.setBounds(75, 195, 350, 40);
        this.jTFUsername.setFont(new Font("YouTube Sans", Font.PLAIN, 20));
        this.jTFUsername.setMargin(new Insets(0, 10, 0, 0));
        this.add(this.jTFUsername);

        //////////// Ingreso de contraseña
        JLabel jLContrasenia = new JLabel("Contraseña");
        jLContrasenia.setBounds(75, 250, 350, 20);
        jLContrasenia.setFont(new Font("YouTube Sans", Font.PLAIN, 20));
        this.add(jLContrasenia);

        this.jPFContrasenia = new JPasswordField();
        this.jPFContrasenia.setBounds(75, 285, 298, 40);
        this.jPFContrasenia.setFont(new Font("Arial", Font.PLAIN, 20));
        this.jPFContrasenia.setMargin(new Insets(0, 10, 0, 0));
        this.add(this.jPFContrasenia);

        JLabel jLVerContrasenia = new JLabel();
        jLVerContrasenia.setBounds(385, 290, 30, 30);
        setImageLabel(jLVerContrasenia, "rsc/img/esconder.png");
        jLVerContrasenia.setHorizontalAlignment(SwingConstants.CENTER);
        jLVerContrasenia.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                setImageLabel(jLVerContrasenia, "rsc/img/mostrar.png");
                jPFContrasenia.setFont(new Font("YouTube Sans", Font.PLAIN, 20));
                jPFContrasenia.setEchoChar((char)0);
            }

            @Override
            public void mouseExited(MouseEvent e){
                setImageLabel(jLVerContrasenia, "rsc/img/esconder.png");
                jPFContrasenia.setFont(new Font("Arial", Font.PLAIN, 20));
                jPFContrasenia.setEchoChar('•');
            }
        });
        this.add(jLVerContrasenia);
        
        //////////// Botón para iniciar sesión
        this.jBIniciarSesion = new JButton("Ingresar");
        this.jBIniciarSesion.setBounds(187, 350, 125, 50);
        this.jBIniciarSesion.setFont(new Font("YouTube Sans Semibold", Font.BOLD, 17));
        this.jBIniciarSesion.setBackground(Color.BLUE);
        this.jBIniciarSesion.setForeground(Color.WHITE);
        this.jBIniciarSesion.setFocusable(false);
        this.add(this.jBIniciarSesion);
    
        //////////// Opción para crear cuenta
        this.jLCrearCuenta = new JLabel("¿Eres nuevo/a? ¡Crea una cuenta!", SwingConstants.CENTER);
        this.jLCrearCuenta.setBounds(75, 420, 350, 20);
        this.jLCrearCuenta.setFont(new Font("YouTube Sans", Font.PLAIN, 14));
        this.jLCrearCuenta.setCursor(new Cursor(Cursor.HAND_CURSOR));
        Map<TextAttribute, Integer> atributosDeFuente = new HashMap<TextAttribute, Integer>();
        atributosDeFuente.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        this.jLCrearCuenta.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e){
                jLCrearCuenta.setFont(new Font("YouTube Sans", Font.PLAIN, 14).deriveFont(atributosDeFuente));
            }

            @Override
            public void mouseExited(MouseEvent e){
                jLCrearCuenta.setFont(new Font("YouTube Sans", Font.PLAIN, 14));
            }

            @Override
            public void mouseReleased(MouseEvent e){
                jLCrearCuenta.setFont(new Font("YouTube Sans", Font.PLAIN, 14));
            }
        });
        this.add(this.jLCrearCuenta);
    }

    private void setImageLabel(JLabel labelname, String root){
        ImageIcon image = new ImageIcon(root);
        Icon icon = new ImageIcon(image.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));
        labelname.setIcon(icon);
    }
}
