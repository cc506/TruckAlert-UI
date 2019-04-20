import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DatabaseMetaData;



public class JDBC {

    public static void main(String[] args){
        try{
            Class.forName("org.postgresql.Driver");

            /* COnnection statement */
            String URL = "jdbc:postgresql://localhost:5432/postgres";

            String username = "postgres";
            String password = "3service4";
            Connection conn = DriverManager.getConnection(URL, username, password);

            DatabaseMetaData dbmd = conn.getMetaData();

            String dbName = dbmd.getDatabaseProductName();

            String dbVersion = dbmd.getDatabaseProductVersion();

            String dbUrl = dbmd.getURL();

            String userName = dbmd.getUserName();

            String driverName = dbmd.getDriverName();

            System.out.println("Database Name is " + dbName);

            System.out.println("Database Version is " + dbVersion);

            System.out.println("Database Connection Url is " + dbUrl);

            System.out.println("Database User Name is " + userName);

            System.out.println("Database Driver Name is " + driverName);



        }
        catch(Exception e){
            System.out.println("Caught Exception");


        }



    }




}
