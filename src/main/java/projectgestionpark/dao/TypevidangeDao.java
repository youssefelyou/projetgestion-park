package projectgestionpark.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import projectgestionpark.bean.Typevidange;

@Repository
public interface TypevidangeDao extends JpaRepository<Typevidange,Long>{
     Typevidange findByCode(Long code);
     int deleteByCode(Long code);

}

