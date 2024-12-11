package sio.projetautoecole;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
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
import sio.projetautoecole.models.Categorie;
import sio.projetautoecole.models.Eleve;
import sio.projetautoecole.models.Moniteur;
import sio.projetautoecole.tools.ConnexionBDD;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class EleveViewController implements Initializable {

    // Anchor Pane Barre de navigation

    @javafx.fxml.FXML
    private AnchorPane apProfile, apLecon , apPlanning, apReglement, apPermis, apPrendreLecon;

    @javafx.fxml.FXML
    private TableView tvProchaineLecon;

    @javafx.fxml.FXML
    private TableColumn tcPermisLecon, tcJourLecon, tcMoniteurLecon, tcHorraireLecon, tcVehiculeLecon;

    @javafx.fxml.FXML
    private ScrollPane spaneListePermis;

    @javafx.fxml.FXML
    private Label lblCP, lblVille, lblDate, lblPrenom, lblNom, lblTelephone;

    @FXML
    private ToggleGroup leconFini;

    @FXML
    private ImageView imgPdp, emp1, emp2, emp3, emp4, emp5;

    @FXML
    private ListView lvPLVehicule, lvPLHorraire, lvPLMoniteur, lvPLCategoriePermis;

    @FXML
    private DatePicker dpDateLecon;

    CompteController compteController;
    EleveController eleveController;
    ConnexionBDD connexionBDD;
    LeconController leconController;
    CategorieController categorieController;
    MoniteurController moniteurController;
    int numCompteActif;
    Eleve eleve;

    // Champs requis pour la leçon

    private int pLecon_codeLecon;
    private Date pLecon_date;
    private int pLecon_codeMoniteur;
    private int pLecon_codeEleve;
    private String pLecon_immatriculation;
    private int pLecon_Reglee;
    private String pLecon_heure;
    @FXML
    private TextField txtNvCp;
    @FXML
    private TextField txtNvVille;
    @FXML
    private TextField txtNvTel;
    @FXML
    private AnchorPane apModifierProfile;
    @FXML
    private PasswordField txtNvMdp;
    @FXML
    private TextField txtNvMail;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        tcPermisLecon.setCellValueFactory(new PropertyValueFactory<>("codeLecon"));
        tcJourLecon.setCellValueFactory(new PropertyValueFactory<>("date"));
        tcMoniteurLecon.setCellValueFactory(new PropertyValueFactory<>("codeMoniteur"));
        tcVehiculeLecon.setCellValueFactory(new PropertyValueFactory<>("categorie"));
        tcHorraireLecon.setCellValueFactory(new PropertyValueFactory<>("heure"));

        try {
            connexionBDD = new ConnexionBDD();
            compteController = new CompteController();
            eleveController = new EleveController();
            leconController = new LeconController();
            categorieController = new CategorieController();
            moniteurController = new MoniteurController();
            numCompteActif = Session.getNumCompteActif();
            eleve = eleveController.getEleveByNumCompte(numCompteActif);
            System.out.println("Eleve : "+eleve.getPrenomEleve()+" "+eleve.getNomEleve());

            // Mettre a jour le pane des permis en cours de l'eleve

            tvProchaineLecon.setItems(FXCollections.observableList(leconController.getAllLeconForEleve(eleve.getIdEleve())));
            lvPLCategoriePermis.setItems(FXCollections.observableList(categorieController.getAllLibelles()));

            // Mettre a jour le tableau des prochaines leçon

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        clearAll();
        changeAP(apProfile);
        majProfil(eleve);

    }



    @javafx.fxml.FXML
    public void deconnexionOnClick(ActionEvent actionEvent) throws IOException {
        // appel d'une fonction seDeconnecter
        Session.changerScene("hello-view.fxml", "Acceuil", actionEvent);

    }

    @javafx.fxml.FXML
    public void changeToProfil(ActionEvent actionEvent) {
        changeAP(apProfile);
        majProfil(eleve);
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
        apPrendreLecon.setVisible(false);
        apModifierProfile.setVisible(false);
    }

    private void changeAP(AnchorPane ap) {
        clearAll();
        ap.setVisible(true);
    }

    @javafx.fxml.FXML
    public void changeModifierProfil(ActionEvent actionEvent) {
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
    public void changePrendreLecon(ActionEvent actionEvent) {
        changeAP(apPrendreLecon);

        // vider les liste view sauf catégorie

        lvPLHorraire.getItems().clear();
        lvPLMoniteur.getItems().clear();
        lvPLVehicule.getItems().clear();

        // vider le champ date picker
        dpDateLecon.setValue(LocalDate.now());

        // set null tout les champs requis
        pLecon_codeEleve = 0;
        pLecon_codeMoniteur = 0;
        pLecon_codeLecon = 0;
        pLecon_date = null;
        pLecon_Reglee = 0;
        pLecon_immatriculation = null;
        pLecon_heure = null;

    }




    public void majProfil(Eleve e){
        lblPrenom.setText(e.getPrenomEleve());
        lblNom.setText(e.getNomEleve());
        lblTelephone.setText(e.getTelephoneEleve());
        lblCP.setText(e.getCodePostalEleve());
        lblVille.setText(e.getVilleEleve());
        lblDate.setText(e.getDateNaisseEleve().toString());
        if (e.getSexeEleve()==1){
            changeImageViewImg(imgPdp, "femme.png" );
        }
        else if (e.getSexeEleve()==2){
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

    @FXML
    public void afficherVehicule(Event event) throws SQLException {


    }

    @FXML
    public void remplirMoniteur(Event event) throws SQLException {
        String libelleCategorie = lvPLCategoriePermis.getSelectionModel().getSelectedItem().toString();
        System.out.println(libelleCategorie);
        Categorie c = categorieController.getCategorieFromLibelle(libelleCategorie);
        ArrayList<String> nomMoniteur = categorieController.getAllMoniteursFromCategorie(c);
        lvPLMoniteur.setItems(FXCollections.observableArrayList(nomMoniteur));
    }


    @FXML
    public void prendreLecon(ActionEvent actionEvent) {
        /*
        *
        * Rappel Lecon=(codeLecon, date, heure, codeMoniteur, codeEleve, immatriculation, reglee, categorie, statut(0,1,2)=>0)
        *
        */

        // on recupère toute les valeurs requise pour créer la leçon
        int codeLecon = 0; // on le prendra pas de tt façon

    }

    public void changeAp(AnchorPane ap){
        clearAll();
        ap.setVisible(true);
    }

    @FXML
    public void enregistrerModificationProfil(ActionEvent actionEvent) throws SQLException {
        // update dans la base de données
        changeAp(apModifierProfile);

        if(!Objects.equals(txtNvCp.getText(), "")){
            eleve.setCodePostalEleve(txtNvCp.getText());
        }
        if(!Objects.equals(txtNvTel.getText(), "")){
            eleve.setTelephoneEleve(txtNvTel.getText());
        }
        if(!Objects.equals(txtNvVille.getText(), "")){
            eleve.setVilleEleve(txtNvVille.getText());
        }

        eleveController.updateEleve(eleve);

        majProfil(eleve);
        changeAp(apProfile);
        txtNvVille.setText("");
        txtNvCp.setText("");
        txtNvTel.setText("");
    }

    @FXML
    public void afficherVueChargerPdp(ActionEvent actionEvent) {
    }

    @FXML
    public void annulerModificationProfil(ActionEvent actionEvent) {
        changeAp(apProfile);
        majProfil(eleve);
        txtNvVille.setText("");
        txtNvCp.setText("");
        txtNvTel.setText("");
    }
}
