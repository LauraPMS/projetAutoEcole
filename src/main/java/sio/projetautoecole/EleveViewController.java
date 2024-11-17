package sio.projetautoecole;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sio.projetautoecole.controllers.CompteController;
import sio.projetautoecole.controllers.EleveController;
import sio.projetautoecole.controllers.MoniteurController;
import sio.projetautoecole.models.Eleve;
import sio.projetautoecole.models.Moniteur;
import sio.projetautoecole.tools.ConnexionBDD;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Objects;
import java.util.ResourceBundle;

public class EleveViewController implements Initializable {

    // Anchor Pane Barre de navigation

    @javafx.fxml.FXML
    private AnchorPane apProfile, apLecon , apPlanning, apReglement, apPermis;

    @javafx.fxml.FXML
    private TableView tvProchaineLecon;

    @javafx.fxml.FXML
    private TableColumn tcPermisLecon, tcJourLecon, tcMoniteurLecon, tcLecon, tcHorraireLecon;

    @javafx.fxml.FXML
    private ScrollPane spaneListePermis;

    CompteController compteController;
    EleveController eleveController;
    ConnexionBDD connexionBDD;
    int numCompteActif;
    Eleve eleve;

    @javafx.fxml.FXML
    private Label lblCP, lblVille, lblDate, lblPrenom, lblNom, lblTelephone;
    @javafx.fxml.FXML
    private ImageView imgPdp;
    @FXML
    private ToggleGroup leconFini;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            connexionBDD = new ConnexionBDD();
            compteController = new CompteController();
            eleveController = new EleveController();
            numCompteActif = Session.getNumCompteActif();
            eleve = eleveController.getEleveByNumCompte(numCompteActif);
            System.out.println("Eleve : "+eleve.getPrenomEleve()+" "+eleve.getNomEleve());

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        clearAll();
        changeAP(apProfile);
        majProfil();

    }



    @javafx.fxml.FXML
    public void deconnexionOnClick(ActionEvent actionEvent) throws IOException {
        // appel d'une fonction seDeconnecter

        Session.changerScene("hello-view.fxml", "Acceuil", actionEvent);

    }

    @javafx.fxml.FXML
    public void changeToProfil(ActionEvent actionEvent) {
        changeAP(apProfile);
        majProfil();
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



    @javafx.fxml.FXML
    public void changeModifierProfil(ActionEvent actionEvent) {

    }

    @javafx.fxml.FXML
    public void changePrendreLecon(ActionEvent actionEvent) {
    }




    public void majProfil(){
        lblPrenom.setText(eleve.getPrenomEleve());
        lblNom.setText(eleve.getNomEleve());
        lblTelephone.setText(eleve.getTelephoneEleve());
        lblCP.setText(eleve.getCodePostalEleve());
        lblVille.setText(eleve.getVilleEleve());
        lblDate.setText(eleve.getDateNaisseEleve().toString());
        if (eleve.getSexeEleve()==1){
            changeImageViewImg(imgPdp, "femme.png" );
        }
        else if (eleve.getSexeEleve()==2){
            changeImageViewImg(imgPdp, "homme.png" );
        }
    }

    public void changeImageViewImg(javafx.scene.image.ImageView imgView, String linkImage){
        imgView.setImage(
                new Image(
                        Objects.requireNonNull(getClass().getResource(
                                "/img/" + linkImage
                        )).toExternalForm()
                )
        );
    }
}
