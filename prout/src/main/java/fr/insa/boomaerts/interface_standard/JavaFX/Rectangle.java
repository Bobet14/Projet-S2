/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.boomaerts.interface_standard.JavaFX;

import javafx.scene.transform.Transform;

/**
 *
 * @author jboomaerts01
 */
public class Rectangle{
    
    private double xMin;
    private double xMax;
    private double yMin;
    private double yMax;

    public Rectangle(double xMin, double xMax, double yMin, double yMax) {
        this.xMin = xMin;
        this.xMax = xMax;
        this.yMin = yMin;
        this.yMax = yMax;
    }
    
    @Override
    public String toString() {
        return "Rectangle{" + "xMin=" + xMin + ", xMax=" + xMax + ", yMin=" + yMin + ", yMax=" + yMax + '}';
    }
    
    public Rectangle echelle(double facteur) {
        double dx = this.xMax - this.xMin;
        double dy = this.yMax - this.yMin;
        double cx = (this.xMax + this.xMin) /2;
        double cy = (this.yMax + this.yMin) /2;
        double nxmin = cx - (dx / 2) * facteur;
        double nxmax = cx + (dx / 2) * facteur;
        double nymin = cy - (dy / 2) * facteur;
        double nymax = cy + (dy / 2) * facteur;
        return new Rectangle(nxmin, nxmax, nymin, nymax);    
    }

    /*public Rectangle translateGauche(double portionConservee) {
        double dx = (this.xMax - this.xMin)*(1-portionConservee);
        return new Rectangle(this.xMin-dx,this.xMax-dx,this.yMin,this.yMax);
    }
    
    public Rectangle translateDroite(double portionConservee) {
        double dx = (this.xMax - this.xMin)*(1-portionConservee);
        return new Rectangle(this.xMin+dx,this.xMax+dx,this.yMin,this.yMax);
    }
    
    public Rectangle translateHaut(double portionConservee) {
        double dy = (this.yMax - this.yMin)*(1-portionConservee);
        return new Rectangle(this.xMin,this.xMax,this.yMin-dy,this.yMax-dy);
    }
    
    public Rectangle translateBas(double portionConservee) {
        double dy = (this.yMax - this.yMin)*(1-portionConservee);
        return new Rectangle(this.xMin,this.xMax,this.yMin+dy,this.yMax+dy);
    }*/
    
    public Transform fitTransform(Rectangle vue) {
        double minX1 = this.xMin;
        double maxX1 = this.xMax;
        double minY1 = this.yMin;
        double maxY1 = this.yMax;
        double dx1 = (maxX1 - minX1);
        double dy1 = (maxY1 - minY1);
        double cx1 = (maxX1 + minX1) / 2;
        double cy1 = (maxY1 + minY1) / 2;
        double minX2 = vue.xMin;
        double minY2 = vue.yMin;
        double maxX2 = vue.xMax;
        double maxY2 = vue.yMax;
        double dx2 = maxX2 - minX2;
        double dy2 = maxY2 - minY2;
        double cx2 = (maxX2 + minX2) / 2;
        double cy2 = (maxY2 + minY2) / 2;
        // je ramène le centre du rectangle 1 en 0,0
        Transform ttrans1 = Transform.translate(-cx1, -cy1);
        // je calcule (si possible) une échelle
        Transform tscale = Transform.scale(1, 1);
        if (dx1 > 0 && dy1 > 0 && dx2 > 0 && dy2 > 0) {
            double scale = Math.min(dx2 / dx1, dy2 / dy1);
            tscale = Transform.scale(scale, scale);
        }
        // je ramène 0 au centre  du rectangle 2
        Transform ttrans2 = Transform.translate(cx2, cy2);
        Transform res = ttrans2.createConcatenation(tscale).createConcatenation(ttrans1);
        return res;
    }

    public double getxMin() {
        return xMin;
    }

    public double getxMax() {
        return xMax;
    }

    public double getyMin() {
        return yMin;
    }

    public double getyMax() {
        return yMax;
    }

    public void setxMin(double xMin) {
        this.xMin = xMin;
    }

    public void setxMax(double xMax) {
        this.xMax = xMax;
    }

    public void setyMin(double yMin) {
        this.yMin = yMin;
    }

    public void setyMax(double yMax) {
        this.yMax = yMax;
    }
}
