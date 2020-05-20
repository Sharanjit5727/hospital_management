
//Q5: Create a android app for “Hospital Management System” for 5 patients. In which you have to use the concept of either SQLite Database or Room Database.
// Avoid directly copying the code from any student/website.. Solution must be unique for each student.
package com.example.hospitalcse226;



import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;


public class MainActivity extends AppCompatActivity {
    EditText editTextEmail;
    EditText editTextPassword;

    //Declaration Button
    Button buttonLogin;
    TextInputLayout textInputLayoutEmail,textInputLayoutPassword;
    //Declaration SqliteHelper
    Databasehelper sqliteHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sqliteHelper = new Databasehelper(this);
        editTextEmail = (EditText) findViewById(R.id.edit_email);
        editTextPassword = (EditText) findViewById(R.id.edit_password);
        textInputLayoutEmail = (TextInputLayout) findViewById(R.id.textInputLayoutEmail);
        textInputLayoutPassword = (TextInputLayout) findViewById(R.id.textInputLayoutPassword);

        buttonLogin = (Button) findViewById(R.id.loginbutton);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Check user input is correct or not
                if (validate()) {

                    //Get values from EditText fields
                    String Email = editTextEmail.getText().toString();
                    String Password = editTextPassword.getText().toString();

                    //Authenticate user
                    User currentUser = sqliteHelper.Authenticate(new User(null, null, Email, Password));
                    if (currentUser != null) {
                        // Snackbar.make(buttonLogin, "Successfully Logged in!", Snackbar.LENGTH_LONG).show();
                        Toast.makeText(getApplicationContext(),"Successfully loggedin",Toast.LENGTH_SHORT).show();
                        Intent two= new Intent(MainActivity.this,Main2Activity.class);
                        startActivity(two);



                        // finish();
                    } else {

                        //User Logged in Failed
                        // Snackbar.make(buttonLogin, "Failed to log in , please try again", Snackbar.LENGTH_LONG).show();

                        Toast.makeText(getApplicationContext(),"Failed to log in , please try again",Toast.LENGTH_SHORT).show();

                    }
                }
            }
        });

    }

    public boolean validate()
    {
        boolean valid = false;

        //Get values from EditText fields
        String Email = editTextEmail.getText().toString();
        String Password = editTextPassword.getText().toString();

        //Handling validation for Email field
        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(Email).matches()) {
            valid = false;
            textInputLayoutEmail.setError("Please enter valid email!");


        } else {
            valid = true;
            textInputLayoutEmail.setError(null);
        }
        //Handling validation for Password field
        if (Password.isEmpty()) {
            valid = false;
            textInputLayoutPassword.setError("Please enter valid password!");


        } else {
            if (Password.length() > 5) {
                valid = true;
                textInputLayoutPassword.setError(null);
            } else
            {
                valid = false;
                textInputLayoutPassword.setError("Password is to short!");


            }
        }

        return valid;
    }

    public void func(View v)
    {
        Intent i=new Intent(MainActivity.this,Register.class);
        startActivity(i);
    }
}

