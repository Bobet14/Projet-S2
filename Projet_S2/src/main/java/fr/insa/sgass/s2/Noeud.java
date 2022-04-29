/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.sgass.s2;

/**
 *
 * @author Sgass
 */
public abstract class Noeud {
    
    private int ID;
    private Vecteur pos;
    private Vecteur Effort;
    private int type;

    public Noeud(int ID, Vecteur pos, Vecteur Effort, int type) {
        this.ID = ID;
        this.pos.setVecteur(pos);
        this.Effort.setVecteur(Effort);
        this.type=type;
    }

    public Noeud(Vecteur pos, Vecteur Effort, int type) {
        this.pos.setVecteur(pos);
        this.Effort.setVecteur(Effort);
        this.ID=-1;
        this.type=type;
    }

    public Noeud(Vecteur pos, int type) {
        this.pos.setVecteur(pos);
        this.Effort = new Vecteur (0,0);
        this.ID=-1;
        this.type=type;
    }
    
    
    
    
    
    
    
    
}
