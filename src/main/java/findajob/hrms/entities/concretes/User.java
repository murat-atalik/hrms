package findajob.hrms.entities.concretes;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "email")
	@NotBlank
	@NotNull
	@Email
	private String email;
	
	@Column(name = "password")
	@NotBlank
	@NotNull
	private String password;
	
	@Column(name = "user_type")
	@NotBlank
	@NotNull
	private String userType;
	//@JsonIgnore
	//@OneToOne(mappedBy = "user")
	//private Candidate candidate;
	
	//@JsonIgnore
	//@OneToOne(mappedBy = "user")
	//private Employer employer;
	
	//@JsonIgnore
	//@OneToOne(mappedBy = "user")
	//private Staff staff;
	

	

}
