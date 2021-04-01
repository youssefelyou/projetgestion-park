package projectgestionpark.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import projectgestionpark.bean.Modele;
import projectgestionpark.bean.TypeCarbu;
import projectgestionpark.bean.Voiture;
import projectgestionpark.dao.VoitureDao;

import java.util.List;

@Service
public class VoitureService {
    public Voiture findByRef(String ref) {
        return voitureDao.findByRef(ref);
    }

    @Transactional
    public int deleteByRef(String ref) {
        int r1 = voitureDao.deleteByRef(ref);
        int r2 = vidangeService.deleteByVoitureRef(ref);
        int r3 = reparationService.deleteByVoitureRef(ref);
        int r4 = consommationService.deleteByVoitureRef(ref);
        return r1 + r2 + r3 + r4;
    }


    public int  save(Voiture voiture ) {

        TypeCarbu typeCarbu=typeCarbuService.findByCode(voiture.getTypeCarburant().getCode());
        Modele modele=modeleService.findByCode(voiture.getModel().getCode());
        voiture.setModel(modele);
        voiture.setTypeCarburant(typeCarbu);
        if(modele==null){
            return -2;

        }
        if(typeCarbu==null){
            return -3;
        }
        if(findByRef(voiture.getRef())!=null) {
            return -1;
        }
        else{
            modeleService.save(modele);
            typeCarbuService.save(typeCarbu);
            voitureDao.save(voiture);
            return 1;
        }
    }


    public Voiture findByMatricule(String matricule) {
        return voitureDao.findByMatricule(matricule);
    }

    public List<Voiture> findAll() {
        return voitureDao.findAll();
    }

    public int deleteByModelCode(Long code) {
        return voitureDao.deleteByModelCode(code);
    }

    public int deleteByTypeCarburantCode(Long code) {
        return voitureDao.deleteByTypeCarburantCode(code);
    }

    @Autowired //injection de dependence
    private VoitureDao voitureDao;
    @Autowired
    private TypeCarbuService typeCarbuService;
    @Autowired
    private ModeleService modeleService;
    @Autowired
    private  VidangeService vidangeService;
    @Autowired
    private ReparationService reparationService;
    @Autowired
    private ConsommationService consommationService;
}
