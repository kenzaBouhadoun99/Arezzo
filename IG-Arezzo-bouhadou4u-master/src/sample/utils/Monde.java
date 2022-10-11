package sample.utils;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import partition.Partition;

import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Synthesizer;

public class Monde extends SujetObserve{
    private String mel;
    private Monde m;
    @FXML private Button parti;
    Synthesizer synthesizer;
    {
        try {
            synthesizer = MidiSystem.getSynthesizer();
        } catch (MidiUnavailableException e) {
            e.printStackTrace();
        }
    }
    Partition part = new Partition(synthesizer);
    public Monde() {
        part.setTitre("Bohemian Rhapsody (F.Mercury)");
    }

    /**
     * Getter de partition
     * @return
     */
    public Partition getPartition(){
        return part;
    }

    /**
     * Setter du nom
     * @param str
     */
    public void setNom(String str){
      this.part.setTitre(str);
    }



}
