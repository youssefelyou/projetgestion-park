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

import projectgestionpark.bean.Categorie;
import projectgestionpark.service.CategorieService;

@RestController
@RequestMapping
public class CategorieProvided {
	
	@Autowired
	private CategorieService categorieservice;
	
	
    @GetMapping("/reference/{reference}")
	public Categorie findByReference(@PathVariable String reference) {
		return categorieservice.findByReference(reference);
	}


    @DeleteMapping("/reference/{reference}")
	public int deleteByReference(@PathVariable String reference) {
		return categorieservice.deleteByReference(reference);
	}

    @PostMapping("/")
	public int save(@RequestBody Categorie catégorie) {
		return categorieservice.save(catégorie);
	}

	public List<Categorie> findAll() {
		return categorieservice.findAll();
	}

	
	@GetMapping("/id/{id}")
	public Categorie getOne(@PathVariable Long id) {
		return categorieservice.getOne(id);
	}

}
