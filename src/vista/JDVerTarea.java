package vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import bd.TareaBD;
import controlador.TareaController;
import modelo.Tarea;

public class JDVerTarea extends JDialog implements ActionListener {
    private JTextArea jTANombreTarea;
    private JTextArea jTADescripcionTarea;
    private JLabel jLFechaCulminacionTarea;
    private Tarea tarea;
    private TareaBD tareaBD;
    private JButton jBEliminarTarea;
    private TareaController tareaCtr;

    public JDVerTarea(Tarea tarea){
        this.setTitle("Ver tarea");
        this.getContentPane().setPreferredSize(new Dimension(600, 400));
        this.getContentPane().setLayout(null);
        this.getContentPane().setBackground(Color.WHITE);

        this.tarea = tarea;
        this.tareaBD = new TareaBD();
        initComponentes();

        this.setResizable(false);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setModalityType(ModalityType.APPLICATION_MODAL);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    }

    private void initComponentes(){
        //////////// Mostrar el nombre de la tarea
        this.jTANombreTarea = new JTextArea();
        this.jTANombreTarea.setBounds(30, 30, 550, 40);
        this.jTANombreTarea.setFont(new Font("YouTube Sans Semibold", Font.BOLD, 30));
        this.jTANombreTarea.setWrapStyleWord(true);
        this.jTANombreTarea.setLineWrap(true);
        this.jTANombreTarea.setBorder(null);
        this.jTANombreTarea.setEditable(false);
        this.jTANombreTarea.setFocusable(false);
        this.jTANombreTarea.setText(this.tarea.getNombre());
        this.add(this.jTANombreTarea);

        //////////// Mostrar la descripción de la tarea
        this.jTADescripcionTarea = new JTextArea();
        this.jTADescripcionTarea.setBounds(30, 90, 550, 160);
        this.jTADescripcionTarea.setFont(new Font("YouTube Sans", Font.PLAIN, 24));
        this.jTADescripcionTarea.setWrapStyleWord(true);
        this.jTADescripcionTarea.setLineWrap(true);
        this.jTADescripcionTarea.setEditable(false);
        this.jTADescripcionTarea.setFocusable(false);
        this.jTADescripcionTarea.setText(this.tarea.getDescripcion());
        this.add(this.jTADescripcionTarea);

        //////////// Mostrar la fecha de culminación
        this.jLFechaCulminacionTarea = new JLabel("Finaliza: "+this.tarea.darFechaDeCulminacion());
        this.jLFechaCulminacionTarea.setBounds(30, 260, 250, 30);
        this.jLFechaCulminacionTarea.setFont(new Font("YouTube Sans", Font.PLAIN, 26));
        this.add(this.jLFechaCulminacionTarea);

        //////////// Botón para eliminar la tarea
        this.jBEliminarTarea = new JButton("Eliminar tarea");
        this.jBEliminarTarea.setBounds(390, 320, 175, 40);
        this.jBEliminarTarea.setFont(new Font("YouTube Sans", Font.PLAIN, 24));
        this.jBEliminarTarea.setForeground(Color.RED);
        this.jBEliminarTarea.setBorder(BorderFactory.createLineBorder(Color.RED, 2, true));
        this.jBEliminarTarea.setFocusable(false);
        this.jBEliminarTarea.addActionListener(this);
        this.add(this.jBEliminarTarea);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        // Si se presionó en el botón de Eliminar tarea
        if(e.getSource() == this.jBEliminarTarea){
            if(JOptionPane.showConfirmDialog(null, "¿Estás seguro/a de querer eliminar esta tarea?", "Eliminar tarea", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
                if(tareaBD.eliminarTarea(this.tarea.getNombre(), this.tarea.getNomUsr())){
                    JOptionPane.showMessageDialog(null, "Se ha eliminado la tarea exitosamente.", "Eliminar tarea", JOptionPane.INFORMATION_MESSAGE);
                    this.dispose();
                    TareaController.cargarListaTareas();
                } 
            }
        }
    }

    public void mostrar(){
        this.setVisible(true);
    }
}
