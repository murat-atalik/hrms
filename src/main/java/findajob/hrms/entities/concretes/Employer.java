package findajob.hrms.entities.concretes;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "employers")
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "jobAdvertisements" })
public class Employer extends User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "user_id")
	private int userId;

	@Column(name = "phone_number")
	@NotBlank
	@NotNull
	private String phoneNumber;

	@Column(name = "email_verification")
	private boolean emailVerification;

	@Column(name = "system_verification")
	private boolean systemVerification;

	// @JsonIgnore
	// @OneToOne(cascade = CascadeType.ALL)
	// @JoinColumn(name = "user_id", referencedColumnName = "id")
	// private User user;

	@ManyToOne()
	@JoinColumn(name = "company_id")
	private Company company;

	@OneToMany(mappedBy = "employer")
	private List<JobAdvertisement> jobAdvertisements;

}
