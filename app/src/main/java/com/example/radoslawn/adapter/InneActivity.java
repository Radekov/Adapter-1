package com.example.radoslawn.adapter;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class InneActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inne);
        List<File> files = new ArrayList<File>();
        File root = Environment.getExternalStorageDirectory();
        File[] list = root.listFiles();
        for(File tmp : list){
            tmp = new File(tmp.getAbsolutePath(),tmp.getName());

        }
    }
}
