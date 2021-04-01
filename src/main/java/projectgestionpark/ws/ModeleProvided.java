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

import projectgestionpark.bean.Modele;
import projectgestionpark.service.ModeleService;

@RestController
@RequestMapping("modele/modele")

public class ModeleProvided {

    @GetMapping("/code/{code}")
    public Modele findByCode(@PathVariable Long code) {
        return modeleService.findByCode(code);
    }
    @DeleteMapping("/code/{code}")
    public int deleteByCode(@PathVariable Long code) {
        return modeleService.deleteByCode(code);
    }

    @GetMapping("/")
    public List<Modele> findAll() {
        return modeleService.findAll();
    }

    @PostMapping("/")
    public int save(@RequestBody Modele modele) {
        return modeleService.save(modele);
    }

    @Autowired
    private ModeleService modeleService;

}

