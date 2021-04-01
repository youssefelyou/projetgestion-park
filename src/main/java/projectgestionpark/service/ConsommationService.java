package projectgestionpark.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projectgestionpark.bean.ConsommationCarburant;
import projectgestionpark.bean.Voiture;
import projectgestionpark.dao.ConsommationCarburantDao;
import projectgestionpark.service.util.StringUtil;
import vo.ConsommationVo;
import vo.ReparationVo;

@Service
public class ConsommationService {

    public List<ConsommationVo> findbycriteria(ConsommationVo consommationVo) {
        String query = "select c from ConsommationCarburant c where 1=1";
        if (StringUtil.isnotEmpty(consommationVo.getRef()))
            query += "AND c.ref ='" + consommationVo.getRef() + "'";

        if (StringUtil.isnotEmpty(consommationVo.getPrixMin()))
            query += " AND v.monatnt >= '" + consommationVo.getPrixMin() + "'";

        if (StringUtil.isnotEmpty(consommationVo.getPrixMax()))
            query += " AND v.monatnt <= '" + consommationVo.getPrixMax() + "'";

        return entitymanager.createQuery(query).getResultList();
    }

    public ConsommationCarburant findByRef(String ref) {
        return consommationCarburantDao.findByRef(ref);
    }

    public List<ConsommationCarburant> findAll() {
        return consommationCarburantDao.findAll();
    }

    @Transactional
    public int deleteByRef(String ref) {
        return consommationCarburantDao.deleteByRef(ref);

    }

    public int save(ConsommationCarburant consommationCarburant) {
        Voiture voiture = voitureService.findByRef(consommationCarburant.getVoiture().getRef());
        consommationCarburant.setVoiture(voiture);
        if (voiture == null) {
            return -2;
        }
        if (findByRef(consommationCarburant.getRef()) != null) {
            return -1;
        } else {
            voitureService.save(voiture);
            consommationCarburantDao.save(consommationCarburant);
            return 0;
        }
    }

    public int deleteByVoitureRef(String ref) {
        return consommationCarburantDao.deleteByVoitureRef(ref);
    }

    @Autowired
    private ConsommationCarburantDao consommationCarburantDao;
    @Autowired
    private EntityManager entitymanager;
    @Autowired
    private VoitureService voitureService;
}