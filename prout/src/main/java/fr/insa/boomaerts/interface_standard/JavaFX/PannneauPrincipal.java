/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.boomaerts.interface_standard.JavaFX;

import fr.insa.boomaerts.Treillis.Treillis;
import javafx.geometry.Insets;
import javafx.scene.Group;
import java.io.File;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author jboomaerts01
 */
public class PannneauPrincipal extends BorderPane {
    
    private Group affichage;
    private Controleur controleur;
    private Stage statut;
    private File fichier;
    private HboxZoom hboxzoom;
    private VBoxGauche vboxgauche;
    private MenuFile menu;
    private HBox mainHBox;
    private Rectangle zoneDeVue = new Rectangle(400, 800, 300, 900);
    private static double MULT_POUR_FIT_ALL = 1.1;
    private DessinCanvas cDessin;
    
    public PannneauPrincipal(Stage statut) {
        this(statut, new Group());
    }

    public PannneauPrincipal(Stage statut, Group affichage) {
        this(statut, null, affichage);
    }
    
    public void fitAll() {
        //this.zoneDeVue = new Rectangle(this.affichage.XminFigure(), this.affichage.XmaxFigure(), this.affichage.YminFigure(), this.affichage.YmaxFigure());
        this.zoneDeVue = this.zoneDeVue.echelle(MULT_POUR_FIT_ALL);
    }

    public PannneauPrincipal(Stage statut,File fromFile, Group affichage) {
        this.statut = statut;
        this.affichage = affichage;
        this.cDessin = new DessinCanvas(this);
        this.menu = new MenuFile(this);
        this.hboxzoom = new HboxZoom();
        hboxzoom.setPadding(new Insets(10,10,10,10));
        this.vboxgauche = new VBoxGauche();
        VBox TopTools = new VBox(new MenuFile(this), hboxzoom);
        this.setCenter(cDessin);
        this.setTop(TopTools);
        this.setLeft(this.vboxgauche);
        this.fitAll();
    }
    
    public Controleur getControleur() {
        return controleur;
    }

    public MenuFile getMenu() {
        return menu;
    }
    
    public Group getAffichage() {
        return affichage;
    }

    public Rectangle getZoneDeVue() {
        return zoneDeVue;
    }

    public void setZoneDeVue(Rectangle zoneDeVue) {
        this.zoneDeVue = zoneDeVue;
    }
    
    public static double getMULT_POUR_FIT_ALL() {
        return MULT_POUR_FIT_ALL;
    }

    public File getFichier() {
        return fichier;
    }

    public Stage getStatut() {
        return statut;
    }

    public VBoxGauche getVboxgauche() {
        return vboxgauche;
    }

    public void setAffichage(Group affichage) {
        this.affichage = affichage;
    }

    public void setStatut(Stage statut) {
        this.statut = statut;
    }

    public void setFichier(File fichier) {
        this.fichier = fichier;
    }

    public void setVboxgauche(VBoxGauche vboxgauche) {
        this.vboxgauche = vboxgauche;
    }

    public void setMenu(MenuFile menu) {
        this.menu = menu;
    }
    
    public void redrawAll() {
        this.cDessin.redrawAll();
    }  

    public HboxZoom getHboxzoom() {
        return hboxzoom;
    }

    public void setHboxzoom(HboxZoom hboxzoom) {
        this.hboxzoom = hboxzoom;
    }

    public HBox getMainHBox() {
        return mainHBox;
    }

    public void setMainHBox(HBox mainHBox) {
        this.mainHBox = mainHBox;
    }   
}
