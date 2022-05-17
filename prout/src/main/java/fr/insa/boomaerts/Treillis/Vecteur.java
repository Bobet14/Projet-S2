/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package fr.insa.boomaerts.Treillis;
/**
 *
 * @author Sgass
 */
public class Vecteur {
    
    public double x;
    public double y;

    public Vecteur(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Vecteur() {
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
    
    public void setVecteur(Vecteur v) {
        this.x = v.getX();
        this.y = v.getY();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + (int) (Double.doubleToLongBits(this.x) ^ (Double.doubleToLongBits(this.x) >>> 32));
        hash = 13 * hash + (int) (Double.doubleToLongBits(this.y) ^ (Double.doubleToLongBits(this.y) >>> 32));
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
        final Vecteur other = (Vecteur) obj;
        if (Double.doubleToLongBits(this.x) != Double.doubleToLongBits(other.x)) {
            return false;
        }
        return Double.doubleToLongBits(this.y) == Double.doubleToLongBits(other.y);
    }
    
    public double angleTo (Vecteur v) {
        return Math.acos(this.x*v.getX()+this.y*v.getY()/(Math.sqrt(this.x*this.x+this.y*this.y)*Math.sqrt(v.getX()*v.getX()+v.getY()*v.getY())));
    }
}
