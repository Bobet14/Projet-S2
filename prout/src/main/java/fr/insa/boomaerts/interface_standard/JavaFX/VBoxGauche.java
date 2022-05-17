/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.boomaerts.interface_standard.JavaFX;

import javafx.scene.control.TitledPane;
import javafx.scene.layout.VBox;

/**
 *
 * @author jboomaerts01
 */
public class VBoxGauche extends VBox{
    
    public VBoxGauche() {
        for(TitledPane i : ListeBoutonsVBoxGauche.lesBoutons()) {
            this.getChildren().add(i);
        }
    }
}
