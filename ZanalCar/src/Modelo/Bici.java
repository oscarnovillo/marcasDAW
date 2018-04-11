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
public class Bici extends Vehiculo {

    public Bici() {
    }

    private int tamanioRueda;
    private int numeroMarchas;
    private String tipoDeCambio;

    public Bici(int tamanioRueda, int numeroMarchas, String tipoDeCambio, String color, String marca, double precioCompra) {
        super(color, marca, precioCompra);
        this.tamanioRueda = tamanioRueda;
        this.numeroMarchas = numeroMarchas;
        this.tipoDeCambio = tipoDeCambio;
    }

    public int getTamanioRueda() {
        return tamanioRueda;
    }

    public void setTamanioRueda(int tamanioRueda) {
        this.tamanioRueda = tamanioRueda;
    }

    public int getNumeroMarchas() {
        return numeroMarchas;
    }

    public void setNumeroMarchas(int numeroMarchas) {
        this.numeroMarchas = numeroMarchas;
    }

    public String getTipoDeCambio() {
        return tipoDeCambio;
    }

    public void setTipoDeCambio(String tipoDeCambio) {
        this.tipoDeCambio = tipoDeCambio;
    }

    @Override
    public String toString() {
        return "\nBici= [tamaño de ruedas " + tamanioRueda + ", marchas " + numeroMarchas + ", cambio " + tipoDeCambio + super.toString();
    }

}
