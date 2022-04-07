package com.workshop.ttm;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;


public class ForgotPass extends AppCompatActivity {
    EditText forgot_mail;
    Button forgot_link;
    ProgressBar progressBar;
    FirebaseAuth auth;
    String mail_verify="[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forgot_password);

        forgot_mail=findViewById(R.id.forgot_mail);
        forgot_link=findViewById(R.id.forgot_link);
        progressBar= new ProgressBar(this);

        auth=FirebaseAuth.getInstance();

        forgot_link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reset_pass();
            }
        });
    }

    private void reset_pass(){
        String mail=forgot_mail.getText().toString().trim();

        if(!mail.matches(mail_verify)){
            forgot_mail.setError("Please enter valid email address");
        }
        else{
        progressBar.setVisibility(View.VISIBLE);
        auth.sendPasswordResetEmail(mail).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {

                if (task.isSuccessful()) {
                    Toast.makeText(ForgotPass.this, "A Password reset email has been sent to you", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(ForgotPass.this, "An Error Occured", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }}
}
