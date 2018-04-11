/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaxml;

import com.fasterxml.jackson.databind.ObjectMapper;
import hashDate.modelo.HashDate;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author oscar
 */
public class TestJackson {
    public static void main(String[] args) {
        try {
            HashDate h = new HashDate();
            ObjectMapper o = new ObjectMapper();
            o.writeValue(new File("hashDate.json"), h);
        } catch (IOException ex) {
            Logger.getLogger(TestJackson.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
