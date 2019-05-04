package com.example.truckalert;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

//import android.EditText
public class Signup extends AppCompatActivity {
    private Button button_Signup2;
    private String nameInput;
    private EditText eiteText;
    private EditText eiteText2;
    private EditText eiteText3;
    private EditText eiteText4;
    String first_Name;
    String last_Name;
    String Email;
    String Password;



    public void extractStringInputs(View arg0) {

        eiteText=(EditText)findViewById(R.id.first_name);
        first_Name=eiteText.getText().toString();
        Log.d("TAG",first_Name);

        eiteText2=(EditText)findViewById(R.id.last_name);
        last_Name=eiteText2.getText().toString();
        Log.d("TAG",last_Name);

        eiteText3=(EditText)findViewById(R.id.email);
        Email=eiteText3.getText().toString();
        Log.d("TAG",Email);

        eiteText4=(EditText)findViewById(R.id.password);
        Password=eiteText4.getText().toString();
        Log.d("TAG",Password);


        System.out.println(first_Name);
        System.out.println(last_Name);
        System.out.println(Email);
        System.out.println(Password);


    }

    //public void onCreate


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //go to Sign in screen after signing up
        setContentView(R.layout.activity_signup);
        button_Signup2 = findViewById(R.id.button_Signup);
        button_Signup2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Signup.this, LoginActivity2.class);
                //JDBC.InsertNewUser(first_Name, last_Name, Email, Password);
                JDBC.InsertNewUser(first_Name, last_Name, Email, Password);
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

        FloatingActionButton mfab = findViewById(R.id.fab);
        mfab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    //public static void main (String[]args){
    //    onClick();
   // }

}
