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


    //String email = first_name.getText().toString();
   // String password = button_Signup2.getText().toString();

    public void extractStringInputs(View arg0) {
        eiteText=(EditText)findViewById(R.id.first_name);
        String first_Name=eiteText.getText().toString();
        Log.d("TAG",first_Name);

        eiteText2=(EditText)findViewById(R.id.last_name);
        String last_Name=eiteText.getText().toString();
        Log.d("TAG",last_Name);

        eiteText3=(EditText)findViewById(R.id.email);
        String Email=eiteText.getText().toString();
        Log.d("TAG",Email);




        //JDBC.InsertNewUser(String first_Name, String last_Name, String Email, String passWord)

        //System.out.println(firstName);
        //System.out.println(lastName);
    }


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
