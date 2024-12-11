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

    public void updateEleve(Eleve e) throws SQLException{
        eleveRepository.updateEleve(e);
    }
}
