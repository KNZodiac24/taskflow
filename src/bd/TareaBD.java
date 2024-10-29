package bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import modelo.Tarea;

public class TareaBD {

    public boolean registrarTarea(Tarea tarea){
        PreparedStatement ps = null;
        Connection con = Conexion.getConexion();
        String sql = "INSERT INTO TAREA (NOMBRE_TAREA, DESCRIPCION, FECHA_HORA_CREACION, FECHA_CULMINACION, NOM_USR) "
                + "VALUES (?,?, NOW(),?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, tarea.getNombre());
            ps.setString(2, tarea.getDescripcion());
            ps.setDate(3, tarea.getFechaCulminacion());
            ps.setString(4, tarea.getNomUsr());
            ps.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al agregar la tarea.", "Agregar tarea", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
    }

    public ArrayList<Tarea> traerListaTareasUsuario(String nomUsr){
        ArrayList<Tarea> listaTareasUsuario = new ArrayList<Tarea>();
        PreparedStatement ps = null;
        Connection con = Conexion.getConexion(); 
        ResultSet rs;
        String sql = "SELECT * FROM TAREA WHERE NOM_USR = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, nomUsr);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                listaTareasUsuario.add(new Tarea(rs.getString("NOMBRE_TAREA"), rs.getString("DESCRIPCION"), rs.getDate("FECHA_CULMINACION"), rs.getDate("FECHA_HORA_CREACION")));
            }

            if(listaTareasUsuario.isEmpty()) return null;
            else return listaTareasUsuario;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo traer la lista de tareas.", "TaskFlow", JOptionPane.ERROR_MESSAGE);
            return null;
        } 
    }
} 
