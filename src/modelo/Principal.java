package modelo;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import bd.UsuarioBD;
import controlador.UsuarioController;
import utils.Configuracion;
import vista.JFLogin;

public class Principal {
    public static void main(String[] args) throws Exception {

        JFLogin frmLogin = new JFLogin();
        UsuarioBD usuarioBD = new UsuarioBD(); 
        Configuracion config = Configuracion.getInstancia(frmLogin.jPSplash);
        frmLogin.mostrar();
        config.configurarPrograma();

    }
}
