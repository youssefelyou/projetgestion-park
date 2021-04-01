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

import projectgestionpark.bean.Typevidange;
import projectgestionpark.service.TypevidangeService;

@RestController
@RequestMapping("typevidange/typevidange")
public class TypevidangeProvided {

    @DeleteMapping("/code/{code}")
    public int deleteByCode(@PathVariable Long code) {
        return typevidangeService.deleteByCode(code);
    }

    @GetMapping("/code/{code}")
    public Typevidange findByCode(@PathVariable Long code) {
        return typevidangeService.findByCode(code);
    }

    @GetMapping("/")
    public List<Typevidange> findAll() {
        return typevidangeService.findAll();
    }

    @PostMapping("/")
    public int save(@RequestBody Typevidange typevidange) {
        return typevidangeService.save(typevidange);
    }

    @Autowired
    private TypevidangeService typevidangeService;
}

