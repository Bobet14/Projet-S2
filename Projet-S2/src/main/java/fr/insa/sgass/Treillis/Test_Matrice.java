/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.sgass.Treillis;
import java.util.Random;
import java.util.Scanner;
/**
 *
 * @author Sgass
 */
public class Test_Matrice {
    
    public static void rdMatrice(double [][] M, int n) {
        Random rd = new Random();
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                M[i][j]=rd.nextDouble()*10;
            }
        }
    }
    
    public static void print(double [][] M){
        int n = M.length;
        System.out.print("[");
        for (int i=0;i<n;i++){
            System.out.print("[");
            for (int j=0;j<n;j++){
                System.out.print(M[i][j]+",");
            }
            System.out.println("],");
        }
        System.out.print("]");
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Taille?");
        int n = sc.nextInt();
        double [][] M = new double [n][n];
        rdMatrice(M, n);
        print(M);
        System.out.println("---");
        Treillis.gauss(M);
        print(M);
    }
    
}
