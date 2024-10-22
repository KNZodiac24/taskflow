package modelo;

import controlador.TareaController;
import vista.JDAgregarTarea;
import vista.JFTaskFlow;

public class Principal {
    public static void main(String[] args) {
        JFTaskFlow frmTaskFlow = new JFTaskFlow();
        JDAgregarTarea dialogAgregarTarea = new JDAgregarTarea();
        TareaController tareaCtr = new TareaController(frmTaskFlow, dialogAgregarTarea);

        frmTaskFlow.mostrar();
    }
}
