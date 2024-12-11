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
import java.sql.SQLException;
import java.util.Objects;
import java.util.Random;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

// AnchorPane

    @FXML
    private AnchorPane ApInscription;
    @FXML
    private AnchorPane ApPrincipale;
    @FXML
    private AnchorPane ApConnexion;
    @FXML
    private AnchorPane ApAccueil;
    @FXML
    private AnchorPane ApCompte;
    @FXML
    private AnchorPane ApEleve;
    @FXML
    private AnchorPane ApMoniteur;



// TextField

    @FXML
    private TextField txtInscriptionNom;
    @FXML
    private TextField txtConnexionPassword;
    @FXML
    private TextField txtInscriptionLogin;
    @FXML
    private TextField txtInscriptionPassword;
    @FXML
    private TextField txtInscriptionPrenom;
    @FXML
    private TextField txtConnexionLogin;



// ImageView

    @FXML
    private ImageView connexion;
    @FXML
    private ImageView btnConnexion;
    @FXML
    private ImageView btnGoInscription;
    @FXML
    private ImageView btnGoConnexion;
    @FXML
    private ImageView fondAccueil;
    @FXML
    private ImageView inscription;
    @FXML
    private ImageView btnInscription;
    @FXML
    private ImageView btnRetourAccueil;



// Bouton (rdo, chk, btn)

    @FXML
    private RadioButton rdoEleve;
    @FXML
    private RadioButton rdoMoniteur;
    @FXML
    private ToggleGroup statut;



// tableau

    @FXML
    private TableColumn tcPrix;
    @FXML
    private TableView tvTestPermis;
    @FXML
    private TableColumn tcPermis;
    @FXML
    private TableColumn tcCodeMoniteur;
    @FXML
    private TableView tvEleve;
    @FXML
    private TableColumn tcPrenomEleve;
    @FXML
    private TableColumn tcGenreMoniteur;
    @FXML
    private TableColumn tcPrenomMoniteur;
    @FXML
    private TableColumn tcNomMoniteur;
    @FXML
    private TableColumn tcNomEleve;
    @FXML
    private TableView tvMoniteur;
    @FXML
    private TableColumn tcCodeEleve;
    @FXML
    private TableColumn tcGenreEleve;



// var local

    // Connexion et controller
    ConnexionBDD connexionBDD;
    EleveController eleveController;
    CategorieController categorieController;
    MoniteurController moniteurController;
    LeconController leconController;
    VehiculeController vehiculeController;
    CompteController compteController;
    EleveCategorieController eleveCategorieController;


    private String pageDebutDestination = "profil";   // Profil, permis ou intro (si inscription)






    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        // Initialiser les controles graphiquess au lancement de l'application

        tcPrix.setCellValueFactory(new PropertyValueFactory<>("prix"));
        tcPermis.setCellValueFactory(new PropertyValueFactory<>("libelle"));

        try {
            connexionBDD = new ConnexionBDD();

            eleveController = new EleveController();
            categorieController = new CategorieController();
            moniteurController = new MoniteurController();
            leconController = new LeconController();
            vehiculeController = new VehiculeController();
            compteController = new CompteController();
            eleveCategorieController = new EleveCategorieController();


            tvTestPermis.setItems(FXCollections.observableList(categorieController.getAllCategories()));
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
        }
        else if(txtConnexionPassword.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Erreur");
            alert.setHeaderText("Veuillez renseignez votre Mot de passe");
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
            }
            else{

                int numCompte = compteController.getnumCompte(login);
                int statutCompte = compteController.getStatutBynumCompte(numCompte);
                Compte compte = new Compte(numCompte,login, password, statutCompte);
                int code = compteController.getUserByCompte(numCompte);

                if (compte.getStatut() == 0){
                    // Partie Eleve
                    Eleve eric = eleveController.getEleveById(code);

                    // Fermer la fenêtre actuelle
                    Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    currentStage.close();

                    // Charger et afficher la nouvelle scène
                    FXMLLoader fxmlLoader = new FXMLLoader(EleveViewController.class.getResource("eleve-view.fxml"));
                    Scene scene = new Scene(fxmlLoader.load());
                    Stage stage = new Stage();
                    stage.setTitle("Partie Élève");
                    stage.setScene(scene);
                    stage.show();

                }
                else{
                    // Partie Moniteur
                    // Fermer la fenêtre actuelle
                    Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    currentStage.close();

                    // Charger et afficher la nouvelle scène
                    FXMLLoader fxmlLoader = new FXMLLoader(EleveViewController.class.getResource("moniteur-view.fxml"));
                    Scene scene = new Scene(fxmlLoader.load());
                    Stage stage = new Stage();
                    stage.setTitle("Partie Moniteur");
                    stage.setScene(scene);
                    stage.show();
                }
            }


        }

    }



    // Click sur le formulaire Inscription
    @FXML
    public void onClickInscription(Event event) {

        // vérification des champs (pas de champs vide!)
        // vérification du statut pour savoir ou enregistrer le nouvel utilisateur
        // création de l'objet utilisateur (élève ou moniteur) puis ajout dans la base de données.
        // Redirection vers l'AnchorPane PremièreConnexionUtilisateur (completer les infos utilisateurs et desription de chaque onglet)

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
    }

    private void changeAP(AnchorPane ap){
        clearAll();
        ap.setVisible(true);
    }

    public void changeImageViewImg(ImageView imgView, String linkImage){
        // change l'image contenue dans l'image view
        imgView.setImage(
                new Image(
                        Objects.requireNonNull(getClass().getResource(
                                "/img/" + linkImage
                        )).toExternalForm()
                )
        );
    }

    public String getImageUrl(ImageView imageView){
        // obtenir l'url de l'image contenue dans image view
        Image image = imageView.getImage();
        if (image != null) {
            String ch =  image.getUrl();
            ch = ch.substring(74);
            return ch;
        } else {
            return null; // L'ImageView n'affiche aucune image
        }
    }

}