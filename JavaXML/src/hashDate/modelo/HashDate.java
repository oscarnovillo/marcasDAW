
        /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashDate.modelo;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapters;
import polideportivo.modelo.Alumno;

/**
 *
 * @author oscar
 */
@XmlRootElement
public class HashDate {

    public HashDate() {
        alumnos=new HashMap<>();
        fecha=LocalDate.now();
        fechas = new LinkedList<>();
        fechas.add(fecha);
        Persona p = new Tonto();
        p.setNombre("jj");
        p.setBirth(LocalDate.now());
        alumnos.put(LocalDate.now(),p);
        p = new Listo();
        p.setNombre("jj");
        p.setBirth(LocalDate.now());
        alumnos.put(LocalDate.of(2016,7,8),p);
        
    }
    

   
    @XmlJavaTypeAdapter(MyMapAdapter.class)
    @XmlElement
    public HashMap<LocalDate,Persona> alumnos;
    

    
    private LinkedList<LocalDate> fechas;
    

    
    private LocalDate fecha;

    
   


    @XmlElementWrapper(name ="fechas")
    public LinkedList<LocalDate> getFechas() {
        return fechas;
    }

    public void setFechas(LinkedList<LocalDate> fechas) {
        this.fechas = fechas;
    }

    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    
    
    
    
    
}
