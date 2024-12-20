package sio.projetautoecole;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import sio.projetautoecole.Session;
import sio.projetautoecole.controllers.*;
import sio.projetautoecole.models.Categorie;
import sio.projetautoecole.models.Eleve;
import sio.projetautoecole.models.Lecon;
import sio.projetautoecole.models.Moniteur;
import sio.projetautoecole.tools.ConnexionBDD;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;
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
    EleveCategorieController eleveCategorieController;
    ConnexionBDD connexionBDD;
    LeconController leconController;
    CategorieController categorieController;
    MoniteurController moniteurController;
    EleveCategorieController eleveCategorieController;
    int numCompteActif;
    Eleve eleve;
    @FXML
    private TextField txtNvVille;
    @FXML
    private AnchorPane apModifierProfile;
    @FXML
    private PasswordField txtNvMdp;
    @FXML
    private TextField txtNvMail;
    @FXML
    private TextField txtNvCp;
    @FXML
    private TextField txtNvTel;

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> b554254c2c9edbd75db32f5ca492d4148db88d71
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
    @FXML
    private ListView lvPermisEleve;
    @FXML
    private Label lblNbHPassee;
    @FXML
    private Label lblNbVehicules;
    @FXML
    private Label lblMoniteurFav;
    @FXML
    private Label lblNomsVehicules;
=======
>>>>>>> branche-laura
<<<<<<< HEAD
=======
>>>>>>> branche-laura
=======
>>>>>>> b554254c2c9edbd75db32f5ca492d4148db88d71

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        // prochaine leçon on profil
        tcPermisLecon.setCellValueFactory(new PropertyValueFactory<>("categorie"));
        tcJourLecon.setCellValueFactory(new PropertyValueFactory<>("date"));
        tcMoniteurLecon.setCellValueFactory(new PropertyValueFactory<>("codeMoniteur"));
        tcVehiculeLecon.setCellValueFactory(new PropertyValueFactory<>("immatriculation"));
        tcHorraireLecon.setCellValueFactory(new PropertyValueFactory<>("heure"));

        // planning
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
            eleveCategorieController = new EleveCategorieController();
            leconController = new LeconController();
            categorieController = new CategorieController();
            moniteurController = new MoniteurController();
            eleveCategorieController = new EleveCategorieController();
            numCompteActif = Session.getNumCompteActif();
            eleve = eleveController.getEleveByNumCompte(numCompteActif);
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> b554254c2c9edbd75db32f5ca492d4148db88d71
            System.out.println("Eleve : "+eleve.getPrenomEleve()+" "+eleve.getNomEleve()+""+eleve.getIdEleve());
            System.out.println(eleveCategorieController.getEleveCategorie(eleve));

=======
            System.out.println("Eleve : " + eleve.getPrenomEleve() + " " + eleve.getNomEleve() + eleve.getIdEleve());
>>>>>>> branche-laura
<<<<<<< HEAD
=======
            System.out.println("Eleve : " + eleve.getPrenomEleve() + " " + eleve.getNomEleve() + eleve.getIdEleve());
>>>>>>> branche-laura
=======
>>>>>>> b554254c2c9edbd75db32f5ca492d4148db88d71

            // Mettre a jour le pane des permis en cours de l'eleve

            tvProchaineLecon.setItems(FXCollections.observableList(leconController.getAllLeconForEleve(eleve.getIdEleve())));
            lvPLCategoriePermis.setItems(FXCollections.observableList(categorieController.getAllLibelles()));
            lvPermisEleve.setItems(FXCollections.observableList(eleveCategorieController.getEleveCategorie(eleve)));


            // Mettre a jour le tableau des prochaines leçon
            tvPlanningLecon.setItems(FXCollections.observableList(leconController.getAllLeconForEleve(eleve.getIdEleve())));

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        clearAll();
        changeAP(apProfile);
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
        majProfil(eleve);
=======
=======
>>>>>>> branche-laura
=======
        majProfil(eleve);
