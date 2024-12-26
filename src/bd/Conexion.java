package bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Conexion {
    private static Connection con = null;

    private Conexion (){
        String BASE = "taskflow";
        String USER = "root";
        String PASSWORD = "root";
        String URL = "jdbc:mysql://127.0.0.1:3306/"+BASE;
        
        try{
            con = DriverManager.getConnection(URL, USER, PASSWORD);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "No se ha podido conectar a la base de datos", "Conexión", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static Connection getConexion(){
        if(con == null) new Conexion();

        return con;
    }
}
