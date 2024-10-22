package vista;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;

public class JPTarea extends JPanel {
    private JLabel jLNombreTarea;
    private JLabel jLDescripcion;
    private JLabel jLFechaCulminacion;
    private JSeparator jSSeparador;

    public JPTarea(){
        this.setPreferredSize(new Dimension(897, 75));
    }

    private void initComponentes(){
        // TODO: Obtener la info de las tareas con la bd/controlador
        this.jLNombreTarea = new JLabel();
    } 
}
