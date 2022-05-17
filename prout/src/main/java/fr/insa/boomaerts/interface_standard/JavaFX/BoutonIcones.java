/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.boomaerts.interface_standard.JavaFX;

import java.io.InputStream;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author jboomaerts01
 */
public class BoutonIcones extends Button {
    
    public BoutonIcones(String PathToImage, double taillex, double tailley) {
        InputStream im = this.getClass().getResourceAsStream(PathToImage);
        if (im == null) {
            this.setText("Image not found " + PathToImage);
        }
        else {
            Image jpg = new Image(im, taillex, tailley, false, true);
            this.setGraphic(new ImageView(jpg));
        }
    }
}
