/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.api.client.util.ArrayMap;
import com.lynden.gmapsfx.GoogleMapView;
import com.lynden.gmapsfx.MapComponentInitializedListener;
import com.lynden.gmapsfx.javascript.event.UIEventType;
import com.lynden.gmapsfx.javascript.object.Animation;
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
import com.lynden.gmapsfx.shapes.PolylineOptions;
import dao.BusDao;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.util.Duration;
import model.Arrive;
import model.Arrives;
import netscape.javascript.JSObject;

/**
 * FXML Controller class
 *
 * @author user
 */
public class FXMLMapsController implements Initializable, MapComponentInitializedListener {

    @FXML
    private GoogleMapView mapView;

    @FXML
    private ComboBox combo;

    private GoogleMap map;

    @FXML
    public void handleCombo(ActionEvent event) {
        System.out.println(combo.getSelectionModel().getSelectedItem().toString());

    }

    private void loadBud() throws IOException {
        map.clearMarkers();

        LatLong centreP = new LatLong(40.4893538421231, -3.6827461557);
        LatLong start = new LatLong(40.4893538421231, -3.6827461557 + 0.02);

        LatLong[] latlongs = new LatLong[2];
        latlongs[0] = centreP;
        latlongs[1] = start;

        MVCArray array = new MVCArray(latlongs);

        PolylineOptions polyOpts = new PolylineOptions()
          .path(array)
          .strokeColor("#00FF00")
          .strokeWeight(2);
        Polyline pp = new Polyline(polyOpts);

        map.addMapShape(pp);

        map.setZoom(16);

        BusDao bus = new BusDao();
        String json = bus.GetStopsLine("76", "PLAZA BEATA");

        BusDao b = new BusDao();

        ObjectMapper m = new ObjectMapper();
        m.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        Arrives arrives = m.readValue(b.GetArrivesStop("2794"), new TypeReference<Arrives>() {
        });
        for (Arrive stop : arrives.getArrives()) {
            System.out.println(stop.getStopId());
            System.out.println(stop.getBusTimeLeft());
            System.out.println(stop.getLatitude());
            System.out.println(stop.getLongitude());
            System.out.println(stop.getBusPositionType());
            LatLong punto = new LatLong(Double.parseDouble(stop.getLatitude()),
              Double.parseDouble(stop.getLongitude()));
            map.setCenter(punto);
            MarkerOptions markerOptions5 = new MarkerOptions();
            markerOptions5.position(punto);
            markerOptions5.title(stop.getBusId());

            Marker joeSmithMarker = new Marker(markerOptions5);
            map.addMarker(joeSmithMarker);

        }
    }

    @FXML
    public void handleButton(ActionEvent event) throws IOException {
        Timeline timeline = new Timeline(
          new KeyFrame(Duration.seconds(5), e -> {
              try {
                  loadBud();
              } catch (IOException ex) {
                  Logger.getLogger(FXMLMapsController.class.getName()).log(Level.SEVERE, null, ex);
              }
          })
        );
        timeline.setCycleCount(10);
        timeline.play();

    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        mapView.addMapInializedListener(this);

        combo.getItems().add("hola");
        combo.getItems().add("hola1");
        combo.getItems().add("hola2");
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
        markerOptions1.label("LABEL");
        markerOptions1.title("TITLE");
        markerOptions1.icon("https://png.clipart.me/istock/previews/5059/50591994-bus-icon-glossy-green-round-button.jpg");

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
        mapView.getMap().addUIEventHandler(joeSmithMarker, UIEventType.click, (JSObject obj) -> {
            LatLong ll = new LatLong((JSObject) obj.getMember("latLng"));

            combo.getItems().add(ll.toString());
            InfoWindowOptions infoWindowOptions1 = new InfoWindowOptions();
            infoWindowOptions1.content("<h2>Fred Wilkie</h2>"
              + "Current Location: Safeway<br>"
              + "ETA: 45 minutes");

            InfoWindow fredWilkeInfoWindow1 = new InfoWindow(infoWindowOptions1);
            fredWilkeInfoWindow1.open(map, joeSmithMarker);

        });
    }

}
