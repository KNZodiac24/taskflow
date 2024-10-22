package vista;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class JPTarea extends JPanel {
    private JLabel jLNombreTarea;
    private JLabel jLDescripcion;
    private JLabel jLFechaCulminacion;

    public JPTarea(){
    
    }

    private void initComponentes(){
        // TODO: Obtener la info de las tareas con la bd/controlador
        this.jLNombreTarea = new JLabel();
    } 
}
