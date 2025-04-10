/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package casoprogramado2;

/**
 *
 * @author alvarados
 */
public class Habitaciones {
    private int numero;
    private String tipo;      
    private int precio;
    private String estado;

    public Habitaciones(int numero, String tipo, int precio, String estado) {
        this.numero = numero;
        this.tipo = tipo;
        this.precio = precio;
        this.estado = estado;
    }

    public Habitaciones() {
    }
public String mostrarInformacion() {
        return "Habitación " + numero + " - Tipo: " + tipo + ", Precio: " + precio + ", Estado: " + estado;
    }
    
    public int getNumero() {
        return numero;
    }

    public String getTipo() {
        return tipo;
    }

    public int getPrecio() {
        return precio;
    }

    public String getEstado() {
        return estado;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
}

