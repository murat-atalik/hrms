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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "job_advertisements")
public class JobAdvertisement {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "job_description")
	private String jobDescription;
	
	@Column(name = "min_salary")
	private double minSalary;
	
	@Column(name = "max_salary")
	private double maxSalary;
	
	@Column(name = "open_position")
	private int openPosition;
	
	
	@Column(name = "application_deadline")
	private Date applicationDeadline;
	
	@Column(name = "release_date")
	private Date releaseDate;
	
	@Column(name = "active")
	private boolean active;
	
	@Column(name = "system_confirmation")
	private boolean systemConfirmation;
	
	@ManyToOne()
	@JoinColumn(name = "employer_id")
	private Employer employer;

	
	@ManyToOne()
	@JoinColumn(name = "workProgram_id")
	private WorkProgram workProgram;

	@ManyToOne()
	@JoinColumn(name = "city_id")
	private City city;
	
	@ManyToOne()
	@JoinColumn(name = "jobPosition_id")
	private JobPosition jobPosition;
	@ManyToOne()
	@JoinColumn(name = "workType_id")
	private WorkType workType;
}
