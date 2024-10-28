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

    public boolean obtenerDatos(){
        PreparedStatement ps = null;
        Connection con = Conexion.getConexion(); 
        ResultSet rs;
        String sql = "SELECT * FROM USUARIO WHERE NOMBRE_USUARIO = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, this.getNombreUsuario());
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
        } 
    }
}
