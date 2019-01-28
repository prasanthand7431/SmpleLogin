package com.demo.second.samplelogin;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class Welcome extends AppCompatActivity {

    //private final static String USER_ID_KEY="com.demo.second.samplelogin.USER_ID_KEY";
    DatabaseManager mDatabaseManager3;
    private TextView mWelcomeText;
    private TextView mDetailText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        mWelcomeText=findViewById(R.id.welcome_user);
        mDetailText=findViewById(R.id.text_details);


        String a=getIntent().getStringExtra("userid");

        //Toast.makeText(this, ""+a, Toast.LENGTH_SHORT).show();

        mDatabaseManager3=new DatabaseManager(Welcome.this);
        Cursor c;
        c=mDatabaseManager3.fetchData(a);
        c.moveToFirst();
        String name=c.getString(c.getColumnIndex("Name"));
        String number=c.getString(c.getColumnIndex("Number"));
        String email=c.getString(c.getColumnIndex("Email"));
        String location=c.getString(c.getColumnIndex("Location"));


        mWelcomeText.setText("Welcome "+name);
        mDetailText.setText("Your details as follows: \n Mobile Number :"+number+"\n" +
                "Email ID: "+email+"\n Location :"+location);



    }
}
