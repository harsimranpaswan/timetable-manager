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
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class SignUp extends AppCompatActivity {
    Button reg_signup;
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
    FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);

        progressDialog= new ProgressDialog(this);
        reg_signup= findViewById(R.id.reg_signup);
        reg_name= findViewById(R.id.reg_name);
        reg_age= findViewById(R.id.reg_age);
        reg_mail= findViewById(R.id.log_mail);
        reg_pass= findViewById(R.id.log_pass);
        reg_cnfpass= findViewById(R.id.reg_cnfpass);
        reg_signin= findViewById(R.id.reg_signin);

        auth=FirebaseAuth.getInstance();
        user=auth.getCurrentUser();
        db=FirebaseFirestore.getInstance();

        reg_signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignUp.this, SignIn.class));
            }
        });

        reg_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reg_method();
                fire_method();
            }
        });
    }

    private void reg_method(){
        String name=reg_name.getText().toString();
        String age=reg_age.getText().toString();
        String mail=reg_mail.getText().toString();
        String pass=reg_pass.getText().toString();
        String cnfpass=reg_cnfpass.getText().toString();

        if (name.isEmpty()){
            reg_name.setError("Please enter Name");
        }
        else if(!mail.matches(mail_verify)){
            reg_mail.setError("Please enter valid email address");
        }
        else if (pass.isEmpty() || pass.length()<8){
            reg_pass.setError("Password must contain atleast 8 letters");
        }
        else if(!cnfpass.equals(pass)) {
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
                        Toast.makeText(SignUp.this, "An Error Occured", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void fire_method(){
        String name=reg_name.getText().toString();
        String age=reg_age.getText().toString();
        String mail=reg_mail.getText().toString();
        String pass=reg_pass.getText().toString();

        Map<String, Object> user= new HashMap<>();
        user.put("Name", name);
        user.put("Age", age);
        user.put("Mail", mail);
        user.put("Password", pass);

        db.collection("user").add(user).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                Toast.makeText(SignUp.this, "User Registered Successfully", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void enterapp(){
        Intent intent= new Intent(this,MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}
