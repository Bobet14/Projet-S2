/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.sgass.s2;

/**
 *
 * @author Sgass
 */
public class NoeudAppuiDouble extends Noeud{

    public NoeudAppuiDouble(int ID, Vecteur pos, Vecteur Effort) {
        super(ID, pos, Effort, 2);
    }

    public NoeudAppuiDouble(Vecteur pos, Vecteur Effort) {
        super(pos, Effort, 2);
    }

    public NoeudAppuiDouble(Vecteur pos) {
        super(pos, 2);
    }
    
    
}
