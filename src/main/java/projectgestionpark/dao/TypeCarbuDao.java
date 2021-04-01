package projectgestionpark.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import projectgestionpark.bean.TypeCarbu;

@Repository

public interface TypeCarbuDao extends JpaRepository<TypeCarbu,Long> {

    TypeCarbu findByCode(Long code);
    // int deleteById(Long id);
    int deleteByCode(Long code);

}