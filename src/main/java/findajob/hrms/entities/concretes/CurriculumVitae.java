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
import javax.validation.constraints.Email;
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
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	@Email
	@Column(name = "email")
	private String email;

	@Column(name = "github")
	private String github;
	
	@Column(name = "linkedin")
	private String linkedin;

	@Column(name = "cover_letter")
	private String coverLetter;

	@Column(name = "image_url")
	private String imageUrl;
	
	@Column(name = "active")
	private boolean active;
	
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
