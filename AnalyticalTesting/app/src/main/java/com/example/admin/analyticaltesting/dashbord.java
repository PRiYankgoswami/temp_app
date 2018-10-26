package com.example.admin.analyticaltesting;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import info.hoang8f.widget.FButton;

public class dashbord extends AppCompatActivity {

    private TextView mTextMessage;

    FButton news,testing,histroy;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashbord);

        news=(FButton)findViewById(R.id.news);
        testing=(FButton)findViewById(R.id.testing);
        histroy=(FButton)findViewById(R.id.history);

        news.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent i=new Intent(dashbord.this,news.class);
                startActivity(i);
            }
        });
        testing.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {

            }
        });
        histroy.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {

            }
        });

    }

}
