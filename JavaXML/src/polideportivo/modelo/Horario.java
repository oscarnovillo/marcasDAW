/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polideportivo.modelo;

/**
 *
 * @author user
 */
public class Horario {
    
    private int horaInicio;
    private int horaFin;
    private String dias;

    public Horario() {
    }

    
    
    
    public Horario(int horaInicio, int horaFin, String dias) {
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.dias = dias;
    }

    
    
    public int getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(int horaInicio) {
        this.horaInicio = horaInicio;
    }

    public int getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(int horaFin) {
        this.horaFin = horaFin;
    }

    public String getDias() {
        return dias;
    }

    public void setDias(String dias) {
        this.dias = dias;
    }

    @Override
    public String toString() {
        return "Horario{" + "horaInicio=" + horaInicio + ", horaFin=" + horaFin + ", dias=" + dias + '}';
    }
    
    
    
    
}
