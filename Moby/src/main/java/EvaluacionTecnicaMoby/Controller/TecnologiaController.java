package EvaluacionTecnicaMoby.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import EvaluacionTecnicaMoby.Model.Moby.Model.Tecnologia;
import EvaluacionTecnicaMoby.Service.TecnologiaService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/tecnologias")
public class TecnologiaController {

	private final TecnologiaService tecnologiaService;

	public TecnologiaController(TecnologiaService tecnologiaService) {
		this.tecnologiaService = tecnologiaService;
	}

	@GetMapping
	public List<Tecnologia> getTecnologias() {
		return tecnologiaService.getTecnologias();
	}

	@GetMapping("/{id}")
	public Tecnologia getTecnologia(@PathVariable Long id) {
		return tecnologiaService.getTecnologiaById(id);
	}

	@PostMapping
	public ResponseEntity<Tecnologia> createTecnologia(@Valid @RequestBody Tecnologia tecnologia) {
		Tecnologia createdTecnologia = tecnologiaService.createTecnologia(tecnologia);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdTecnologia);
	}

	@PutMapping("/{id}")
	public Tecnologia updateTecnologia(@PathVariable Long id, @Valid @RequestBody Tecnologia tecnologia) {
		return tecnologiaService.updateTecnologia(id, tecnologia);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteTecnologia(@PathVariable Long id) {
		tecnologiaService.deleteTecnologia(id);
		return ResponseEntity.noContent().build();
	}

}
