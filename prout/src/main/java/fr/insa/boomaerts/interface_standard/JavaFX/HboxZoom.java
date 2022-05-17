/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.boomaerts.interface_standard.JavaFX;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
/*import fr.insa.boomaerts.IconesBoutons.*;*/

/**
 *
 * @author jboomaerts01
 */
public class HboxZoom extends HBox {
    
    private Controleur controleur;
    private BoutonIcones Zoomplus;
    private BoutonIcones Zoommoins;
    private BoutonIcones Zoomniveau;
    
    public HboxZoom() {
        //Button zoomplus = new Button("zoom +");
        this.Zoomplus = new BoutonIcones("IconesBoutons/plus.png", 18, 18);
        this.Zoomplus.setOnAction((z) -> {
            this.controleur.zoomAvant();
        });
        this.Zoomniveau = new BoutonIcones("IconesBoutons/reset.png", 18, 18);
        //Button zoomniveau = new Button("reset");
        this.Zoomniveau.setOnAction((z) -> {
            this.controleur.zoomNiveau();
        });
        this.Zoommoins = new BoutonIcones("IconesBoutons/moins.png", 18, 18);
        //Button zoommoins = new Button("zoom -");
        this.Zoommoins.setOnAction((z) -> {
            this.controleur.zoomArriere();
        });

        
        this.getChildren().addAll(Zoomplus, Zoomniveau, Zoommoins);
    }

    public Controleur getControleur() {
        return controleur;
    }

    public BoutonIcones getZoomplus() {
        return Zoomplus;
    }

    public BoutonIcones getZoommoins() {
        return Zoommoins;
    }

    public BoutonIcones getZoomniveau() {
        return Zoomniveau;
    }

    public void setZoomplus(BoutonIcones Zoomplus) {
        this.Zoomplus = Zoomplus;
    }

    public void setZoommoins(BoutonIcones Zoommoins) {
        this.Zoommoins = Zoommoins;
    }

    public void setZoomniveau(BoutonIcones Zoomniveau) {
        this.Zoomniveau = Zoomniveau;
    }
}
