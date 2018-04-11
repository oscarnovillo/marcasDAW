/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Objects;

/**
 *
 * @author Daw
 */
public abstract class VehiculoMotor extends Vehiculo {

    protected String matricula;
    protected int kilometrosUso;

    public VehiculoMotor() {
    }

    public VehiculoMotor(String color, String marca, double precioCompra, String matricula, int kilometrosUso) {
        super(color, marca, precioCompra);
        this.matricula = matricula;
        this.kilometrosUso = kilometrosUso;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getKilometrosUso() {
        return kilometrosUso;
    }

    public void setKilometrosUso(int kilometrosUso) {
        this.kilometrosUso = kilometrosUso;
    }

    @Override
    public String toString() {
        return " matricula " + matricula + ", kilometros de uso " + kilometrosUso + super.toString();
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 19 * hash + Objects.hashCode(this.matricula);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final VehiculoMotor other = (VehiculoMotor) obj;
        if (!Objects.equals(this.matricula.toLowerCase(), other.matricula.toLowerCase())) {
            return false;
        }
        return true;
    }

}
