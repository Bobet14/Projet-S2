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

    public NoeudAppuiDouble(int ID, Vecteur pos, Vecteur Effort, int type) {
        super(ID, pos, Effort, type);
    }

    public NoeudAppuiDouble(Vecteur pos, Vecteur Effort, int type) {
        super(pos, Effort, type);
    }

    public NoeudAppuiDouble(Vecteur pos, int type) {
        super(pos, type);
    }
    
    
}
