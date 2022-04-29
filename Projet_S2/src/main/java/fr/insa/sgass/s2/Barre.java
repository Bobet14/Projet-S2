/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.sgass.s2;

import java.util.Objects;

/**
 *
 * @author Sgass
 */
public class Barre {
    private int ID;
    private Noeud Depart;
    private Noeud Arrivee;

    public Barre(int ID, Noeud Depart, Noeud Arrivee) {
        this.ID = ID;
        this.Depart = Depart;
        this.Arrivee = Arrivee;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Noeud getDepart() {
        return Depart;
    }

    public void setDepart(Noeud Depart) {
        this.Depart.setNoeud(Depart);
    }

    public Noeud getArrivee() {
        return Arrivee;
    }

    public void setArrivee(Noeud Arrivee) {
        this.Arrivee.setNoeud(Arrivee);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + this.ID;
        hash = 37 * hash + Objects.hashCode(this.Depart);
        hash = 37 * hash + Objects.hashCode(this.Arrivee);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Barre other = (Barre) obj;
        if (!Objects.equals(this.Depart, other.Depart)) {
            return false;
        }
        return Objects.equals(this.Arrivee, other.Arrivee);
    }
    
    public Noeud noeudOppose (Noeud N) {
        if (this.Arrivee.equals(N)) {
            return this.Depart;
        }
        return this.Arrivee;
    }
    
    public Vecteur getDir() {
        return new Vecteur(this.Arrivee.getPos().getX()-this.Depart.getPos().getX(),this.Arrivee.getPos().getY()-this.Depart.getPos().getY());
    }
    
    public double angle () {
        return this.getDir().angleTo(new Vecteur (1,0));
    }
}
