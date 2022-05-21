package fr.insa.sgass.Treillis;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import static java.lang.Math.abs;
import java.util.ArrayList;
import java.util.Scanner;
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
    
    //Trie respectivement les barres et les noeuds par indice
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
    
    public static void gauss(double [][]Systeme){
        int n = Systeme.length;
        double [][] M = new double [n][n];
        double [][] inv = new double [n][n];
        //la matrice inv est l'identité au début
        for (int i=0;i<n;i++){
            inv[i][i]=1;
        }
        //on copie la partie gauche des égalites dans une matrice à part
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                M[i][j] = Systeme[i][j];
            }
        }
        //debut de l'algorithme: on rend la matrice triangle
        for (int i=0;i<n-1;i++){
            int j=1;
            //Pivot non nul
            while ((M[i][i]==0)&&(j+i<n)){
                cgtColonne(M, inv, i, i+j);
                j++;
            }
            if (j+i<n){
                zeroingRight(M, inv, i);
            }
            else {
                System.err.println("Matrice non inversible");
            }
        }
        //deuxième partie de l'algorithme: on diagonalise la matrice
        for (int i=n-1;i>0;i--){
            zeroingLeft(M, inv, i);
        }
        //fin de l'algorithme: on rend la matrice identité
        for (int i=0;i<n;i++){
            diviseColonne(M, inv, i);
        }
        //on recopie la matrice inverse dans la partie gauche des égalités
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                Systeme[i][j] = inv[i][j];
            }
        }
        Test_Matrice.print(M);
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
    
    public static void zeroingRight(double [][]M, double [][]inv, int c){
        int n = M.length;
        double p = M[c][c];
        for (int i=c+1;i<n;i++){
            double a = M[c][i];
            for (int j=0;j<n;j++){
                M[j][i]=M[j][i]-a*M[j][c]/p;
                inv[j][i]=inv[j][i]-a*inv[j][c]/p;
            }
        }
    }
    public static void zeroingLeft(double [][]M, double [][]inv, int c){
        int n = M.length;
        double p = M[c][c];
        for (int i=0;i<c;i++){
            double a = M[c][i];
            for (int j=0;j<n;j++){
                M[j][i]=M[j][i]-a*M[j][c]/p;
                inv[j][i]=inv[j][i]-a*inv[j][c]/p;
            }
        }
    }
    public static void diviseColonne(double [][]M, double [][]inv, int c){
        double d = M[c][c];
        int n = M.length;
        for (int i=0;i<n;i++){
            M[i][c] = M[i][c]/d;
            inv[i][c]=inv[i][c]/d;
        }
    }
    
    public void creerSauvegarde(String f) throws IOException{
        f=f+".txt";
        FileWriter fw = new FileWriter(f);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write("Noeuds:\r\n");
        for (int i=0;i<this.Noeuds.size();i++){
            Noeud N = this.Noeuds.get(i);
            bw.write(""+N.getID()+";"+N.getType()+";("+N.getPos().getX()+";"+N.getPos().getY()+");("+N.getEffort().getX()+";"+N.getEffort().getY()+")\r\n");
        }
        bw.write("Barres:\r\n");
        for (int i=0;i<this.Barres.size();i++){
            Barre B = this.Barres.get(i);
            bw.write(""+B.getID()+";"+B.getDepart().getID()+";"+B.getArrivee().getID() +"\r\n");
        }
        bw.close();
        fw.close();
    }
    public static boolean isDouble (char c){
        return (((c<=57)&&(c>=48))||(c==46)) ;  
    }
    
    public Treillis(String f) {
        f=f+".txt";
        Scanner sc = new Scanner(f);
        this.Noeuds = new ArrayList<Noeud>();
        this.Barres = new ArrayList<Barre>();
        while (sc.hasNext()&&!sc.nextLine().equals("Barres:")){
            String n = sc.nextLine();
            int id = n.charAt(0)-'0';
            double px=0;
            ArrayList <Character> c = new ArrayList<Character>();
            int i=5;
            int j=0;
            while (isDouble(n.charAt(i))) {
                if (n.charAt(i)=='.'){
                    j=i-3;
                }
                else{
                    c.add(n.charAt(i));
                }
                i++;
            }
            for (int k=0;k<c.size();k++){
                px=px+(c.get(k)-'0')*Math.pow(10, j-k);
            }
            c.clear();
            i++;
            double py=0;
            j=i;
            while (isDouble(n.charAt(i))){
                if (n.charAt(i)=='.'){
                    j=i-j;
                }
                else {
                    c.add(n.charAt(i));
                }
                i++;
            }
            for (int k=0;k<c.size();k++){
                py = py+(c.get(k)-'0')*Math.pow(10, j-k);
            }
            c.clear();
            i=i+2;
            j=i;
            double ex=0;
            while (isDouble(n.charAt(i))){
                if (n.charAt(i)=='.'){
                    j=i-j;
                }
                else {
                    c.add(n.charAt(i));
                }
                i++;
            }
            for (int k=0;k<c.size();k++){
                ex = ex+(c.get(k)-'0')*Math.pow(10, j-k);
            }
            c.clear();
            i++;
            j=i;
            double ey=0;
            while (isDouble(n.charAt(i))){
                if (n.charAt(i)=='.'){
                    j=i-j;
                }
                else {
                    c.add(n.charAt(i));
                }
                i++;
            }
            for (int k=0;k<c.size();k++){
                ey = ey+(c.get(k)-'0')*Math.pow(10, j-k);
            }
            this.Noeuds.add(new Noeud(id,new Vecteur(px,py),new Vecteur(ex, ey), n.charAt(2)-'0'));
        }
        sortNoeuds();
        while (sc.hasNext()){
            String b = sc.nextLine();
            this.Barres.add(new Barre(b.charAt(0)-'0', Noeuds.get(b.charAt(2)-'0'), Noeuds.get(b.charAt(4)-'0')));
        }
    }
}
