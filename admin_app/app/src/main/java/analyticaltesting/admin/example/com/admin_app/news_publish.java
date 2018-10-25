package analyticaltesting.admin.example.com.admin_app;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class news_publish extends AppCompatActivity
{
    Button send;
    EditText news_body,news_title;
    FirebaseDatabase fb;
    DatabaseReference dr;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_publish);

        fb= FirebaseDatabase.getInstance();
        dr=fb.getReference();
        send=(Button)findViewById(R.id.send);
        news_body=(EditText)findViewById(R.id.news_body);
        news_title=(EditText)findViewById(R.id.news_title);

        send.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String title=news_title.getText().toString();
                String body=news_body.getText().toString();

                if(!title.isEmpty()&&!body.isEmpty())
                {
                    Map<String,String> news=new HashMap<>();
                    news.put("Title",title);
                    news.put("Body",body);


                    dr.child("news").push().setValue(news).addOnCompleteListener(new OnCompleteListener<Void>()
                    {
                        @Override
                        public void onComplete(@NonNull Task<Void> task)
                        {

                            Toast.makeText(getApplicationContext(),"News Published", Toast.LENGTH_SHORT).show();

                        }
                    }).addOnFailureListener(new OnFailureListener()
                    {
                        @Override
                        public void onFailure(@NonNull Exception e)
                        {
                            Toast.makeText(getApplicationContext(),"News Not Published", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Fields Cannot be Empty",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
