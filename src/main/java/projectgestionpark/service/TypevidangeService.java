package projectgestionpark.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import projectgestionpark.bean.Typevidange;
import projectgestionpark.dao.TypevidangeDao;

@Service
public class TypevidangeService {

    @Transactional
    public int deleteByCode(Long code) {
        int r1 =  typevidangeDao.deleteByCode(code);
        int r2 =  vidangeService.deleteByTypeVidangeCode(code);
        return  r1+r2;
    }

    public Typevidange findByCode(Long code) {
        return typevidangeDao.findByCode(code);
    }

    public List<Typevidange> findAll() {
        return typevidangeDao.findAll();
    }




    public int save(Typevidange typevidange) {
                    if (findByCode(typevidange.getCode())!= null) {
                        return -1;
                    } else {
                        typevidangeDao.save(typevidange);
                        return 1;
                    }
                }
    @Autowired
    private TypevidangeDao typevidangeDao;
    @Autowired
    private VidangeService vidangeService;
}

