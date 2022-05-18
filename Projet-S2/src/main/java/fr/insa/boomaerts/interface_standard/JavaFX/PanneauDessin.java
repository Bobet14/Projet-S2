/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.boomaerts.interface_standard.JavaFX;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

/**
 *
 * @author jboomaerts01
 */
public class PanneauDessin extends Pane {
    
    final Double scaleDelta = 1.1;
    private DessinCanvas zoneDessin;
    private Label PositionSouris;
    
    public PanneauDessin(DessinCanvas zoneDessin) {
        super();
        this.zoneDessin = zoneDessin;
        //this.redrawAll();
    }
    
   /* public void redrawAll() {
        this.getChildren().clear(); // enlève ce qu'il y avait avant
        //visibilité coor souris
        this.PositionSouris = new Label("");
        this.PositionSouris.setLayoutX(10);
        this.PositionSouris.setLayoutY(10);
        this.setOnMouseEntered((var i) -> {
            this.PositionSouris.setText"X : " + i.getX()+ "\n" + "Y : " +i.getY());
        });
        */
    }
}
