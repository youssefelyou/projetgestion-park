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

import projectgestionpark.bean.Vidange;
import projectgestionpark.service.VidangeService;
import vo.VidangeVo;

@RestController
@RequestMapping("vidange/vidange")
public class VidangeProvided {
    @GetMapping("/ref/{ref}")
    public Vidange findByRef(@PathVariable String ref) {
        return vidangeService.findByRef(ref);
    }

    @DeleteMapping("/ref/{ref}")
    public Vidange deleteByRef(@PathVariable String ref) {
        return vidangeService.deleteByRef(ref);
    }

    @GetMapping("/")
    public List<Vidange> findAll() {
        return vidangeService.findAll();
    }

    @GetMapping("/id/{id}")
    public Vidange getOne(@PathVariable Long id) {
        return vidangeService.getOne(id);
    }

    @PostMapping("/")
    public int save(@RequestBody Vidange vidange) {
        return vidangeService.save(vidange);
    }


    @Autowired
    private VidangeService vidangeService;

    @PostMapping("/criteria")
	public List<VidangeVo> findbycriteria(@RequestBody VidangeVo vidangeVo) {
		return vidangeService.findbycriteria(vidangeVo);
	}
}
