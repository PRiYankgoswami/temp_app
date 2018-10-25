
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

import info.hoang8f.widget.FButton;

public class account_maker extends AppCompatActivity
{
    FButton create_acc;
    EditText name,surname,email,password;
    FirebaseDatabase fb;
    DatabaseReference dr;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_maker);
        fb=FirebaseDatabase.getInstance();
        dr=fb.getReference();

        create_acc=(FButton)findViewById(R.id.create_user);
        name=(EditText)findViewById(R.id.user_name);
        surname=(EditText)findViewById(R.id.user_surname);
        email=(EditText)findViewById(R.id.user_email);
        password=(EditText)findViewById(R.id.user_password);

        create_acc.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
              String tname=name.getText().toString();
              String tsurname=surname.getText().toString();
              String temail=email.getText().toString();
              String tpass=password.getText().toString();
              if(!tname.isEmpty()&&!tsurname.isEmpty()&&!temail.isEmpty()&&!tpass.isEmpty())
              {
                  Map<String,String> userdata=new HashMap<>();

                  userdata.put("Email",temail);
                  userdata.put("Password",tpass);
                  userdata.put("Name",tname);
                  userdata.put("Surname",tsurname);


                  dr.child("user_loign").child(temail).setValue(userdata).addOnCompleteListener(new OnCompleteListener<Void>()
                  {
                      @Override
                      public void onComplete(@NonNull Task<Void> task)
                      {

                          Toast.makeText(getApplicationContext(),"Account Generated", Toast.LENGTH_SHORT).show();

                      }
                  }).addOnFailureListener(new OnFailureListener()
                  {
                      @Override
                      public void onFailure(@NonNull Exception e)
                      {
                          Toast.makeText(getApplicationContext(),"Account Not Generated", Toast.LENGTH_SHORT).show();
                      }
                  });
              }
              else
              {

              }
            }
        });


    }
}
