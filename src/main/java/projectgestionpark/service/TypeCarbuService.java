package projectgestionpark.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import projectgestionpark.bean.TypeCarbu;
import projectgestionpark.dao.TypeCarbuDao;

@Service
public class TypeCarbuService {


    public TypeCarbu findByCode(Long code) {
        return typeCarbuDao.findByCode(code);
    }

    public int  save(TypeCarbu typeCarbu ) {
        if(findByCode(typeCarbu.getCode())!=null) {
            return -1;

        }else {
            typeCarbuDao.save(typeCarbu);
            return 1; }
    }

    public List<TypeCarbu> findAll() {
        return typeCarbuDao.findAll();
    }

    @Transactional
    public int deleteByCode(Long code) {
        return typeCarbuDao.deleteByCode(code);
    }

    @Autowired
    private TypeCarbuDao typeCarbuDao;

}
