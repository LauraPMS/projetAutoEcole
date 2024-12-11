package sio.projetautoecole;

import javafx.event.ActionEvent;
import javafx.event.Event;
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
import sio.projetautoecole.controllers.MoniteurController;
import sio.projetautoecole.models.Compte;
import sio.projetautoecole.models.Moniteur;
import sio.projetautoecole.tools.ConnexionBDD;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Objects;
import java.util.ResourceBundle;

public class MoniteurViewController implements Initializable {



    // Liste déroulante des différentes licences obtenue par le moniteur



    // Liste des prochaine leçon (pour le lendemain)

    @javafx.fxml.FXML
    private TableView tvProchaineLecon;
    @javafx.fxml.FXML
    private TableColumn tcHorraireLecon, tcPermisLecon, tcJourLecon, tcMoniteurLecon;


    // controller utile : Compte, Moniteur
    CompteController compteController;
    MoniteurController moniteurController;
    ConnexionBDD connexionBDD;

    // Moniteur connecté
    Moniteur moniteur;

    int numCompteActif;
    @javafx.fxml.FXML
    private ImageView emp5;
    @javafx.fxml.FXML
    private ImageView emp4;
    @javafx.fxml.FXML
    private ImageView emp3;
    @javafx.fxml.FXML
    private ImageView emp2;
    @javafx.fxml.FXML
    private ImageView emp1;
    @javafx.fxml.FXML
    private PasswordField txtNewMdp;
    @javafx.fxml.FXML
    private TextField txtNewPrenom;
    @javafx.fxml.FXML
    private TableColumn tcVehiculeLecon;
    @javafx.fxml.FXML
    private AnchorPane apInfoProfil;
    @javafx.fxml.FXML
    private AnchorPane apModifProfil;
    @javafx.fxml.FXML
    private TextField txtNewVille;
    @javafx.fxml.FXML
    private ImageView imgPdpModif;
    @javafx.fxml.FXML
    private TextField txtNewNom;
    @javafx.fxml.FXML
    private AnchorPane apContenuProfil;
    @javafx.fxml.FXML
    private DatePicker dpNewDate;
    @javafx.fxml.FXML
    private TextField txtNewTel;
    @javafx.fxml.FXML
    private TextField txtNewSexe;
    @javafx.fxml.FXML
    private ScrollPane spaneListePermis;
    @javafx.fxml.FXML
    private TextField txtNewCp;
    @javafx.fxml.FXML
    private AnchorPane apProfil;
    @javafx.fxml.FXML
    private Label lblCP;
    @javafx.fxml.FXML
    private Label lblNom;
    @javafx.fxml.FXML
    private ImageView imgPdp;
    @javafx.fxml.FXML
    private Label lblVille;
    @javafx.fxml.FXML
    private Label lblDate;
    @javafx.fxml.FXML
    private Label lblPrenom;
    @javafx.fxml.FXML
    private Label lblTelephone;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try {
            connexionBDD = new ConnexionBDD();
            compteController = new CompteController();
            moniteurController = new MoniteurController();
            numCompteActif = Session.getNumCompteActif();
            moniteur = moniteurController.getMoniteurByNumCompte(numCompteActif);
            System.out.println("Moniteur récupéré : " + moniteur.getPrenomMoniteur()+" "+moniteur.getNomMoniteur());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        clearAll();
        changeAp(apProfil);
        majProfil();
    }



    // ----------------------------  Fonction controleurs Graphiques    ------------------------------------ //

    @javafx.fxml.FXML
    public void deconnexionOnClick(ActionEvent actionEvent) throws IOException {
        // Retour a la page accueil
        Session.changerScene("hello-view.fxml", "Accueil", actionEvent);
    }

    @javafx.fxml.FXML
    public void changeToProfil(ActionEvent actionEvent) {
        changeAp(apProfil);
        majProfil();
    }

    @javafx.fxml.FXML
    public void changeModifierProfil(ActionEvent actionEvent) {
        apInfoProfil.setVisible(false);
        apContenuProfil.setVisible(false);
        apModifProfil.setVisible(true);

        txtNewPrenom.setText(moniteur.getPrenomMoniteur());
        txtNewNom.setText(moniteur.getNomMoniteur());
        txtNewTel.setText(moniteur.getTelephoneMoniteur());
        txtNewCp.setText(moniteur.getCodePostal());
        txtNewVille.setText(moniteur.getVilleMoniteur());

        if (moniteur.getSexeMoniteur()==1){
            changeImageViewImg(imgPdpModif, "femme.png" );
            txtNewSexe.setText("Femme");
        }
        else if (moniteur.getSexeMoniteur()==2){
            changeImageViewImg(imgPdpModif, "homme.png" );
            txtNewSexe.setText("Homme");
        }

    }
    @javafx.fxml.FXML
    public void annulerModificationProfil(ActionEvent actionEvent) {
        majProfil();
        apInfoProfil.setVisible(true);
        apContenuProfil.setVisible(true);
        apModifProfil.setVisible(false);
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

    public void majProfil(){
        lblPrenom.setText(moniteur.getPrenomMoniteur());
        lblNom.setText(moniteur.getNomMoniteur());
        lblVille.setText(moniteur.getVilleMoniteur());
        lblDate.setText(moniteur.getDateMoniteur().toString());
        lblTelephone.setText(moniteur.getTelephoneMoniteur());
        lblCP.setText(moniteur.getCodePostal());
        if (moniteur.getSexeMoniteur()==1){
            changeImageViewImg(imgPdp, "femme.png" );
        }
        else if (moniteur.getSexeMoniteur()==2){
            changeImageViewImg(imgPdp, "homme.png" );
        }
    }


    // Focntion utile

    public void clearAll(){
        apModifProfil.setVisible(false);
        apProfil.setVisible(false);
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


    @javafx.fxml.FXML
    public void modifierProfil(ActionEvent actionEvent) throws SQLException {
        moniteurController.modifier(moniteur, txtNewCp.getText(), txtNewVille.getText(), txtNewTel.getText());

        majProfil();
        apInfoProfil.setVisible(true);
        apContenuProfil.setVisible(true);
        apModifProfil.setVisible(false);
    }

    @javafx.fxml.FXML
    public void changePrendreLecon(ActionEvent actionEvent) {
    }
}
