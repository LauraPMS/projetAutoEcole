package sio.projetautoecole.controllers;

import sio.projetautoecole.models.Eleve;
import sio.projetautoecole.models.Moniteur;
import sio.projetautoecole.services.MoniteurService;

import java.sql.SQLException;

public class MoniteurController {

    private MoniteurService moniteurService;

    public MoniteurController() {
        moniteurService = new MoniteurService();
    }

    public Moniteur getMoniteurByNumCompte(int numCompte) throws SQLException {
        return moniteurService.getMoniteurByNumCompte(numCompte);
    }

    public void updateMoniteur(Moniteur m) throws SQLException{
        moniteurService.updateMoniteur(m);
    }

    public void inscription(Moniteur m) throws SQLException{
        moniteurService.inscription(m);
    }

    public Moniteur getMoniteurByName(String selectedMoniteur) throws SQLException {
        return moniteurService.getMoniteurByName(selectedMoniteur);
    }

    public void modifier(Moniteur moniteur, String newCP, String newVille, String newTel) throws SQLException {
        moniteurService.modifier(moniteur, newCP, newVille, newTel);
    }
}
