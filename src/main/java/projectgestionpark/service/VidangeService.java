package projectgestionpark.service;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import projectgestionpark.bean.Categorie;
import projectgestionpark.bean.Typevidange;
import projectgestionpark.bean.Vidange;
import projectgestionpark.bean.Voiture;
import projectgestionpark.dao.VidangeDao;
import projectgestionpark.service.util.StringUtil;
import vo.VidangeVo;

@Service
public class VidangeService {
	
	public List<VidangeVo> findbycriteria(VidangeVo vidangeVo){
		String query= "select v from Vidange v where 1=1";
		if(StringUtil.isnotEmpty(vidangeVo.getRef()))
			query+= "AND v.ref ='"+vidangeVo.getRef()+"'";
		
		if(StringUtil.isnotEmpty(vidangeVo.getMontantMin()))
			query+=" AND v.monatnt >= '"+vidangeVo.getMontantMin()+"'";
		
		if(StringUtil.isnotEmpty(vidangeVo.getMontantMax()))
			query+=" AND v.monatnt <= '"+vidangeVo.getMontantMax()+"'";
		
		return entitymanager.createQuery(query).getResultList();
	}

    public Vidange findByRef(String ref) {
        return vidangeDao.findByRef(ref);
    }
   @Transactional
    public Vidange deleteByRef(String ref) {
        return vidangeDao.deleteByRef(ref);
    }

    public List<Vidange> findAll() {
        return vidangeDao.findAll();
    }

    public Vidange getOne(Long aLong) {
        return vidangeDao.getOne(aLong);
    }

    public int save(Vidange vidange) {
        Typevidange typevidange = typevidangeService.findByCode(vidange.getTypeVidange().getCode());
        Voiture voiture = voitureService.findByRef(vidange.getVoiture().getRef());
        Categorie categorie = categorieService.findByReference(vidange.getCategorie().getReference());
        vidange.setTypeVidange(typevidange);
        vidange.setCatégorie(categorie);
        vidange.setVoiture(voiture);
        if(vidangeDao.findByRef(vidange.getRef()) != null){
            return -4;
        }
        if( typevidange == null){
            return -1;
        }
        else if( voiture == null){
            return -2;
        }
        else if( categorie == null){
            return -3;
        }
        else {
            voitureService.save(voiture);
            categorieService.save(categorie);
            typevidangeService.save(typevidange);
            vidangeDao.save(vidange);
            return 1;
        }

    }

    public int deleteByCategorieReference(String ref) {
        return vidangeDao.deleteByCategorieReference(ref);
    }

    public int deleteByTypeVidangeCode(Long code) {
        return vidangeDao.deleteByTypeVidangeCode(code);
    }

    public int deleteByVoitureRef(String ref) {
        return vidangeDao.deleteByVoitureRef(ref);
    }

    @Autowired
    private VidangeDao vidangeDao;
    @Autowired
    private EntityManager entitymanager;
    @Autowired
    private VoitureService voitureService;
    @Autowired
    private CategorieService categorieService;
    @Autowired
    private TypevidangeService typevidangeService;
}