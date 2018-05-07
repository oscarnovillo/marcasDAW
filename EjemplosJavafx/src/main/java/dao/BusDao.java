/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.IOException;
import java.util.ArrayList;
import com.google.api.client.http.EmptyContent;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.UrlEncodedContent;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.GenericJson;
import com.google.api.client.json.JsonObjectParser;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.ArrayMap;
import com.google.api.client.util.GenericData;
import model.Arrives;

/**
 *
 * @author user
 */
public class BusDao {
 
    public static void main(String[] args) throws IOException {
        BusDao b = new BusDao();
        b.processRequest();
    }
    
    
    public ArrayList processRequest() throws IOException
       {

           
        HttpTransport HTTP_TRANSPORT = new NetHttpTransport();
        JsonFactory JSON_FACTORY = new JacksonFactory();
        HttpRequestFactory requestFactory
          = HTTP_TRANSPORT.createRequestFactory(new HttpRequestInitializer() {
              @Override
              public void initialize(HttpRequest request) {
                  request.setParser(new JsonObjectParser(JSON_FACTORY));
              }
          });

        GenericUrl url = new GenericUrl("https://openbus.emtmadrid.es:9443/emt-proxy-server/last/geo/GetArriveStop.php");

        GenericData data = new GenericData();
        data.put("idClient", "WEB.SERV.oscar.novillo@iesquevedo.es");
        data.put("passKey", "4C7A2AC7-2AC4-4AAE-9E63-E27EEA72969E");
        data.put("idStop", "2794");

        HttpRequest requestGoogle = requestFactory.buildPostRequest(url, new UrlEncodedContent(data));
        
//        url.set("idClient", "WEB.SERV.oscar.novillo@iesquevedo.es");
//        url.set("passKey", "4C7A2AC7-2AC4-4AAE-9E63-E27EEA72969E");
//        url.set("idStop", "3727");

        
        Arrives arr = requestGoogle.execute().parseAs(Arrives.class);
        GenericJson json = requestGoogle.execute().parseAs(GenericJson.class);
        //response.getWriter().print(arr.getArrives().size());

        ArrayList arrives = (ArrayList) json.get("arrives");
        
        for (int i = 0; i < arrives.size(); i++) {
            ArrayMap arrive = (ArrayMap)arrives.get(i);
            System.out.print(arrive.get("busTimeLeft")+" ");
            System.out.print(arrive.get("lineId")+" ");
            System.out.print(arrive.get("busDistance")+" ");
            System.out.print("<br>");
        }
        
        data = new GenericData();
        data.put("idClient", "WEB.SERV.oscar.novillo@iesquevedo.es");
        data.put("passKey", "4C7A2AC7-2AC4-4AAE-9E63-E27EEA72969E");
        data.put("line", "76");
        data.put("direction", "PLAZA BEATA");
        url = new GenericUrl("https://openbus.emtmadrid.es:9443/emt-proxy-server/last/geo/GetStopsLine.php");
        requestGoogle = requestFactory.buildPostRequest(url, new UrlEncodedContent(data));
        json = requestGoogle.execute().parseAs(GenericJson.class);
        
      ArrayList stops = (ArrayList) json.get("stop");
      System.out.print(json.get("destination"));
      for (int i = 0; i < stops.size(); i++) {
            ArrayMap stop = (ArrayMap)stops.get(i);
            System.out.println("");
            System.out.print(stop.get("stopId")+" ");
            System.out.print(stop.get("name")+" ");
           
            System.out.print("<br>");
        }
      return stops;

    }
}
