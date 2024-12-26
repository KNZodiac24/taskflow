package bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import utils.Configuracion;

public class Conexion {
    private static Connection con = null;
    private static final String BASE = "taskflow";
    private static final String USER = "root";
    private static final String PASSWORD = Configuracion.getContraseniaBD();
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/"+BASE;
    
    private Conexion (){ 
        try{
            con = DriverManager.getConnection(URL, USER, PASSWORD);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "No se ha podido conectar a la base de datos", "Conexión", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static Connection getConexion() throws SQLException{
        if(con == null || con.isClosed()) new Conexion();

        return con;
    }
}
