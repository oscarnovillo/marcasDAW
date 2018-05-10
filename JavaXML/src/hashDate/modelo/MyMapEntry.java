/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashDate.modelo;

import java.time.LocalDate;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlValue;

/**
 *
 * @author oscar
 */
public class MyMapEntry {
   @XmlElement
   public LocalDate key; 
 
   @XmlElements({
            @XmlElement(name = "listo", type = Listo.class),
            @XmlElement(name = "tonto", type = Tonto.class)
            
    })

   public Persona value;
}
