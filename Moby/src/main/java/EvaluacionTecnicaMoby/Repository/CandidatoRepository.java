package EvaluacionTecnicaMoby.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import EvaluacionTecnicaMoby.Model.Moby.Model.Candidato;

@Repository
public interface CandidatoRepository extends JpaRepository<Candidato, Long> {

    List<Candidato> findByTecnologiasNombre(String nombreTecnologia);

}