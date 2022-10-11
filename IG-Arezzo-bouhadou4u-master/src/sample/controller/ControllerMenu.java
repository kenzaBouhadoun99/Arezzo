package sample.controller;


import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import partition.Melodie;
import sample.Main;
import sample.utils.Monde;
import sample.utils.Observateur;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Optional;


public class ControllerMenu  implements Observateur {

    @FXML private Label montitre;
    private  Monde m;

    /**
     * Controlleur du Menu
     * @param monde
     */
    public ControllerMenu(Monde monde) {
        this.m=monde;
        this.m.ajouterObservateur(this);
    }

    /**
     * La fonction qui permet de quitter l'application
     */
    public void quitter(){
       Platform.exit();
    }

    /**
     * La fonction qui permet de renommer la partie
     */
    public void renommer(){
        TextInputDialog boitededialogue = new TextInputDialog("Entrer un nom pour la Partition");
        boitededialogue.setContentText("Entrer un nom pour la Partition");
        boitededialogue.setHeaderText("Renommer la partition");
        boitededialogue.setTitle("Renommer la Partition");
        Optional<String> affichage = boitededialogue.showAndWait();
        affichage.ifPresent(nometp -> {m.setNom(nometp);});
        m.notifierObservateurs();
        }

    /**
     * La  fonction
     */
    public void ouvrir(){
          FileChooser file = new FileChooser();
          file.setTitle("Selectionner un fichier a ouvrir :");
          file.setInitialDirectory(new File(System.getProperty("user.home")));
          FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Arezzo", "*.");
          file.getExtensionFilters().add(extFilter);
          File files = file.showOpenDialog(new Stage());

          if (files!=null) {
              try {

                  FileInputStream f= new FileInputStream(files.getPath());
                  ObjectInputStream obj = new ObjectInputStream(f);
                  Melodie melod = (Melodie) obj.readObject();
                  m.setNom(melod.getTitre());
                  obj.close();
                  f.close();
              }catch (Exception e){
                  e.printStackTrace();
              }
          }
      }
    @Override
    public void reagir() {
        montitre.setText(m.getPartition().getTitre());
    }
}