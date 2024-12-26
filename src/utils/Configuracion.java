package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Base64;
import java.util.Scanner;

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
        ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", "where git"); progresoConfig += 5; this.splash.setProgresoBarra(progresoConfig);
        builder.redirectErrorStream(true); progresoConfig += 5; this.splash.setProgresoBarra(progresoConfig);
        Process p = builder.start(); progresoConfig += 5; this.splash.setProgresoBarra(progresoConfig);
        BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream())); progresoConfig += 5; this.splash.setProgresoBarra(progresoConfig);
        String line; progresoConfig += 5; this.splash.setProgresoBarra(progresoConfig);
        while (true) {
            line = r.readLine();
            if (line == null) { break; }
            if(line.endsWith("git.exe")) return true;
        } progresoConfig += 5; this.splash.setProgresoBarra(progresoConfig);

        return false;
    }

    private void validarDirectorioConfiguracion() throws Exception{
        File dirConfig = new File(System.getProperty("user.home")+File.separator+".taskflow"); progresoConfig += 5; this.splash.setProgresoBarra(progresoConfig);
        if(!dirConfig.exists()){ progresoConfig += 5; this.splash.setProgresoBarra(progresoConfig);
            dirConfig.mkdirs(); progresoConfig += 5; this.splash.setProgresoBarra(progresoConfig);
            this.pathConfig = dirConfig.getAbsolutePath(); progresoConfig += 5; this.splash.setProgresoBarra(progresoConfig);
        }else{
            this.pathConfig = dirConfig.getAbsolutePath(); progresoConfig += 10; this.splash.setProgresoBarra(progresoConfig);
        }
    }

    private void traerRecursos() throws Exception{
        ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", "git clone https://github.com/KNZodiac24/taskflow.git "+this.pathConfig+" && cd "+this.pathConfig+" && rmdir /s /q src lib docs .git && del .gitignore MANIFEST.MF TaskFlow.jar ejecutar.ps1 LICENSE"); progresoConfig += 5; this.splash.setProgresoBarra(progresoConfig);
        builder.redirectErrorStream(true);  progresoConfig += 5; this.splash.setProgresoBarra(progresoConfig);
        Process p = builder.start();  progresoConfig += 5; this.splash.setProgresoBarra(progresoConfig);
        p.waitFor();  progresoConfig += 5; this.splash.setProgresoBarra(progresoConfig);
    }

    private void crearEnv() throws IOException{
        File env = new File(this.pathConfig+File.separator+".env"); progresoConfig += 5; this.splash.setProgresoBarra(progresoConfig);
        if(!env.exists()){ progresoConfig += 5; this.splash.setProgresoBarra(progresoConfig);
            FileWriter fw = new FileWriter(env);
            try {
                if(env.createNewFile()) { progresoConfig += 5; this.splash.setProgresoBarra(progresoConfig);
                    fw.write("PASSWORD="+Base64.getDecoder().decode("cm9vdA=="));
                }
            } catch (IOException e) {
                System.out.println(e);
            } finally{
                fw.close();
            }
        }
    }

    public void configurarPrograma() throws Exception{
        if(verificarGit()){ progresoConfig += 5; this.splash.setProgresoBarra(progresoConfig);
            validarDirectorioConfiguracion();  progresoConfig += 5; this.splash.setProgresoBarra(progresoConfig);
            crearEnv(); progresoConfig += 5; this.splash.setProgresoBarra(progresoConfig);
            traerRecursos();
            progresoConfig = 100;
            this.splash.setProgresoBarra(progresoConfig);

            SwingUtilities.invokeLater(() -> this.splash.getFrame().configPanelLogin());
        }else{
            JOptionPane.showMessageDialog(null, "No se ha encontrado git en este equipo.\n\nPor favor instalar la dependencia y volver a iniciar el programa.", "Error de configuración", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }

    public static String getContraseniaBD(){
        String pw = "";
        Scanner sc = null;
        try {
            File env = new File(System.getProperty("user.home")+File.separator+".taskflow"+File.separator+".env");
            sc = new Scanner(env);
            while(sc.hasNext()){
                pw = sc.next().substring(9);
            }
            return pw;
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } finally {
            if(sc != null) sc.close();
        }

        return pw;
    }

}
