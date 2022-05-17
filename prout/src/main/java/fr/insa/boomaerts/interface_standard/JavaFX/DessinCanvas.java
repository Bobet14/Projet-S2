/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.boomaerts.interface_standard.JavaFX;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.transform.Affine;
import javafx.scene.transform.Transform;


/**
 *
 * @author jboomaerts01
 */
public class DessinCanvas extends Pane {
    
    private PannneauPrincipal main;

    final Canvas realCanvas;
    private Rectangle asRect;

    public DessinCanvas(PannneauPrincipal main) {
        this.main = main;
        this.realCanvas = new Canvas(this.getWidth(), this.getHeight());
        /*this.asRect = new Rectangle(0, 0, this.getWidth(), this.getHeight());*/
        this.getChildren().add(this.realCanvas);
        this.realCanvas.heightProperty().bind(this.heightProperty());
        this.realCanvas.heightProperty().addListener((o) -> {
            this.redrawAll();
        });
        this.realCanvas.widthProperty().bind(this.widthProperty());
        this.realCanvas.widthProperty().addListener((o) -> {
            this.redrawAll();
        });
        this.redrawAll();
    }

    /*public void concatenateTransform(Transform trans) {
        Transform oldTrans = this.realCanvas.getGraphicsContext2D().getTransform();
        Transform newTrans = oldTrans.createConcatenation(trans);
        this.setTransform(newTrans);
    }

    public void setTransform(Transform trans) {
        this.realCanvas.getGraphicsContext2D().setTransform(new Affine(trans));
    }

    public Transform getTransform() {
        return this.realCanvas.getGraphicsContext2D().getTransform();
    }*/

    public void redrawAll() {
        GraphicsContext context = this.realCanvas.getGraphicsContext2D();
        context.setFill(Color.WHITE);
        context.fillRect(0, 0, realCanvas.getWidth(), realCanvas.getHeight());
        /*context.setTransform(new Affine());
        context.clearRect(0, 0, this.realCanvas.getWidth(), this.realCanvas.getHeight());
        this.asRect.setXmax(this.realCanvas.getWidth());
        this.asRect.setYmax(this.realCanvas.getHeight());*/
        /*Transform curTrans = this.main.getZoneDeVue().fitTransform(this.asRect);*/
        /*this.setTransform(curTrans);*/
        }
}
