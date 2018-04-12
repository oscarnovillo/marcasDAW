/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rss;

import hashDate.modelo.HashDate;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author oscar
 */
public class TestRss {
    
    
    public static void main(String[] args) {
        
        
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Rss.class);
            
            
            Unmarshaller um = jaxbContext.createUnmarshaller();
            Rss p = (Rss)um.unmarshal(new URL("http://estaticos.marca.com/rss/futbol/betis.xml"));
            
            System.out.println(p.channel.getLink());
            
            for (Item i : p.channel.getItem())
            {
                System.out.println(i.getTitle());
            }
        } catch (JAXBException ex) {
            Logger.getLogger(TestRss.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(TestRss.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}