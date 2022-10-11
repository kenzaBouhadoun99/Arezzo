package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import sample.controller.*;
import sample.utils.Monde;

public class Main  extends Application{
    @Override
    public void start(Stage primaryStage) throws Exception {

        FXMLLoader fxmlLoader=new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("vue/arezzo.fxml"));
        Monde monde = new Monde();


        ControllerMenu menu = new ControllerMenu((monde));
        ControllerPiano piano = new ControllerPiano((monde));
        ControllerNotes note = new ControllerNotes(monde);
        ControllerSlider slide = new ControllerSlider(monde);
        ControllerPartition p = new ControllerPartition(monde);

        fxmlLoader.setControllerFactory(ic ->{
            if(ic.equals(sample.controller.ControllerPiano.class)) return piano;
            if(ic.equals(sample.controller.ControllerMenu.class)) return menu;
            if(ic.equals(sample.controller.ControllerNotes.class)) return note;
            if(ic.equals(sample.controller.ControllerSlider.class)) return slide;
            if(ic.equals(sample.controller.ControllerPartition.class)) return p;
            else return null;
        });
        Pane par =fxmlLoader.load();
        primaryStage.setTitle("Arezzo");
        primaryStage.setScene(new Scene(par,800,600));
        primaryStage.show();
    }

    /**
     * La fonction qui permet de stopper le processus
     */
    public void stop(){System.exit(0);}
    public static void main(String[] args) {
        launch(args);
    }

}