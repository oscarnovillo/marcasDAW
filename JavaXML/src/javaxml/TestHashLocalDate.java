/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaxml;

import hashDate.modelo.HashDate;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import polideportivo.Polideportivo;

/**
 *
 * @author oscar
 */
public class TestHashLocalDate {
    
    
    public static void main(String[] args) {
        try {
            HashDate h = new HashDate();
            
            JAXBContext jaxbContext = JAXBContext.newInstance(HashDate.class);
            
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
          
            
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            
            jaxbMarshaller.marshal(h, new File("HashDate.xml"));
            
            //jaxbMarshaller.marshal(poli, System.out);
            
            
            Unmarshaller um = jaxbContext.createUnmarshaller();
            HashDate p = (HashDate)um.unmarshal(new File("HashDate.xml"));
            
            System.out.println(p.alumnos.values().size());
        } catch (JAXBException ex) {
            Logger.getLogger(TestHashLocalDate.class.getName()).log(Level.SEVERE, null, ex);
        }
                
    }
    
}
