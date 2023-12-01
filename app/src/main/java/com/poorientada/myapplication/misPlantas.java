package com.poorientada.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class misPlantas extends AppCompatActivity {

    final int[] Humedadpiso = new int[1];
    final int[] Humedadpiso2 = new int[1];
    final int[] Humedadpiso3 = new int[1];
    final Float[] Temperatura = new Float[1];
    final Float[] Humedad = new Float[1];
    TextView mHumedadDePisoTextView;
    TextView mTemperaturaTextView;
    TextView mHumedadTextView;
    int opcion = 0;

    private DatabaseReference mDatabaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mis_plantas);

        mHumedadDePisoTextView = findViewById(R.id.humedadDePisoTextView);
        mTemperaturaTextView = findViewById(R.id.temperaturaTextView);
        mHumedadTextView = findViewById(R.id.humedadTextView);


        // Inicializa la referencia a la base de datos
        mDatabaseReference = FirebaseDatabase.getInstance().getReference();

        // Agrega un listener para escuchar cambios en la base de datos
        mDatabaseReference.child("Invernadero").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists() && dataSnapshot.hasChild("Humedad de piso")) {
                    try {
                        Humedadpiso[0] = Integer.parseInt(dataSnapshot.child("Humedad de piso").getValue().toString());
                    } catch (NumberFormatException e) {
                        Log.e("misPlantas", "Error al convertir a int: " + e.getMessage());
                        mHumedadDePisoTextView.setText("Error de formato");
                    }
                } else {
                    Log.d("misPlantas", "No existe el nodo 'Agua:'");
                    // Manejar el caso en el que los datos o el nodo no existen
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Manejar errores de la base de datos
                Log.e("misPlantas", "Error en la base de datos: " + error.getMessage());
            }
        });

        mDatabaseReference.child("Invernadero").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists() && dataSnapshot.hasChild("Humedad de piso2")) {
                    try {
                        Humedadpiso2[0] = Integer.parseInt(dataSnapshot.child("Humedad de piso2").getValue().toString());
                    } catch (NumberFormatException e) {
                        Log.e("misPlantas", "Error al convertir a int: " + e.getMessage());
                        mHumedadDePisoTextView.setText("Error de formato");
                    }
                } else {
                    Log.d("misPlantas", "No existe el nodo 'Agua:'");
                    // Manejar el caso en el que los datos o el nodo no existen
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Manejar errores de la base de datos
                Log.e("misPlantas", "Error en la base de datos: " + error.getMessage());
            }
        });

        mDatabaseReference.child("Invernadero").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists() && dataSnapshot.hasChild("Humedad de piso3")) {
                    try {
                        Humedadpiso3[0] = Integer.parseInt(dataSnapshot.child("Humedad de piso3").getValue().toString());
                    } catch (NumberFormatException e) {
                        Log.e("misPlantas", "Error al convertir a int: " + e.getMessage());
                        mHumedadDePisoTextView.setText("Error de formato");
                    }
                } else {
                    Log.d("misPlantas", "No existe el nodo 'Agua:'");
                    // Manejar el caso en el que los datos o el nodo no existen
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Manejar errores de la base de datos
                Log.e("misPlantas", "Error en la base de datos: " + error.getMessage());
            }
        });

        mDatabaseReference.child("Invernadero").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists() && dataSnapshot.hasChild("Temperatura")) {
                    try {
                        Temperatura[0] = Float.parseFloat(dataSnapshot.child("Temperatura").getValue().toString());
                    } catch (NumberFormatException e) {
                        Log.e("misPlantas", "Error al convertir a int: " + e.getMessage());
                        mTemperaturaTextView.setText("Error de formato");
                    }
                } else {
                    Log.d("misPlantas", "No existe el nodo 'Agua:'");
                    // Manejar el caso en el que los datos o el nodo no existen
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Manejar errores de la base de datos
                Log.e("misPlantas", "Error en la base de datos: " + error.getMessage());
            }
        });

        mDatabaseReference.child("Invernadero").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists() && dataSnapshot.hasChild("Humedad")) {
                    try {
                        Humedad[0] = Float.parseFloat(dataSnapshot.child("Humedad").getValue().toString());
                    } catch (NumberFormatException e) {
                        Log.e("misPlantas", "Error al convertir a int: " + e.getMessage());
                        mHumedadTextView.setText("Error de formato");
                    }
                } else {
                    Log.d("misPlantas", "No existe el nodo 'Agua:'");
                    // Manejar el caso en el que los datos o el nodo no existen
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Manejar errores de la base de datos
                Log.e("misPlantas", "Error en la base de datos: " + error.getMessage());
            }
        });

        ImageButton ibAgua = findViewById(R.id.ibAgua);

        ibAgua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(misPlantas.this, tanqueAgua.class);
                startActivity(i);
            }
        });

        Button boton1 = findViewById(R.id.boton1);

        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opcion = 1;
                actualizarTexto();
            }
        });

        Button boton2 = findViewById(R.id.boton2);

        boton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opcion = 2;
                actualizarTexto();
            }
        });

        Button boton3 = findViewById(R.id.boton3);

        boton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opcion = 3;
                actualizarTexto();
            }
        });

        Button boton4 = findViewById(R.id.boton4);

        boton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opcion = 4;
                actualizarTexto();
            }
        });

        Button boton5 = findViewById(R.id.boton5);

        boton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opcion = 5;
                actualizarTexto();
            }
        });

        Button boton6 = findViewById(R.id.boton6);

        boton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opcion = 6;
                actualizarTexto();
            }
        });

        Button boton7 = findViewById(R.id.boton7);

        boton7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opcion = 7;
                actualizarTexto();
            }
        });

        Button boton8 = findViewById(R.id.boton8);

        boton8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opcion = 8;
                actualizarTexto();
            }
        });

    }

    @SuppressLint("SetTextI18n")
    private void actualizarTexto() {

        mTemperaturaTextView.setText(String.valueOf(Temperatura[0]) + "°C");
        mHumedadTextView.setText(String.valueOf(Humedad[0]) + "%");

        switch (opcion) {
            case 1:
                mHumedadDePisoTextView.setText(String.valueOf(Humedadpiso[0]) + "%");
                break;
            case 2:
                mHumedadDePisoTextView.setText(String.valueOf(Humedadpiso2[0]) + "%");
                break;
            case 3:
                mHumedadDePisoTextView.setText(String.valueOf(Humedadpiso3[0]) + "%");
                break;
            case 4:
                mHumedadDePisoTextView.setText("No hay planta");
                break;
            case 5:
                mHumedadDePisoTextView.setText("No hay planta");
                break;
            case 6:
                mHumedadDePisoTextView.setText("No hay planta");
                break;
            case 7:
                mHumedadDePisoTextView.setText("No hay planta");
                break;
            case 8:
                mHumedadDePisoTextView.setText("No hay planta");
                break;
            default:
                mHumedadDePisoTextView.setText("No hay planta");
                mTemperaturaTextView.setText("No hay planta");
                mHumedadTextView.setText("No hay planta");
        }

    }
}