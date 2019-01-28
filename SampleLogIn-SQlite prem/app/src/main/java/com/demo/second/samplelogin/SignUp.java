package com.demo.second.samplelogin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class SignUp extends AppCompatActivity {

    EditText mUserName;
    private EditText mMobileNumber;
    private EditText mPassword;
    private EditText mConfirmPassword;
    private EditText mEmailId;
    private EditText mLocation;

    DatabaseManager mDatabaseManager;

    private Button mSignupButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        mUserName=findViewById(R.id.et_user_name);
        mMobileNumber=findViewById(R.id.et_mobile_number);
        mPassword=findViewById(R.id.et_user_password);
        mConfirmPassword=findViewById(R.id.et_confirm_password);
        mEmailId=findViewById(R.id.et_email_id);
        mLocation=findViewById(R.id.et_location);

        mSignupButton=findViewById(R.id.button_rsign_up);


        //final int iMobileNumber;







        mSignupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String sName,sMobileNumber,sPassword,sConfirmPassword,sEmailId,sLocation;

                sName=mUserName.getText().toString();
                sMobileNumber=mMobileNumber.getText().toString();
                sPassword=mPassword.getText().toString();
                sConfirmPassword=mConfirmPassword.getText().toString();
                sEmailId=mEmailId.getText().toString();
                sLocation=mLocation.getText().toString();

                if(sName.isEmpty() || sMobileNumber.isEmpty() || sPassword.isEmpty() || sConfirmPassword.isEmpty() || sEmailId.isEmpty() || sLocation.isEmpty() ){

                    Toast.makeText(SignUp.this, "Kindly fill all details", Toast.LENGTH_SHORT).show();



                }else if (sPassword.equals(sConfirmPassword)){

                    mDatabaseManager=new DatabaseManager((SignUp.this));

                    long h=mDatabaseManager.saveIt(sName,sMobileNumber,sPassword,sEmailId,sLocation);

                    if (h>0){
                        Toast.makeText(SignUp.this, "User Created. Kindly login now", Toast.LENGTH_SHORT).show();
                        finish();
                    }


                }else {

                    Toast.makeText(SignUp.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
                    mPassword.setText("");
                    mConfirmPassword.setText("");
                }

            }
        });



    }
}
