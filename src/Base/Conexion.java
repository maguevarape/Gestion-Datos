package Base;
import java.sql.Connection;
import java.sql.DriverManager;
public class Conexion {
   public Connection conectar() {
        Connection con = null;
        try {
  
             Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
             String url = "jdbc:sqlserver://localhost:1433;"
                         + "databaseName=paciente;"
                         + "user=usersql;"
                         + "password=nueva_contraseña;"
                         + "encrypt=true;"
                         + "trustServerCertificate=true;";
                con = DriverManager.getConnection(url);


            System.out.println("Conexión exitosa a la base de datos.");
        } catch (Exception e) {
            System.out.println(" Error de conexión: " + e.getMessage());
        }
        return con;
    }
    }   

