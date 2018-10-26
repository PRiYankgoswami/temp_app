package com.example.admin.analyticaltesting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class news extends AppCompatActivity
{
    RecyclerView news_disp;
    List<news_class> news_data;
    news_adapter adapter;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        firebaseDatabase=FirebaseDatabase.getInstance();
        databaseReference=firebaseDatabase.getReference();


        news_disp=(RecyclerView)findViewById(R.id.new_disp);
        news_data=new ArrayList<>();
        adapter=new news_adapter(news_data);
        RecyclerView.LayoutManager manage=new LinearLayoutManager(news.this);
        news_disp.setLayoutManager(manage);
        news_disp.setItemAnimator(new DefaultItemAnimator());
        news_disp.setAdapter(adapter);

        databaseReference.child("news").addChildEventListener(new ChildEventListener()
        {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s)
            {
                Map<String,Object> newdata= (Map<String, Object>) dataSnapshot.getValue();
                List<String> key=new ArrayList<String>(newdata.keySet());
                Toast.makeText(news.this,newdata.size()+" "+key.size(),Toast.LENGTH_LONG).show();
                if(newdata.size()>0)
                {
                        //Map<String,String> temp=(Map<String, String>)newdata.get(key.get());
                        //Toast.makeText(news.this,,Toast.LENGTH_LONG).show();
                        //news_data.add(new news_class(temp.get("Title"),temp.get("Body"),null,null));
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) { }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) { }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) { }

            @Override
            public void onCancelled(DatabaseError databaseError) { }
        });

        /*databaseReference.child("news").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot)
            {
                Map<String,Object> newdata= (Map<String, Object>) dataSnapshot.getValue();
                List<String> key=new ArrayList<String>(newdata.keySet());
                Toast.makeText(news.this,newdata.size()+"",Toast.LENGTH_LONG).show();
                if(newdata.size()>0)
                {
                    for(int i=0;i<key.size();i++)
                    {
                        Map<String,String> temp=(Map<String, String>)newdata.get(key.get(i));
                        //Toast.makeText(news.this,,Toast.LENGTH_LONG).show();
                        news_data.add(new news_class(temp.get("Title"),temp.get("Body"),null,null));
                    }
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError)
            {

            }
        });*/

    }
}
