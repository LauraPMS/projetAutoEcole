package sio.projetautoecole.controllers;

import sio.projetautoecole.models.Eleve;
import sio.projetautoecole.models.Moniteur;
import sio.projetautoecole.services.EleveService;

import java.sql.SQLException;

public class EleveController {

    private EleveService eleveService;

    public EleveController() {
        eleveService = new EleveService();
    }

    public Eleve getEleveByNumCompte(int numCompte) throws SQLException {
        return eleveService.getEleveByNumCompte(numCompte);
    }

    public void inscription(Eleve eleve) throws SQLException {
        eleveService.inscription(eleve);
    }
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> b554254c2c9edbd75db32f5ca492d4148db88d71

    public void updateEleve(Eleve e) throws SQLException{
        eleveService.updateEleve(e);
=======
    public void update(Eleve m) throws SQLException {
        eleveService.update(m);
>>>>>>> branche-laura
<<<<<<< HEAD
=======
    public void update(Eleve m) throws SQLException {
        eleveService.update(m);
>>>>>>> branche-laura
=======
>>>>>>> b554254c2c9edbd75db32f5ca492d4148db88d71
    }
}
