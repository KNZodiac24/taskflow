package vista;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.font.TextAttribute;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JToolTip;
import javax.swing.SwingConstants;


public class JPCrearCuenta extends JPanel{
    public JLabel jLRegresar;
    public JTextField jTFNuevoUsername;
    public JTextField jTFNuevoNombrePreferido;
    public JPasswordField jPFNuevaContrasenia;
    public JButton jBCrearCuenta;
    
    public JPCrearCuenta(){
        this.setPreferredSize(new Dimension(500, 500));
        this.setBackground(Color.WHITE);
        this.setLayout(null);

        initComponentes();
    }

    private void initComponentes(){
        //////////// Cargar las fuentes
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        try {
            File f = new File("rsc/fuentes/YouTubeSansMedium.otf");
            Font fuente = Font.createFont(Font.TRUETYPE_FONT, f);
            ge.registerFont(fuente);
 
            f = new File("rsc/fuentes/YouTubeSansSemibold.otf");
            fuente = Font.createFont(Font.TRUETYPE_FONT, f);
            ge.registerFont(fuente);
        } catch (Exception e){
            System.out.println(e);
        }

        //////////// Opción para regresar al inicio de sesión
        this.jLRegresar = new JLabel("< Regresar");
        this.jLRegresar.setBounds(30, 25, 100, 20);
        this.jLRegresar.setFont(new Font("YouTube Sans", Font.PLAIN, 14));
        this.jLRegresar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        Map<TextAttribute, Integer> atributosDeFuente = new HashMap<TextAttribute, Integer>();
        atributosDeFuente.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        this.jLRegresar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e){
                jLRegresar.setFont(new Font("YouTube Sans", Font.PLAIN, 14).deriveFont(atributosDeFuente));
            }

            @Override
            public void mouseExited(MouseEvent e){
                jLRegresar.setFont(new Font("YouTube Sans", Font.PLAIN, 14));
            }

            @Override
            public void mouseReleased(MouseEvent e){
                jLRegresar.setFont(new Font("YouTube Sans", Font.PLAIN, 14));
            }
        });
        this.add(this.jLRegresar);

        //////////// Ingreso de nuevo nombre de usuario
        JLabel jLUsername = new JLabel("Nombre de usuario");
        jLUsername.setBounds(75, 100, 350, 20);
        jLUsername.setFont(new Font("YouTube Sans", Font.PLAIN, 20));
        this.add(jLUsername);

        this.jTFNuevoUsername = new JTextField();
        this.jTFNuevoUsername.setBounds(75, 135, 350, 40);
        this.jTFNuevoUsername.setFont(new Font("YouTube Sans", Font.PLAIN, 20));
        this.add(this.jTFNuevoUsername);

        //////////// Ingreso de nombre preferido
        JLabel jLNombrePreferido = new JLabel("Nombre preferido");
        jLNombrePreferido.setBounds(75, 190, 175, 20);
        jLNombrePreferido.setFont(new Font("YouTube Sans", Font.PLAIN, 20));
        this.add(jLNombrePreferido);
        JLabel jLInfo = new JLabel("\u24d8");
        jLInfo.setBounds(230, 190, 25, 20);
        jLInfo.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
        jLInfo.setToolTipText("Es el nombre con el que te gusta que te llamen");
        this.add(jLInfo);

        this.jTFNuevoNombrePreferido = new JTextField();
        this.jTFNuevoNombrePreferido.setBounds(75, 225, 350, 40);
        this.jTFNuevoNombrePreferido.setFont(new Font("YouTube Sans", Font.PLAIN, 20));
        this.add(this.jTFNuevoNombrePreferido);

        //////////// Ingreso de nueva contraseña
        JLabel jLNuevaContrasenia = new JLabel("Contraseña");
        jLNuevaContrasenia.setBounds(75, 280, 350, 20);
        jLNuevaContrasenia.setFont(new Font("YouTube Sans", Font.PLAIN, 20));
        this.add(jLNuevaContrasenia);

        this.jPFNuevaContrasenia = new JPasswordField();
        this.jPFNuevaContrasenia.setBounds(75, 315, 298, 40);
        this.jPFNuevaContrasenia.setFont(new Font("Arial", Font.PLAIN, 20));
        this.add(this.jPFNuevaContrasenia);

        JLabel jLVerContrasenia = new JLabel();
        jLVerContrasenia.setBounds(380, 320, 30, 30);
        setImageLabel(jLVerContrasenia, "rsc/img/esconder.png");
        jLVerContrasenia.setHorizontalAlignment(SwingConstants.CENTER);
        jLVerContrasenia.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                setImageLabel(jLVerContrasenia, "rsc/img/mostrar.png");
                jPFNuevaContrasenia.setFont(new Font("YouTube Sans", Font.PLAIN, 20));
                jPFNuevaContrasenia.setEchoChar((char)0);               
            }

            @Override
            public void mouseExited(MouseEvent e){
                setImageLabel(jLVerContrasenia, "rsc/img/esconder.png");
                jPFNuevaContrasenia.setFont(new Font("Arial", Font.PLAIN, 20));
                jPFNuevaContrasenia.setEchoChar('•');
            }
        });
        this.add(jLVerContrasenia);

        // Botón para crear cuenta
        this.jBCrearCuenta = new JButton("Crear Cuenta");
        this.jBCrearCuenta.setBounds(183, 380, 135, 50);
        this.jBCrearCuenta.setFont(new Font("YouTube Sans Semibold", Font.BOLD, 17));
        this.jBCrearCuenta.setFocusable(false);
        this.jBCrearCuenta.setBackground(Color.BLUE);
        this.jBCrearCuenta.setForeground(Color.WHITE);
        this.add(this.jBCrearCuenta);
    }

    private void setImageLabel(JLabel labelname, String root){
        ImageIcon image = new ImageIcon(root);
        Icon icon = new ImageIcon(image.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));
        labelname.setIcon(icon);
    }
}
