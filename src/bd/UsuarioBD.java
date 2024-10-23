package bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bd.Conexion.getConexion;

public class UsuarioBD {

    public boolean registrarUsuario(String nombreUsuario, String nombrePreferido, String contrasenia){
        PreparedStatement ps = null;
        Connection con = getConexion();
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
            System.err.println(e + " No se pudo conectar");
            return false;
        }
        
    }
    
    public boolean validarExistencia(String nombreUsuario, String contrasenia) {
        PreparedStatement ps = null;
        Connection con = getConexion();
        ResultSet rs;
        String sql = "SELECT * FROM USUARIO WHERE NOMBRE_USUARIO = ? AND CONTRASENIA = ?";
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
        } 
    }
}
