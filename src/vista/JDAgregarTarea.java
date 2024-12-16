package vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import java.util.Date;
import java.util.Locale;
import java.util.Properties;

public class JDAgregarTarea extends JDialog {
    public JTextField jTFNombreTarea;
    public JTextArea jTADescripcionTarea;
    public JTextField jTFFechaCulminacion;
    public JButton jBAgregarTarea;

    public JDAgregarTarea(){
        this.setTitle("Agregar tarea");
        this.getContentPane().setPreferredSize(new Dimension(500, 410));
        this.getContentPane().setLayout(null);
        this.getContentPane().setBackground(Color.WHITE);

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
        jLNombreTarea.setFont(new Font("YouTube Sans", Font.PLAIN, 20));
        jLNombreTarea.setBounds(30, 30, 100, 25);
        this.add(jLNombreTarea);

        this.jTFNombreTarea = new JTextField();
        this.jTFNombreTarea.setBounds(110, 30, 360, 30);
        this.jTFNombreTarea.setFont(new Font("YouTube Sans", Font.PLAIN, 16));
        this.jTFNombreTarea.setMargin(new Insets(0, 10, 0, 0));
        this.add(this.jTFNombreTarea);

        // Para agregar la descripción
        JLabel jLDescripcion = new JLabel("Descripción:");
        jLDescripcion.setFont(new Font("YouTube Sans", Font.PLAIN, 20));
        jLDescripcion.setBounds(30, 65, 150, 25);
        this.add(jLDescripcion);

        this.jTADescripcionTarea = new JTextArea();
        this.jTADescripcionTarea.setBounds(30, 100, 440, 200);
        this.jTADescripcionTarea.setFont(new Font("YouTube Sans", Font.PLAIN, 24));
        this.jTADescripcionTarea.setMargin(new Insets(5, 10, 5, 5));
        this.jTADescripcionTarea.setWrapStyleWord(true);
        this.jTADescripcionTarea.setLineWrap(true);
        JScrollPane jSPScrollDescripcion = new JScrollPane(this.jTADescripcionTarea);
        jSPScrollDescripcion.setBounds(this.jTADescripcionTarea.getBounds()); 
        this.add(jSPScrollDescripcion);

        // Para agregar la fecha de culminación
        JLabel jLFechaCulminacion = new JLabel("Fecha de culminación:");
        jLFechaCulminacion.setFont(new Font("YouTube Sans", Font.PLAIN, 20));
        jLFechaCulminacion.setBounds(30, 310, 200, 25);
        this.add(jLFechaCulminacion);

        JDateChooser dateChooser = new JDateChooser();
        dateChooser.setDateFormatString("dd/MM/yyyy");
        JTextField dateTextField = ((JTextField) dateChooser.getDateEditor().getUiComponent());
        dateTextField.setEditable(false);
        dateTextField.setFocusable(false);
        dateTextField.setFont(new Font("YouTube Sans", Font.PLAIN, 16));
        this.jTFFechaCulminacion = dateTextField;
        dateChooser.setBounds(220, 310, 250, 30);
        this.add(dateChooser);


        // Para el botón de agregar tarea
        this.jBAgregarTarea = new JButton("Agregar tarea");
        this.jBAgregarTarea.setFont(new Font("YouTube Sans", Font.PLAIN, 16));
        this.jBAgregarTarea.setBounds(180, 355, 130, 40);
        this.jBAgregarTarea.setFocusable(false);
        this.add(this.jBAgregarTarea);
    }

    public void mostrar(){
        this.setVisible(true);
    }

}
