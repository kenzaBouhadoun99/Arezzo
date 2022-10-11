package sample.controller;

import sample.utils.Monde;
import sample.utils.Observateur;

public class ControllerSlider implements Observateur {
    private Monde monde;

    public  ControllerSlider(Monde monde){
        this.monde=monde;
    }
    public void guitare(){
        monde.getPartition().setInstrument("Guitare");
    }

    /**
     * La fonction qui permet de choisir le saxophone
     */
    public void Saxophone(){
        monde.getPartition().setInstrument("Saxophone");
    }
    /**
     * La fonction qui permet de choisir le piano
     */
    public void piano(){
        monde.getPartition().setInstrument("Piano");
    }
    /**
     * La fonction qui permet de choisir le guitare
     */
    public void trompette(){
        monde.getPartition().setInstrument("Trompette");
    }
    @Override
    public void reagir() {

    }
}
