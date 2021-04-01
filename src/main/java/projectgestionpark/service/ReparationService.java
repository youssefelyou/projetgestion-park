package projectgestionpark.service;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import projectgestionpark.bean.Reparation;
import projectgestionpark.dao.ReparationDao;
import projectgestionpark.service.util.StringUtil;
import vo.ReparationVo;
import vo.VidangeVo;

@Service
public class ReparationService {
	
	public List<ReparationVo> findbycriteria(ReparationVo reparationVo){
		String query= "select r from Reparation r where 1=1";
		if(StringUtil.isnotEmpty(reparationVo.getRef()))
			query+= "AND v.ref ='"+reparationVo.getRef()+"'";
		
		if(StringUtil.isnotEmpty(reparationVo.getMontantMin()))
			query+=" AND v.monatnt >= '"+reparationVo.getMontantMin()+"'";
		
		if(StringUtil.isnotEmpty(reparationVo.getMontantMax()))
			query+=" AND v.monatnt <= '"+reparationVo.getMontantMax()+"'";
		
		return entitymanager.createQuery(query).getResultList();
	}

	public int deleteByVoitureRef(String ref) {
		return reparationDao.deleteByVoitureRef(ref);
	}

	@Autowired
	private ReparationDao reparationDao;
	@Autowired
    private EntityManager entitymanager;
	public Reparation findByRef(String ref) {
		return reparationDao.findByRef(ref);
	}
	
    @Transactional
	public int deleteByRef(String ref) {
		return reparationDao.deleteByRef(ref);
	}

	
	public int save(Reparation reparation) {
		if (findByRef(reparation.getRef())!=null) {
		
			return -1;
		}else{
			
			reparationDao.save(reparation);
			return 1;
		}
		
	}

	public Reparation getOne(Long id) {
		return reparationDao.getOne(id);
	}



public List<Reparation> findAll() {
	return reparationDao.findAll();
}

}
 



