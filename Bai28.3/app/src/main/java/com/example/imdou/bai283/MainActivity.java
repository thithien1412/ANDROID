package com.example.imdou.bai283;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btncreatecache,btnreadcache;
    EditText editdata;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btncreatecache=(Button) findViewById(R.id.btncreatecache);
        btnreadcache=(Button) findViewById(R.id.btnreadcache);
        editdata =(EditText) findViewById(R.id.editdata);
        btncreatecache.setOnClickListener(this);
        btnreadcache.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        if(v.getId()==R.id.btncreatecache)
        {
            createCache();
        }
        else if(v.getId()==R.id.btnreadcache)
        {
            readCache();
        }
    }
    /**
     * Lấy toàn bộ file cache
     */
    public void loadAllCache()
    {
        File pathCacheDir = getCacheDir();
        File []listCache= pathCacheDir.listFiles();
        for(File f :listCache)
        {
            //process f here
            f.delete();
        }
    }
    /**
     * đọc cache file
     * getCacheDir() trả về đúng thư mục cache
     */
    public void readCache() {
        try {
            File pathCacheDir = getCacheDir();
            String strCacheFileName = "myCacheFile.cache";
            File newCacheFile = new
                    File(pathCacheDir, strCacheFileName);
            Scanner sc=new Scanner(newCacheFile);
            String data="";
            while(sc.hasNext())
            {
                data+=sc.nextLine()+"\n";
            }
            editdata.setText(data);
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    /**
     * Lưu cache file
     */
    public void createCache()
    {
        try {
            File pathCacheDir = getCacheDir();
            String strCacheFileName = "myCacheFile.cache";
            String strFileContents = editdata.getText()+"";
            File newCacheFile = new
                    File(pathCacheDir, strCacheFileName);
            newCacheFile.createNewFile();
            FileOutputStream foCache =
                    new FileOutputStream(
                            newCacheFile.getAbsolutePath());
            foCache.write(strFileContents.getBytes());
            foCache.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
