package com.workshop.ttm;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Profile extends Fragment {
    Button profile_logout;
    FirebaseAuth mauth;
    FirebaseUser muser;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_profile, container, false);

        profile_logout=v.findViewById(R.id.profile_logout);

        mauth= FirebaseAuth.getInstance();
        muser=mauth.getCurrentUser();

        profile_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mauth.signOut();
                log_out();
            }
        });
        return v;
    }
    public void log_out(){
        Intent intent= new Intent(getActivity(),SignIn.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
}