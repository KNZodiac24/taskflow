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

import utils.Fecha;

public class JDRangoFechas extends JDialog implements ActionListener {
    public JTextField jTFFechaInicio;
    public JTextField jTFFechaFin;
    public JButton jBAceptarRango;

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

        this.jTFFechaInicio = new JTextField("dd/mm/aaaa");
        this.jTFFechaInicio.setBounds(85, 20, 125, 30);
        this.jTFFechaInicio.setFont(new Font("YouTube Sans", Font.PLAIN, 16));
        this.jTFFechaInicio.setMargin(new Insets(0, 10, 0, 0));
        this.jTFFechaInicio.setForeground(Color.GRAY);
        this.jTFFechaInicio.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (jTFFechaInicio.getText().equals("dd/mm/aaaa")) {
                    jTFFechaInicio.setText("");
                    jTFFechaInicio.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (jTFFechaInicio.getText().isEmpty()) {
                    jTFFechaInicio.setText("dd/mm/aaaa");
                    jTFFechaInicio.setForeground(Color.GRAY);
                }
            }
        });
        this.add(this.jTFFechaInicio);

        // Fecha fin
        JLabel jLHasta = new JLabel("Hasta:");
        jLHasta.setBounds(30, 55, 50, 40);
        jLHasta.setFont(new Font("YouTube Sans", Font.PLAIN, 18));
        this.add(jLHasta);

        this.jTFFechaFin = new JTextField("dd/mm/aaaa");
        this.jTFFechaFin.setBounds(85, 60, 125, 30);
        this.jTFFechaFin.setFont(new Font("YouTube Sans", Font.PLAIN, 16));
        this.jTFFechaFin.setMargin(new Insets(0, 10, 0, 0));
        this.jTFFechaFin.setForeground(Color.GRAY);
        this.jTFFechaFin.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (jTFFechaFin.getText().equals("dd/mm/aaaa")) {
                    jTFFechaFin.setText("");
                    jTFFechaFin.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (jTFFechaFin.getText().isEmpty()) {
                    jTFFechaFin.setText("dd/mm/aaaa");
                    jTFFechaFin.setForeground(Color.GRAY);
                }
            }
        });
        this.add(this.jTFFechaFin);

        // Botón para aceptar el rango
        this.jBAceptarRango = new JButton("Aceptar");
        this.jBAceptarRango.setBounds(75, 105, 100, 30);
        this.jBAceptarRango.setFont(new Font("YouTube Sans", Font.PLAIN, 16));
        this.jBAceptarRango.setFocusable(false);
        this.add(this.jBAceptarRango);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == this.jBAceptarRango){
            Fecha fechaInicio = new Fecha(this.jTFFechaInicio.getText());
            Fecha fechaFin = new Fecha(this.jTFFechaFin.getText());
            if(fechaInicio.esFechaValida() && fechaFin.esFechaValida()){
                TareaController.cargarListaTareas();
            }else{
                JOptionPane.showMessageDialog(null, "Formato de fecha inválida.", "Seleccionar rango de fechas", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void mostrar(){
        this.setVisible(true);
    }
}
