package sio.projetautoecole;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import sio.projetautoecole.controllers.*;
import sio.projetautoecole.models.Compte;
import sio.projetautoecole.models.Eleve;
import sio.projetautoecole.models.Moniteur;
import sio.projetautoecole.tools.ConnexionBDD;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

// AnchorPane

    @FXML
    private AnchorPane ApInscription, ApConnexion, ApAccueil, ApCompte ;


// TextField

    @FXML
    private TextField txtConnexionPassword, txtConnexionLogin;
    @FXML
    private TextField txtInscNom, txtInxcAdresse, txtInxcVille, txtInxcCp, txtInscLogin, txtInxcTelephone, txtInxcPrenom;
    @FXML
    private PasswordField txtInscPassWord;

// var local

    // Connexion et controller

    ConnexionBDD connexionBDD;
    CompteController compteController;
    MoniteurController moniteurController;
    EleveController eleveController;

    int numCompteActif;

    @FXML
    private RadioButton rdoInscFemme, rdoInscHomme;

    @FXML
    private DatePicker dpNaissance;

    @FXML
    private RadioButton rdoInsMoniteur, rdoInsEleve;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try {
            connexionBDD = new ConnexionBDD();
            compteController = new CompteController();
            moniteurController = new MoniteurController();
            eleveController = new EleveController();


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
    public void onClickInscription(Event event) throws SQLException {
      // a faire par lorenz finalement non

        // verification des champs vides
        String erreur = "Veuillez remplir les champs suivant : ";
        boolean erreurTrouve = false;
        if(txtInscLogin.getText().equals("")){
            erreurTrouve = true;
            erreur += " login ; ";
        }
        if(txtInscPassWord.getText().equals("")){
            erreurTrouve = true;
            erreur += " password ; ";
        }
        if(txtInscNom.getText().equals("")){
            erreurTrouve = true;
            erreur += " nom ; ";
        }
        if(txtInxcPrenom.getText().equals("")){
            erreurTrouve = true;
            erreur += " prenom ; ";
        }
        if(txtInxcAdresse.getText().equals("")){
            erreurTrouve = true;
            erreur += " adresse ; ";
        }
        if(txtInxcVille.getText().equals("")){
            erreurTrouve = true;
            erreur += " ville ; ";
        }
        if (txtInxcCp.getText().equals("")){
            erreurTrouve = true;
            erreur += " code postal ; ";
        }
        if(txtInxcTelephone.getText().equals("")){
            erreurTrouve = true;
            erreur += " telephone ; ";
        }
        if ( !rdoInscFemme.isSelected() && !rdoInscHomme.isSelected()) {
            erreurTrouve = true;
            erreur += " genre ; ";
        }
        if ( !rdoInsEleve.isSelected() && !rdoInsMoniteur.isSelected()) {
            erreurTrouve = true;
            erreur += " statut ; ";
        }
        if (compteController.loginAlreadyExist(txtInscLogin.getText())){
            erreurTrouve = true;
            erreur += "\n - login existe deja dans la base de données ; ";
        }
        if(erreurTrouve){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Erreur");
            alert.setHeaderText(erreur);
            alert.showAndWait();
        }
        else{
            // procéder a l'inscription
            if (rdoInsMoniteur.isSelected()){
                Compte c = new Compte(0, txtInscLogin.getText(), txtInscPassWord.getText(), 1);
                compteController.inscription(c.getLogin(), c.getMdp(), c.getStatut());
                int numCompteRecuperer = compteController.getNumeroCompte(txtInscLogin.getText(), txtInscPassWord.getText());

                int genre = 0;
                if (rdoInscFemme.isSelected()){
                    genre = 1;
                }

                Moniteur m = new Moniteur(numCompteRecuperer+1000, txtInscNom.getText(), txtInxcPrenom.getText(), txtInxcAdresse.getText(), genre, dpNaissance.getValue(), txtInxcCp.getText(), txtInxcVille.getText(), txtInxcTelephone.getText(), null, numCompteRecuperer );
                moniteurController.inscription(m);

            } else if (rdoInsEleve.isSelected()) {
                Compte c = new Compte(0, txtInscLogin.getText(), txtInscPassWord.getText(), 0);
                compteController.inscription(c.getLogin(), c.getMdp(), c.getStatut());
                int numCompteRecuperer = compteController.getNumeroCompte(txtInscLogin.getText(), txtInscPassWord.getText());

                int genre = 0;
                if (rdoInscFemme.isSelected()){
                    genre = 1;
                }
                Eleve e = new Eleve(numCompteRecuperer+1000, txtInscNom.getText(), txtInxcPrenom.getText(), txtInxcAdresse.getText(), txtInxcTelephone.getText(), genre, dpNaissance.getValue(), txtInxcCp.getText(), txtInxcVille.getText(), numCompteRecuperer, null );
                eleveController.inscription(e);

            }

            changeAP(ApConnexion);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Bienvenue ! ");
            alert.setHeaderText("Veuillez vous connecter avec vos identifiants");
            alert.showAndWait();

        }

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
        

    }



    //------------ Fonction utile ------------//

    private void clearAll(){
        ApAccueil.setVisible(false);
        ApInscription.setVisible(false);
        ApConnexion.setVisible(false);
        ApAccueil.setVisible(false);
        ApCompte.setVisible(false);
    }

    private void changeAP(AnchorPane ap){
        clearAll();
        ap.setVisible(true);
    }


}