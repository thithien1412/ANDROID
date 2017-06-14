package com.example.imdou.bai8_4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText edtF,edtC;
    Button btnF,btnC,btnClear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtF = (EditText) findViewById(R.id.edtF);
        edtC = (EditText) findViewById(R.id.edtC);
        btnClear = (Button) findViewById(R.id.btnClear);
        btnC = (Button) findViewById(R.id.btnC);
        btnF = (Button) findViewById(R.id.btnF);
        btnF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float F,C;
                if (edtC.getText().length()==0) {edtC.setText("Nhập C !");edtF.setText("");}

                else {C=Float.parseFloat(edtC.getText().toString());
                    F=C * (float)9/5 + 32;
                    edtF.setText(F+"");}
            }
        });
        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float C,F;

                if (edtF.getText().length()==0) {edtF.setText("Nhập F !");edtC.setText("");}
                else {F=Float.parseFloat(edtF.getText().toString());
                    C=(F-32) * (float)5/9;
                    edtC.setText(C+"");}
            }
        });
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtC.setText("");
                edtF.setText("");
            }
        });
    }

}
