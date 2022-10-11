package sample.controller;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sample.utils.Monde;
import sample.utils.Observateur;

/* Faire une list view dans controller note et cree un autre fichier fxml pour les medium image medium  */

public class ControllerNotes implements Observateur {
    private ContextMenu items;
    @FXML private Button listnote;
    @FXML private ListView listview;
    private Monde monde;


    public ControllerNotes(Monde monde){
        this.monde=monde;
        this.monde.ajouterObservateur(this);
    }

    public void ouvrirFenetre() {
        Label secondLabel = new Label("new Window");
        StackPane secondaryLayout = new StackPane();
        secondaryLayout.getChildren().addAll(secondLabel);
        Scene secondScene = new Scene(secondaryLayout, 230, 100);
        Stage newWindow = new Stage();
        newWindow.setTitle("Notes");
        newWindow.setScene(secondScene);
        newWindow.initModality(Modality.WINDOW_MODAL);
        newWindow.show();
        items =new ContextMenu();
        MenuItem monter =new MenuItem("Effacer");
        monter.setOnAction(actionEvent ->f_monter() );

        items.getItems().add(monter);
        listview.setContextMenu(items);
    }
    private void f_monter()
    {
        for (Object i : listview.getSelectionModel().getSelectedItems()){
            Pane notePane = (Pane)i;
            if (notePane != null){
               // BasicNote note = (BasicNote)notePane.getUserData();
                //if (note != null){
                  //  monde.monterLeTon(note);
                }
            }
        }
        @Override
        public void reagir () {

        }
    }