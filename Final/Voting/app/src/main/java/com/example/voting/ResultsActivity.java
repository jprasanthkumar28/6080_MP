package com.example.voting;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.voting.MainActivity;
import com.example.voting.R;

public class ResultsActivity extends AppCompatActivity {
    Button logoutbutton;
    TextView tv1;
    TextView tv2;
    TextView tv3;
    TextView tv4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        tv1 = ((TextView)findViewById(R.id.textView11));
        tv1.setText(getIntent().getStringExtra("candidate -1"));


        tv2 = ((TextView)findViewById(R.id.textView12));
        tv2.setText(getIntent().getStringExtra("candidate -2"));

        tv3 = ((TextView)findViewById(R.id.textView13));
        tv3.setText(getIntent().getStringExtra("candidate -3"));

        tv4 = ((TextView)findViewById(R.id.textView14));
        tv4.setText(getIntent().getStringExtra("candidate -4"));




//        int intValue = mIntent.getIntExtra("pubgcount", 0);
        logoutbutton = (Button) findViewById(R.id.logout_button);
        logoutbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity();
            }
        }) ;
    }
    public void openActivity() {
        Intent intent = new Intent(this, MainActivity.class);

        startActivity(intent);
    }
}