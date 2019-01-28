package com.demo.second.samplelogin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    private Button mSignUpButton;
    private Button mLogIn;
    private EditText mUserID;
    private EditText mPassword;
    DatabaseManager mDatabaseManager2;
    //private final static String USER_ID_KEY="com.demo.second.samplelogin.USER_ID_KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSignUpButton=findViewById(R.id.button_sign_up);
        mLogIn=findViewById(R.id.button_log_in);
        mUserID=findViewById(R.id.text_mobile_number);
        mPassword=findViewById(R.id.text_user_password);

        mSignUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,SignUp.class);
                startActivity(i);

            }
        });

        mLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String sUserName,sPassword;
                sUserName=mUserID.getText().toString();
                sPassword=mPassword.getText().toString();

                if(sUserName.isEmpty()||sPassword.isEmpty()){

                    Toast.makeText(MainActivity.this, "Kindly provide user id and password", Toast.LENGTH_SHORT).show();
                }else
                {

                    mDatabaseManager2=new DatabaseManager(MainActivity.this);
                    int a=mDatabaseManager2.checkUser(sUserName,sPassword);

                    if(a==1){

                        Intent i =new Intent(MainActivity.this,Welcome.class);
                        i.putExtra("userid",sUserName);
                        startActivity(i);
                        finish();


                    }else if(a==0){

                        Toast.makeText(MainActivity.this, "Invalid credentials. Try again.", Toast.LENGTH_SHORT).show();
                    }

                }



            }
        });
    }
}
