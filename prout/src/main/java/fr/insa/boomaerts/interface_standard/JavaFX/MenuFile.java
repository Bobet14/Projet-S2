/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.boomaerts.interface_standard.JavaFX;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author jboomaerts01
 */
public class MenuFile extends MenuBar {
    
    private PannneauPrincipal main;
    public MenuFile(PannneauPrincipal main) {
        this.main = main;
        String sampleText = "Bonjour, nous vous sommes reconnaissant d'avoir choisis notre application pour votre création de treillis.\n Malheureusement, nous avons rencontré un problème lors de la sauvegarde de ce dernier. Merci pour votre compréhension.";
        Text sample = new Text(sampleText);
        
        Menu fichierMenu = new Menu("Ficher");
        Menu templateMenu = new Menu("Templates");
        Menu aideMenu = new Menu("Aide");
        
        MenuItem help = new MenuItem("Aide"); /* fichier à remplir*/
        MenuItem aPropos = new MenuItem("A Propos"); /* fichier à remplir*/
        
        this.getMenus().addAll(fichierMenu, templateMenu, aideMenu);
        this.setStyle("-fx-base: lightblue ");
        
        aideMenu.getItems().addAll(help, aPropos);
        MenuItem nouveau = new MenuItem("Nouveau");
        MenuItem openFile = new MenuItem("Ouvrir");
        MenuItem saveFile = new MenuItem("Enregistrer");
        MenuItem saveFileas = new MenuItem("Enregistrer sous...");
        fichierMenu.getItems().addAll(nouveau, openFile, saveFile, saveFileas);
        
        nouveau.setAccelerator(KeyCombination.keyCombination("Ctrl+N"));
        nouveau.setOnAction((n) -> {
            Stage newWindow = new Stage();
            newWindow.setTitle("Nouveau Treillis");
            Scene scene = new Scene(new PannneauPrincipal(newWindow), 1000, 800);
            newWindow.setScene(scene);
            newWindow.show();
        });
        
        openFile.setAccelerator(KeyCombination.keyCombination("Ctrl+O"));
        openFile.setOnAction((t) -> {
            FileChooser fileChooser= new FileChooser();
            File fichier = fileChooser.showOpenDialog(this.main.getStatut());
        });
        
        saveFile.setAccelerator(KeyCombination.keyCombination("Ctrl+S"));
        saveFile.setOnAction((r) -> {
        if (this.main.getFichier()==null) {
            FileChooser fileSaver = new FileChooser();
            FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Treillis", "*.txt");
            fileSaver.getExtensionFilters().add(extFilter);
            File fichier = fileSaver.showSaveDialog(this.main.getStatut());
 
            if (fichier != null) {
                saveTextToFile(sampleText, fichier);
            }
        }
        else {
            this.ecraseSauvegarde(this.main.getFichier());
        }
        });
        
        saveFileas.setAccelerator(new KeyCodeCombination(KeyCode.S, KeyCombination.ALT_DOWN));
        saveFileas.setOnAction((e) -> {
            FileChooser fileSaver = new FileChooser();
            FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Treillis", "*.txt");
            fileSaver.getExtensionFilters().add(extFilter);
            File fichier = fileSaver.showSaveDialog(this.main.getStatut());
 
            if (fichier != null) {
                saveTextToFile(sampleText, fichier);
            }
        });
        
        aPropos.setOnAction((p) -> {
            Alert info = new Alert(AlertType.INFORMATION);
            info.setTitle("A Propos");
            info.setHeaderText(null);
            info.setContentText("à remplir");
            info.showAndWait();
        });
        
        help.setAccelerator(KeyCombination.keyCombination("Ctrl+A"));
        help.setOnAction((h) -> {
            /*fichier image d'aide*/
        }); 
    }
        private void saveTextToFile(String sampleText, File file) {
            try {
                PrintWriter writer;
                writer = new PrintWriter(file);
                writer.println(sampleText);
                writer.close();
            } catch (IOException ex) {
                Logger.getLogger(MenuFile.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        public void ecraseSauvegarde(File fichier) {
            try {
                BufferedWriter push = new BufferedWriter(new FileWriter("Treillis.txt", true)); /*save est à mettre dans le programme qui crée la figure de Siméon
            public void sauvegarde(File fichier) throws IOException {
        identificateur du numéro de figure
        try (BufferedWriter push = new BufferedWriter(new FileWriter(fout))) {
            this.save(push, variable identificateur);
        }*/
                this.main.setFichier(fichier);
                this.main.getStatut().setTitle(fichier.getName());
            } catch (IOException err) {
                Alert alerte = new Alert(AlertType.ERROR);
                alerte.setTitle("Attention");
                alerte.setHeaderText("Couldn't save file. Please try again.");
                alerte.setContentText(err.getLocalizedMessage());
                alerte.showAndWait();
            }
        } 
}

