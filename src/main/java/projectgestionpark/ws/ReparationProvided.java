package projectgestionpark.ws;

import projectgestionpark.bean.Reparation;
import projectgestionpark.service.ReparationService;
import vo.ReparationVo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("gestion-park/reparation")
public class ReparationProvided {
	
	@Autowired
	private ReparationService reparationService;
	
	
    @GetMapping("/ref/{ref}")
	public Reparation findByRef(@PathVariable String ref) {
		return reparationService.findByRef(ref);
	}
    
    @DeleteMapping("/ref/{ref}")
	public int deleteByRef(@PathVariable String ref) {
		return reparationService.deleteByRef(ref);
	}
    
    @PostMapping("/criteria")
    public List<ReparationVo> findbycriteria(ReparationVo reparationVo) {
		return reparationService.findbycriteria(reparationVo);
	}

	@PostMapping("/")
	public int save(@RequestBody Reparation reparation) {
		return reparationService.save(reparation);
	}

	@GetMapping("/id/{id}")
	public Reparation getOne(@PathVariable Long id) {
		return reparationService.getOne(id);
	}

}
