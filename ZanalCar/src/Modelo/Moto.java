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
public class Moto extends VehiculoMotor {

    public Moto() {
    }

    public Moto(String color, String marca, double precioCompra, String matricula, int kilometrosUso) {
        super(color, marca, precioCompra, matricula, kilometrosUso);
    }

    @Override
    public String toString() {
        return "\nMoto= [" + super.toString();
    }

}
