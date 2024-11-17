package sio.projetautoecole.controllers;

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
}
