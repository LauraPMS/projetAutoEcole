package sio.projetautoecole;

import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Session {
    private static int numCompteActif;

    public static int getNumCompteActif() {
        return numCompteActif;
    }

    public static void setNumCompteActif(int numCompteActif) {
        Session.numCompteActif = numCompteActif;
    }

    static void changerScene(String strFXML, String titre, Event event) throws IOException {
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.close();
        FXMLLoader fxmlLoader = new FXMLLoader(EleveViewController.class.getResource(strFXML));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle(titre);
        stage.setScene(scene);
        stage.show();
    }
}
