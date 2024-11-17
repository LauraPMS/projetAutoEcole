package sio.projetautoecole;

import com.fasterxml.jackson.core.json.DupDetector;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import sio.projetautoecole.controllers.*;
import sio.projetautoecole.models.Compte;
import sio.projetautoecole.models.Eleve;
import sio.projetautoecole.tools.ConnexionBDD;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Objects;
import java.util.Random;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

// AnchorPane

    @FXML
    private AnchorPane ApInscription, ApConnexion, ApAccueil, ApCompte, ApEleve, ApMoniteur;


// TextField

    @FXML
    private TextField txtInscriptionNom, txtInscriptionLogin, txtInscriptionPassword, txtInscriptionPrenom;
    @FXML
    private TextField txtConnexionPassword, txtConnexionLogin;


// var local

    // Connexion et controller
    ConnexionBDD connexionBDD;
    CompteController compteController;

    int numCompteActif;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try {
            connexionBDD = new ConnexionBDD();
            compteController = new CompteController();

            clearAll();
            changeAP(ApAccueil);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    // Click sur le bouton du formulaire connexion
    @FXML
    public void onClickConnexion(Event event) throws SQLException, IOException {

        // vérifier les champs vides

        if (txtConnexionLogin.getText().equals("")) {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Erreur");
            alert.setHeaderText("Veuillez renseignez votre login");
            alert.showAndWait();

        }
        else if(txtConnexionPassword.getText().equals("")) {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Erreur");
            alert.setHeaderText("Veuillez renseignez votre Mot de passe");
            alert.showAndWait();

        }

        else {

            // Récupère les champs txt et compare leur existence dans la base de données

            String login = txtConnexionLogin.getText();
            String password = txtConnexionPassword.getText();

            // Si le compte existe, on récupère le statut pour savoir quel interface afficher.

            if(!compteController.verifCompte(login, password)){

                // si le compte n'existe pas on génère une erreur
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Erreur");
                alert.setHeaderText("Votre login ou mot de passe est incorrect");
                alert.showAndWait();

            }
            else{

                int statutCompte = compteController.getStatutBynumCompte();
                numCompteActif = compteController.getNumCompteActif();
                Session.setNumCompteActif(numCompteActif);
                System.out.println("Hello Controller : " + numCompteActif);

                if (statutCompte == 0){

                    Session.changerScene("eleve-view.fxml", "Partie Eleve", event);

                }
                else if (statutCompte == 1){

                    Session.changerScene("moniteur-view.fxml", "Partie Moniteur", event);

                }
                else {
                    System.out.println("Bizzarerie");
                }
            }


        }

    }



    // Click sur le formulaire Inscription
    @FXML
    public void onClickInscription(Event event) {
      // a faire par lorenz
    }






    // ----------------- Changement de vue ------------------------- //

    @FXML
    public void changeToConnexion(Event event) {

        // fonction permettant d'afficher l'AnchorPane ApConnexion
        changeAP(ApConnexion);

    }

    @FXML
    public void changeToInscription(Event event) {

        // fonction permettant d'afficher l'AnchorPane ApInscription
        changeAP(ApInscription);

    }

    @FXML
    public void changeToAccueil(Event event) {

        // fonction permettant d'afficher l'AnchorPane ApAccueil
        changeAP(ApAccueil);

    }

    @FXML
    public void changeToCompte(Event event) {

        //fonction permettant d'afficher l'Anchor Pane APCompte7
        changeAP(ApCompte);

        // Cette fonction devra une fois l'utilisateur connecter, renvoyer vers la page Souscrire a un permis

    }



    //------------ Fonction utile ------------//

    private void clearAll(){
        ApAccueil.setVisible(false);
        ApInscription.setVisible(false);
        ApConnexion.setVisible(false);
        ApAccueil.setVisible(false);
        ApCompte.setVisible(false);
        ApEleve.setVisible(false);
        ApMoniteur.setVisible(false);
    }

    private void changeAP(AnchorPane ap){
        clearAll();
        ap.setVisible(true);
    }

    public int getNumCompteActif(){
        return numCompteActif;
    }



}