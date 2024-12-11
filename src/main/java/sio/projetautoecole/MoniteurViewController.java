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

public class MoniteurViewController implements Initializable{


    @javafx.fxml.FXML
    private AnchorPane apPlanning;
    @javafx.fxml.FXML
    private AnchorPane apProfil;
    @javafx.fxml.FXML
    private AnchorPane apRevenus;
    @javafx.fxml.FXML
    private AnchorPane apLicence;
    @javafx.fxml.FXML
    private AnchorPane apSuiviEleves;

    @javafx.fxml.FXML
    public void deconnexionOnClick(ActionEvent actionEvent) throws IOException {
        // appel d'une fonction seDeconnecter
        Stage currentStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        currentStage.close();

        FXMLLoader fxmlLoader = new FXMLLoader(sio.projetautoecole.HelloController.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Accueil");
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void changeToProfil(ActionEvent actionEvent) { changeAP(apProfil); }

    @javafx.fxml.FXML
    public void hoverNavItem(Event event) {
    }

    @javafx.fxml.FXML
    public void retourNavItemToNormal(Event event) {
    }

    @javafx.fxml.FXML
    public void changeToPlanning(ActionEvent actionEvent) { changeAP(apPlanning); }

    @javafx.fxml.FXML
    public void changeToLicence(ActionEvent actionEvent) { changeAP(apLicence); }

    @javafx.fxml.FXML
    public void changeToRevenus(ActionEvent actionEvent) { changeAP(apRevenus); }

    @javafx.fxml.FXML
    public void changeToSuiviEleve(ActionEvent actionEvent) { changeAP(apSuiviEleves); }

    public void clearAll(){
        apSuiviEleves.setVisible(false);
        apRevenus.setVisible(false);
        apLicence.setVisible(false);
        apPlanning.setVisible(false);
        apProfil.setVisible(false);
    }

    private void changeAP(AnchorPane ap){
        clearAll();
        ap.setVisible(true);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        clearAll();
        changeAP(apProfil);
    }
}
