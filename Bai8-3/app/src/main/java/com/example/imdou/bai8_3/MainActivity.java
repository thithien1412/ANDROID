package com.example.imdou.bai8_3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText edtTen,edtChieucao,edtCannang,edtBmi,edtChuandoan;
    Button btnDoi;
    String[] chi,can;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtTen = (EditText) findViewById(R.id.edtTen);
        edtChieucao = (EditText) findViewById(R.id.edtChieuCao);
        edtCannang = (EditText) findViewById(R.id.edtCanNang);
        edtBmi = (EditText) findViewById(R.id.edtBmi);
        edtChuandoan = (EditText) findViewById(R.id.edtChuanDoan);
        btnDoi = (Button) findViewById(R.id.btnDoi);

        btnDoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float BMI;
                BMI = Float.parseFloat(edtCannang.getText().toString())/(Float.parseFloat(edtChieucao.getText().toString())*Float.parseFloat(edtChieucao.getText().toString()));
                BMI = (float)Math.round(BMI*10)/10;
                edtBmi.setText(BMI+"");
                if (BMI < 18) edtChuandoan.setText("Người gầy");
                else if (BMI < 25) edtChuandoan.setText("Người bình thường");
                else if (BMI < 30) edtChuandoan.setText("Người béo phì độ I");
                else if (BMI < 35 ) edtChuandoan.setText("Người béo phì độ II");
                else  edtChuandoan.setText("Người béo phì độ III");
            }
        });
    }

}
