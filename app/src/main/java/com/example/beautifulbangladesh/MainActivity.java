package com.example.beautifulbangladesh;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
     Button religion,season,hospitality,food,attire,historical;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        religion=(Button)findViewById(R.id.religion);
        attire=(Button)findViewById(R.id.attire);
        hospitality=(Button)findViewById(R.id.hospitality);
        food=(Button)findViewById(R.id.food);
        historical=(Button)findViewById(R.id.historicaltspots);

        season=(Button)findViewById(R.id.season);
        religion.setOnClickListener(this);
        attire.setOnClickListener(this);
        food.setOnClickListener(this);
        season.setOnClickListener(this);
        hospitality.setOnClickListener(this);
        historical.setOnClickListener(this);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.exit:
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(1);

                return true;
            case R.id.logout:
                SharedPrefManager.getInstance(getApplicationContext()).logout();

                startActivity(new Intent(this, loginActivity.class));
                finish();
                return true;

        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onClick(View v) {

        if(v.getId()==R.id.religion){
            Intent intent=new Intent(MainActivity.this,Religion.class);
            startActivity(intent);
        }
        else if(v.getId()==R.id.season){
            Intent intent=new Intent(MainActivity.this,ReadingPage.class);
            intent.putExtra("title","seasion");
            startActivity(intent);

        }
        else if(v.getId()==R.id.hospitality){
            Intent intent=new Intent(MainActivity.this,ReadingPage.class);
            intent.putExtra("title","hospitality");
            startActivity(intent);

        }
        else if(v.getId()==R.id.food){
            Intent intent=new Intent(MainActivity.this,ReadingPage.class);
            intent.putExtra("title","food");
            startActivity(intent);

        }
        else if(v.getId()==R.id.attire){
            Intent intent=new Intent(MainActivity.this,ReadingPage.class);
            intent.putExtra("title","attire");
            startActivity(intent);

        }
        else if(v.getId()==R.id.historicaltspots){
            Intent intent=new Intent(MainActivity.this,HistoricaltSpots.class);
            startActivity(intent);

        }

    }
}
