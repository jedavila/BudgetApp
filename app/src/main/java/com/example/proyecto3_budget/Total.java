/*
Nombre: Juan Esteban Davila 206604 || Martin Farfan 207250
Descripcion: Clase encargada de obtener el total

 */

package com.example.proyecto3_budget;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Total extends AppCompatActivity {
    private Controlador eduController = Controlador.getInstance();
    TextView txtTotalEducacion;
    TextView txtTotalComida;
    TextView txtTotalSalud;
    TextView txtTotalTotal;
    private Controlador Controller = Controlador.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.total_layout);
        txtTotalEducacion = this.findViewById(R.id.txtTotalEducacion);
        txtTotalSalud = this.findViewById(R.id.txtTotalSalud);
        txtTotalComida = this.findViewById(R.id.txtTotalComida);
        txtTotalTotal = this.findViewById(R.id.txtTotalTotal);
        total();


    }
    @Override
    protected void onStart() {
        super.onStart();
        total();
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

    public void total(){
        txtTotalEducacion.setText(String.valueOf(Controller.sumaEducacion()));
        txtTotalSalud.setText(String.valueOf(Controller.sumaSalud()));
        txtTotalComida.setText(String.valueOf(Controller.sumaComida()));
        txtTotalTotal.setText(String.valueOf(Controller.sumaTotal()));


    }

}
