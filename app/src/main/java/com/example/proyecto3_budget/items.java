/*
Nombre: Juan Esteban Davila 206604 || Martin Farfan 207250
Descripcion: Clase de los items.

 */

package com.example.proyecto3_budget;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class items{

    String descripcion="";
    float valor = 0.0f;
    String fecha;
    
    public items(String descripcion, float valor, LocalDateTime fecha) {
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy\nHH:mm");
        this.descripcion = descripcion;
        this.valor = valor;
        this.fecha = fecha.format(myFormatObj);

    }

    public items() {
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getFecha() {return fecha;}

    public void setFecha(LocalDateTime fecha) {
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy\nHH:mm");
        this.fecha = fecha.format(myFormatObj);
    }

}
