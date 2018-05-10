/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polideportivo;

import java.util.Scanner;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import polideportivo.modelo.Actividad;
import polideportivo.modelo.Alumno;
import polideportivo.modelo.Horario;

/**
 *
 * @author user
 */
@XmlRootElement( name = "polideportivo" )
public class Polideportivo {

    @XmlElementWrapper(name = "alumnos")
    @XmlElement( name = "alumno" )
    private Alumno[] alumnos;
    @XmlElementWrapper(name = "actividades")
    @XmlElement( name = "actividad" )
    private Actividad[] actividades;

    private int numAlumnos = 0;

    public Polideportivo() {
        alumnos = new Alumno[50];
        actividades = new Actividad[20];

        Horario h = new Horario(10, 11, "L,X,V");
        Actividad a = new Actividad("areobic", 35, 47.60f, h);
        actividades[0] = a;
        h = new Horario(11, 12, "L,X,V");
        a = new Actividad("areobic", 35, 47.60f, h);
        actividades[1] = a;

        actividades[2] = new Actividad("areobic", 35, 47.60f,
                new Horario(19, 20, "L,X,V"));

        actividades[3] = new Actividad("aerobic", 35, 35.70f,
                new Horario(9, 10, "M,J"));

        actividades[4] = new Actividad("aerobic", 35, 35.70f,
                new Horario(10, 11, "M,J"));

        actividades[5] = new Actividad("aerobic", 35, 35.70f,
                new Horario(18, 19, "M,J"));
        //------------------------------------------------------------
        actividades[6] = new Actividad("Artes Marciales", 15, 45.00f,
                new Horario(19, 20, "L,X,V"));

        actividades[7] = new Actividad("Artes Marciales", 15, 34.00f,
                new Horario(18, 19, "M,J"));

        actividades[8] = new Actividad("Artes Marciales", 15, 34.00f,
                new Horario(19, 20, "M,J"));
        //-------------------------------------------------------------
        actividades[9] = new Actividad("Natación", 35, 47.60f,
                new Horario(18, 19, "L,X,V"));

        actividades[10] = new Actividad("Natación", 35, 35.70f,
                new Horario(17, 18, "M,J"));
        
        alumnos[0] = new Alumno("juan", "perez");
        alumnos[1] = new Alumno("pedro", "perez");
        

        actividades[0].addAlumno(alumnos[0]);
        actividades[0].addAlumno(alumnos[1]);
        actividades[1].addAlumno(alumnos[0]);
        

    }

    private Alumno crearAlumno() {

        Scanner sc = new Scanner(System.in);
        // pedir nombre y apellidos por teclado
        String nombre;
        String apellidos;

        System.out.println("Nombre: ");

        nombre = sc.next();

        System.out.println("Apellidos: ");
        apellidos = sc.next();

        //crear el alumno
        Alumno alumno = new Alumno(nombre, apellidos);
        //devolver alumno
        return alumno;
    }

    public void darAltaAlumno() {

        Alumno a = crearAlumno();
        alumnos[numAlumnos] = a;
        numAlumnos++;

        return;
    }

    public void darBajaAlumno() {
        //encontrar Alumno
        System.out.println("dame alumno a borrar:");
        Alumno a = crearAlumno();
        int encontrado = encontrarAlumno(a);

        //Dar de baja de las actividades, aumentar plaza
        //reordenar array para no dejar huecos
        alumnos[encontrado] = alumnos[numAlumnos - 1];
        alumnos[numAlumnos - 1] = null;
        numAlumnos--;

        return;
    }

    private int encontrarAlumno(Alumno a) {
        //recorrer array de alumno buscando nombre y apellidos
        int encontrado = -1;

        for (int i = 0; i < alumnos.length; i++) {
            System.out.println(alumnos[i]);
            if (alumnos[i].equals(a)) {
                encontrado = i;
            }
        }
        return encontrado;
    }

    public void matricularAlumno() {

        Alumno temp = crearAlumno();
        //encontrarle en el array
        int encontrado = encontrarAlumno(temp);
        Alumno alumno = alumnos[encontrado];

        //encontrar actividad
        int encontrarActividad = encontrarActividad();
        //quitar plaza
        Actividad actividad = actividades[encontrarActividad];

       
        actividad.addAlumno(alumno);

        // aumentar el dinero del alumno
        alumno.setRecibo(alumno.getRecibo() + actividad.getPrecio());

    }

    private int encontrarActividad() {
        int encontrado = -1;

        for (int i = 0; i < actividades.length; i++) {
            System.out.println(i + ". " + actividades[i]);
        }
        Scanner sc = new Scanner(System.in);
        encontrado = sc.nextInt();
        sc.nextLine();

        return encontrado;
    }

    public void reciboAlumno() {
        for (int i = 0; i < alumnos.length; i++) {
            System.out.println(alumnos[i].getNombre() + " " + " paga " + alumnos[i].getRecibo());
                                    
        }
    }
    
    public void reciboActividad() {
        
        
        for (int i = 0; i < actividades.length; i++){
            
           float precio= actividades[i].getPrecio();
           int numAlumnos = actividades[i].getPlazas()-actividades[i].getPlazasLibres(); 
           System.out.println(actividades[i].getTipo() + " recibe "+ numAlumnos*precio);
           
            
        }  //es el numero de alumnos que hay en una actividad * el precio de las actividades.
        //se sabe el numero de alumnos que hay en una actividad si restamos las plazas menos las plazas libres.
    }
    
    
}
