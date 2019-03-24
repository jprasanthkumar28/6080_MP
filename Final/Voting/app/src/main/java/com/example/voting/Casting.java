package com.example.voting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;


public class Casting extends AppCompatActivity {
    Button button;
    RadioButton candid1;
    RadioButton candid2;
    RadioButton candid3;
    RadioButton candid4;
    final Count obj = new Count();
    @Override
    protected void onCreate(Bundle savedInstanceState) {

            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_casting);

            candid1 = (RadioButton) findViewById(R.id.R1);
            candid2 = (RadioButton) findViewById(R.id.R2);
            candid3 = (RadioButton) findViewById(R.id.R3);
            candid4 = (RadioButton) findViewById(R.id.R4);
            button = (Button) findViewById(R.id.submit_button);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    count();
                }
            });
        }
        public void selectCandidate (View v){

            switch (v.getId()) {
                case R.id.R1:
                    if (candid1.isChecked()) {
                        candid2.setEnabled(false);
                        candid3.setEnabled(false);
                        candid4.setEnabled(false);
                        obj.setCandid1(1);
                    } else {
                        candid3.setEnabled(true);
                        candid2.setEnabled(true);
                        candid4.setEnabled(true);
                    }
                    break;

                case R.id.R2:
                    if (candid2.isChecked()) {
                        candid1.setEnabled(false);
                        candid3.setEnabled(false);
                        candid4.setEnabled(false);
                        obj.setCandid2(1);
                    } else {
                        candid1.setEnabled(true);
                        candid3.setEnabled(true);
                        candid4.setEnabled(true);
                    }
                    break;

                case R.id.R3:
                    if (candid3.isChecked()) {
                        candid2.setEnabled(false);
                        candid1.setEnabled(false);
                        candid4.setEnabled(false);
                        obj.setCandid3(1);
                    } else {
                        candid1.setEnabled(true);
                        candid2.setEnabled(true);
                        candid4.setEnabled(true);
                    }
                    break;

                case R.id.R4:
                    if (candid4.isChecked()) {
                        candid2.setEnabled(false);
                        candid1.setEnabled(false);
                        candid3.setEnabled(false);
                        obj.setCandid4(1);
                    } else {
                        candid1.setEnabled(true);
                        candid2.setEnabled(true);
                        candid3.setEnabled(true);
                    }
                    break;
            }

        }


        private void count () {

            final DatabaseReference rootref;
            rootref = FirebaseDatabase.getInstance().getReference();

            rootref.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                    HashMap<String, Object> countlist = new HashMap<>();
                    countlist.put("candid-1 count", obj.getCandid1() + "");
                    countlist.put("candid-2 count", obj.getCandid2() + "");
                    countlist.put("candid-3 count", obj.getCandid3() + "");
                    countlist.put("candid-4 count", obj.getCandid4() + "");
                    rootref.child("Users").child("").updateChildren(countlist)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        openActivity();
                                    }
                                }
                            });
                    //getting old values
                    rootref.child("Count").child("candid-1 count").addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            String temp = dataSnapshot.getValue().toString();
//                        int t = Integer.parseInt(temp);
                            System.out.println("temp is " + temp);
                            int t = Integer.parseInt(temp);

                            obj.setCandid1(t);
                        }


                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });

                    rootref.child("Count").child("candid-2 count").addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            String temp = dataSnapshot.getValue().toString();
//                        int t = Integer.parseInt(temp);
                            System.out.println("temp is " + temp);
                            int t = Integer.parseInt(temp);

                            obj.setCandid2(t);
                        }


                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    rootref.child("Count").child("candid-3 count").addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            String temp = dataSnapshot.getValue().toString();
//                        int t = Integer.parseInt(temp);
                            System.out.println("temp is " + temp);
                            int t = Integer.parseInt(temp);

                            obj.setCandid3(t);
                        }


                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    rootref.child("Count").child("candid-4 count").addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            String temp = dataSnapshot.getValue().toString();
//                        int t = Integer.parseInt(temp);
                            System.out.println("temp is " + temp);
                            int t = Integer.parseInt(temp);

                            obj.setCandid4(t);
                        }


                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            openActivity();
                        }
                    });
//                    final DatabaseReference rootref1;
//                    rootref1 = FirebaseDatabase.getInstance().getReference();
//                    System.out.println("value is " + obj.getCandid1());
//                    rootref1.child("Count").setValue(obj);


                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }
        public void openActivity() {
            final DatabaseReference rootref1;
                    rootref1 = FirebaseDatabase.getInstance().getReference();
                    System.out.println("value is " + obj.getCandid1());
                    rootref1.child("Count").setValue(obj);

                    Intent intent = new Intent(this,ResultsActivity.class);
                    intent.putExtra("candidate -1", obj.getCandid1());
            intent.putExtra("candidate -2", obj.getCandid2());
            intent.putExtra("candidate -3", obj.getCandid3());
            intent.putExtra("candidate -4", obj.getCandid4());
            startActivity(intent);


        }
    }