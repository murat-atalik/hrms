package findajob.hrms.entities.concretes;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "experiences")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","curriculum_vitae"})
public class Experience {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name = "business_name")
	@NotBlank
	@NotNull
	private String businessName;
	
	@Column(name = "position")
	@NotBlank
	@NotNull
	private String position;

	@Column(name="starting_date")
	@NotBlank
	@NotNull
	private Date startingDate;
	
	@Column(name="quit_date")
	private Date quitDate;
	
	@ManyToOne
	@JoinColumn(name = "curriculum_vitae_id")
	private CurriculumVitae curriculum_vitae;
}
