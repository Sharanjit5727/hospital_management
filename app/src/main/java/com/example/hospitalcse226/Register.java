package com.example.hospitalcse226;



import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.os.Handler;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.material.textfield.TextInputLayout;

public class Register extends AppCompatActivity {
    EditText editTextUserName;
    EditText editTextEmail;
    EditText editTextPassword;

    TextInputLayout textInputLayoutEmail,textInputLayoutPassword,textInputLayoutUserName;


    //Declaration Button
    Button buttonRegister;

    //Declaration SqliteHelper
    Databasehelper sqliteHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        sqliteHelper = new Databasehelper(this);
        editTextEmail = (EditText) findViewById(R.id.edit_email);
        editTextPassword = (EditText) findViewById(R.id.edit_password);
        editTextUserName = (EditText) findViewById(R.id.edit_username);
        textInputLayoutEmail = (TextInputLayout) findViewById(R.id.textInputLayoutEmail);
        textInputLayoutPassword = (TextInputLayout) findViewById(R.id.textInputLayoutPassword);
        textInputLayoutUserName = (TextInputLayout) findViewById(R.id.textInputLayoutUserName);

        buttonRegister = (Button) findViewById(R.id.registerbutton);

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validate()) {
                    String UserName = editTextUserName.getText().toString();
                    String Email = editTextEmail.getText().toString();
                    String Password = editTextPassword.getText().toString();

                    //Check in the database is there any user associated with  this email
                    if (!sqliteHelper.isEmailExists(Email)) {

                        //Email does not exist now add new user to database
                        sqliteHelper.addUser(new User(null, UserName, Email, Password));
                        //Snackbar.make(buttonRegister, "User created successfully! Please Login ", Snackbar.LENGTH_LONG).show();
                        Toast.makeText(getApplicationContext(),"User created succesfully! Please Login",Toast.LENGTH_SHORT).show();
                        Intent login= new Intent(Register.this,MainActivity.class);
                        startActivity(login);
                    }else {

                        //Email exists with email input provided so show error user already exist
                        // Snackbar.make(buttonRegister, "User already exists with same email ", Snackbar.LENGTH_LONG).show();
                        Toast.makeText(getApplicationContext(),"User already exists with same email",Toast.LENGTH_SHORT).show();


                    }


                }
            }
        });
    }

    public boolean validate() {
        boolean valid = false;

        //Get values from EditText fields
        String UserName = editTextUserName.getText().toString();
        String Email = editTextEmail.getText().toString();
        String Password = editTextPassword.getText().toString();

        //Handling validation for UserName field
        if (UserName.isEmpty()) {
            valid = false;
            textInputLayoutUserName.setError("Please enter valid username!");
            // Toast.makeText(getApplicationContext(),"Please enter valid username!",Toast.LENGTH_SHORT).show();


        } else {
            if (UserName.length() > 5) {
                valid = true;
                textInputLayoutUserName.setError(null);
                // Toast.makeText(getApplicationContext(),"User already exists with same email",Toast.LENGTH_SHORT).show();

            }
            else {
                valid = false;
                textInputLayoutUserName.setError("Username is too short!");
                //Toast.makeText(getApplicationContext(),"Username is to short!",Toast.LENGTH_SHORT).show();

            }
        }

        //Handling validation for Email field
        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(Email).matches()) {
            valid = false;
            textInputLayoutEmail.setError("Please enter valid email!");
            //Toast.makeText(getApplicationContext(),"Please enter valid email!",Toast.LENGTH_SHORT).show();
        } else {
            valid = true;
            textInputLayoutEmail.setError(null);
        }

        //Handling validation for Password field
        if (Password.isEmpty()) {
            valid = false;
            textInputLayoutPassword.setError("Please enter valid password!");
            // Toast.makeText(getApplicationContext(),"Please enter valid password!",Toast.LENGTH_SHORT).show();
        } else {
            if (Password.length() > 5) {
                valid = true;
                textInputLayoutPassword.setError(null);
            }
            else {
                valid = false;
                textInputLayoutPassword.setError("Password is to short!");
                //Toast.makeText(getApplicationContext(),"Password is to short!",Toast.LENGTH_SHORT).show();
            }
        }


        return valid;
    }

    public void func1(View v)
    {
        Intent i=new Intent(Register.this,MainActivity.class);
        startActivity(i);
    }
}





