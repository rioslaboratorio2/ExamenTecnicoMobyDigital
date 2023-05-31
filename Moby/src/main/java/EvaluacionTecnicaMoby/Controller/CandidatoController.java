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

import EvaluacionTecnicaMoby.Model.Moby.Model.Candidato;
import EvaluacionTecnicaMoby.Service.CandidatoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/candidatos")
public class CandidatoController {

    private final CandidatoService candidatoService;

    public CandidatoController(CandidatoService candidatoService) {
        this.candidatoService = candidatoService;
    }

    @GetMapping
    public List<Candidato> getCandidatos() {
        return candidatoService.getCandidatos();
    }

    @GetMapping("/{id}")
    public Candidato getCandidato(@PathVariable Long id) {
        return candidatoService.getCandidatoById(id);
    }

    @GetMapping("/tecnologia/{nombreTecnologia}")
    public List<Candidato> getCandidatosPorTecnologia(@PathVariable String nombreTecnologia) {
        return candidatoService.getCandidatosPorTecnologia(nombreTecnologia);
    }

    @PostMapping
    public ResponseEntity<Candidato> createCandidato(@Valid @RequestBody Candidato candidato) {
        Candidato createdCandidato = candidatoService.createCandidato(candidato);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCandidato);
    }

    @PutMapping("/{id}")
    public Candidato updateCandidato(@PathVariable Long id, @Valid @RequestBody Candidato candidato) {
        return candidatoService.updateCandidato(id, candidato);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCandidato(@PathVariable Long id) {
        candidatoService.deleteCandidato(id);
        return ResponseEntity.noContent().build();
    }
}
