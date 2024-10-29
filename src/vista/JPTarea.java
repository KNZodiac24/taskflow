package vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import modelo.Tarea;

public class JPTarea extends JPanel {
    private JLabel jLNombreTarea;
    private JLabel jLDescripcion;
    private JLabel jLFechaCulminacion;
    private JSeparator jSSeparador;
    private Tarea tarea;

    public JPTarea(Tarea tarea){
        this.setPreferredSize(new Dimension(897, 75));
        this.setBackground(Color.WHITE);
        this.setLayout(null);
        this.tarea = tarea;

        initComponentes();
    }

    private void initComponentes(){
        // Mostrar el nombre de la tarea
        this.jLNombreTarea = new JLabel(this.tarea.getNombre());
        this.jLNombreTarea.setBounds(25, 8, 180, 60);
        this.jLNombreTarea.setFont(new Font("YouTube Sans Semibold", Font.BOLD, 14));
        this.add(this.jLNombreTarea);

        // Mostrar la descripción de la tarea
        this.jLDescripcion = new JLabel(this.tarea.getDescripcion(), SwingConstants.CENTER);
        //this.jLDescripcion.setBounds(225, 8, 508, 60);
        this.jLDescripcion.setFont(new Font("YouTube Sans", Font.PLAIN, 14));
        this.add(this.jLDescripcion);

        // Mostrar la fecha de culminación
        this.jLFechaCulminacion = new JLabel(this.tarea.darFechaDeCulminacion(), SwingConstants.RIGHT);
        //this.jLFechaCulminacion.setBounds(753, 8, 119, 60);
        this.jLFechaCulminacion.setFont(new Font("YouTube Sans", Font.PLAIN, 14));
        this.add(this.jLFechaCulminacion);

        // Separador para distinguir los distintos elementos de la lista
        this.jSSeparador = new JSeparator(JSeparator.HORIZONTAL);
        //this.jSSeparador.setBounds(10, 70, 877, 2);
        this.add(this.jSSeparador);
    }

    public void aplicarResponsive(int auxEspaciado){
        this.getParent().addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                // Para el panel como tal
                setBounds(0, auxEspaciado, getParent().getWidth(), 75);
                
                // Para el nombre de la tarea
                jLNombreTarea.setSize((int)(getWidth()*0.2), 60);

                // Para la descripción de la tarea
                jLDescripcion.setBounds(jLNombreTarea.getX()+jLNombreTarea.getWidth()+20, 8, (int)(getWidth()*0.8), 60);

                // Para la fecha de culminación
                jLFechaCulminacion.setBounds(jLDescripcion.getX()+jLDescripcion.getWidth()+20, 8, (int)(getWidth()*0.2), 60);

                // Para el separador 
                jSSeparador.setBounds(10, 70, getWidth()-10, 2);
            }
        });
    }

}
