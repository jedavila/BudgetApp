/*
Nombre: Juan Esteban Davila 206604 || Martin Farfan 207250
Descripcion: Clase controladora de rows para la tabla.

 */
package com.example.proyecto3_budget;

import android.content.Context;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;


public class TableController {
    private TableLayout tableLayout;
    private Context context;
    private TableRow tableRow;
    private int index;
    private Controlador Controller = Controlador.getInstance();

    public TableController(TableLayout tableLayout, Context context) {
        this.tableLayout = tableLayout;
        this.context = context;

    }

    public void addRow(String descripcion, float value, String fecha){

        tableRow = new TableRow(context);

        TextView txtDescripcion = new TextView(context);
        txtDescripcion.setText(descripcion);

        TextView txtValor = new TextView(context);
        txtValor.setText(String.valueOf(value));

        TextView txtFecha = new TextView(context);
        txtFecha.setText(fecha);

        ImageButton imgEdit = new ImageButton(context);
        imgEdit.setImageResource(android.R.drawable.ic_menu_edit);
        imgEdit.setBackgroundResource(R.drawable.btn_crud);

        imgEdit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Controller.editElement(context, descripcion, value, fecha );
            }
        });


        ImageButton imgDelete = new ImageButton(context);
        imgDelete.setImageResource(android.R.drawable.ic_menu_delete);
        imgDelete.setBackgroundResource(R.drawable.btn_crud);

        imgDelete.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Controller.deleteElement(context,descripcion, value, fecha );
            }
        });


        tableRow.setId(index);
        tableRow.addView(txtDescripcion);
        tableRow.addView(txtValor);
        tableRow.addView(txtFecha);
        tableRow.addView(imgEdit);
        tableRow.addView(imgDelete);
        tableLayout.addView(tableRow);

        index++;
    }
    public void destroy(int i){
        int aux=0;
        while(aux<i){
            tableLayout.removeView(tableRow);
            aux++;
        }


    }
}
