package projectgestionpark.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import projectgestionpark.bean.Modele;

@Repository
public interface ModeleDao extends JpaRepository<Modele,Long> {
    Modele findByCode(Long code);
    int deleteByCode(Long code);

}
