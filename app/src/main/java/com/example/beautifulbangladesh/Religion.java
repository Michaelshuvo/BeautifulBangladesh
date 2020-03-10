package com.example.beautifulbangladesh;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Religion extends AppCompatActivity implements View.OnClickListener {
  Button muslim,hindu,christian,buddhist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.religion);
        muslim=(Button)findViewById(R.id.muslim);
        hindu=(Button)findViewById(R.id.hindu);
        christian=(Button)findViewById(R.id.christian);
        buddhist=(Button)findViewById(R.id.buddhist);
        muslim.setOnClickListener(this);
        hindu.setOnClickListener(this);
        christian.setOnClickListener(this);
        buddhist.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String data="0";
        if (v.getId() == R.id.muslim) {
            data = "muslim";
        } else if (v.getId() == R.id.hindu) {
            data = "hindu";
        } else if (v.getId() == R.id.christian) {
            data = "christian";
        } else if (v.getId() == R.id.buddhist) {
            data = "buddhist";
        }

        Intent intent = new Intent(Religion.this, ReadingPage.class);
        intent.putExtra("title",data);
        startActivity(intent);
    }
}
