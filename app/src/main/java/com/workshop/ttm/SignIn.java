package com.workshop.ttm;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignIn extends AppCompatActivity{

    ProgressDialog progressDialog;
    EditText log_mail;
    EditText log_pass;
    Button log_signin;
    TextView log_signup;
    TextView log_forgot;
    String mail_verify="[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    FirebaseAuth auth;
    FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in);
        log_signup=findViewById(R.id.log_signup);
        log_signin=findViewById(R.id.reg_signup);
        log_pass=findViewById(R.id.log_pass);
        log_mail=findViewById(R.id.log_mail);
        progressDialog= new ProgressDialog(this);

        auth= FirebaseAuth.getInstance();
        user=auth.getCurrentUser();

        log_signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                log_method();
            }
        });

        log_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignIn.this, SignUp.class));
            }
        });
//       log_forgot.setOnClickListener(new View.OnClickListener() {
//           @Override
//           public void onClick(View v) { startActivity(new Intent(SignIn.this, ForgotPass.class)); }
//        });
    }


    private void log_method(){
        String mail=log_mail.getText().toString();
        String pass=log_pass.getText().toString();

        if(!mail.matches(mail_verify)){
            log_mail.setError("Please enter valid email address");
        }
        else if (pass.isEmpty() || pass.length()<8){
            log_pass.setError("Please enter valid password");
        }
        else{
            progressDialog.setMessage("Logging in");
            progressDialog.setTitle("Sign In");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();

            auth.signInWithEmailAndPassword(mail,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful())
                    {
                        progressDialog.dismiss();
                        enterapp();
                    }
                    else{
                        progressDialog.dismiss();
                        Toast.makeText(SignIn.this, "An Error Occured", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
    private void enterapp(){
        Intent intent= new Intent(this,MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}
