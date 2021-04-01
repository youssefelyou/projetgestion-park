package projectgestionpark.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import projectgestionpark.bean.TypeCarbu;
import projectgestionpark.service.TypeCarbuService;


@RestController
@RequestMapping("typeCarbu/typeCarbu")
public class TypeCarbuProvided {

    @GetMapping("/code/{code}")
    public TypeCarbu findByCode(@PathVariable Long code) {
        return typeCarbuService.findByCode(code);
    }

    @PostMapping("/")
    public int save(@RequestBody TypeCarbu typeCarbu) {
        return typeCarbuService.save(typeCarbu);
    }

    @GetMapping("/")
    public List<TypeCarbu> findAll() {
        return typeCarbuService.findAll();
    }

    @DeleteMapping("/code/{code}")
    public int deleteByCode(@PathVariable Long code) {
        return typeCarbuService.deleteByCode(code);
    }

    @Autowired
    private TypeCarbuService typeCarbuService;
}

