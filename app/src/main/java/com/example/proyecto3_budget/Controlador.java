/*
Nombre: Juan Esteban Davila 206604 || Martin Farfan 207250
Descripcion: Clase controladora del sistema, se almacena todos los datos aqui.

 */

package com.example.proyecto3_budget;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Controlador {

    private List<items> educacion;
    private List<items> salud;
    private List<items> comida;
    private static Controlador ourInstance = new Controlador();

    public static Controlador getInstance() {
        return ourInstance;
    }

    private Controlador() {
        educacion = new ArrayList<>();
        salud = new ArrayList<>();
        comida = new ArrayList<>();
    }

    public List<items> getEducacion() {
        return educacion;
    }

    public List<items> getSalud() {
        return salud;
    }

    public List<items> getComida() {
        return comida;
    }

    public void newEducacion(String d, float v, LocalDateTime fecha) {
        this.educacion.add(new items(d, v, fecha));
    }

    public void newSalud(String d, float v, LocalDateTime fecha) {
        this.salud.add(new items(d, v, fecha));
    }

    public void newComida(String d, float v, LocalDateTime fecha) {
        this.comida.add(new items(d, v, fecha));
    }

    public void setEducacion(List<items> educacion) {
        this.educacion = educacion;
    }

    public void setSalud(List<items> salud) {
        this.salud = salud;
    }

    public void setComida(List<items> comida) {
        this.comida = comida;
    }


    public void deleteElement(Context context, String d, float v, String fecha) {
        Predicate<items> findElement =
                items -> (items.getDescripcion().equals(d) && items.getValor() == v && items.getFecha().equals(fecha));

        if (String.valueOf(context.getClass()).equals("class com.example.proyecto3_budget.Educacion")) {

            getEducacion().removeIf(findElement);


        } else if (String.valueOf(context.getClass()).equals("class com.example.proyecto3_budget.Salud")) {
            getSalud().removeIf(findElement);

        } else if (String.valueOf(context.getClass()).equals("class com.example.proyecto3_budget.comida")) {
            getComida().removeIf(findElement);
        }
        Intent intent = new Intent(context, context.getClass());
        context.startActivity(intent);
    }



    public void editElement(Context context, String d, float v, String fecha) {

        Dialog dialogEdit = new Dialog(context);
        Predicate<items> findElement =
                items ->(items.getDescripcion().equals(d) && items.getValor()==v && items.getFecha().equals(fecha));


        dialogEdit.setContentView(R.layout.edit_item);
        dialogEdit.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        Button btnGuardar = (Button) dialogEdit.findViewById(R.id.btnGuardar);
        Button btnCancelar = (Button) dialogEdit.findViewById(R.id.btnCancelar);
        EditText txtDescripcion = (EditText) dialogEdit.findViewById(R.id.txtDesc);
        EditText txtValor = (EditText) dialogEdit.findViewById(R.id.txtNum);

        txtDescripcion.setText(d);
        txtValor.setText(String.valueOf(v));

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {dialogEdit.dismiss();}
        });


        btnGuardar.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                LocalDateTime fecha = LocalDateTime.now();
                String descripcion = String.valueOf(txtDescripcion.getText());
                float valor = Float.parseFloat(String.valueOf(txtValor.getText()));

                if (String.valueOf(context.getClass()).equals("class com.example.proyecto3_budget.Educacion")) {
                    getEducacion().stream()
                            .filter(findElement)
                            .collect(Collectors.toList())
                            .forEach(i ->{
                                i.setDescripcion(descripcion);
                                i.setValor(valor);
                                i.setFecha(fecha);
                            });

                    dialogEdit.dismiss();

                } else if (String.valueOf(context.getClass()).equals("class com.example.proyecto3_budget.Salud")) {
                    getSalud().stream()
                            .filter(findElement)
                            .collect(Collectors.toList())
                            .forEach(i ->{
                                i.setDescripcion(descripcion);
                                i.setValor(valor);
                                i.setFecha(fecha);
                            });

                    dialogEdit.dismiss();

                } else if (String.valueOf(context.getClass()).equals("class com.example.proyecto3_budget.comida")) {
                    getComida().stream()
                            .filter(findElement)
                            .collect(Collectors.toList())
                            .forEach(i ->{
                                i.setDescripcion(descripcion);
                                i.setValor(valor);
                                i.setFecha(fecha);
                            });


                    dialogEdit.dismiss();
                }

                Intent intent = new Intent(context, context.getClass());
                context.startActivity(intent);

            }
        });

        dialogEdit.show();



    }

    public float sumaEducacion(){
        return (float) getEducacion().stream().mapToDouble(i -> i.getValor()).sum();
    }
    public float sumaComida(){
        return (float) getComida().stream().mapToDouble(i -> i.getValor()).sum();

    }
    public float sumaSalud(){
        return (float) getSalud().stream().mapToDouble(i -> i.getValor()).sum();

    }
    public float sumaTotal(){
        return (float) sumaSalud()+sumaComida()+sumaEducacion();
    }
}




