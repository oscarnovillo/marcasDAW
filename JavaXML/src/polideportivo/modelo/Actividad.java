/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polideportivo.modelo;

import java.util.LinkedList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.XmlList;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author user
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Actividad {

    private String tipo;
    private int plazas;
    private float precio;
    private int plazasLibres;
    private Horario horario;
    
    @XmlElement( name = "alumno" )
    @XmlIDREF
    private Alumno prueba;
    

    @XmlIDREF
    @XmlElementWrapper(name = "alumnos")
    @XmlElement( name = "alumno" )
    private List<Alumno> alumnos;

    public Actividad() {
    }

    
    
    
    public Actividad(String tipo, int plazas, float precio,
      Horario horario) {

        this.tipo = tipo;
        this.plazas = plazas;
        this.precio = precio;
        this.plazasLibres = this.plazas;
        this.horario = horario;
        alumnos = new LinkedList<>();
    }

   public boolean delAlumno(Alumno a){
       boolean ok = false;
      alumnos.remove(a);
       return ok;
   }
    
    public boolean addAlumno(Alumno a) {
        boolean ok = false;
        if (plazasLibres > 0) {
            this.alumnos.add(a);
            this.plazasLibres--;
            ok = true;
        }
        return ok;
    }
    
    public Alumno getPrueba() {
        return prueba;
    }

    public void setPrueba(Alumno prueba) {
        this.prueba = prueba;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getPlazas() {
        return plazas;
    }

    public void setPlazas(int plazas) {
        this.plazas = plazas;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getPlazasLibres() {
        return plazasLibres;
    }

    public void setPlazasLibres(int plazasLibres) {
        this.plazasLibres = plazasLibres;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    @Override
    public String toString() {
        String imprimir = "Actividad{" + "tipo=" + tipo + ", \n precio=" + precio + "€, \nplazasLibres=" + plazasLibres + ", horario=" + horario + '}';
        
        for (int i =0;i<alumnos.size();i++)
        {
            imprimir += alumnos.get(i).toString();
        }
        
        imprimir += "\n";
        return imprimir;
    }

}
