package EvaluacionTecnicaMoby.Service;

import org.springframework.stereotype.Service;

import EvaluacionTecnicaMoby.Exception.RecursoNoEncontradoException;
import EvaluacionTecnicaMoby.Model.Moby.Model.Tecnologia;
import EvaluacionTecnicaMoby.Repository.TecnologiaRepository;

import java.util.List;

@Service
public class TecnologiaService {

    private final TecnologiaRepository tecnologiaRepository;

    public TecnologiaService(TecnologiaRepository tecnologiaRepository) {
        this.tecnologiaRepository = tecnologiaRepository;
    }

    public List<Tecnologia> getTecnologias() {
        return tecnologiaRepository.findAll();
    }

    public Tecnologia getTecnologiaById(Long id) {
        return tecnologiaRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Tecnología", "id", id));
    }

    public Tecnologia createTecnologia(Tecnologia tecnologia) {
        return tecnologiaRepository.save(tecnologia);
    }

    public Tecnologia updateTecnologia(Long id, Tecnologia tecnologiaActualizada) {

        Tecnologia tecnologia = getTecnologiaById(id);
        tecnologia.setNombre(tecnologiaActualizada.getNombre());
        tecnologia.setVersion(tecnologiaActualizada.getVersion());
        return tecnologiaRepository.save(tecnologia);
    }

    public void deleteTecnologia(Long id) {
        Tecnologia tecnologia = getTecnologiaById(id);
        tecnologiaRepository.delete(tecnologia);
    }
}
