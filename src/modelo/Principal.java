package modelo;

import bd.UsuarioBD;
import controlador.TareaController;
import controlador.UsuarioController;
import vista.JDAgregarTarea;
import vista.JFLogin;
import vista.JFTaskFlow;

public class Principal {
    public static void main(String[] args) {
        JFLogin frmLogin = new JFLogin();
        UsuarioBD usuarioBD = new UsuarioBD(); 
        UsuarioController usuarioCtr = new UsuarioController(frmLogin, usuarioBD);

        frmLogin.mostrar();
    }
}
