package bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private final String base = "taskflow";
    private final String user = "root";
    private final String password = "root";
    private final String url = "jdbc:mysql://127.0.0.1:3306/"+base;
    private Connection con = null;
    
    public Connection getConexion(){
        try{
            con = DriverManager.getConnection(this.url, this.user, this.password);
        }catch(SQLException e){
            System.out.println(e);
        }
        return con;
    }
}
