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

import projectgestionpark.bean.Voiture;
import projectgestionpark.service.VoitureService;

@RestController
@RequestMapping("voi/voiture")
public class VoitureProvided {


    @GetMapping("/ref/{ref}")
    public Voiture findByRef(@PathVariable String ref) {
        return voitureService.findByRef(ref);
    }

    @DeleteMapping("/ref/{ref}")
    public int deleteByRef(@PathVariable String ref) {
        return voitureService.deleteByRef(ref);
    }

    @PostMapping("/")
    public int save(@RequestBody Voiture voiture) {
        return voitureService.save(voiture);
    }

    @GetMapping("/matricule/{matricule}")
    public Voiture findByMatricule(@PathVariable String matricule) {
        return voitureService.findByMatricule(matricule);
    }

    @GetMapping("/")
    public List<Voiture> findAll() {
        return voitureService.findAll();
    }

    @Autowired
    private VoitureService voitureService;
}
