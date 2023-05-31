package EvaluacionTecnicaMoby.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import EvaluacionTecnicaMoby.Exception.RecursoNoEncontradoException;
import EvaluacionTecnicaMoby.Model.Moby.Model.Candidato;
import EvaluacionTecnicaMoby.Repository.CandidatoRepository;

@Service
public class CandidatoService {

    private final CandidatoRepository candidatoRepository;

    public CandidatoService(CandidatoRepository candidatoRepository) {
        this.candidatoRepository = candidatoRepository;
    }

    public List<Candidato> getCandidatos() {
        return candidatoRepository.findAll();
    }

    public Candidato getCandidatoById(Long id) {
        return candidatoRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Candidato", "id", id));
    }

    public Candidato createCandidato(Candidato candidato) {
        return candidatoRepository.save(candidato);
    }

    // cargar candidato
    public Candidato updateCandidato(Long id, Candidato candidatoActualizado) {

        Candidato candidato = getCandidatoById(id);
        candidato.setNombre(candidatoActualizado.getNombre());
        candidato.setApellido(candidatoActualizado.getApellido());
        candidato.setTipoDocumento(candidatoActualizado.getTipoDocumento());
        candidato.setNumeroDocumento(candidatoActualizado.getNumeroDocumento());
        candidato.setFechaNacimiento(candidatoActualizado.getFechaNacimiento());
        candidato.setTecnologias(candidatoActualizado.getTecnologias());
        return candidatoRepository.save(candidato);
    }

    public List<Candidato> getCandidatosPorTecnologia(String nombreTecnologia) {
        return candidatoRepository.findByTecnologiasNombre(nombreTecnologia);
    }

    public void deleteCandidato(Long id) {
        Candidato candidato = getCandidatoById(id);
        candidatoRepository.delete(candidato);
    }
}
