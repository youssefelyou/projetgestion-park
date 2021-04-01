package projectgestionpark.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import projectgestionpark.bean.ConsommationCarburant;

@Repository


public interface ConsommationCarburantDao extends JpaRepository<ConsommationCarburant, Long> {

    ConsommationCarburant findByRef(String ref);
    int deleteByRef(String ref);
    int deleteByVoitureRef(String ref);


}
