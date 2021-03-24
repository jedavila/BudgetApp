/*
Nombre: Juan Esteban Davila 206604 || Martin Farfan 207250
Descripcion: Clase encargada de pantalla Salud

 */

package com.example.proyecto3_budget;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;

import androidx.appcompat.app.AppCompatActivity;

import java.time.LocalDateTime;

public class Salud extends AppCompatActivity {
    private Dialog dialog;
    private TableLayout table;
    private TableController tableController;
    private Controlador Controller = Controlador.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.salud_layout);
        dialog=new Dialog(this);
        table = this.findViewById(R.id.tableSalud);
        tableController = new TableController(table, this);

    }
    @Override
    protected void onStart() {
        super.onStart();
        loadTable();
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
    public void startNewItem(View v){

        dialog.setContentView(R.layout.new_item);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        Button btnGuardar = (Button) dialog.findViewById(R.id.btnGuardar);
        Button btnCancelar = (Button) dialog.findViewById(R.id.btnCancelar);
        EditText txtDescripcion = (EditText) dialog.findViewById(R.id.txtDesc);
        EditText txtValor = (EditText) dialog.findViewById(R.id.txtNum);


        btnGuardar.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                LocalDateTime fecha = LocalDateTime.now();
                String descripcion = String.valueOf(txtDescripcion.getText());
                float valor = Float.parseFloat(String.valueOf(txtValor.getText()));
                Controller.newSalud(descripcion, valor, fecha);
                loadTable();
                dialog.dismiss();

            }
        });

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {dialog.dismiss();}
        });



        dialog.show();

    }
    private void loadTable(){
        tableController.destroy(Controller.getSalud().size());
        Controller.getSalud().forEach(i ->{
            tableController.addRow(i.getDescripcion(), i.getValor(), i.getFecha());
        });

    }

}
