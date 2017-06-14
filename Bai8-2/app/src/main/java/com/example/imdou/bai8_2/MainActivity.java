package com.example.imdou.bai8_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText edtNam;
    Button btnDoi;
    TextView txtKq;
    String[] chi,can;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtNam = (EditText) findViewById(R.id.edt1);
        btnDoi = (Button) findViewById(R.id.btn1);
        txtKq = (TextView) findViewById(R.id.txt1);
        can = new String[]{"Canh","Tân","Nhâm","Quý","Giáp","Ất","Bính","Đinh","Mậu","Kỷ"};
        chi = new String[]{"Thân","Dậu","Tuất","Hợi","Tý","Sửu","Dần","Mẹo","Thìn","Tị","Ngọ","Mùi"};
        btnDoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String kq;
                kq = can[Integer.parseInt(edtNam.getText().toString())%10] + " " + chi[Integer.parseInt(edtNam.getText().toString())%12];
                txtKq.setText(kq);
            }
        });
    }
}
