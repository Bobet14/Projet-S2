/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.boomaerts.Treillis;

import java.util.ArrayList;
import java.util.Objects;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 *
 * @author Sgass
 */
public class Noeud extends Vecteur {
    
    private int ID;
    private Vecteur pos;
    private Vecteur Effort;
    private int type;
    private ArrayList <Barre> BDepart;
    private ArrayList <Barre> BArrivee;
    private double radius=5;
    private Color color = Color.RED;

    public Noeud(int ID, Vecteur pos, Vecteur Effort, int type) {
        this.ID = ID;
        this.pos.setVecteur(pos);
        this.Effort.setVecteur(Effort);
        this.type=type;
        this.BArrivee = new ArrayList <Barre>();
        this.BDepart = new ArrayList <Barre>();
    }

    public Noeud(Vecteur pos, Vecteur Effort, int type) {
        this.pos.setVecteur(pos);
        this.Effort.setVecteur(Effort);
        this.ID=-1;
        this.type=type;
        this.BArrivee = new ArrayList <Barre>();
        this.BDepart = new ArrayList <Barre>();
    }

    public Noeud(Vecteur pos, int type) {
        this.pos.setVecteur(pos);
        this.Effort = new Vecteur (0,0);
        this.ID=-1;
        this.type=type;
        this.BArrivee = new ArrayList <Barre>();
        this.BDepart = new ArrayList <Barre>();
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Vecteur getPos() {
        return pos;
    }

    public void setPos(Vecteur pos) {
        this.pos.setVecteur(pos);
    }

    public Vecteur getEffort() {
        return Effort;
    }

    public void setEffort(Vecteur Effort) {
        this.Effort.setVecteur(Effort);
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public ArrayList<Barre> getBDepart() {
        return BDepart;
    }

    public ArrayList<Barre> getBArrivee() {
        return BArrivee;
    }
    public void addBDepart(Barre b) {
        BDepart.add(b);
    }
    public void addBArrivee(Barre b){
        BArrivee.add(b);
    }
    public void removeBDepart(Barre b) {
        BDepart.remove(b);
    }
    public void removeBArrivee(Barre b) {
        BArrivee.remove(b);
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.ID;
        hash = 59 * hash + Objects.hashCode(this.pos);
        hash = 59 * hash + Objects.hashCode(this.Effort);
        hash = 59 * hash + this.type;
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
        final Noeud other = (Noeud) obj;
        if (this.type != other.type) {
            return false;
        }
        if (!Objects.equals(this.pos, other.pos)) {
            return false;
        }
        return Objects.equals(this.Effort, other.Effort);
    }
    
    public void setNoeud (Noeud N){
        this.ID = N.getID();
        this.type = N.getType();
        this.pos.setVecteur(N.getPos());
        this.Effort.setVecteur(N.getEffort());
        this.BDepart.clear();
        this.BArrivee.clear();
        for (int i=0;i<N.getBDepart().size();i++) {
            this.BDepart.add(N.getBDepart().get(i));
        }
        for (int i=0;i<N.getBArrivee().size();i++) {
            this.BArrivee.add(N.getBArrivee().get(i));
        }
    }
    public void draw(GraphicsContext context){
        context.setFill(getColor());
        context.fillOval(this.x-radius, this.y-radius,2*radius , 2*radius);
    }

}
