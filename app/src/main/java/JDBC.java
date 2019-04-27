import java.sql.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.sql.PreparedStatement;


public class JDBC {

    /* Connection statement */

    String URL = "jdbc:postgresql://localhost:5432/postgres";

    String username = "postgres";
    String password = "3service4";


    public static void InsertNewUser (String firstName, String lastName, String emaiL, String passWord){

        String URL = "jdbc:postgresql://localhost:5432/postgres";
        String username = "postgres";
        String password = "3service4";

        String SQL = "INSERT INTO UserCredentials(email,first_name,last_name,pass) VALUES (" + emaiL + "," + firstName + "," + lastName + "," + passWord + ");";

        try (Connection conn = DriverManager.getConnection(URL, username, password);
             Statement pstmt = conn.createStatement()) {

            //pstmt.setString(1, emaiL);
            //pstmt.setString(2, firstName);
            //pstmt.setString(3, lastName);
            //pstmt.setString(4, passWord);

            pstmt.executeUpdate(SQL);

            System.out.println("Thank you " + firstName + "! We have created your new account!");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        //return
    }


    public boolean CheckLoginInfo (String email, String passWord){
        boolean a;

        String checkEmail = "SELECT email,  FROM UserCredentials";
        String checkPassword = "SELECT pass, FROM UserCredentials";


        if (email.equals(checkEmail) && passWord.equals(checkPassword)){
            a = true;
            return a;
        }
        else{
            a = false;
            return a;
        }



    }


    /*
    public int getActorCount() {
        String SQL = "SELECT count(*) FROM actor";
        int count = 0;

        try (Connection conn = connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(SQL)) {
            rs.next();
            count = rs.getInt(1);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return count;
    }

     */




    public static void main(String[] args){


        try{
            Class.forName("org.postgresql.Driver");

            /* Connection statement */
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


            InsertNewUser("Kevin", "Ta", "ree@ree.edu", "Turlock" );



        }
        catch(Exception e){
            System.out.println("Caught Exception");


        }



    }




}
