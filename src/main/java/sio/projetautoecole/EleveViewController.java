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
import sio.projetautoecole.models.Lecon;
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

    @FXML
    private AnchorPane apProfile, apPlanning, apReglement, apPermis, apPrendreLecon, apVoirCataloguePermis;

    @FXML
    private TableView tvProchaineLecon;

    @FXML
    private TableColumn tcPermisLecon, tcJourLecon, tcMoniteurLecon, tcHorraireLecon, tcVehiculeLecon;

    @FXML
    private ScrollPane spaneListePermis;

    @FXML
    private Label lblCP, lblVille, lblDate, lblPrenom, lblNom, lblTelephone;

    @FXML
    private ToggleGroup leconFini;

    @FXML
    private ImageView imgPdp, emp1, emp2, emp3, emp4, emp5;

    @FXML
    private ListView lvPLVehicule, lvPLHorraire, lvPLMoniteur, lvPLCategoriePermis;

    @FXML
    private DatePicker dpDateLecon;

    @FXML
    private Button btnSousCrireMoto, btnSousCrireCamion, btnSousCrireAuto, btnSousCrireTransport, btnSousCrirebato;
    @FXML
    private TableColumn tcPlanningCategorie, tcPlanningHorraire, tcPlanningVehicule, tcPlanningDate, tcPlanningEstPassee, tcPlanningMoniteur;
    @FXML
    private TableView tvPlanningLecon;

    CompteController compteController;
    EleveController eleveController;
    ConnexionBDD connexionBDD;
    LeconController leconController;
    CategorieController categorieController;
    MoniteurController moniteurController;
    EleveCategorieController eleveCategorieController;
    int numCompteActif;
    Eleve eleve;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        tcPermisLecon.setCellValueFactory(new PropertyValueFactory<>("codeLecon"));
        tcJourLecon.setCellValueFactory(new PropertyValueFactory<>("date"));
        tcMoniteurLecon.setCellValueFactory(new PropertyValueFactory<>("codeMoniteur"));
        tcVehiculeLecon.setCellValueFactory(new PropertyValueFactory<>("categorie"));
        tcHorraireLecon.setCellValueFactory(new PropertyValueFactory<>("heure"));

        tcPlanningHorraire.setCellValueFactory(new PropertyValueFactory<>("heure"));
        tcPlanningVehicule.setCellValueFactory(new PropertyValueFactory<>("immatriculation"));
        tcPlanningCategorie.setCellValueFactory(new PropertyValueFactory<>("heure"));
        tcPlanningDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        tcPlanningEstPassee.setCellValueFactory(new PropertyValueFactory<>("reglee"));
        tcPlanningMoniteur.setCellValueFactory(new PropertyValueFactory<>("codeMoniteur"));

        try {
            connexionBDD = new ConnexionBDD();
            compteController = new CompteController();
            eleveController = new EleveController();
            leconController = new LeconController();
            categorieController = new CategorieController();
            moniteurController = new MoniteurController();
            eleveCategorieController = new EleveCategorieController();
            numCompteActif = Session.getNumCompteActif();
            eleve = eleveController.getEleveByNumCompte(numCompteActif);
            System.out.println("Eleve : "+eleve.getPrenomEleve()+" "+eleve.getNomEleve()+eleve.getIdEleve());

            // Mettre a jour le pane des permis en cours de l'eleve

            tvProchaineLecon.setItems(FXCollections.observableList(leconController.getAllLeconForEleve(eleve.getIdEleve())));
            lvPLCategoriePermis.setItems(FXCollections.observableList(categorieController.getAllLibelles()));

            // Mettre a jour le tableau des prochaines leçon
            tvPlanningLecon.setItems(FXCollections.observableList(leconController.getAllLeconForEleve(eleve.getIdEleve())));

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        clearAll();
        changeAP(apProfile);
        majProfil();

    }






    // ------------------ Section Lecon : Prendre Lecon ------------------- //

    // Declancher par la selection d'une categorie
    @FXML
    public void afficherMoniteurEtVehicule(Event event) throws SQLException {
        // Récupération de la date et de l'heure sélectionnées
        LocalDate selectedDate = dpDateLecon.getValue();
        String selectedTime = (String) lvPLHorraire.getSelectionModel().getSelectedItem();

        // Récupération de la catégorie sélectionnée
        Object selectedCategorie = lvPLCategoriePermis.getSelectionModel().getSelectedItem();
        if (selectedCategorie == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Avertissement");
            alert.setHeaderText("Veuillez sélectionner une catégorie.");
            alert.showAndWait();
            return;
        }

        String libelleCategorie = selectedCategorie.toString();
        Categorie c = categorieController.getCategorieFromLibelle(libelleCategorie);
        int idCateg = c.getIdCategorie();

        // Vérification que tous les champs sont sélectionnés
        if (selectedDate == null || selectedTime == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Avertissement");
            alert.setHeaderText("Veuillez sélectionner une date, une heure et une catégorie.");
            alert.showAndWait();
            return;
        }

        try {
            // Requête pour les moniteurs disponibles
            List<Moniteur> availableMonitors = moniteurController.getAvailableMoniteurs(
                    selectedDate.toString(), selectedTime, idCateg
            );
            lvPLMoniteur.setItems(FXCollections.observableList(
                    availableMonitors.stream()
                            .map(Moniteur::getNomPrenom) // Transforme les objets Moniteur en leur nom complet
                            .collect(Collectors.toList())
            ));

            // Requête pour les véhicules disponibles
            List<String> availableVehicles = leconController.getAvailableVehicles(
                    selectedDate.toString(), selectedTime, idCateg
            );
            lvPLVehicule.setItems(FXCollections.observableList(availableVehicles));
        } catch (SQLException e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Erreur lors du chargement des données.");
            alert.showAndWait();
        }
    }


    // Remplir la liste view des horraires
    public void remplirHoraire() {
        if (lvPLHorraire == null) {
            System.out.println("ListView lvPLHorraire n'est pas initialisé !");
            return;
        }

        List<String> horaires = new ArrayList<>();
        LocalTime start = LocalTime.of(9, 0, 0);
        LocalTime end = LocalTime.of(17, 0, 0);

        while (!start.isAfter(end)) {
            horaires.add(start.toString());
            start = start.plusHours(1);
        }

        lvPLHorraire.setItems(FXCollections.observableList(horaires));

    }


    //
    @FXML
    public void prendreLecon(ActionEvent actionEvent) throws SQLException {
        // Vérification que toutes les valeurs requises sont sélectionnées
        if (dpDateLecon.getValue() == null) {
            System.out.println("Veuillez sélectionner une date.");
            return;
        }
        if (lvPLHorraire.getSelectionModel().isEmpty()) {
            System.out.println("Veuillez sélectionner un horaire.");
            return;
        }
        if (lvPLMoniteur.getSelectionModel().isEmpty()) {
            System.out.println("Veuillez sélectionner un moniteur.");
            return;
        }
        if (lvPLVehicule.getSelectionModel().isEmpty()) {
            System.out.println("Veuillez sélectionner un véhicule.");
            return;
        }

        // Récupération des données
        String date = dpDateLecon.getValue().toString(); // Conversion en "yyyy-MM-dd"
        String heure = lvPLHorraire.getSelectionModel().getSelectedItem().toString();
        String moniteurNom = lvPLMoniteur.getSelectionModel().getSelectedItem().toString();

        // Extraire le deuxième mot du nom complet
        String[] nomParts = moniteurNom.split(" ");
        if (nomParts.length < 2) {
            System.out.println("Le format du nom du moniteur est incorrect.");
            return;
        }
        String nom = nomParts[1]; // Récupérer le deuxième mot

        // Recherche du moniteur avec le deuxième mot de son nom
        System.out.println("Nom extrait pour recherche : " + nom);
        Moniteur m = moniteurController.getMoniteurByName(nom);
        if (m == null) {
            System.out.println("Aucun moniteur trouvé avec le nom extrait.");
            return;
        }

        int codeMoniteur = m.getIdMoniteur();
        int codeEleve = eleve.getIdEleve();
        String immatriculation = lvPLVehicule.getSelectionModel().getSelectedItem().toString();
        int regle = 0;

        // Création et ajout de la leçon
        Lecon l = new Lecon(0, date, heure, codeMoniteur, codeEleve, immatriculation, regle);
        leconController.add(l);
        System.out.println("Leçon ajoutée avec succès !");
    }

    // ----------------------- Fin Section Lecon / Prendre une lecon --------------------------- //




    // -------------- Section Permis : Stat et Catalogue ------------------ //

    @FXML
    public void inscrireEleveBateau(ActionEvent actionEvent) throws SQLException {
        inscrireEleveCategorie(3);
    }

    @FXML
    public void inscrireEleveCamion(ActionEvent actionEvent) throws SQLException {
        inscrireEleveCategorie(2);
    }

    @FXML
    public void inscrireEleveMoto(ActionEvent actionEvent) throws SQLException {
        inscrireEleveCategorie(4);
    }

    @FXML
    public void inscrireEleveAutomobile(ActionEvent actionEvent) throws SQLException {
        inscrireEleveCategorie(1);
    }

    @FXML
    public void inscrireEleveTransport(ActionEvent actionEvent) throws SQLException {
        inscrireEleveCategorie(5);
    }


    public void inscrireEleveCategorie(int codeCateg) throws SQLException {

        int idEleve = numCompteActif;

        // si la ligne avec l'eleve et la categorie n'est pas présente dans eleve_categorie alors :

        if(!eleveCategorieController.get(idEleve, codeCateg)){
            // Insert dans la table eleve_categorie (codeEleve, codeCategorie)
            eleveCategorieController.add(idEleve, codeCateg);
            // affiche d'une boite de message pour dire
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Succès");
            alert.setHeaderText("Vous avez souscris a ce permis");
            alert.showAndWait();
            // card grisé (a faire)
            switch(codeCateg){
                case 1:
                    btnSousCrireAuto.setDisable(true);
                    break;
                case 2:
                    btnSousCrireCamion.setDisable(true);
                    break;
                case 3:
                    btnSousCrirebato.setDisable(true);
                    break;
                case 4 :
                    btnSousCrireMoto.setDisable(true);
                    break;
                case 5 :
                    btnSousCrireTransport.setDisable(true);
                    break;
            }
        }

        // sinon :
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Un seul permis par type de véhicule est largement suffisant !");
            alert.showAndWait();
        }
    }


    @FXML
    public void changeVoirCatalogue(ActionEvent actionEvent) throws SQLException {
        for(int i = 1; i<categorieController.getAllCategories().toArray().length; i++){
            System.out.println(i);
            System.out.println(numCompteActif);
            if(eleveCategorieController.get(numCompteActif, i)){
                switch(i){
                    case 1:
                        btnSousCrireAuto.setDisable(true);
                        break;
                    case 2:
                        btnSousCrireCamion.setDisable(true);
                        break;
                    case 3:
                        btnSousCrirebato.setDisable(true);
                        break;
                    case 4 :
                        btnSousCrireMoto.setDisable(true);
                        break;
                    case 5 :
                        btnSousCrireTransport.setDisable(true);
                        break;
                }
            }
        }
        changeAP(apVoirCataloguePermis);
    }

    // ------------ Fin Section Permis: Stat et catalogue ----------------------- //



    // ------------------- Fonction utile sans plus --------------------------- //
    @FXML
    public void deconnexionOnClick(ActionEvent actionEvent) throws IOException {
        // appel d'une fonction seDeconnecter
        Session.changerScene("hello-view.fxml", "Acceuil", actionEvent);

    }

    @FXML
    public void changeToProfil(ActionEvent actionEvent) {
        changeAP(apProfile);
        majProfil();
        // chargement
    }

    @FXML
    public void changeToReglement(ActionEvent actionEvent) {
        changeAP(apReglement);
    }

    @FXML
    public void hoverNavItem(Event event) {

    }

    @FXML
    public void retourNavItemToNormal(Event event) {
    }

    @FXML
    public void changeToPlanning(ActionEvent actionEvent) throws SQLException {
        tvPlanningLecon.setItems(FXCollections.observableList(leconController.getAllLeconForEleve(eleve.getIdEleve())));
        changeAP(apPlanning);
    }

    @FXML
    public void changeToPermis(ActionEvent actionEvent) {
        changeAP(apPermis);
    }

    @FXML
    public void changeToLecon(ActionEvent actionEvent) {
        changeAP(apPrendreLecon);
    }


    public void clearAll(){
        apPrendreLecon.setVisible(false);
        apReglement.setVisible(false);
        apPermis.setVisible(false);
        apPlanning.setVisible(false);
        apProfile.setVisible(false);
        apPrendreLecon.setVisible(false);
        apVoirCataloguePermis.setVisible(false);
    }

    private void changeAP(AnchorPane ap) {
        clearAll();
        ap.setVisible(true);
    }

    @FXML
    public void changeModifierProfil(ActionEvent actionEvent) {

    }

    @FXML
    public void changePrendreLecon(ActionEvent actionEvent) {
        changeAP(apPrendreLecon);

        // vider les liste view sauf catégorie

        lvPLHorraire.getItems().clear();
        lvPLMoniteur.getItems().clear();
        lvPLVehicule.getItems().clear();

        dpDateLecon.setValue(LocalDate.now());
        remplirHoraire();

        int pLecon_codeEleve = 0;
        int pLecon_codeMoniteur = 0;
        int pLecon_codeLecon = 0;
        String pLecon_date = null;
        int pLecon_Reglee = 0;
        String pLecon_immatriculation = null;
        String pLecon_heure = null;
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

