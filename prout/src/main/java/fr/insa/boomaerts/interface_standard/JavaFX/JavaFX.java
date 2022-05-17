/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.boomaerts.interface_standard.JavaFX;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author jboomaerts01
 */
public class JavaFX extends Application {
    
    @Override
    public void start (Stage fenprincipale) {
        //fenprincipale.getIcons().setAll(new Image(getClass().getResource("Icones Boutons/icon.png").toExternalForm()));
        fenprincipale.setTitle("BOOMAERTS/GASS/DUMONT Projet S2 2022");
        Scene scene = new Scene(new PannneauPrincipal(fenprincipale), 800, 600);
        fenprincipale.setScene(scene);
        fenprincipale.show();
    }
    
    public static void main(String[] args) {
        Application.launch(args);
    }
}
