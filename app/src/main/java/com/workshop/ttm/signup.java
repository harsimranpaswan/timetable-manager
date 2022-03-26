package com.workshop.ttm;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class signup extends AppCompatActivity {
    Button reg_button;
    EditText reg_name;
    EditText reg_age;
    EditText reg_mail;
    EditText reg_pass;
    EditText reg_cnfpass;
    TextView reg_signin;
    ProgressDialog progressDialog;
    String mail_verify="[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    FirebaseAuth auth;
    FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);

        reg_button= findViewById(R.id.reg_button);
        reg_name= findViewById(R.id.reg_name);
        reg_age= findViewById(R.id.reg_age);
        reg_mail= findViewById(R.id.reg_mail);
        reg_pass= findViewById(R.id.reg_pass);
        reg_cnfpass= findViewById(R.id.reg_cnfpass);
        reg_signin= findViewById(R.id.reg_signin);

        auth=FirebaseAuth.getInstance();
        user=auth.getCurrentUser();

        reg_signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(signup.this, signin.class));
            }
        });

        reg_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reg_method();
            }
        });
    }

    private void reg_method(){
        String name=reg_name.getText().toString();
        String age=reg_age.getText().toString();
        String mail=reg_mail.getText().toString();
        String pass=reg_pass.getText().toString();
        String cnfpass=reg_cnfpass.getText().toString();

        if(mail.matches(mail_verify)){
            reg_mail.setError("Please enter valid email address");
        }
        else if (pass.isEmpty() || pass.length()<8){
            reg_pass.setError("Password must contain atleast 8 letters");
        }
        else if(cnfpass.equals(pass)) {
            reg_cnfpass.setError("Passwords do not match");
        }
        else{
            progressDialog.setMessage("Registering");
            progressDialog.setTitle("Registration");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();

            auth.createUserWithEmailAndPassword(mail,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful())
                    {
                        progressDialog.dismiss();
                        enterapp();
                    }
                    else{
                        progressDialog.dismiss();
                        Toast.makeText(signup.this, "An Error Occured", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
    private void enterapp(){
        Intent intent= new Intent(signup.this,MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}
