/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaxml;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import javax.xml.bind.Unmarshaller;
import polideportivo.Polideportivo;

/**
 *
 * @author oscar
 */
public class JavaXML {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws PropertyException, JAXBException {
        // TODO code application logic here

        JAXBContext jaxbContext = JAXBContext.newInstance(Polideportivo.class);

        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        Polideportivo poli = new Polideportivo();

        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        jaxbMarshaller.marshal(poli, new File("polideportivo.xml"));
        
        
        Unmarshaller um = jaxbContext.createUnmarshaller();
        Polideportivo p = (Polideportivo)um.unmarshal(new File("polideportivo.xml"));
        
        p.reciboActividad();
        p.reciboAlumno();

    }

}
