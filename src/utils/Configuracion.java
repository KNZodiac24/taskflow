package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import vista.JPSplash;


public class Configuracion {
    private String pathConfig;
    private static Configuracion instancia;
    private int progresoConfig = 0;
    private JPSplash splash;

    private Configuracion(JPSplash splash){
        this.splash = splash;
    }

    public static synchronized Configuracion getInstancia(JPSplash splash){
        if (instancia == null) {
            instancia = new Configuracion(splash);
        }

        return instancia;
    }

    private boolean verificarGit() throws Exception{
        ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", "where git"); progresoConfig += 6; this.splash.setProgresoBarra(progresoConfig);
        builder.redirectErrorStream(true); progresoConfig += 6; this.splash.setProgresoBarra(progresoConfig);
        Process p = builder.start(); progresoConfig += 6; this.splash.setProgresoBarra(progresoConfig);
        BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream())); progresoConfig += 6; this.splash.setProgresoBarra(progresoConfig);
        String line; progresoConfig += 6; this.splash.setProgresoBarra(progresoConfig);
        while (true) {
            line = r.readLine();
            if (line == null) { break; }
            if(line.endsWith("git.exe")) return true;
        } progresoConfig += 6; this.splash.setProgresoBarra(progresoConfig);

        return false;
    }

    private void validarDirectorioConfiguracion() throws Exception{
        File dirConfig = new File(System.getProperty("user.home")+File.separator+".taskflow"); progresoConfig += 6; this.splash.setProgresoBarra(progresoConfig);
        if(!dirConfig.exists()){ progresoConfig += 6; this.splash.setProgresoBarra(progresoConfig);
            dirConfig.mkdirs(); progresoConfig += 6; this.splash.setProgresoBarra(progresoConfig);
            this.pathConfig = dirConfig.getAbsolutePath(); progresoConfig += 6; this.splash.setProgresoBarra(progresoConfig);
        }else{
            this.pathConfig = dirConfig.getAbsolutePath(); progresoConfig += 12; this.splash.setProgresoBarra(progresoConfig);
        }
    }

    private void traerRecursos() throws Exception{
        ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", "git clone https://github.com/KNZodiac24/taskflow.git "+this.pathConfig+" && cd "+this.pathConfig+" && rmdir /s /q src lib docs .git && del .gitignore MANIFEST.MF TaskFlow.jar ejecutar.ps1 LICENSE"); progresoConfig += 6; this.splash.setProgresoBarra(progresoConfig);
        builder.redirectErrorStream(true);  progresoConfig += 6; this.splash.setProgresoBarra(progresoConfig);
        Process p = builder.start();  progresoConfig += 6; this.splash.setProgresoBarra(progresoConfig);
        p.waitFor();  progresoConfig += 6; this.splash.setProgresoBarra(progresoConfig);
    }

    public void configurarPrograma() throws Exception{
        if(verificarGit()){ progresoConfig += 6; this.splash.setProgresoBarra(progresoConfig);
            validarDirectorioConfiguracion();  progresoConfig += 6; this.splash.setProgresoBarra(progresoConfig);
            traerRecursos();
            progresoConfig = 100;
            this.splash.setProgresoBarra(progresoConfig);

            SwingUtilities.invokeLater(() -> this.splash.getFrame().configPanelLogin());
        }else{
            JOptionPane.showMessageDialog(null, "No se ha encontrado git en este equipo.\n\nPor favor instalar la dependencia y volver a iniciar el programa.", "Error de configuración", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }

}
