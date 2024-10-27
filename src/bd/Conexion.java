package bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static final String base = "taskflow";
    private static final String user = "root";
    private static final String password = "root";
    private static final String url = "jdbc:mysql://127.0.0.1:3306/"+base;
    private static Connection con = null;
    
    public static Connection getConexion(){
        try{
            con = DriverManager.getConnection(url, user, password);
        }catch(SQLException e){
            System.out.println(e);
        }
        return con;
    }
}
