package com.example.beautifulbangladesh;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class HistoricaltSpots extends AppCompatActivity {
Button AhsanManzil,CoxsBazar,Floatingmarkets,LalbaghFort,NationalMemorialr,Paharpur,RatargulSwampForest,SaintMartin,Sajekvalley,ShahidMinar,Srimangal,SylhetTeaGarden,
        Tajhat,TheSundarban;
ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.historical);
        final String[] iteam=getResources().getStringArray(R.array.historicalspot);
        final String[] iteamname=getResources().getStringArray(R.array.historicalspotfile);
        listView=(ListView)findViewById(R.id.listview);
        ArrayAdapter<String> adapter=new ArrayAdapter<>(this,R.layout.listviewwww,R.id.textt,iteam);
         listView.setAdapter(adapter);
         listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
             @Override
             public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                 String title=iteamname[position];
                 Intent intent=new Intent(HistoricaltSpots.this,ReadingPage.class);
                 intent.putExtra("title","historicalspots/"+title);
                // intent.putExtra("title","historicalspots/"+title);

                 startActivity(intent);
             }
         });
    }

    }

