import java.sql.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;


public class JDBC {

    /* Connection statement */

    String URL = "jdbc:postgresql://localhost:5432/postgres";

    String username = "postgres";
    String password = "3service4";


    public static void InsertNewUser (String firstName, String lastName, String emaiL, String passWord){

        String URL = "jdbc:postgresql://localhost:5432/postgres";
        String username = "postgres";
        String password = "3service4";


        //INSERT INTO user_credentials (email, first_name, last_name, pass)
        //VALUES ('reeree', 'Kevin', 'Ta', 'onision')

        String SQL = "INSERT INTO user_credentials(email,first_name,last_name,pass)"
                    + "VALUES ('" + emaiL + "','" + firstName + "','" + lastName + "','" + passWord + "');";

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




    public static boolean CheckLoginInfo (String emailInput, String passWordInput){
        boolean a = true;

        String URL = "jdbc:postgresql://localhost:5432/postgres";
        String username = "postgres";
        String password = "3service4";


        String SQL = "SELECT email, pass FROM user_credentials";

        List <String> emailList = new ArrayList<String>();
        List <String> passList = new ArrayList<String>();


        try (Connection conn = DriverManager.getConnection(URL, username, password);
             Statement pstmt = conn.createStatement();
             Statement pstmt2 = conn.createStatement();
             ResultSet rs1 = pstmt.executeQuery(SQL)){

           String email, userPassword;

           int i = 0;


           while (rs1.next()){

               emailList.add(rs1.getString(1));
               passList.add(rs1.getString(2));
           }


           while (i < emailList.size()){

               if (emailInput.equals(emailList.get(i)) && passWordInput.equals(passList.get(i))){
                   a = true;
                   System.out.println("Found the user!");
                   return a;
               }

               else {
                   a = false;
                   System.out.println("Still searching....");

               }
               i++;

           }

           System.out.println("User not found!");


        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("XXXX");
        }
        return a;
    }


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


            //InsertNewUser("Sonny", "Ta", "sta@gmail.com", "lso" );

            Boolean b = CheckLoginInfo("sta@gmail.com", "lso");
            System.out.println(b);




        }
        catch(Exception e){
            System.out.println("Caught Exception");


        }



    }




}
