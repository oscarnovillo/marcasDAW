/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashDate.modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 *
 * @author oscar
 */
public class HashMapAdapter extends XmlAdapter<LinkedList<Persona>, HashMap<LocalDate,Persona>>  {

    @Override
    public HashMap unmarshal(LinkedList v) throws Exception {
        HashMap<LocalDate,Persona> personas = new HashMap<>();
        for (Object o : v)
        {
            Persona p = (Persona)o;
            personas.put(p.getBirth(), p);
        }
        return personas;
    }

    @Override
    public LinkedList marshal(HashMap v) throws Exception {
        LinkedList<Persona> lista = new LinkedList(v.values());
        return lista;
    }

  
  

    
}
