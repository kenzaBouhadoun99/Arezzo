package sample.controller;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import sample.utils.Monde;
import sample.utils.Observateur;


public class ControllerPartition implements Observateur {
    private Monde m;
    @FXML private ImageView par;

    /**
     * Le constructeur de la partition
     * @param m
     */
    public ControllerPartition (Monde m){
        this.m=m;
        this.m.ajouterObservateur(this);

    }
    @Override
    public void reagir() {
        this.par.setImage(m.getPartition().getImage());
    }
}
