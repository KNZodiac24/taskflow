package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bd.Conexion;

public class Usuario {
    private String nombreUsuario;
    private String nombrePreferido;

    public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public String getNombrePreferido() {
		return nombrePreferido;
	}
	public void setNombrePreferido(String nombrePreferido) {
		this.nombrePreferido = nombrePreferido;
	}

    public boolean obtenerDatos(String nombreUsr) throws SQLException {
        Connection con = Conexion.getConexion(); 
        ResultSet rs = null;
        String sql = "SELECT NOMBRE_USUARIO, NOMBRE_PREFERIDO, CONTRASENIA FROM USUARIO WHERE NOMBRE_USUARIO = ?";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, nombreUsr);
            rs = ps.executeQuery();
            if (rs.next()) {
                // Llena el objeto Usuario con los datos obtenidos de la base de datos
                this.setNombreUsuario(rs.getString("NOMBRE_USUARIO"));
                this.setNombrePreferido(rs.getString("NOMBRE_PREFERIDO"));
                return true;
            }
            return false;
        } catch (SQLException e) {
            System.err.println(e + " No se pudo conectar");
            return false;
        } finally {
            ps.close();
            rs.close();
            con.close();
        } 
    }
}
