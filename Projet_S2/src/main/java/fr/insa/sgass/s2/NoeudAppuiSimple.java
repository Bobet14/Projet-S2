/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.sgass.s2;

/**
 *
 * @author Sgass
 */
public class NoeudAppuiSimple extends Noeud{

    public NoeudAppuiSimple(int ID, Vecteur pos, Vecteur Effort) {
        super(ID, pos, Effort, 1);
    }

    public NoeudAppuiSimple(Vecteur pos, Vecteur Effort) {
        super(pos, Effort, 1);
    }

    public NoeudAppuiSimple(Vecteur pos) {
        super(pos, 1);
    }
    
}
