package vista;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import vista.JFLogin;


public class JPSplash extends JPanel {
    private JProgressBar jPBBarra;
    private JFLogin frmLogin;

    public JPSplash(JFLogin frmLogin){
        this.frmLogin = frmLogin;
        this.setPreferredSize(new Dimension(500, 500));
        this.setBackground(Color.WHITE);
        this.setLayout(null);

        initComponentes();
    }

    private void initComponentes(){
        UIManager.put("ProgressBar.background", Color.WHITE);
        UIManager.put("ProgressBar.foreground", Color.GREEN);
        UIManager.put("ProgressBar.selectionBackground", Color.DARK_GRAY);
        UIManager.put("ProgressBar.selectionForeground", Color.DARK_GRAY);
        this.jPBBarra = new JProgressBar(JProgressBar.HORIZONTAL, 0, 100);
        this.jPBBarra.setBounds(125, 235, 250, 30);
        this.jPBBarra.setStringPainted(true);
        this.jPBBarra.setString("Configurando programa...");
        this.add(this.jPBBarra);
    }

    public void setProgresoBarra(int progreso) {
        SwingUtilities.invokeLater(() -> {
            this.jPBBarra.setValue(progreso);
        });
    }

    public void mostrar(){
        this.setVisible(true);
    }

    public JFLogin getFrame() {
        return this.frmLogin;
    }
}
