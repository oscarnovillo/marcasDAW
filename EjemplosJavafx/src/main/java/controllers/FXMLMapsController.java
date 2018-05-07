/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.google.api.client.util.ArrayMap;
import com.lynden.gmapsfx.GoogleMapView;
import com.lynden.gmapsfx.MapComponentInitializedListener;
import com.lynden.gmapsfx.javascript.object.GoogleMap;
import com.lynden.gmapsfx.javascript.object.InfoWindow;
import com.lynden.gmapsfx.javascript.object.InfoWindowOptions;
import com.lynden.gmapsfx.javascript.object.LatLong;
import com.lynden.gmapsfx.javascript.object.MVCArray;
import com.lynden.gmapsfx.javascript.object.MapOptions;
import com.lynden.gmapsfx.javascript.object.MapTypeIdEnum;

import com.lynden.gmapsfx.javascript.object.Marker;
import com.lynden.gmapsfx.javascript.object.MarkerOptions;
import com.lynden.gmapsfx.shapes.Polyline;
import dao.BusDao;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;


/**
 * FXML Controller class
 *
 * @author user
 */
public class FXMLMapsController implements Initializable, MapComponentInitializedListener {

    @FXML
    private GoogleMapView mapView;

    private GoogleMap map;

    @FXML
    public void handleButton(ActionEvent event) throws IOException {
        map.setCenter(new LatLong(40.4893538421231, -3.6827461557));

        LatLong centreP = new LatLong(40.4893538421231, -3.6827461557);
        LatLong start = new LatLong(40.4893538421231, -3.6827461557 + 0.02);
        
        LatLong[] latlongs = new LatLong[2];
        latlongs[0] = centreP;
        latlongs[1] = start;

        MVCArray array = new MVCArray(latlongs);
        
        Polyline pp = new Polyline();
        pp.setPath(array);
        map.addMapShape(pp);
        
        map.setZoom(16);
        
        
            BusDao bus = new BusDao();
            ArrayList arrives = bus.processRequest();
            for (int i = 0; i < arrives.size(); i++) {
            ArrayMap arrive = (ArrayMap)arrives.get(i);
            
            LatLong punto = new LatLong(((BigDecimal)arrive.get("latitude")).doubleValue(),
             ((BigDecimal)arrive.get("longitude")).doubleValue());
            map.setCenter(punto);
             MarkerOptions markerOptions5 = new MarkerOptions();
        markerOptions5.position(punto);

        Marker joeSmithMarker = new Marker(markerOptions5);
        map.addMarker(joeSmithMarker);
            
            
            
        }
            
            
            
            
            
        
        
        
        

    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        mapView.addMapInializedListener(this);
    }

    @Override
    public void mapInitialized() {
        LatLong joeSmithLocation = new LatLong(47.6197, -122.3231);
        LatLong joshAndersonLocation = new LatLong(47.6297, -122.3431);
        LatLong bobUnderwoodLocation = new LatLong(47.6397, -122.3031);
        LatLong tomChoiceLocation = new LatLong(47.6497, -122.3325);
        LatLong fredWilkieLocation = new LatLong(47.6597, -122.3357);

        //Set the initial properties of the map.
        MapOptions mapOptions = new MapOptions();

        mapOptions.center(new LatLong(47.6097, -122.3331))
          .mapType(MapTypeIdEnum.ROADMAP)
          .overviewMapControl(false)
          .panControl(false)
          .rotateControl(false)
          .scaleControl(false)
          .streetViewControl(false)
          .zoomControl(false)
          .zoom(12);

        map = mapView.createMap(mapOptions);

        //Add markers to the map
        MarkerOptions markerOptions1 = new MarkerOptions();
        markerOptions1.position(joeSmithLocation);

        MarkerOptions markerOptions2 = new MarkerOptions();
        markerOptions2.position(joshAndersonLocation);

        MarkerOptions markerOptions3 = new MarkerOptions();
        markerOptions3.position(bobUnderwoodLocation);

        MarkerOptions markerOptions4 = new MarkerOptions();
        markerOptions4.position(tomChoiceLocation);

        MarkerOptions markerOptions5 = new MarkerOptions();
        markerOptions5.position(fredWilkieLocation);

        Marker joeSmithMarker = new Marker(markerOptions1);
        Marker joshAndersonMarker = new Marker(markerOptions2);
        Marker bobUnderwoodMarker = new Marker(markerOptions3);
        Marker tomChoiceMarker = new Marker(markerOptions4);
        Marker fredWilkieMarker = new Marker(markerOptions5);

        map.addMarker(joeSmithMarker);
        map.addMarker(joshAndersonMarker);
        map.addMarker(bobUnderwoodMarker);
        map.addMarker(tomChoiceMarker);
        map.addMarker(fredWilkieMarker);

        InfoWindowOptions infoWindowOptions = new InfoWindowOptions();
        infoWindowOptions.content("<h2>Fred Wilkie</h2>"
          + "Current Location: Safeway<br>"
          + "ETA: 45 minutes");

        InfoWindow fredWilkeInfoWindow = new InfoWindow(infoWindowOptions);
        fredWilkeInfoWindow.open(map, fredWilkieMarker);
    }

}
