package com.poorientada.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageButton ibPlantas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ibPlantas = (ImageButton)findViewById(R.id.ibPlantas);

        ibPlantas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Plantas.class);
                startActivity(i);
            }
        });

        ImageButton ibMisPlantas = (ImageButton) findViewById(R.id.ibMisPlantas);

        ibMisPlantas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, misPlantas.class);
                startActivity(i);
            }
        });

        ImageButton ibPestes = (ImageButton) findViewById(R.id.ibPestes);

        ibPestes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Pestes.class);
                startActivity(i);
            }
        });

    }
    public void presion(View v){
        Toast.makeText(this, "Prueba de que sirve botón", Toast.LENGTH_SHORT).show();

        }


    }
