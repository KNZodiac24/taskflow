package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.JDAgregarTarea;
import vista.JFTaskFlow;

public class TareaController implements ActionListener{
    
    private JFTaskFlow frmTaskFlow;
    private JDAgregarTarea frmAgregarTarea;

    public TareaController(JFTaskFlow frmTaskFlow, JDAgregarTarea frmAgregarTarea){
        this.frmTaskFlow = frmTaskFlow;
        this.frmAgregarTarea = frmAgregarTarea;
        this.frmTaskFlow.jBAgregar.addActionListener(this);
        //this.frmAgregarTarea.jBAgregarTarea.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        // Si se presionó el botón Agregar en la vista principal
        if(e.getSource() == frmTaskFlow.jBAgregar){
            JDAgregarTarea frmAgregar = new JDAgregarTarea();
            frmAgregar.mostrar();
        }
    }
}
