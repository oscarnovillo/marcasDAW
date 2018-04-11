/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Daw
 */
public class Coche extends VehiculoMotor implements IProbable {

    public Coche(){}
    
    public Coche(String color, String marca, double precioCompra, String matricula, int kilometrosUso) {
        super(color, marca, precioCompra, matricula, kilometrosUso);
    }

    @Override
    public String toString() {
        return "\nCoche= [" + super.toString();
    }

    @Override
    public void probarVehiculo(int kilometros) {
        setKilometrosUso(kilometrosUso+kilometros);
    }

}
