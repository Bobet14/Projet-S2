package fr.insa.sgass.Treillis;

import static java.lang.Math.abs;
import java.util.ArrayList;
import javafx.scene.canvas.GraphicsContext;

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
    
    public Noeud NoeudLePlusProche(double x, double y) {
        double minD=0 ;
        Noeud i = this.Noeuds.get(0);
        if (this.Noeuds.size()>0) {
            i = this.Noeuds.get(0);
            minD = Math.sqrt(abs(i.getX()-x)+abs(i.getY())-y);
        }
        for(Noeud j : Noeuds){                           
            double dmin=Math.sqrt(abs(j.getX()-x)+abs(j.getY()-y));
            if (dmin<minD) {
                j=i;
                minD=dmin;  
            }
            else {
                return null;
            }    
        }
        return i;
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
    
    public void draw(GraphicsContext context) { 
        for (Noeud n : this.Noeuds){
            n.draw(context);
        }
        for (Barre b : this.Barres){
            b.draw(context);
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
    
    public int noeudAppui (){
        int a=0;
        for (int i=0;i<this.Noeuds.size();i++){
            if (this.Noeuds.get(i).getType()!=0){
                a++;
            }
        }
        return a;
    }
    
    public void Calcul (double [][] e) {
        sortBarres();
        sortNoeuds();
        boolean condition_calcul = (this.noeudAppui()>=2);
        if (condition_calcul){
            for (int i=0;i<this.Noeuds.size();i++) {
                for (int j=0;j<this.Barres.size();j++){
                    if ((this.Barres.get(j).getArrivee().equals(this.Noeuds.get(i)))||this.Barres.get(j).getDepart().equals(this.Noeuds.get(i))){
                        e[2*i][2*j] = Math.cos(this.Barres.get(j).angle());
                        e[2*i+1][2*j+1] = Math.sin(this.Barres.get(j).angle());
                    }
                }
                e[2*i][this.Barres.size()*2] = this.Noeuds.get(i).getEffort().getX();
                e[2*i+1][this.Barres.size()*2] = this.Noeuds.get(i).getEffort().getY();
            }
            gauss(e);
        }
        else if (this.noeudAppui()<2) {
            System.err.println("Il manque un noeud d'appui");
        }
        else {
            System.err.println("Trop/pas assez d'equations");
        }
    }
    
    public void gauss(double [][]Systeme){
        int n = Systeme.length;
        double [][] M = new double [n][n];
        double [][] inv = new double [n][n];
        //on copie la partie gauche des égalites dans une matrice à part
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                M[i][j] = Systeme[i][j];
            }
        }
        //debut de l'algorithme: on rend la matrice triangle
        
        //on recopie la matrice inverse dans la partie gauche des égalités
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                Systeme[i][j] = M[i][j];
            }
        }
    }
    
    public static void cgtColonne(double [][]M, double [][]inv, int J1, int J2){
        for (int i=0;i<M.length;i++){
            double s = M[i][J1];
            M[i][J1]=M[i][J2];
            M[i][J2]=s;
            s = inv[i][J1];
            inv[i][J1]=inv[i][J2];
            inv[i][J2]=s;
        }
    }
    
    public static void zeroingRight(double [][]M, double [][]inv, int l){
        int n = M.length;
        double p = M[l][l];
        for (int i=l+1;i<n;i++){
            double a = M[l][i];
            for (int j=l;j<n;j++){
                M[j][i]=M[j][i]-a*M[j][l]/p;
                inv[j][i]=inv[j][i]-a*inv[j][l]/p;
            }
        }
    }
    public static void zeroingLeft(double [][]M, double [][]inv, int l){
        int n = M.length;
        double p = M[l][l];
        for (int i=l-1;i>0;i--){
            double a = M[l][i];
            for (int j=n-1;j<l;j--){
                M[j][i]=M[j][i]-a*M[j][l]/p;
                inv[j][i]=inv[j][i]-a*inv[j][l]/p;
            }
        }
    }
}
