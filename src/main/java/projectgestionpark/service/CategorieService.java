package projectgestionpark.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import projectgestionpark.bean.Categorie;
import projectgestionpark.dao.CategorieDao;

@Service
public class CategorieService {
	
	@Autowired
	private CategorieDao categorieDao;
	@Autowired
	private VidangeService vidangeService;

	public Categorie findByReference(String reference) {
		return categorieDao.findByReference( reference);
	}

	@Transactional
	public int deleteByReference(String reference) {
		int r1 = categorieDao.deleteByReference(reference);
		int r2 = vidangeService.deleteByCategorieReference(reference);
		return r1 + r2;
	}
	
	public int save(Categorie categorie) {
		if (findByReference(categorie.getReference())!=null) {
		
			return -1;
		}else{
			
			categorieDao.save(categorie);
			return 1;
		}
		
	}
	public List<Categorie> findAll() {
		return categorieDao.findAll();
	}

	public Categorie getOne(Long id) {
		return categorieDao.getOne(id);
	}
	
}


