package fr.insa.boomaerts.Treillis;

import java.util.Objects;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Barre {
    private int ID;
    private Noeud Depart;
    private Noeud Arrivee;
    Color color = Color.BLACK;

    public Barre(int ID, Noeud Depart, Noeud Arrivee) {
        this.ID = ID;
        this.Depart = Depart;
        this.Depart.addBDepart(this);
        this.Arrivee = Arrivee;
        this.Arrivee.addBArrivee(this);
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
        Depart.addBDepart(this);
        this.Depart.setNoeud(Depart);
    }

    public Noeud getArrivee() {
        return Arrivee;
    }

    public void setArrivee(Noeud Arrivee) {
        Arrivee.addBArrivee(this);
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
    
    public void draw(GraphicsContext context){ 
        context.setFill(this.color);
        context.setLineWidth(0.1);
        context.strokeLine(Depart.getX(), Depart.getY(), Depart.getX(), Depart.getY());
    }

}
