package projectgestionpark.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import projectgestionpark.bean.Vidange;

@Repository
public interface VidangeDao extends JpaRepository<Vidange, Long> {

    Vidange findByRef(String ref);
    Vidange deleteByRef(String ref);
    int deleteByCategorieReference(String ref);
    int deleteByTypeVidangeCode(Long code);
    int deleteByVoitureRef(String ref);
}