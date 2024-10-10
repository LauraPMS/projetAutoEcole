package sio.projetautoecole;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    // AnchorPane
    @FXML
    private AnchorPane ApFondAccueil;
    @FXML
    private AnchorPane ApFormInscription;
    @FXML
    private AnchorPane ApAccueilEleve;
    @FXML
    private AnchorPane ApVuePlanning;
    @FXML
    private AnchorPane ApProfilPermis;
    @FXML
    private AnchorPane ApPrendreLecon;
    @FXML
    private AnchorPane ApGrillePlanning;
    @FXML
    private AnchorPane ApModifierProfile;

    // element du bandeau quand onn arrive sur le page d'acceuil

    @FXML
    private ImageView imgLogo;
    @FXML
    private Button btnConnexion;
    @FXML
    private Button btnInscription;

    // element du formulaire connexion
    @FXML
    private AnchorPane ApFormConnexion;
    @FXML
    private Button connexion;
    @FXML
    private TextField txtMdpConn;
    @FXML
    private RadioButton rdoEleveConn;
    @FXML
    private TextField txtLoginConn;
    @FXML
    private RadioButton rdoMoniteurConn;
    @FXML
    private RadioButton rdoResponsableConn;


    // element du formulaire inscription


    @FXML
    private Button inscription;
    @FXML
    private TextField txtLoginInsc;
    @FXML
    private RadioButton rdoResponsableInsc;
    @FXML
    private DatePicker dateNaissance;
    @FXML
    private RadioButton rdoHomme;
    @FXML
    private TextField txtMdpInsc;
    @FXML
    private RadioButton rdoFemmeInsc;
    @FXML
    private RadioButton rdoMoniteurInsc;
    @FXML
    private RadioButton rdoEleveInsc;

    @FXML
    private Label lblNom1;
    @FXML
    private ImageView imgFemme;
    @FXML
    private Label lblNom;

    @FXML
    private Rectangle EmplPermis1;
    @FXML
    private Label lblPrenom;

    @FXML
    private Rectangle VuePermisMoto;
    @FXML
    private Rectangle VuePermisCamiion;
    @FXML
    private CheckBox chkPermisVoiture;
    @FXML
    private Rectangle VuePermisBateau;
    @FXML
    private ComboBox cboMoniteurLecon;
    @FXML
    private GridPane gridPlanning;
    @FXML
    private ComboBox cboCategorieLecon;
    @FXML
    private DatePicker dateLecon;
    @FXML
    private Spinner spinSemaine;
    @FXML
    private ComboBox cboHeureLecon;
    @FXML
    private CheckBox chkPermisMoto;
    @FXML
    private Rectangle VuePermisTransport;
    @FXML
    private CheckBox chkPermisTransport;
    @FXML
    private Spinner spinCreneau;
    @FXML
    private Rectangle VuePermisVoiture;
    @FXML
    private CheckBox chkPermisBateau;
    @FXML
    private Rectangle EmplPermis4;
    @FXML
    private Rectangle EmplPermis5;
    @FXML
    private Rectangle EmplPermis2;
    @FXML
    private Rectangle EmplPermis3;
    @FXML
    private CheckBox chkPermixCamion;


    // couleur principale : #a32727


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        clearAll();
        changeAP(ApFondAccueil);
        btnConnexion.setStyle("-fx-background-color: #FFFFFF; -fx-text-fill: #000000;");
        visible(ApGrillePlanning);
        visible(ApProfilPermis);
        visible(ApVuePlanning);
    }

    // fonction controlleur graphique


    @FXML
    public void changeToConnexion(ActionEvent actionEvent) {
        // modification de la vue
        invisible(ApFormInscription);
        visible(ApFormConnexion);
        //modification du bouton de la page active
        btnInscription.setStyle("-fx-background-color: #FFFFFF; -fx-text-fill: #000000;");
        btnConnexion.setStyle("-fx-background-color: #a32727; -fx-text-fill: #FFFFFF;");
    }

    @FXML
    public void changeToInscription(ActionEvent actionEvent) {
        // modification de la vue
        invisible( ApFormConnexion);
        visible(ApFormInscription);
        //modification du bouton de la page active
        btnConnexion.setStyle("-fx-background-color: #FFFFFF; -fx-text-fill: #000000;");
        btnInscription.setStyle("-fx-background-color: #a32727; -fx-text-fill: #FFFFFF;");
    }

    @FXML
    public void inscription(ActionEvent actionEvent) {
        if(toutRempli(ApFormInscription)){

        }


    }
    @FXML
    public void modifierProfil(ActionEvent actionEvent) {
        invisible(ApProfilPermis);
        visible(ApModifierProfile);
    }

    @FXML
    public void reserverLecon(ActionEvent actionEvent) {
    }

    @FXML
    public void prendreLeçon(ActionEvent actionEvent) {
        invisible(ApVuePlanning);
        visible(ApPrendreLecon);
    }

    @FXML
    public void souscrire(ActionEvent actionEvent) {
    }

    @FXML
    public void connexion(ActionEvent actionEvent) {
        changeAP(ApAccueilEleve);
        visible(ApFondAccueil);
    }


    // fonction pratique

    // Vérifie les entrées du formulaire :
    public boolean toutRempli(AnchorPane ap){
        // si l'un de ces if donne une alerte on retourne false
        if(ap == ApFormConnexion)
        {
            // login , mdp, statut
        }
        else
        {
            // login, mdp, statut
        }
        // si on a générer aucun alert dans ces if c'est que tout est ok !
        return true;
    }


    // Genere un nombre aleatoire entre 0 et 100. ------------------------------------------------------------------- //
    public int alea() { return (int)(Math.random() * 101 ); } // 0 to 100

    // Prend un entier qui ira remplir le label. -------------------------------------------------------------------- //
    public void writeRapideInt(Label lblTexte, int intTexte)
    {
        lblTexte.setText(Integer.toString(intTexte));
        return;
    }

    // Prend une image qui ira remplacer l'image view --------------------------------------------------------------- //
    public void changeImageViewImg(ImageView imgView, String linkImage){
        imgView.setImage(
                new Image(
                        getClass().getResource(
                                "/img/"+linkImage
                        ).toExternalForm()
                )
        );
    }

    // Rend visible/invisible une AnchorPane ------------------------------------------------------------------------ //
    public void invisible(AnchorPane apCourante){apCourante.setVisible(false);return;}
    public void invisible(ImageView img){img.setVisible(false);return;}
    public void visible(AnchorPane apCourante){apCourante.setVisible(true);return;}
    public void visible(ImageView img){img.setVisible(true);return;}

    // Cache toutes les AnchorPanes --------------------------------------------------------------------------------- //
    public void clearAll()
    {
        invisible(ApFondAccueil);
        invisible(ApFormConnexion);
        invisible(ApFormInscription);
        invisible(ApAccueilEleve);
        invisible(ApPrendreLecon);
    }

    // Donne un entier compris entre a et b ------------------------------------------------------------------------- //
    public int intervalleInt(int a, int b)
    {
        Random random = new Random();
        return random.nextInt((b - a) + 1) + a;
    }

    // Change d'AnchorPane ------------------------------------------------------------------------------------------ //
    public void changeAP (AnchorPane choice){
        clearAll();
        visible(choice);
    }


}