package projectgestionpark.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import projectgestionpark.bean.Reparation;

@Repository
public interface ReparationDao extends JpaRepository<Reparation, Long> {
	
  Reparation findByRef(String ref);
  int deleteByRef(String ref);
  int deleteByVoitureRef(String ref);

}
