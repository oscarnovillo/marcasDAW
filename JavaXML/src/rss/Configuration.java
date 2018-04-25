/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rss;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class Configuration {
    
    
    
    private List<String> urls;

    public List<String> getUrls() {
        return urls;
    }

    
    
    public Configuration()  {
        
        urls = new LinkedList<>();
        this.loadConfig();
    }
    
    private void loadConfig()
    {
        try {
            
            Properties pro = new Properties();
            
            pro.load(new FileInputStream("config.properties"));
            
            String urlProperty = pro.getProperty("url");
            
            String[] urlsSplit = urlProperty.split(";;");
            
            for (String url: urlsSplit)
            {
                urls.add(url);
            }
            
            
            
        } catch (Exception ex) {
            Logger.getLogger(Configuration.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    public void saveConfig()
    {
        
    }
    

     
    
    
}
