package com.example.voting;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity{
    private Button button;
    private Button admin;
    private EditText rollNumber;
    private EditText passcode;
    public String enterpasscode;
//    admin.setEnabled(false);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rollNumber = (EditText) findViewById(R.id.rollEnter);
        passcode = (EditText) findViewById(R.id.passcodeEnter);
        button = (Button) findViewById(R.id.login_button);
        enterpasscode = "msit1234";
        admin = (Button) findViewById(R.id.admin);
//        EditText edit = (EditText) findViewById(R.id.passcode);
        passcode = (EditText) findViewById(R.id.passcodeEnter);
        passcode.setEnabled(false);
        Button ko = (Button) findViewById(R.id.ok);
        ko.setEnabled(false);
        admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText edit = (EditText) findViewById(R.id.passcodeEnter);
                edit.setEnabled(true);
                Button ko = (Button) findViewById(R.id.ok);
                ko.setEnabled(true);
            }
        });


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createAccount();
            }
        }) ;
    }
    public void openActivity() {
        Intent intent = new Intent(this, Casting.class);
        startActivity(intent);
    }
//    public void openActivity1() {
//        Intent intent = new Intent(this, StatusActivity.class);
//        startActivity(intent);
//    }
    public void createAccount() {
        String rollnum = rollNumber.getText().toString();
        String name = passcode.getText().toString();

        if (TextUtils.isEmpty(rollnum)) {
            rollNumber.setError("Enter roll number");
        }
        else if (TextUtils.isEmpty(name)) {
            passcode.setError("Enter password");

        } else if (!(name.equals(enterpasscode))){
            passcode.setError("Enter valid passcode");

        } else {
            validateCredentials(rollnum);
        }

    }
    private void validateCredentials(final String checkroll) {
        final DatabaseReference rootref;
        rootref = FirebaseDatabase.getInstance().getReference();
        rootref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(!(dataSnapshot.child("Users").child(checkroll).exists())) {
                    HashMap<String, Object> userdetails = new HashMap<>();
                    userdetails.put("checkroll", checkroll);


                    rootref.child("Users").child(checkroll).updateChildren(userdetails)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        openActivity();
                                    }
                                }
                            });
              }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}

