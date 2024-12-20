package sio.projetautoecole;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sio.projetautoecole.controllers.*;
import sio.projetautoecole.models.Compte;
import sio.projetautoecole.models.Moniteur;
import sio.projetautoecole.tools.ConnexionBDD;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

public class MoniteurViewController implements Initializable {


    @javafx.fxml.FXML
    private AnchorPane apProfile, apModifierProfile;

    // Informations du moniteur affiché sur la page profil
    @javafx.fxml.FXML
    private Label lblCP, lblNom, lblVille, lblDate, lblTelephone, lblPrenom, lblProchaineLecon, lblMail;
    @javafx.fxml.FXML
    private ImageView imgPdp;

    // Liste déroulante des différentes licences obtenue par le moniteur

    @javafx.fxml.FXML
    private ScrollPane spListePermis;
    @javafx.fxml.FXML
    private ImageView empPermis1, empPermis2, empPermis3, empPermis4, empPermis5;

    // Liste des prochaine leçon (pour le lendemain)

    @javafx.fxml.FXML
    private TableView tvProchaineLecon;
    @javafx.fxml.FXML
    private TableColumn tcHorraireLecon, tcPermisLecon, tcJourLecon, tcMoniteurLecon;

    // Informations du moniteur affiché sur la page Modifier Profile
    @javafx.fxml.FXML
    private TextField txtNvCp,txtNvVille,txtNvTel;


    // controller utile : Compte, Moniteur
    CompteController compteController;
    EleveController eleveController;
    ConnexionBDD connexionBDD;
    LeconController leconController;
    CategorieController categorieController;
    MoniteurController moniteurController;
    LicenceController licenceController;
    EleveCategorieController eleveCategorieController;

    // Moniteur connecté
    Moniteur moniteur;

    int numCompteActif;
    @javafx.fxml.FXML
    private Label lblListeCategorie;
    @javafx.fxml.FXML
    private TableColumn tcVehiculeLecon;
    @javafx.fxml.FXML
    private PasswordField txtNvMdp;
    @javafx.fxml.FXML
    private TextField txtNvMail;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        tcPermisLecon.setCellValueFactory(new PropertyValueFactory<>("categorie"));
        tcJourLecon.setCellValueFactory(new PropertyValueFactory<>("date"));
        tcMoniteurLecon.setCellValueFactory(new PropertyValueFactory<>("codeMoniteur"));
        tcVehiculeLecon.setCellValueFactory(new PropertyValueFactory<>("immatriculation"));
        tcHorraireLecon.setCellValueFactory(new PropertyValueFactory<>("heure"));

