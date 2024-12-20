package sio.projetautoecole.services;

import sio.projetautoecole.models.Eleve;
import sio.projetautoecole.models.Moniteur;
import sio.projetautoecole.repositories.EleveRepository;

import java.sql.SQLException;

public class EleveService {

    private EleveRepository eleveRepository;

    public EleveService() {
        eleveRepository = new EleveRepository();
    }
    public Eleve getEleveByNumCompte(int numCompte) throws SQLException {
        return eleveRepository.getEleveByNumCompte(numCompte);
    }

    public void inscription(Eleve eleve) throws SQLException {
        eleveRepository.inscription(eleve);
    }

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> b554254c2c9edbd75db32f5ca492d4148db88d71
    public void updateEleve(Eleve e) throws SQLException{
        eleveRepository.updateEleve(e);
=======
    public void update(Eleve m) throws SQLException {
        eleveRepository.update(m);
>>>>>>> branche-laura
<<<<<<< HEAD
=======
    public void update(Eleve m) throws SQLException {
        eleveRepository.update(m);
>>>>>>> branche-laura
=======
>>>>>>> b554254c2c9edbd75db32f5ca492d4148db88d71
    }
}
