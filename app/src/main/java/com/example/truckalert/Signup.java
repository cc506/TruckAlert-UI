package com.example.truckalert;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.app.Activity;
import android.view.View.OnClickListener;
import android.support.design.widget.TextInputEditText;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

//import android.EditText
public class Signup extends AppCompatActivity {

    private Button button_Signup2;
     String nameInput;
    EditText eiteText;
    EditText eiteText2;
    EditText eiteText3;
    EditText eiteText4;
    String first_Name;
    String last_Name;
    String Email;
    String Password;

    //Button Signup2;
    TextView mText1, mText2, mText3, mText4;

    public void InsertNewUser2 (String firstName, String lastName, String emaiL, String passWord){

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
    }

    public void extractStringInputs(View v) {

        eiteText=(EditText)findViewById(R.id.FirstNameInput);
        mText1=(TextView)findViewById(R.id.FirstName);
        mText1.setText(mText1.getText().toString());
        first_Name=eiteText.getText().toString();
        Log.d("TAG",first_Name);


        eiteText2=(EditText)findViewById(R.id.LastNameInput);
        mText2=(TextView)findViewById(R.id.LastName);
        mText2.setText(mText2.getText().toString());
        last_Name=eiteText2.getText().toString();
        Log.d("TAG",last_Name);

        eiteText3=(EditText)findViewById(R.id.EmailInput);
        mText3=(TextView)findViewById(R.id.Email);
        mText3.setText(mText3.getText().toString());
        Email=eiteText3.getText().toString();
        Log.d("TAG",Email);

        eiteText4=(EditText)findViewById(R.id.PasswordInput);
        mText4=(TextView)findViewById(R.id.Password);
        mText4.setText(mText4.getText().toString());
        Password=eiteText4.getText().toString();
        Log.d("TAG",Password);


        System.out.println(first_Name);
        System.out.println(last_Name);
        System.out.println(Email);
        System.out.println(Password);


    }


    public void StoreUser(){
        first_Name = "Louis";
        last_Name = "Theroux";
        Email = "musiclover@gmail.com";
        Password = "fdfdfdfdf";

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //go to Sign in screen after signing up
        setContentView(R.layout.activity_signup2);
        button_Signup2 = findViewById(R.id.button_Signup);
        button_Signup2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Signup.this, LoginActivity2.class);
                extractStringInputs(v);
                //StoreUser();
                InsertNewUser2(first_Name, last_Name, Email, Password);
                startActivity(intent);
            }
        });
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // go back to signin screen
        Button signin_signup = findViewById(R.id.button_signin);
        signin_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goBackIntent = new Intent(Signup.this, LoginActivity2.class);
               // startActivity(JDBC.InsertNewUser(first_Name, last_Name, Email, Password));
                startActivity(goBackIntent);

            }


        });


    }

    //public static void main (String[]args){
        //onCreate();
    //}

}
