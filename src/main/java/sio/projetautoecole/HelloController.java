package sio.projetautoecole;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;
import sio.projetautoecole.controllers.*;
import sio.projetautoecole.tools.ConnexionBDD;

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


// var local

    ConnexionBDD connexionBDD;
    EleveController eleveController;
    CategorieController categorieController;
    MoniteurController moniteurController;
    LeconController leconController;
    VehiculeController vehiculeController;



    private String pageDebutDestination = "profil";   // Profil, permis ou intro (si inscription)
    @FXML
    private TableColumn tcPrix;
    @FXML
    private TableView tvTestPermis;
    @FXML
    private TableColumn tcPermis;


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

            tvTestPermis.setItems(FXCollections.observableList(categorieController.getAllCategories()));

            clearAll();
            changeAP(ApAccueil);

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @FXML
    public void onClickConnexion(Event event) {

        // Récupère les champs txt et compare leur existence dans la base de données


        // Si le compte existe, on récupère le statut pour savoir quel interface afficher.


        // Création de l'objet utilisateur et calcul des différentes statistiques


        // maj des labels du profil

    }


    @FXML
    public void onClickInscription(Event event) {

        // vérification des champs (pas de champs vide!)
        // vérification du statut pour savoir ou enregistrer le nouvel utilisateur
        // création de l'objet utilisateur (élève ou moniteur) puis ajout dans la base de données.
        // Redirection vers l'AnchorPane PremièreConnexionUtilisateur (completer les infos utilisateurs et desription de chaque onglet)

    }

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