package projectgestionpark.dao;
import projectgestionpark.bean.Voiture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface VoitureDao extends JpaRepository<Voiture,Long>{
    Voiture findByRef(String ref);
    Voiture findByMatricule(String matricule);
    int deleteByRef (String ref);
    int deleteByModelCode(Long code);
    int deleteByTypeCarburantCode(Long code);

}

