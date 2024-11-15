package sio.projetautoecole;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class EleveViewController implements Initializable {
    @javafx.fxml.FXML
    private AnchorPane apProfile;
    @javafx.fxml.FXML
    private AnchorPane apLecon;
    @javafx.fxml.FXML
    private AnchorPane apPlanning;
    @javafx.fxml.FXML
    private AnchorPane apReglement;
    @javafx.fxml.FXML
    private AnchorPane apPermis;

    @javafx.fxml.FXML
    public void deconnexionOnClick(ActionEvent actionEvent) throws IOException {
        // appel d'une fonction seDeconnecter
        Stage currentStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        currentStage.close();

        FXMLLoader fxmlLoader = new FXMLLoader(sio.projetautoecole.HelloController.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("PartieEleve");
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void changeToProfil(ActionEvent actionEvent) {
        changeAP(apLecon);
        // chargement
    }

    @javafx.fxml.FXML
    public void changeToReglement(ActionEvent actionEvent) {
        changeAP(apReglement);
    }

    @javafx.fxml.FXML
    public void hoverNavItem(Event event) {

    }

    @javafx.fxml.FXML
    public void retourNavItemToNormal(Event event) {
    }

    @javafx.fxml.FXML
    public void changeToPlanning(ActionEvent actionEvent) {
        changeAP(apPlanning);
    }

    @javafx.fxml.FXML
    public void changeToPermis(ActionEvent actionEvent) {
        changeAP(apPermis);
    }

    @javafx.fxml.FXML
    public void changeToLecon(ActionEvent actionEvent) {
        changeAP(apLecon);
    }


    public void clearAll(){
        apLecon.setVisible(false);
        apReglement.setVisible(false);
        apPermis.setVisible(false);
        apPlanning.setVisible(false);
        apProfile.setVisible(false);
    }

    private void changeAP(AnchorPane ap){
        clearAll();
        ap.setVisible(true);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        clearAll();
        changeAP(apProfile);
    }

}
