/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.boomaerts.Treillis;

/**
 *
 * @author Sgass
 */
public class NoeudSimple extends Noeud{
    
    public NoeudSimple(int ID, Vecteur pos, Vecteur Effort) {
        super(ID, pos, Effort, 0);
    }

    public NoeudSimple(Vecteur pos, Vecteur Effort) {
        super(pos, Effort, 0);
    }

    public NoeudSimple(Vecteur pos) {
        super(pos, 0);
    }
    
    
    
}
