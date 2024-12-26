package modelo;

import utils.Configuracion;
import vista.JFLogin;

public class Principal {
    public static void main(String[] args) throws Exception {

        JFLogin frmLogin = new JFLogin();
        Configuracion config = Configuracion.getInstancia(frmLogin.jPSplash);
        frmLogin.mostrar();
        config.configurarPrograma();

    }
}