=======
>>>>>>> b554254c2c9edbd75db32f5ca492d4148db88d71
        try {
            majProfil();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> branche-laura
=======
=======
>>>>>>> b554254c2c9edbd75db32f5ca492d4148db88d71
>>>>>>> branche-laura

    }




    // ------------------ Section Lecon : Prendre Lecon ------------------- //

    @FXML
    public void prendreLecon(ActionEvent actionEvent) throws SQLException {
        // verif
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

        String date = dpDateLecon.getValue().toString();
        String heure = lvPLHorraire.getSelectionModel().getSelectedItem().toString();
        String moniteurNom = lvPLMoniteur.getSelectionModel().getSelectedItem().toString();

        // travaille a fire car on affiche le nom ET prenom dans la liste view des moniteurs
        String[] nomParts = moniteurNom.split(" ");
        if (nomParts.length < 2) {
            System.out.println("Le format du nom du moniteur est incorrect.");
            return;
        }

        String nom = nomParts[1];
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

        // Création et ajout de la lecons
        Lecon l = new Lecon(0, date, heure, codeMoniteur, codeEleve, immatriculation, regle);
        leconController.add(l);
        System.out.println("Leçon ajoutée avec succès !");

        // Vider les champs

    }


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
                            .map(Moniteur::getNomPrenom)
                            .collect(Collectors.toList())
            ));


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


    // remlploi la liste view des horraires
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

        if (!eleveCategorieController.get(idEleve, codeCateg)) {
            // Insert dans la table eleve_categorie (codeEleve, codeCategorie)
            eleveCategorieController.add(idEleve, codeCateg);
            // affiche d'une boite de message pour dire
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Succès");
            alert.setHeaderText("Vous avez souscris a ce permis");
            alert.showAndWait();
            // card grisé (a faire)
            switch (codeCateg) {
                case 1:
                    btnSousCrireAuto.setDisable(true);
                    break;
                case 2:
                    btnSousCrireCamion.setDisable(true);
                    break;
                case 3:
                    btnSousCrirebato.setDisable(true);
                    break;
                case 4:
                    btnSousCrireMoto.setDisable(true);
                    break;
                case 5:
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
        for (int i = 1; i < categorieController.getAllCategories().toArray().length; i++) {
            System.out.println(i);
            System.out.println(numCompteActif);
            if (eleveCategorieController.get(numCompteActif, i)) {
                switch (i) {
                    case 1:
                        btnSousCrireAuto.setDisable(true);
                        break;
                    case 2:
                        btnSousCrireCamion.setDisable(true);
                        break;
                    case 3:
                        btnSousCrirebato.setDisable(true);
                        break;
                    case 4:
                        btnSousCrireMoto.setDisable(true);
                        break;
                    case 5:
                        btnSousCrireTransport.setDisable(true);
                        break;
                }
            }
        }
        changeAP(apVoirCataloguePermis);
    }

    // ------------ Fin Section Permis: Stat et catalogue ----------------------- //





    // SECTION  PAGE PERMIS //

    public void majProfil() throws SQLException {
        // affiche les données de l'eleve
        lblPrenom.setText(eleve.getPrenomEleve());
        lblNom.setText(eleve.getNomEleve());
        lblTelephone.setText(eleve.getTelephoneEleve());
        lblCP.setText(eleve.getCodePostalEleve());
        lblVille.setText(eleve.getVilleEleve());
        lblDate.setText(eleve.getDateNaisseEleve().toString());
        if (eleve.getSexeEleve() == 1) {
            changeImageViewImg(imgPdp, "femme.png");
        } else if (eleve.getSexeEleve() == 2) {
            changeImageViewImg(imgPdp, "homme.png");
        }

        // affiche les permis

        viderEmplacements();

        for (int i = 1; i <= 5; i++) {
            if (eleveCategorieController.get(numCompteActif, i)) {
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
        List<ImageView> imgEmp = Arrays.asList(emp1, emp2, emp3, emp4, emp5);
        for (ImageView image : imgEmp) {
            if (image.getImage() == null) {
                changeImageViewImg(image, source);
                return;
            }
        }
    }

    public void viderEmplacements() {
        List<ImageView> imgEmp = Arrays.asList(emp1, emp2, emp3, emp4, emp5);
        for (ImageView image : imgEmp) {
            image.setImage(null);
        }
    }


    @javafx.fxml.FXML
    public void annulerModificationProfil(ActionEvent actionEvent) throws SQLException {
        changeAP(apProfile);
        majProfil();
        txtNvVille.setText("");
        txtNvCp.setText("");
        txtNvTel.setText("");
    }




    // il manque le changement de mot de passe
    @javafx.fxml.FXML
    public void enregistrerModificationProfil(ActionEvent actionEvent) throws SQLException {
        // update dans la base de données
        changeAP(apModifierProfile);

        if(!Objects.equals(txtNvCp.getText(), "")){
            eleve.setCodePostalEleve(txtNvCp.getText());
        }
        if(!Objects.equals(txtNvTel.getText(), "")){
            eleve.setTelephoneEleve(txtNvTel.getText());
        }
        if(!Objects.equals(txtNvVille.getText(), "")){
            eleve.setVilleEleve(txtNvVille.getText());
        }


        eleveController.update(eleve);

        majProfil();
        changeAP(apProfile);
        txtNvVille.setText("");
        txtNvCp.setText("");
        txtNvTel.setText("");

    }

    // FIN SECTION PAGE PROFIL



    // ------------------- Fonction utile sans plus --------------------------- //
    @FXML
    public void deconnexionOnClick(ActionEvent actionEvent) throws IOException {
        // appel d'une fonction seDeconnecter
        Session.changerScene("hello-view.fxml", "Acceuil", actionEvent);

    }

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> b554254c2c9edbd75db32f5ca492d4148db88d71
    @javafx.fxml.FXML
    public void changeToProfil(ActionEvent actionEvent) {
        changeAP(apProfile);
        majProfil(eleve);
        // chargement
    }
=======
    @FXML
    public void changeToProfil(ActionEvent actionEvent) throws SQLException {changeAP(apProfile);majProfil();}
>>>>>>> branche-laura
<<<<<<< HEAD
=======
    @FXML
    public void changeToProfil(ActionEvent actionEvent) throws SQLException {changeAP(apProfile);majProfil();}
>>>>>>> branche-laura
=======
>>>>>>> b554254c2c9edbd75db32f5ca492d4148db88d71

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
    public void changeToPlanning(ActionEvent actionEvent) throws SQLException {tvPlanningLecon.setItems(FXCollections.observableList(leconController.getAllLeconForEleve(eleve.getIdEleve())));changeAP(apPlanning);}

    @FXML
    public void changeToPermis(ActionEvent actionEvent) {
        changeAP(apPermis);
    }

    @FXML
    public void changeToLecon(ActionEvent actionEvent) {
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> b554254c2c9edbd75db32f5ca492d4148db88d71
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
=======
>>>>>>> branche-laura
<<<<<<< HEAD
=======
>>>>>>> branche-laura
=======
>>>>>>> b554254c2c9edbd75db32f5ca492d4148db88d71
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


<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> b554254c2c9edbd75db32f5ca492d4148db88d71


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
=======
<<<<<<< HEAD
=======
>>>>>>> branche-laura
=======
>>>>>>> b554254c2c9edbd75db32f5ca492d4148db88d71
    public void clearAll() {
        apPrendreLecon.setVisible(false);
        apReglement.setVisible(false);
        apPermis.setVisible(false);
        apPlanning.setVisible(false);
        apProfile.setVisible(false);
        apPrendreLecon.setVisible(false);
        apVoirCataloguePermis.setVisible(false);
        apModifierProfile.setVisible(false);
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> branche-laura
=======
=======
>>>>>>> b554254c2c9edbd75db32f5ca492d4148db88d71
>>>>>>> branche-laura
    }

    private void changeAP(AnchorPane ap) {
        clearAll();
        ap.setVisible(true);
    }

    @FXML
    public void changeModifierProfil(ActionEvent actionEvent) {
        changeAP(apModifierProfile);

    }

    @FXML
    public void changePrendreLecon(ActionEvent actionEvent) {
        changeToLecon(actionEvent);
    }

    private void changeImageViewImg(ImageView imgEmp, String image) {
        imgEmp.setImage(
                new Image(
                        Objects.requireNonNull(getClass().getResource(
                                "/img/" + image
                        )).toExternalForm()
                )
        );
    }

<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> b554254c2c9edbd75db32f5ca492d4148db88d71

    @FXML
    public void afficherVueChargerPdp(ActionEvent actionEvent) {
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

    @FXML
    public void onLvPermisEleveClicked(Event event) throws SQLException {

        String libelleCategorie = lvPermisEleve.getSelectionModel().getSelectedItem().toString();
        Categorie categorie = categorieController.getCategorieFromLibelle(libelleCategorie);
        int codeCategorie = categorie.getIdCategorie();

        ArrayList<String> heuresPermisEleve = eleveCategorieController.getTotalHeureByPermisEleve(eleve, codeCategorie);

        //Total horraire par permis
        int totalHeure = 0;
        for(String heures : heuresPermisEleve)
        {
            totalHeure += 1;
        }

        lblNbHPassee.setText(totalHeure + " heures");

        ArrayList<String> nomVehicules = eleveCategorieController.getVehiculePermisEleve(eleve, codeCategorie);
        int cpt = 0;
        String nomsVehiculesPermis = "";
        for(String vehicules : nomVehicules)
        {
            nomsVehiculesPermis += vehicules + " ";
            cpt += 1;
        }
        lblNomsVehicules.setText(nomsVehiculesPermis);
        lblNbVehicules.setText(""+cpt);

=======

    @FXML
    public void afficherVueChargerPdp(ActionEvent actionEvent) {
>>>>>>> branche-laura
    }
}
