package projectgestionpark.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import projectgestionpark.bean.ConsommationCarburant;
import projectgestionpark.service.ConsommationService;
import vo.ConsommationVo;

@RestController
@RequestMapping("consommationCarburant/consommationCarburant")
public class ConsommationCarburantProvided {

	@PostMapping("/criteria")
    public List<ConsommationVo> findbycriteria(@RequestBody ConsommationVo consommationVo) {
		return consommationService.findbycriteria(consommationVo);
	}

	@GetMapping("/ref/{ref}")
    public ConsommationCarburant findByRef(@PathVariable String ref) {
        return consommationService.findByRef(ref);
    }

    @GetMapping("/")
    public List<ConsommationCarburant> findAll() {
        return consommationService.findAll();
    }

    @DeleteMapping("/ref/{ref}")
    public int deleteByRef(@PathVariable String ref) {
        return consommationService.deleteByRef(ref);
    }

    @PostMapping("/")
    public int save(@RequestBody ConsommationCarburant consommationCarburant) {
        return consommationService.save(consommationCarburant);
    }

    @Autowired
    private ConsommationService consommationService;


}
