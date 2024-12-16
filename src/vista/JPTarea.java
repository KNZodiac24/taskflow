package vista;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import bd.TareaBD;
import controlador.TareaController;
import modelo.Tarea;
import utils.Fecha;

public class JPTarea extends JPanel {
    private JLabel jLNombreTarea;
    private JLabel jLDescripcion;
    private JLabel jLFechaCulminacion;
    public JSeparator jSSeparador;
    private Tarea tarea;
    private boolean haPasadoUnMinuto;
    private JLabel jLTareaCompletada;

    public JPTarea(Tarea tarea){
        this.setPreferredSize(new Dimension(1024, 75));
        this.setLayout(null);
        this.tarea = tarea;

        initComponentes();
        aplicarEstilos();
    }

    private void initComponentes(){
        // Mostrar el nombre de la tarea
        this.jLNombreTarea = new JLabel(this.tarea.getNombre());
        this.jLNombreTarea.setBounds(25, 8, 180, 60);
        this.jLNombreTarea.setFont(new Font("YouTube Sans Semibold", Font.BOLD, 14));
        this.add(this.jLNombreTarea);

        // Mostrar la descripción de la tarea
        this.jLDescripcion = new JLabel(this.tarea.getDescripcion());
        this.jLDescripcion.setBounds(225, 8, 508, 60);
        this.jLDescripcion.setFont(new Font("YouTube Sans", Font.PLAIN, 14));
        this.add(this.jLDescripcion);

        // Mostrar la fecha de culminación
        this.jLFechaCulminacion = new JLabel(this.tarea.darFechaDeCulminacion(), SwingConstants.RIGHT);
        this.jLFechaCulminacion.setBounds(753, 8, 119, 60);
        this.jLFechaCulminacion.setFont(new Font("YouTube Sans", Font.PLAIN, 14));
        this.add(this.jLFechaCulminacion);
        
        // Mostrar botón para completar la tarea
        this.jLTareaCompletada = new JLabel();
        this.jLTareaCompletada.setBounds(this.getWidth()-35, 25, 25, 25);
        String rutaCheck = System.getProperty("user.home")+File.separator+".taskflow"+File.separator+"rsc"+File.separator+"img"+File.separator+"check.png";
        setImageLabel(this.jLTareaCompletada, rutaCheck);
        this.jLTareaCompletada.setForeground(Color.GREEN);
        this.jLTareaCompletada.setToolTipText("Marcar tarea como completada.");
        this.jLTareaCompletada.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.add(this.jLTareaCompletada);
        this.jLTareaCompletada.setVisible(false);

        // Separador para distinguir los distintos elementos de la lista
        this.jSSeparador = new JSeparator(JSeparator.HORIZONTAL);
        this.jSSeparador.setBounds(10, 70, 877, 2);
        this.add(this.jSSeparador);
    }

    public void aplicarResponsive(){
        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                // Para el panel como tal
                setBounds(0, 0, getParent().getWidth(), 75);
               
                // Para el nombre de la tarea
                jLNombreTarea.setBounds((int)(getWidth()*0.05), 8, (int)(getWidth()*0.15), 60);

                // Para la descripción de la tarea
                jLDescripcion.setBounds(jLNombreTarea.getX()+jLNombreTarea.getWidth()+(int)(getWidth()*0.05), 8, (int)(getWidth()*0.5), 60);

                // Para la fecha de culminación
                jLFechaCulminacion.setBounds(jLDescripcion.getX()+jLDescripcion.getWidth()+(int)(getWidth()*0.05), 8, (int)(getWidth()*0.15), 60);

                // Para el botón de completar tarea
                jLTareaCompletada.setLocation(getWidth()-35, 25);

                // Para el separador 
                jSSeparador.setBounds(0, 73, getWidth(), 2);
            }
        });
    }

    private void aplicarEstilos(){ 
        // Verificamos si la tarea fue recién creada para destacarla
        if(Fecha.haPasadoUnMinuto(this.tarea.getFechaYHoraCreacion())){
            this.setBackground(Color.WHITE);
        }else{
            this.setBackground(new Color(242, 240, 90));
        }

        if(this.tarea.estaCompletada()) this.setBackground(new Color(54, 129, 169));
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e){
                if(Fecha.haPasadoUnMinuto(tarea.getFechaYHoraCreacion())) setBackground(new Color(245, 245, 245));
                else setBackground(new Color(201, 200, 131));
                
                
                if(tarea.estaCompletada()) {
                    setBackground(new Color(36, 85, 112));
                    jLTareaCompletada.setVisible(false);
                }else{
                    jLTareaCompletada.setVisible(true);
                }
                
            } 

            @Override
            public void mouseExited(MouseEvent e){
                if (Fecha.haPasadoUnMinuto(tarea.getFechaYHoraCreacion())) setBackground(Color.WHITE);
                else setBackground(new Color(242, 240, 90));

                
                if(tarea.estaCompletada()) {
                    setBackground(new Color(54, 129, 169));
                    jLTareaCompletada.setVisible(false);
                }else{
                    jLTareaCompletada.setVisible(false);
                }

            }

        });

        this.jLTareaCompletada.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                jLTareaCompletada.setVisible(true);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                jLTareaCompletada.setVisible(true);
            }
        });
    }

    public void aplicarAcciones(){
        this.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                JDVerTarea frmVerTarea = new JDVerTarea(tarea);
                frmVerTarea.mostrar();
            } 
        });

        this.jLTareaCompletada.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                int eleccion = JOptionPane.showConfirmDialog(null, "¿Deseas marcar como completada esta tarea?\n\nLas tareas completadas se eliminan de la lista de tareas pendientes", "Marcar tarea completada", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if(eleccion == JOptionPane.YES_OPTION){
                    try {
                        TareaBD tareaBD = new TareaBD();
                        tareaBD.actualizarTareaCompletada(tarea);
                        TareaController.cargarListaTareas();
                    } catch (SQLException ex){
                        System.out.println(ex);
                    }
                }
            }
        });
    }

    private void setImageLabel(JLabel labelname, String root){
        ImageIcon image = new ImageIcon(root);
        Icon icon = new ImageIcon(image.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH));
        labelname.setIcon(icon);
    }
}
