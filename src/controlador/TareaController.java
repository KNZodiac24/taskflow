package controlador;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import bd.TareaBD;
import modelo.Tarea;
import utils.Fecha;
import vista.JDAgregarTarea;
import vista.JDRangoFechas;
import vista.JFTaskFlow;
import vista.JPTarea;

public class TareaController implements ActionListener{
    
    private static JFTaskFlow frmTaskFlow;
    private JDAgregarTarea frmAgregarTarea;
    private static TareaBD tareaBD;

    public TareaController(JFTaskFlow frmTaskFlow, JDAgregarTarea frmAgregarTarea, TareaBD tareaBD){
        this.frmTaskFlow = frmTaskFlow;
        this.frmAgregarTarea = frmAgregarTarea;
        this.tareaBD = tareaBD;
        this.frmTaskFlow.jBAgregar.addActionListener(this);
        this.frmAgregarTarea.jBAgregarTarea.addActionListener(this);
        this.frmTaskFlow.jCBOrdenLista.addActionListener(this);
        cargarListaTareas();
    }

    @Override
    public void actionPerformed(ActionEvent e){
        // Si se presionó el botón Agregar en la vista principal
        if(e.getSource() == frmTaskFlow.jBAgregar){
            frmAgregarTarea.mostrar();
        }

        // Si se presionó el botón Agregar Tarea en el dialog de agregar tarea
        if(e.getSource() == frmAgregarTarea.jBAgregarTarea){
            String nombreTarea = frmAgregarTarea.jTFNombreTarea.getText();
            String descripcionTarea = frmAgregarTarea.jTADescripcionTarea.getText();
            Fecha fechaTemp = new Fecha(frmAgregarTarea.jTFFechaCulminacion.getText());
            if (fechaTemp.esFechaValida()){
                if(Fecha.verificarFechaMayorALaActual(fechaTemp)){
                    Date fechaCulminacionTarea = Date.valueOf(fechaTemp.getFechaConFormatoValidoEnBD());
                    Tarea tarea = new Tarea(nombreTarea, descripcionTarea, fechaCulminacionTarea, frmTaskFlow.getUsuarioActual().getNombreUsuario());
                
                    if(tareaBD.registrarTarea(tarea)){
                        JOptionPane.showMessageDialog(null, "¡Se agregó correctamente la tarea!", "Agregar tarea", JOptionPane.INFORMATION_MESSAGE);
                        frmAgregarTarea.dispose();
                        cargarListaTareas();
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "La fecha de culminación debe ser mayor a la fecha actual.", "Agregar tarea", JOptionPane.ERROR_MESSAGE);
                }
            }else{
                JOptionPane.showMessageDialog(null, "Formato de fecha inválida.", "Agregar tarea", JOptionPane.ERROR_MESSAGE);
            }

        }

        // Si se presiona en alguna opción del comboBox
        if(e.getSource() == frmTaskFlow.jCBOrdenLista){
            cargarListaTareas();
        }
    }

    public static void cargarListaTareas(){
        ArrayList<Tarea> listaTareas = new ArrayList<Tarea>(); 
        int criterio = frmTaskFlow.jCBOrdenLista.getSelectedIndex();
        
        if(criterio < 2) listaTareas = tareaBD.traerListaTareasUsuario(frmTaskFlow.getUsuarioActual().getNombreUsuario(), criterio);
        else{
            JDRangoFechas frmSeleccionfechas = new JDRangoFechas();
            frmSeleccionfechas.mostrar();
        }
        
        if(listaTareas == null){
            frmTaskFlow.jTPListaTareas.setText("");
            frmTaskFlow.jLListaSinElementos.setVisible(true);
        }else{
            frmTaskFlow.jTPListaTareas.setText("");
            frmTaskFlow.jLListaSinElementos.setVisible(false);

            for (Tarea tarea : listaTareas){
                JPTarea panelTarea = new JPTarea(tarea);
                frmTaskFlow.jTPListaTareas.insertComponent(panelTarea);
                panelTarea.aplicarResponsive();
                panelTarea.aplicarAcciones();
            }

        }
    }

}
