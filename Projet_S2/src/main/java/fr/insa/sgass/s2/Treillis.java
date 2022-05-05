package fr.insa.sgass.s2;

import java.util.ArrayList;

public class Treillis {
   private  ArrayList <Noeud> Noeuds;
   private ArrayList <Barre> Barres;

   public Treillis(ArrayList<Noeud> Noeuds, ArrayList<Barre> Barres) {
       this.Noeuds = Noeuds;
       this.Barres = Barres;
   }

   public Treillis() {
   }

    public ArrayList<Noeud> getNoeuds() {
        return Noeuds;
    }

    public void setNoeuds(ArrayList<Noeud> Noeuds) {
        this.Noeuds = Noeuds;
    }

    public ArrayList<Barre> getBarres() {
        return Barres;
    }

    public void setBarres(ArrayList<Barre> Barres) {
        this.Barres = Barres;
    }
   
    public int maxIdNoeud() {
        int max = -1;
        for (int i=0;i<this.Noeuds.size();i++) {
            if (max<this.Noeuds.get(i).getID()) {
                max = this.Noeuds.get(i).getID();
            }
        }
        return max;
    }
    public int maxIdBarre() {
        int max = -1;
        for (int i=0;i<this.Barres.size();i++) {
            if (max<this.Barres.get(i).getID()) {
                max = this.Barres.get(i).getID();
            }
        }
        return max;
    }
   
    public boolean isNoeudIn(Noeud N){
        boolean a = false;
        int i = 0;
        while (!a&&(i<this.Noeuds.size())){
            a=N.equals(this.Noeuds.get(i));
            i++;
        }
        return a;
    }
   
    public void addNoeud (Noeud N) {
        if (this.isNoeudIn(N)){
            System.err.println("Noeud deja present");
        }
        else {
            N.setID(this.maxIdNoeud()+1);
            this.Noeuds.add(N);
        }
    }
    public boolean isBarreIn(Barre B){
        boolean a = false;
        int i = 0;
        while (!a&&(i<this.Barres.size())){
            a=B.equals(this.Barres.get(i));
            i++;
        }
        return a;
    }
   
    public void addBarre (Barre B) {
        if (this.isBarreIn(B)){
            System.err.println("Barre deja presente");
        }
        else {
            if (!isNoeudIn(B.getArrivee())) {
                this.Noeuds.add(B.getArrivee());
            }
            if (!isNoeudIn(B.getDepart())) {
                this.Noeuds.add(B.getDepart());
            }
            B.setID(this.maxIdBarre()+1);
            this.Barres.add(B);
        }
    }
    public void sortBarres () {
        Barre stock;
        for (int i=0;i<this.Barres.size();i++) {
            int j=i;
            while ((j>0)&&(this.Barres.get(j).getID()<this.Barres.get(j-1).getID())) {
                stock=this.Barres.get(j);
                this.Barres.set(j,this.Barres.get(j-1));
                this.Barres.set(j-1, stock);
            }
        }
    }
    public void sortNoeuds () {
        Noeud stock;
        for (int i=0;i<this.Noeuds.size();i++) {
            int j=i;
            while ((j>0)&&(this.Noeuds.get(j).getID()<this.Noeuds.get(j-1).getID())) {
                stock=this.Noeuds.get(j);
                this.Noeuds.set(j,this.Noeuds.get(j-1));
                this.Noeuds.set(j-1, stock);
            }
        }
    }
    
    public int [][] chercheEquation () {
        int [][] e = new int[this.Noeuds.size()][this.Noeuds.size()+1];
        
        return e;
    }
   
}
