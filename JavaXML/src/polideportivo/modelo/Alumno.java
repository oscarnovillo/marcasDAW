/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polideportivo.modelo;

import java.util.Objects;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;

/**
 *
 * @author user
 */
public class Alumno {
    
    
    private String nombre;
    private String apellidos;
    private float recibo;

    
    private String id;
    

    private Actividad[]actividades;

    public Alumno() {
    }
    

    public Alumno(String nombre, 
      String apellidos) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.recibo = 0;
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
        final Alumno other = (Alumno) obj;
        
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.apellidos, other.apellidos)) {
            return false;
        }
        return true;
    }

        @XmlID
    public String getId() {
        return Integer.toString(System.identityHashCode(this));
    }

    public void setId(String id) {
        this.id = id;
    }

    
//    
//public String getId()
//{
//    return Integer.toString(System.identityHashCode(this));
//}
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public float getRecibo() {
        return recibo;
    }

    public void setRecibo(float recibo) {
        this.recibo = recibo;
    }
    
    
}
