/*
Nombre: Juan Esteban Davila 206604 || Martin Farfan 207250
Descripcion: Clase principal. pantalla que inicializa la aplicacion.

 */

package com.example.proyecto3_budget;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void startEducacion(View v) {
        Intent intent = new Intent(this, Educacion.class);
        startActivity(intent);
    }
    public void startSalud(View v) {
        Intent intent = new Intent(this, Salud.class);
        startActivity(intent);
    }
    public void startComida(View v) {
        Intent intent = new Intent(this, comida.class);
        startActivity(intent);
    }
    public void startTotal(View v) {
        Intent intent = new Intent(this, Total.class);
        startActivity(intent);
    }

}