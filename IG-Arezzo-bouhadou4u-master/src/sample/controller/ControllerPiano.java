package sample.controller;


import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import sample.utils.Monde;
import sample.utils.Observateur;

public class ControllerPiano implements Observateur {

    @FXML
    private RadioButton croch,white,noi,ron,gra,med,aig;
    private  Monde monde;
    private String melo="";

    public ControllerPiano(Monde monde) {
        this.monde=monde;
        monde.ajouterObservateur(this);
    }

    /**
     * La fonction qui permet de choisir les notes voulue
     * @param s
     * @return
     */
        public String choixNotes(String s){
        if(aig.isSelected()){
            s= s.toLowerCase();
        }
        if(med.isSelected() || noi.isSelected()){
            s= s.toUpperCase();
        }
        if(gra.isSelected()){
            s =s +',';
        }
        if(ron.isSelected()){
            s =s+'4';
        }
        if(white.isSelected()){
            s = s+'2';
        }
        if(croch.isSelected()){
            s = s +'/';
        }
        return s;
        }

    /**
     * La fonction qui permet d'appliquer la note la
     */
    public void La() {
            String s=choixNotes("A");
            monde.getPartition().play(s);
            melo+=s;
            monde.getPartition().setMelodie(melo);
            monde.notifierObservateurs();
    }

    /**
     * La fonction qui permet d'appliquer la note si
     */
        public void Si() {
            String s=choixNotes("B");
            monde.getPartition().play(s);
            melo+=s;
            monde.getPartition().setMelodie(melo);
            monde.notifierObservateurs();
    }

    /**
     * La fonction qui permet de choisir la note do
     */
        public void Do() {
            String s=choixNotes("C");
            monde.getPartition().play(s);
            melo+=s;
            monde.getPartition().setMelodie(melo);
            monde.notifierObservateurs();}

    /**
     * L a fonction qui permet de choisir la note re
     */
        public void Re() {
            String s=choixNotes("D");
            monde.getPartition().play(s);
            melo+=s;
            monde.getPartition().setMelodie(melo);
            monde.notifierObservateurs();
                }

    /**
     * L a fonction qui permet de choisir la note mi
     */
    public void Mi() {
        String s=choixNotes("E");
            monde.getPartition().play(s);
            melo+=s;
            monde.getPartition().setMelodie(melo);
            monde.notifierObservateurs();
                }
    /**
     * L a fonction qui permet de choisir la note fa
     */
        public void Fa() {
        String s=choixNotes("F");
            monde.getPartition().play(s);
            melo+=s;
            monde.getPartition().setMelodie(melo);
            monde.notifierObservateurs();}
    /**
     * L a fonction qui permet de choisir la note sol
     */
        public void Sol() {
        String s=choixNotes("G");
            monde.getPartition().play(s);
            melo+=s;
            monde.getPartition().setMelodie(melo);
            monde.notifierObservateurs();}
    /**
     * L a fonction qui permet de choisir la note la noire
     */
        public void LaNoire() {
            String s=choixNotes("^A");
            monde.getPartition().play(s);
            melo+=s;
            monde.getPartition().setMelodie(melo);
            monde.notifierObservateurs();
                }
    /**
     * L a fonction qui permet de choisir la note do noire
     */
        public void DoNoire() {
            String s=choixNotes("^B");
            monde.getPartition().play(s);
            melo+=s;
            monde.getPartition().setMelodie(melo);
            monde.notifierObservateurs();
                }
    /**
     * L a fonction qui permet de choisir la note re noire
     */
        public void ReNoire() {
            String s=choixNotes("^C");
            monde.getPartition().play(s);
            melo+=s;
            monde.getPartition().setMelodie(melo);
            monde.notifierObservateurs();
                }
    /**
     * L a fonction qui permet de choisir la note fa noire
     */
        public void FaNoire() {
            String s=choixNotes("^D");
            monde.getPartition().play(s);
            melo+=s;
            monde.getPartition().setMelodie(melo);
            monde.notifierObservateurs();
                }
    /**
     * L a fonction qui permet de choisir la note sol noire
     */
        public void SolNoire() {
            String s=choixNotes("^E");
            monde.getPartition().play(s);
            melo+=s;
            monde.getPartition().setMelodie(melo);
            monde.notifierObservateurs();}

    /**
     * La FONCTION QUI permet de jouer la partition
     */
    public void jouerLaPartition(){
        monde.getPartition().play(melo);
    }
    @Override
    public void reagir() {
    }
}