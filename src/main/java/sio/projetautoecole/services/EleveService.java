package sio.projetautoecole.services;

import sio.projetautoecole.models.Eleve;
import sio.projetautoecole.repositories.EleveRepository;

import java.sql.SQLException;

public class EleveService {

    private EleveRepository eleveRepository;

    public EleveService() {
        eleveRepository = new EleveRepository();
    }
    public Eleve getEleveById(int id) throws SQLException{
        return eleveRepository.getEleveById(id);
    }
}
