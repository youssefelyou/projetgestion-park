package projectgestionpark.service;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projectgestionpark.bean.Modele;
import projectgestionpark.dao.ModeleDao;

@Service

public class ModeleService {
    public Modele findByCode(Long code) {
        return modeleDao.findByCode(code);
    }

    @Transactional
    public int deleteByCode(Long code) {
        return modeleDao.deleteByCode(code);
    }

    public List<Modele> findAll() {
        return modeleDao.findAll();
    }

    public int save(Modele modele) {
        if(findByCode(modele.getCode())!=null){
            return -1;
        }else{
            modeleDao.save(modele);
            return 1;
        }
    }

    @Autowired
    private ModeleDao modeleDao;

    /*public List<Modele> findByCodeLikeAndMarqueGreaterThan(long code, String marque) {
        return findByCodeLikeAndMarqueGreaterThan(code,marque);
    }*/

     /*public Modele getOne(Long aLong) {
        return modeleDao.getOne(aLong);
    }*/
}
