package com.example.imdou.bai11;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edtHoten,edtCMND,edtBosung;
    RadioGroup rad;
    CheckBox ck1,ck2,ck3;
    Button btnOk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtHoten = (EditText) findViewById(R.id.edtHoten);
        edtBosung = (EditText) findViewById(R.id.edtBosung);
        edtCMND = (EditText) findViewById(R.id.edtCMND);
        rad = (RadioGroup) findViewById(R.id.radgr1);
        ck1 = (CheckBox) findViewById(R.id.ck1);
        ck2 = (CheckBox) findViewById(R.id.ck2);
        ck3 = (CheckBox) findViewById(R.id.ck3);
        btnOk = (Button) findViewById(R.id.btnOk);
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                XuLy();
            }
        });
    }
    public void XuLy(){
        String hoten,cmnd,bangcap,sothich = "",kq,bosung;
        int id;
        hoten = edtHoten.getText().toString();
        if (hoten.length()<3){
            edtHoten.requestFocus();
            Toast.makeText(this, "Họ tên phải nhiều hơn 3 ký tự", Toast.LENGTH_SHORT).show();
            return;
        }
        cmnd = edtCMND.getText().toString();
        if (cmnd.length()!=9){
            edtCMND.requestFocus();
            Toast.makeText(this, "CMND phải đủ 9 số", Toast.LENGTH_SHORT).show();
            return;
        }
        id = rad.getCheckedRadioButtonId();
        if (id == R.id.rad1) bangcap = "Trung cấp";
        else if (id == R.id.rad2) bangcap = "Cao đẳng";
        else bangcap = "Đại học";

        if (!ck1.isChecked() && !ck2.isChecked() && !ck3.isChecked()){
            Toast.makeText(this, "Phải chọn ít nhất 1 sở thích", Toast.LENGTH_SHORT).show();
            return;
        }
        else {
            if (ck1.isChecked()) sothich += ck1.getText() + "\n";
            if (ck2.isChecked()) sothich += ck2.getText() + "\n";
            if (ck3.isChecked()) sothich += ck3.getText() + "\n";
        }
        bosung = edtBosung.getText().toString();

        kq = hoten + "\n";
        kq = kq + cmnd + "\n";
        kq = kq + bangcap + "\n";
        kq = kq + sothich + "\n";
        kq = kq + "-------------------- \n";
        kq = kq + "Thông tin bổ sung \n";
        kq = kq + bosung + ": \n";
        kq = kq + "-------------------- \n";
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Thông tin cá nhân");
        alert.setPositiveButton("Đóng", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        alert.setMessage(kq);
        alert.create().show();
    }
}
