package projectgestionpark.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import projectgestionpark.bean.Categorie;

@Repository
public interface CategorieDao extends JpaRepository<Categorie ,Long >{

	Categorie findByReference(String refrence);
	int deleteByReference(String reference);
}
