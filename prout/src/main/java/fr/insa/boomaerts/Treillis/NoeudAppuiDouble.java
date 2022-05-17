
package fr.insa.boomaerts.Treillis;

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
