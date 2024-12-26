package vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import modelo.Usuario;

public class JFTaskFlow extends JFrame {
    private JLabel jLMensajeBienvenida;
    private JLabel jLNombreApp;
    public JTextPane jTPListaTareas;
    private JLabel jLDescripcionLista;
    public JScrollPane jSPScrollLista;
    public JButton jBAgregar;
    private Usuario usuarioActual;
    public JLabel jLListaSinElementos;
    public JComboBox<String> jCBOrdenLista;

    public JFTaskFlow(Usuario usuarioActual){

        initEstilo();

        this.setTitle("TaskFlow");
        this.getContentPane().setPreferredSize(new Dimension(1280, 720));
        this.getContentPane().setMinimumSize(new Dimension(600, 600));
        this.setMinimumSize(new Dimension(600, 600));
        this.getContentPane().setLayout(null);
        this.getContentPane().setBackground(Color.WHITE);

        this.usuarioActual = usuarioActual;
        initComponentes();

        this.setResizable(true);
        this.pack();
        this.setLocationRelativeTo(null); 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setIconImage(new ImageIcon("rsc/img/logo.png").getImage());

        aplicarResponsive();
    } 

    private void initComponentes(){
        // Mensaje de bienvenida
        this.jLMensajeBienvenida = new JLabel("Bienvenido/a, "+usuarioActual.getNombrePreferido(), SwingConstants.RIGHT);
        this.jLMensajeBienvenida.setBounds(0, 15, 1250, 25);
        this.jLMensajeBienvenida.setFont(new Font("YouTube Sans Semibold", Font.BOLD, 20));
        this.add(this.jLMensajeBienvenida);

        // Título con el nombre de la app
        this.jLNombreApp = new JLabel("TaskFlow", SwingConstants.CENTER);
        this.jLNombreApp.setBounds(0, 50, 1280, 80);
        this.jLNombreApp.setFont(new Font("Remachine Script Personal Use", Font.PLAIN, 100));
        this.add(this.jLNombreApp);

        // Descripción de la Lista
        this.jLDescripcionLista = new JLabel("Lista de tareas pendientes:");
        this.jLDescripcionLista.setBounds(192, 150, 225, 40);
        this.jLDescripcionLista.setFont(new Font("YouTube Sans", Font.PLAIN, 20));
        this.jLDescripcionLista.setVerticalAlignment(SwingConstants.CENTER);
        this.jLDescripcionLista.setHorizontalAlignment(SwingConstants.LEFT);
        this.add(this.jLDescripcionLista);

        // Ordenar la lista
        this.jCBOrdenLista = new JComboBox<String>();
        this.jCBOrdenLista.addItem("Fecha (ascendente)");
        this.jCBOrdenLista.addItem("Fecha (descendente)");
        this.jCBOrdenLista.addItem("Rango de fechas");
        this.jCBOrdenLista.setBounds(425, 150, 155, 40);
        this.jCBOrdenLista.setFocusable(false);
        this.jCBOrdenLista.setFont(new Font("YouTube Sans", Font.PLAIN, 15));
        this.add(this.jCBOrdenLista);

        // Botón para agregar tareas
        this.jBAgregar = new JButton("Agregar");
        this.jBAgregar.setBounds(988, 150, 100, 40);
        this.jBAgregar.setFocusable(false);
        this.jBAgregar.setFont(new Font("YouTube Sans Semibold", Font.BOLD, 16));
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
    
        // Mensaje cuando no hay elementos en la lista
        this.jLListaSinElementos = new JLabel("No se han encontrado tareas pendientes.", SwingConstants.CENTER);
        this.jLListaSinElementos.setBounds(0,(int)(this.jTPListaTareas.getHeight()/2)-20, this.jTPListaTareas.getWidth(), 40);
        this.jLListaSinElementos.setFont(new Font("YouTube Sans Semibold", Font.BOLD, 30));
        this.jLListaSinElementos.setForeground(Color.GRAY);
        this.jLListaSinElementos.setVisible(false);
        this.jTPListaTareas.add(this.jLListaSinElementos);
    }

    private void aplicarResponsive(){
        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e){
                // Para el mensaje de bienvenida            
                jLMensajeBienvenida.setSize(getContentPane().getWidth()-30, 25);

                // Para el título con el nombre
                jLNombreApp.setSize(getContentPane().getWidth(), 80);

                // Para la lista de tareas pendientes
                jSPScrollLista.setBounds((int)(getContentPane().getWidth()*0.1),
                                         200,
                                         (int)(getContentPane().getWidth()*0.8),
                                         getContentPane().getHeight()-210);
                
                jTPListaTareas.setBounds(0, 0,
                                         jSPScrollLista.getWidth(),
                                         getContentPane().getHeight()-210);                
    
                // Para la descripción de la lista
                jLDescripcionLista.setBounds(jSPScrollLista.getX(), 150, 225, 40);

                // Para el criterio de ordenación
                jCBOrdenLista.setLocation(jLDescripcionLista.getX()+jLDescripcionLista.getWidth()+5, 150);

                // Para el botón de agregar tarea
                jBAgregar.setLocation(jSPScrollLista.getX()+jSPScrollLista.getWidth()-100, 150);

                // Para el mensaje de lista sin elementos
                jLListaSinElementos.setBounds(0, (int)(jSPScrollLista.getHeight()/2)-20, jSPScrollLista.getWidth(), 40);
            }
        });    
    }

    private void initEstilo(){
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            System.out.println(e);
        }
    }

    public Usuario getUsuarioActual(){
        return this.usuarioActual;
    }

    public void mostrar(){
        this.setVisible(true);
    }
}
