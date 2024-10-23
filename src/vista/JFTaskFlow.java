package vista;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.Insets;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.File;
import java.io.InputStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.Border;

import com.sun.tools.javac.Main;

public class JFTaskFlow extends JFrame {
    private JLabel jLNombreApp;
    private JTextPane jTPListaTareas;
    private JLabel jLDescripcionLista;
    private JScrollPane jSPScrollLista;
    public JButton jBAgregar;

    public JFTaskFlow(){

        initEstilo();

        this.setTitle("TaskFlow");
        this.getContentPane().setPreferredSize(new Dimension(1280, 720));
        this.getContentPane().setMinimumSize(new Dimension(600, 600));
        this.setMinimumSize(new Dimension(600, 600));
        this.getContentPane().setLayout(null);

        initComponentes();

        this.setResizable(true);
        this.pack();
        this.setLocationRelativeTo(null); 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        aplicarResponsive();
    } 

    private void initComponentes(){
        // Título con el nombre de la app
        this.jLNombreApp = new JLabel("TaskFlow", SwingConstants.CENTER);
        this.jLNombreApp.setBounds(0, 50, 1280, 80);
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        try {
            File f = new File("rsc/fuentes/RemachineScript.ttf");
            Font fuente = Font.createFont(Font.TRUETYPE_FONT, f);
            ge.registerFont(fuente);
            this.jLNombreApp.setFont(new Font("Remachine Script Personal Use", Font.PLAIN, 100));
        } catch (Exception e){
            System.out.println(e);
        }
        this.add(this.jLNombreApp);

        // Descripción de la Lista
        this.jLDescripcionLista = new JLabel("Lista de tareas pendientes:");
        this.jLDescripcionLista.setBounds(192, 150, 896, 40);
        this.jLDescripcionLista.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
        this.jLDescripcionLista.setVerticalAlignment(SwingConstants.CENTER);
        this.jLDescripcionLista.setHorizontalAlignment(SwingConstants.LEFT);
        this.add(this.jLDescripcionLista);

        // Botón para agregar tareas
        this.jBAgregar = new JButton("Agregar");
        this.jBAgregar.setBounds(988, 150, 100, 40);
        this.jBAgregar.setFocusable(false);
        this.jBAgregar.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 16));
        this.add(this.jBAgregar);

        // Lista de tareas pendientes
        this.jTPListaTareas = new JTextPane();
        this.jTPListaTareas.setBounds(128, 200, 896, 510);
        this.jTPListaTareas.setEditable(false);
        this.jTPListaTareas.setFocusable(false);
        this.jSPScrollLista = new JScrollPane(this.jTPListaTareas);
        this.jSPScrollLista.setBounds(this.jTPListaTareas.getBounds());
        this.jSPScrollLista.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        this.jSPScrollLista.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        this.jSPScrollLista.setBorder(null);
        this.add(this.jSPScrollLista);
    }

    private void aplicarResponsive(){
        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e){
                // Para el título con el nombre
                jLNombreApp.setSize(getContentPane().getWidth(), 80);

                // Para la lista de tareas pendientes
                jSPScrollLista.setBounds((int)(getContentPane().getWidth()*0.1),
                                         200,
                                         (int)(getContentPane().getWidth()*0.8),
                                         getContentPane().getHeight()-210);
                
                jTPListaTareas.setBounds(0, 0,
                                         (int)(getContentPane().getWidth()*0.8),
                                         getContentPane().getHeight()-210);                
    
                // Para la descripción de la lista
                jLDescripcionLista.setBounds(jSPScrollLista.getX(), 150, jSPScrollLista.getWidth(), 40);

                // Para el botón de agregar tarea
                jBAgregar.setLocation(jSPScrollLista.getX()+jSPScrollLista.getWidth()-100, 150);
            }
        });    
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
