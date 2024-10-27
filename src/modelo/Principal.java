package modelo;

import controlador.TareaController;
import controlador.UsuarioController;
import vista.JDAgregarTarea;
import vista.JFLogin;
import vista.JFTaskFlow;

public class Principal {
    public static void main(String[] args) {
        JFLogin frmLogin = new JFLogin();
        JFTaskFlow frmTaskFlow = new JFTaskFlow();
        JDAgregarTarea dialogAgregarTarea = new JDAgregarTarea();
        TareaController tareaCtr = new TareaController(frmTaskFlow, dialogAgregarTarea);
        UsuarioController usuarioCtr = new UsuarioController(frmLogin);

        frmLogin.mostrar();
    }
}
