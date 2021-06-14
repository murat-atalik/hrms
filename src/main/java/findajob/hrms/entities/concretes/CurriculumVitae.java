package findajob.hrms.entities.concretes;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "curriculum_vitaes")
@Entity
public class CurriculumVitae {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "github")
	@NotBlank
	@NotNull
	private String github;

	@Column(name = "linkedin")
	@NotBlank
	@NotNull
	private String linkedin;

	@Column(name = "cover_letter")
	private String coverLetter;

	@Column(name = "image_url")
	private String imageUrl;

	@Column(name = "created_date")
	private LocalDate createdDate = LocalDate.now();

	@ManyToOne
	@JoinColumn(name = "candidate_id")
	private Candidate candidate;
	
	@OneToMany(mappedBy = "curriculum_vitae")
	private List<Education> educations;
	
	@OneToMany(mappedBy = "curriculum_vitae")
	private List<Experience> experiences;
	
	@OneToMany(mappedBy = "curriculum_vitae")
	private List<Language> languages;
	
	
	@OneToMany(mappedBy = "curriculum_vitae")
	private List<Ability> abilities;
}
