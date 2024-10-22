package vista;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class JDAgregarTarea extends JDialog {
    private JTextField jTFNombreTarea;
    private JTextArea jTADescripcionTarea;
    private JTextField jTFFechaCuliminacion;
    public JButton jBAgregarTarea;

    public JDAgregarTarea(){
        this.setTitle("Agregar tarea");
        this.getContentPane().setPreferredSize(new Dimension(500, 500));
        this.getContentPane().setLayout(null);
        
        initComponentes();

        this.setResizable(false);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setModalityType(ModalityType.APPLICATION_MODAL);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    }
 
    private void initComponentes(){
        // Para agregar el nombre
        JLabel jLNombreTarea = new JLabel("Nombre:");
        jLNombreTarea.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
        jLNombreTarea.setBounds(30, 30, 100, 20);
        this.add(jLNombreTarea);

        this.jTFNombreTarea = new JTextField();
        this.jTFNombreTarea.setBounds(125, 30, 200, 20);
        this.add(this.jTFNombreTarea);
    }

    public void mostrar(){
        this.setVisible(true);
    }

}
