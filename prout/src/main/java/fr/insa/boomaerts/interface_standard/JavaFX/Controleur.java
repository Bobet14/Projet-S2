/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.boomaerts.interface_standard.JavaFX;

/**
 *
 * @author jboomaerts01
 */
public class Controleur {
    
    private PannneauPrincipal appli;
    /*String sampleText = "Bonjour, nous vous sommes reconnaissant d'avoir choisis notre application pour votre création de treillis.\n Malheureusement, nous avons rencontré un problème lors de la sauvegarde de ce dernier. Merci pour votre compréhension.";
    Text sample = new Text(sampleText);*/

    public Controleur (PannneauPrincipal appli) {
        this.appli = appli;
    }
    
    public void zoomAvant() {
        this.appli.setZoneDeVue(this.appli.getZoneDeVue().echelle(0.5));
        this.appli.redrawAll();
    }
    
    public void zoomArriere() {
        this.appli.setZoneDeVue(this.appli.getZoneDeVue().echelle(2));
        this.appli.redrawAll();
    }
    
    public void zoomNiveau() {
        this.appli.fitAll();
        this.appli.redrawAll();
    }
    
    public void deplacementDroite() {
        this.appli.setZoneDeVue(this.appli.getZoneDeVue().echelle(0.8));
        this.appli.redrawAll();
    }
    
    public void deplacementGauche() {
        this.appli.setZoneDeVue(this.appli.getZoneDeVue().echelle(0.8));
        this.appli.redrawAll();
    }
    
    public void deplacementHaut() {
        this.appli.setZoneDeVue(this.appli.getZoneDeVue().echelle(0.8));
        this.appli.redrawAll();
    }
    
    public void deplacementBas() {
        this.appli.setZoneDeVue(this.appli.getZoneDeVue().echelle(0.8));
        this.appli.redrawAll();
    }
}
