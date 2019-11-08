package com.homeworks.homework1_month3;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class OpenActivity extends AppCompatActivity {
    private TextView result;
    private Button share;
    private MainAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open);
        RecyclerView recyclerView = findViewById(R.id.op_recyclerView);
        adapter = new MainAdapter();
        recyclerView.setAdapter(adapter);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        result = findViewById(R.id.op_resultTextView);
        share = findViewById(R.id.share);
        if (result!=null){
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent shareIntent = new Intent();
                shareIntent.setAction(Intent.ACTION_SEND);
                shareIntent.putExtra(Intent.EXTRA_TEXT, adapter.list.toString());
                shareIntent.setType("text/plain");
                if (shareIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(shareIntent);
                }
            }
        });
    }
    }

    public void openCalc(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivityForResult(intent, 100);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == 100 && data != null) {
            String result1 = data.getStringExtra("key");
            result.setText(result1);
            adapter.addText(result1);
        }
    }
}
