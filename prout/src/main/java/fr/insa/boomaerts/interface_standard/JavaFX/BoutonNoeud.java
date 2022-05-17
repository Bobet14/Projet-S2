/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.boomaerts.interface_standard.JavaFX;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

/**
 *
 * @author jboomaerts01
 */
public class BoutonNoeud extends VBox {
        public static List<Button> noBoutons() {
            List<Button> res = new ArrayList<>();
            Button jb1 = new Button("Ajouter");
            res.add(jb1);
            Button jb2 = new Button("Effacer");
            res.add(jb2);
            return res;
        }
        public BoutonNoeud() {
            for(Button i : noBoutons()) {
                this.getChildren().add(i);
            }
        }
}
