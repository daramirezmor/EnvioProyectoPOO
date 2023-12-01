package com.poorientada.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class tanqueAgua extends AppCompatActivity {

    TextView mAguaTextView;
    private DatabaseReference mDatabaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tanque_agua);

        // Asocia las TextView en tu layout
        mAguaTextView = findViewById(R.id.Agua_Texto);

        // Inicializa la referencia a la base de datos
        mDatabaseReference = FirebaseDatabase.getInstance().getReference();

        // Agrega un listener para escuchar cambios en la base de datos
        mDatabaseReference.child("Invernadero").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists() && dataSnapshot.hasChild("Agua")) {
                    try {
                        int temperature = Integer.parseInt(dataSnapshot.child("Agua").getValue().toString());
                        mAguaTextView.setText(String.valueOf(temperature));
                    } catch (NumberFormatException e) {
                        Log.e("TanqueAgua", "Error al convertir a int: " + e.getMessage());
                        mAguaTextView.setText("Error de formato");
                    }
                } else {
                    Log.d("TanqueAgua", "No existe el nodo 'Agua:'");
                    // Manejar el caso en el que los datos o el nodo no existen
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Manejar errores de la base de datos
                Log.e("TanqueAgua", "Error en la base de datos: " + error.getMessage());
            }
        });
    }
}
