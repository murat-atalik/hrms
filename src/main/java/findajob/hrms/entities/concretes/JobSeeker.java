package findajob.hrms.entities.concretes;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="job_seekers")
@NoArgsConstructor
@AllArgsConstructor
public class JobSeeker  extends User {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	@Column(name="id")
	private int id;
	@Column(name="user_id")
	private int userId;
	@Column(name="first_name")
	private String firstName;
	@Column(name="last_name")
	private String lastName;
	@Column(name="nationality_id")
	private String nationalityId;
	@Column(name="birthday")
	private Date birthday;
	@Column(name="email_verification")
	private boolean emailVerification;
}