        try {
            connexionBDD = new ConnexionBDD();
            compteController = new CompteController();
            moniteurController = new MoniteurController();
            eleveController = new EleveController();
            leconController = new LeconController();
            categorieController = new CategorieController();
            licenceController = new LicenceController();
            numCompteActif = Session.getNumCompteActif();
            moniteur = moniteurController.getMoniteurByNumCompte(numCompteActif);
            System.out.println("Moniteur récupéré : " + moniteur.getPrenomMoniteur()+" "+moniteur.getNomMoniteur());

            tvProchaineLecon.setItems(FXCollections.observableList(leconController.getAllLeconForMoniteur(numCompteActif)));



        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        clearAll();
        changeAp(apProfile);
        try {
            majProfil(moniteur);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



    // ----------------------------  Fonction controleurs Graphiques    ------------------------------------ //

    @javafx.fxml.FXML
    public void deconnexionOnClick(ActionEvent actionEvent) throws IOException {
        // Retour a la page accueil
        Session.changerScene("hello-view.fxml", "Acceuil", actionEvent);
    }

    @javafx.fxml.FXML
    public void changeToProfil(ActionEvent actionEvent) throws SQLException {changeAp(apProfile);majProfil(moniteur);}

    @javafx.fxml.FXML
    public void changeModifierProfil(ActionEvent actionEvent) {
        // changement de vuie
        // mise a jour concernant le moniteur
        changeAp(apModifierProfile);
        String ville = lblVille.getText();
        String tel = lblTelephone.getText();
        String cP = lblCP.getText();

        txtNvCp.setPromptText(cP.toString());
        txtNvVille.setPromptText(ville);
        txtNvTel.setPromptText(tel);
        txtNvMdp.setPromptText("****");

    }
    @javafx.fxml.FXML
    public void annulerModificationProfil(ActionEvent actionEvent) throws SQLException {
        changeAp(apProfile);
        majProfil(moniteur);
        txtNvVille.setText("");
        txtNvCp.setText("");
        txtNvTel.setText("");
    }


    // il manque le changement de mot de passe
    @javafx.fxml.FXML
    public void enregistrerModificationProfil(ActionEvent actionEvent) throws SQLException {
        // update dans la base de données
        changeAp(apModifierProfile);

        if(!Objects.equals(txtNvCp.getText(), "")){
            moniteur.setCodePostal(txtNvCp.getText());
        }
        if(!Objects.equals(txtNvTel.getText(), "")){
            moniteur.setTelephoneMoniteur(txtNvTel.getText());
        }
        if(!Objects.equals(txtNvVille.getText(), "")){
            moniteur.setVilleMoniteur(txtNvVille.getText());
        }


        moniteurController.updateMoniteur(moniteur);

        majProfil(moniteur);
        changeAp(apProfile);
        txtNvVille.setText("");
        txtNvCp.setText("");
        txtNvTel.setText("");

    }


    @javafx.fxml.FXML
    public void changeToReglement(ActionEvent actionEvent) {
        // changement de vuie
        // mise a jour concernant le moniteur
    }

    @javafx.fxml.FXML
    public void hoverNavItem(Event event) {
        // rien pour l'instant
    }



    @javafx.fxml.FXML
    public void retourNavItemToNormal(Event event) {
        // rien pour l'instant
    }

    @javafx.fxml.FXML
    public void changeToPlanning(ActionEvent actionEvent) {
        // changement de vuie
        // mise a jour concernant le moniteur
    }

    @javafx.fxml.FXML
    public void changeToPermis(ActionEvent actionEvent) {
        // changement de vuie
        // mise a jour concernant le moniteur
    }



    @javafx.fxml.FXML
    public void changeToLecon(ActionEvent actionEvent) {

    }

    @javafx.fxml.FXML
    public void afficherVueChargerPdp(ActionEvent actionEvent) {
        // a voir plus tard

    }

    // ------------------------------- Fin Fonction Controleurs graphiques --------------------------------//

    // -------------------- Fonction servant aux controlleurs graphiques (maj, affichage etc) ------------------------//

    public void majProfil(Moniteur m) throws SQLException {
        lblPrenom.setText(m.getPrenomMoniteur());
        lblNom.setText(m.getNomMoniteur());
        lblVille.setText(m.getVilleMoniteur());
        lblDate.setText(m.getDateMoniteur().toString());
        lblTelephone.setText(m.getTelephoneMoniteur());
        lblCP.setText(m.getCodePostal());
        if (m.getSexeMoniteur()==1){
            changeImageViewImg(imgPdp, "femme.png" );
        }
        else if (m.getSexeMoniteur()==2){
            changeImageViewImg(imgPdp, "homme.png" );
        }
        viderEmplacements();

        for (int i = 1; i <= 5; i++) {
            if (licenceController.get(numCompteActif, i)) {
                switch (i) {
                    case 1:
                        afficherAuPremierEmplacement("voiture.png");
                        break;
                    case 2:
                        afficherAuPremierEmplacement("livraison-rapide.png");
                        break;
                    case 3:
                        afficherAuPremierEmplacement("bateau.png");
                        break;
                    case 4:
                        afficherAuPremierEmplacement("moto.png");
                        break;
                    case 5:
                        afficherAuPremierEmplacement("train.png");
                        break;
                }
            }
        }

    }
    public void afficherAuPremierEmplacement(String source) {
        List<ImageView> imgEmp = Arrays.asList(empPermis1, empPermis2, empPermis3, empPermis4, empPermis5);
        for (ImageView image : imgEmp) {
            if (image.getImage() == null) {
                changeImageViewImg(image, source);
                return;
            }
        }
    }

    public void viderEmplacements() {
        List<ImageView> imgEmp = Arrays.asList(empPermis1, empPermis2, empPermis3, empPermis4, empPermis5);
        for (ImageView image : imgEmp) {
            image.setImage(null);
        }
    }






    // Focntion utile

    public void clearAll(){
        apModifierProfile.setVisible(false);
        apProfile.setVisible(false);
    }

    public void changeAp(AnchorPane ap){
        clearAll();
        ap.setVisible(true);
    }

    public void changeImageViewImg(ImageView imgView, String linkImage){
        imgView.setImage(
                new Image(
                        Objects.requireNonNull(getClass().getResource(
                                "/img/" + linkImage
                        )).toExternalForm()
                )
        );
    }


}
