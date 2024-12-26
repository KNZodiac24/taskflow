package vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import controlador.TareaController;
import utils.Fecha;

public class JDRangoFechas extends JDialog implements ActionListener {
    public JTextField jTFFechaInicio;
    public JTextField jTFFechaFin;
    public JButton jBAceptarRango;
    private boolean esRangoCorrecto;

    public JDRangoFechas(){
        this.setTitle("Seleccionar rango de fechas");
        this.getContentPane().setPreferredSize(new Dimension(250, 150));
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
        // Fecha de inicio
        JLabel jLDesde = new JLabel("Desde:");
        jLDesde.setBounds(30, 15, 50, 40);
        jLDesde.setFont(new Font("YouTube Sans", Font.PLAIN, 18));
        this.add(jLDesde);

        JDateChooser dateChooserFechaInicio = new JDateChooser();
        dateChooserFechaInicio.setDateFormatString("dd/MM/yyyy");
        JTextField dateTextFieldFechaInicio = ((JTextField) dateChooserFechaInicio.getDateEditor().getUiComponent());
        dateTextFieldFechaInicio.setEditable(false);
        dateTextFieldFechaInicio.setFocusable(false);
        dateTextFieldFechaInicio.setFont(new Font("YouTube Sans", Font.PLAIN, 16));
        this.jTFFechaInicio = dateTextFieldFechaInicio;
        dateChooserFechaInicio.setBounds(85, 20, 125, 30);
        this.add(dateChooserFechaInicio);

        // Fecha fin
        JLabel jLHasta = new JLabel("Hasta:");
        jLHasta.setBounds(30, 55, 50, 40);
        jLHasta.setFont(new Font("YouTube Sans", Font.PLAIN, 18));
        this.add(jLHasta);
        
        JDateChooser dateChooserFechaFin = new JDateChooser();
        dateChooserFechaFin.setDateFormatString("dd/MM/yyyy");
        JTextField dateTextFieldFechaFin = ((JTextField) dateChooserFechaFin.getDateEditor().getUiComponent());
        dateTextFieldFechaFin.setEditable(false);
        dateTextFieldFechaFin.setFocusable(false);
        dateTextFieldFechaFin.setFont(new Font("YouTube Sans", Font.PLAIN, 16));
        this.jTFFechaFin = dateTextFieldFechaFin;
        dateChooserFechaFin.setBounds(85, 60, 125, 30);
        this.add(dateChooserFechaFin);

        // Botón para aceptar el rango
        this.jBAceptarRango = new JButton("Aceptar");
        this.jBAceptarRango.setBounds(75, 105, 100, 30);
        this.jBAceptarRango.setFont(new Font("YouTube Sans", Font.PLAIN, 16));
        this.jBAceptarRango.setFocusable(false);
        this.jBAceptarRango.addActionListener(this);
        this.add(this.jBAceptarRango);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == this.jBAceptarRango){
            Fecha fechaInicio = new Fecha(this.jTFFechaInicio.getText());
            Fecha fechaFin = new Fecha(this.jTFFechaFin.getText());
            if(fechaInicio.esFechaValida() && fechaFin.esFechaValida()){
                this.esRangoCorrecto = true;
                this.dispose();
            }else{
                JOptionPane.showMessageDialog(null, "Formato de fecha inválida.", "Seleccionar rango de fechas", JOptionPane.ERROR_MESSAGE);
                this.esRangoCorrecto = false;
                this.dispose();
            }
        }
    }

    private boolean esRangoCorrecto(){
        return this.esRangoCorrecto;
    }

    private String[] obtenerFechas(){
        Fecha fechaInicio = new Fecha(this.jTFFechaInicio.getText());
        Fecha fechaFin = new Fecha(this.jTFFechaFin.getText());
        fechaInicio.rellenarFecha();
        fechaFin.rellenarFecha();
        return new String[]{fechaInicio.getFechaConFormatoValidoEnBD(), fechaFin.getFechaConFormatoValidoEnBD()};
    }

    public Object[] mostrar(){
        this.setVisible(true);
        return new Object[]{esRangoCorrecto(), obtenerFechas()[0], obtenerFechas()[1]};
    }
}
