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
public class Quad extends VehiculoMotor implements IProbable {

    public Quad() {
    }

    public Quad(String color, String marca, double precioCompra, String matricula, int kilometrosUso) {
        super(color, marca, precioCompra, matricula, kilometrosUso);
    }

    @Override
    public String toString() {
        return "\nQuad= [" + super.toString();
    }

    @Override
    public void probarVehiculo(int kilometros) {
        setKilometrosUso(kilometrosUso + kilometros);
    }

}
