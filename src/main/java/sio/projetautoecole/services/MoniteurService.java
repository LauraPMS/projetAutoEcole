package sio.projetautoecole.services;

import sio.projetautoecole.models.Moniteur;
import sio.projetautoecole.repositories.MoniteurRepository;

import java.sql.SQLException;

public class MoniteurService {

    MoniteurRepository repo ;
    public MoniteurService() {
        repo = new MoniteurRepository();
    }

    public Moniteur getMoniteurByNumCompte(int numCompte) throws SQLException{
        return repo.getMoniteurByNumCompte(numCompte);
    }

    public void updateMoniteur(Moniteur m) throws SQLException{
        repo.updateMoniteur(m);
    }

}
