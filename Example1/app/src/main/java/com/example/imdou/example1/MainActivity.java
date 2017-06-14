package com.example.imdou.example1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btncount;
    TextView txt1;
    RadioButton rad1,rad2;
    int sum = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btncount = (Button)findViewById(R.id.btncount);
        txt1 = (TextView)findViewById(R.id.txt1);
        rad1 = (RadioButton)findViewById(R.id.rad1);
        rad2 = (RadioButton)findViewById(R.id.rad2);

        btncount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rad1.isChecked()) sum = sum+1;
                else sum = sum -1;
                txt1.setText(sum + "");
            }
        });


    }
}
