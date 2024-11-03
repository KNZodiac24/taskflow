package vista;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import modelo.Tarea;
import utils.Fecha;

public class JPTarea extends JPanel {
    private JLabel jLNombreTarea;
    private JLabel jLDescripcion;
    private JLabel jLFechaCulminacion;
    public JSeparator jSSeparador;
    private Tarea tarea;
    private boolean haPasadoUnMinuto;

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
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e){
                if(Fecha.haPasadoUnMinuto(tarea.getFechaYHoraCreacion())) setBackground(new Color(245, 245, 245));
                else setBackground(new Color(201, 200, 131));
            }

            @Override
            public void mouseExited(MouseEvent e){
                if (Fecha.haPasadoUnMinuto(tarea.getFechaYHoraCreacion())) setBackground(Color.WHITE);
                else setBackground(new Color(242, 240, 90));
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
    }
}
