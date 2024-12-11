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
        apPrendreLecon.setVisible(false);
    }

    private void changeAP(AnchorPane ap) {
        clearAll();
        ap.setVisible(true);
    }

    @javafx.fxml.FXML
    public void changeModifierProfil(ActionEvent actionEvent) {

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

    public void afficherHorraire(ActionEvent actionEvent) throws SQLException {
        // Récupérer la date sélectionnée dans le DatePicker
        LocalDate selectedDate = dpDateLecon.getValue();
        if (selectedDate == null) {
            System.out.println("Veuillez sélectionner une date.");
            return;
        }

        // Récupérer le moniteur sélectionné dans la ListView
        String selectedMoniteur = (String) lvPLMoniteur.getSelectionModel().getSelectedItem();
        if (selectedMoniteur == null || selectedMoniteur.isEmpty()) {
            System.out.println("Veuillez sélectionner un moniteur.");
            return;
        }

        // Obtenir l'objet Moniteur correspondant
        Moniteur moniteur = moniteurController.getMoniteurByName(selectedMoniteur);
        if (moniteur == null) {
            System.out.println("Moniteur introuvable.");
            return;
        }

        // Générer les horaires de base (9h00 à 17h00, toutes les heures)
        List<LocalTime> horairesBase = new ArrayList<>();
        for (int heure = 9; heure <= 17; heure++) {
            horairesBase.add(LocalTime.of(heure, 0));  // Ajoute chaque heure pleine
        }

        // Récupérer les horaires réservés pour le moniteur à cette date
        List<LocalTime> horairesReserves = leconController.getHorairesReserves(moniteur, selectedDate);

        // Filtrer les horaires disponibles (horaires de base moins ceux réservés)
        List<LocalTime> horairesDisponibles = horairesBase.stream()
                .filter(horaire -> !horairesReserves.contains(horaire))  // Exclure les horaires déjà réservés
                .collect(Collectors.toList());

        // Afficher les horaires disponibles dans la ListView
        lvPLHorraire.setItems(FXCollections.observableArrayList(
                horairesDisponibles.stream().map(LocalTime::toString).collect(Collectors.toList())
        ));
    }


}
