/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Daw
 */
public abstract class Vehiculo {

    protected String color;
    protected String marca;
    protected double precioCompra;
    protected double precioVenta;

    public Vehiculo() {
    }

    
    
    public Vehiculo(String color, String marca, double precioCompra) {
        this.color = color;
        this.marca = marca;
        this.precioCompra = precioCompra;
        this.precioVenta = (precioCompra * 1.25);/*si es inferior pedir un precio mas adecuado*/
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    @Override
    public String toString() {
        return ", color " + color + ", marca " + marca + ", precio de compra " + precioCompra + ",  precio de venta " + precioVenta + "]";
    }
}
