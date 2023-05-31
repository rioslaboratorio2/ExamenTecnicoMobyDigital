package EvaluacionTecnicaMoby.Model.Moby.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.Data;
import java.util.*;

@Entity
@Data
public class Candidato {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	private String nombre;

	@NotBlank
	private String apellido;

	@NotBlank
	private String tipoDocumento;

	@NotBlank
	private String numeroDocumento;

	@NotNull
	@Past
	private Date fechaNacimiento;

	/*
	 * VER si puedo implementar O VER TABLA INTERMEDIA ---
	 * 
	 * @ManyToMany
	 * 
	 * @JoinTable(
	 * name = "candidato_tecnologia",
	 * joinColumns = @JoinColumn(name = "candidato_id"),
	 * inverseJoinColumns = @JoinColumn(name = "tecnologia_id")
	 * )
	 * 
	 */

	private Set<Tecnologia> tecnologias = new HashSet<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Set<Tecnologia> getTecnologias() {
		return tecnologias;
	}

	public void setTecnologias(Set<Tecnologia> tecnologias) {
		this.tecnologias = tecnologias;
	}

}