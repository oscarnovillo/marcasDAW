/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.ZanalCar;
import java.io.File;
import java.nio.file.Files;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author Daw
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int opcion;
        ZanalCar zc = cargar();
        Scanner sc = new Scanner(System.in);

        do {
            System.out.print("\n0] Salir.\n"
              + "1] Comprar Vehiculo.\n"
              + "2] Vender Vehiculo.\n"
              + "3] Probar Vehiculo.\n"
              + "4] Facturacion Total.\n"
              + "5] Inventario.\n"
              + "Opción: ");
            opcion = sc.nextInt();
            switch (opcion) {
                case 0:
                    System.out.println("Saliste con exito.");
                    break;
                case 1:
                    System.out.println("Comprar Vehiculos.");
                    zc.comprarCoche();
                    break;
                case 2:
                    System.out.println("Vender Vehiculo.");
                    zc.listadoVehiculosVender();
                    break;
                case 3:
                    System.out.println("Probar Coche/Quad.");
                    zc.prueba();
                    break;
                case 4:
                    System.out.println("Facturacion empresa.");
                    zc.facturacion();
                    break;
                case 5:
                    System.out.println("Ver inventario.");
                    zc.inventarioStock();
                    zc.inventarioVentas();
                    break;
                default:
                    System.out.println("Opcion incorrecta, vuelve a intentarlo.");
                    break;
            }
        } while (opcion != 0);

        guardar(zc);
    }

    public static ZanalCar cargar() {
        ZanalCar z = null;
        try {

            JAXBContext jaxbContext
              = JAXBContext.newInstance(ZanalCar.class);

            Unmarshaller um = jaxbContext.createUnmarshaller();
            z = (ZanalCar) um.unmarshal(new File("zanalcar.xml"));

        } catch (JAXBException ex) {
            z = new ZanalCar();
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        return z;
    }

    public static void guardar(ZanalCar z) {
        try {
            JAXBContext jaxbContext = 
              JAXBContext.newInstance(ZanalCar.class);
            
            Marshaller jaxbMarshaller = 
              jaxbContext.createMarshaller();
            
            
            jaxbMarshaller.setProperty(
              Marshaller.JAXB_FORMATTED_OUTPUT, true);
            
            jaxbMarshaller.marshal(z, new File("zanalcar.xml"));
        } catch (JAXBException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
