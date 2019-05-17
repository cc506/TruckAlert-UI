

package com.example.truckalert;

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
import java.util.Scanner;
import java.util.concurrent.TimeUnit;


public class JDBC {

    /* Connection statement */

    public static void InsertNewUser (String firstName, String lastName, String emaiL, String passWord){

        Connection conn = null;
        Statement stmt = null;

        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "3service4");
            System.out.println("Opened database successfully");

            stmt = conn.createStatement();

            String SQL = "INSERT INTO user_credentials(email,first_name,last_name,pass)"
                    + "VALUES ('" + emaiL + "','" + firstName + "','" + lastName + "','" + passWord + "');";

            stmt.executeUpdate(SQL);
            stmt.close();
            conn.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }
        System.out.println("Thank you " + firstName + "! We have created your new account!");
        //return
    }


    public static void StoreUserCoordinates (float Long, float Lat){

        Connection conn = null;
        Statement stmt = null;

        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "3service4");
            System.out.println("Opened database successfully");

            stmt = conn.createStatement();

            String SQL = "INSERT INTO user_coordinates(longitude, latitude)"
                    + "VALUES ('" + Long + "','" + Lat + "');";

            stmt.executeUpdate(SQL);
            stmt.close();
            conn.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }
        System.out.println("Successfully stored coordinates! \n"
                + "Longitude: " + Long + "\n"
                + "Latitude: " + Lat);
    }

    public static void StoreObstacleCoordinates (float Long, float Lat){

        Connection conn = null;
        Statement stmt = null;

        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "3service4");
            System.out.println("Opened database successfully");

            stmt = conn.createStatement();

            String SQL = "INSERT INTO obstacle_coordinates(longitude, latitude)"
                    + "VALUES ('" + Long + "','" + Lat + "');";

            stmt.executeUpdate(SQL);
            stmt.close();
            conn.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }
        System.out.println("Successfully stored coordinates! \n"
                + "Longitude: " + Long + "\n"
                + "Latitude: " + Lat);
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


    public static void TestLoad (){
        String firstName, lastName, emaiL, passWord = "";

        int iterations = 0;
        Scanner myScan = new Scanner (System.in);

        System.out.print("Enter First Name: ");
        firstName = myScan.nextLine();

        System.out.print("Enter Last Name: ");
        lastName = myScan.nextLine();

        System.out.print("Enter Email: ");
        emaiL = myScan.nextLine();

        System.out.print("Enter Password: ");
        passWord = myScan.nextLine();

        System.out.print("How many iterations?: ");
        iterations = myScan.nextInt();

        long startTime = System.nanoTime();
        for (int i = 0; i < iterations; i++){
            JDBC.InsertNewUser(firstName, lastName, emaiL, passWord );
        }
        long endTime = System.nanoTime();

        long durationNano = (endTime - startTime);
        long durationMillis = TimeUnit.NANOSECONDS.toMillis(durationNano);
        long durationSecs = TimeUnit.NANOSECONDS.toSeconds(durationNano);



        System.out.println("Completed appending!");
        System.out.println("This action completed in: " + durationMillis + " milliseconds");
        System.out.println("This action completed in: " + durationSecs + " seconds");



    }




    public static void main(String [] args){


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


            TestLoad();
           // InsertNewUser("Jay", "Ta", "sta@gmail.com", "lso" );

            //Boolean b = CheckLoginInfo("sta@gmail.com", "lso");
            //System.out.println(b);




        }
        catch(Exception e){
            System.out.println("Caught Exception");


        }



    }




}
