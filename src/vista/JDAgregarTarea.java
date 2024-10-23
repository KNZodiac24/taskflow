package vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class JDAgregarTarea extends JDialog {
    private JTextField jTFNombreTarea;
    private JTextArea jTADescripcionTarea;
    private JTextField jTFFechaCulminacion;
    public JButton jBAgregarTarea;

    public JDAgregarTarea(){
        this.setTitle("Agregar tarea");
        this.getContentPane().setPreferredSize(new Dimension(500, 410));
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
        jLNombreTarea.setBounds(30, 30, 100, 25);
        this.add(jLNombreTarea);

        this.jTFNombreTarea = new JTextField();
        this.jTFNombreTarea.setBounds(110, 30, 360, 25);
        this.jTFNombreTarea.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 16));
        this.add(this.jTFNombreTarea);

        // Para agregar la descripción
        JLabel jLDescripcion = new JLabel("Descripción:");
        jLDescripcion.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
        jLDescripcion.setBounds(30, 65, 150, 25);
        this.add(jLDescripcion);

        this.jTADescripcionTarea = new JTextArea();
        this.jTADescripcionTarea.setBounds(30, 100, 440, 200);
        this.jTADescripcionTarea.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 16));
        this.jTADescripcionTarea.setWrapStyleWord(true);
        this.jTADescripcionTarea.setLineWrap(true);
        JScrollPane jSPScrollDescripcion = new JScrollPane(this.jTADescripcionTarea);
        jSPScrollDescripcion.setBounds(this.jTADescripcionTarea.getBounds()); 
        this.add(jSPScrollDescripcion);

        // Para agregar la fecha de culminación
        JLabel jLFechaCulminacion = new JLabel("Fecha de culminación:");
        jLFechaCulminacion.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
        jLFechaCulminacion.setBounds(30, 310, 200, 25);
        this.add(jLFechaCulminacion);

        this.jTFFechaCulminacion = new JTextField("dd/mm/aaaa");
        this.jTFFechaCulminacion.setBounds(230, 310, 240, 25);
        this.jTFFechaCulminacion.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 16));
        this.jTFFechaCulminacion.setForeground(Color.GRAY);
        this.jTFFechaCulminacion.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (jTFFechaCulminacion.getText().equals("dd/mm/aaaa")) {
                    jTFFechaCulminacion.setText("");
                    jTFFechaCulminacion.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (jTFFechaCulminacion.getText().isEmpty()) {
                    jTFFechaCulminacion.setText("dd/mm/aaaa");
                    jTFFechaCulminacion.setForeground(Color.GRAY);
                }
            }
        });
        this.add(this.jTFFechaCulminacion);

        // Para el botón de agregar tarea
        this.jBAgregarTarea = new JButton("Agregar tarea");
        this.jBAgregarTarea.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 16));
        this.jBAgregarTarea.setBounds(180, 355, 130, 40);
        this.jBAgregarTarea.setFocusable(false);
        this.add(this.jBAgregarTarea);
    }

    public void mostrar(){
        this.setVisible(true);
    }

}
