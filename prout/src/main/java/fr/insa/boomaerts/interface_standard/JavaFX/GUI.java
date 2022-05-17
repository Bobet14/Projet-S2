/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.boomaerts.interface_standard.JavaFX;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.Button;
import javafx.scene.control.TitledPane;

/**
 *
 * @author jboomaerts01
 */
public class GUI  {
    public static List<TitledPane> lesBoutons() {
        List<TitledPane> res = new ArrayList<>();
        TitledPane pointAppui = new TitledPane("Point d'Appui", new BoutonPointAppui());
        res.add(pointAppui);
        TitledPane barres = new TitledPane("Barre", new BoutonBarre());
        res.add(barres);
        TitledPane noeuds = new TitledPane("Noeud", new BoutonNoeud());
        res.add(noeuds);
        TitledPane affichage = new TitledPane("Affichage", new BoutonAffichage());
        res.add(affichage);
        return res;
    }
}
