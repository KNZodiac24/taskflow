package bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class UsuarioBD {

    public boolean registrarUsuario(String nombreUsuario, String nombrePreferido, String contrasenia) throws SQLException, NullPointerException{
        PreparedStatement ps = null;
        Connection con = Conexion.getConexion();
        String sql = "INSERT INTO USUARIO (NOMBRE_USUARIO, NOMBRE_PREFERIDO, CONTRASENIA) "
                + "VALUES (?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, nombreUsuario);
            ps.setString(2, nombrePreferido);
            ps.setString(3, contrasenia);
            ps.execute();
            return true;
        } catch (SQLException e) {
            if(e.getMessage().startsWith("Duplicate entry")) JOptionPane.showMessageDialog(null, "El nombre de usuario '"+nombreUsuario+"' ya está en uso.", "Crear cuenta", JOptionPane.ERROR_MESSAGE);
            else JOptionPane.showMessageDialog(null, "Error al crear la cuenta", "Crear cuenta", JOptionPane.ERROR_MESSAGE);
            return false;
        } finally {
            if(ps != null) ps.close();
            con.close();
        }
        
    }
    
    public boolean validarExistencia(String nombreUsuario, String contrasenia) throws SQLException, NullPointerException {
        PreparedStatement ps = null;
        Connection con = Conexion.getConexion();
        ResultSet rs = null;
        String sql = "SELECT NOMBRE_USUARIO, NOMBRE_PREFERIDO, CONTRASENIA FROM USUARIO WHERE NOMBRE_USUARIO = ? AND CONTRASENIA = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, nombreUsuario);
            ps.setString(2, contrasenia);
            
            rs = ps.executeQuery();
            if (rs.next()) return true;
                
            return false;
        } catch (SQLException e) {
            System.err.println(e + " No se pudo conectar");
            return false;
        } finally {
            if(ps != null) ps.close();
            con.close();
            if(rs != null) rs.close();
        } 
    }
}
