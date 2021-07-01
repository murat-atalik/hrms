package findajob.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="updated_companies")
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","employers"})
public class UpdatedCompany {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="company_id")
	private int companyId;
	
	@Column(name="employer_id")
	private int employerId;
	
	@Column(name="old_company_name")
	private String OldCompanyName;
	
	@Column(name="new_company_name")
	private String newCompanyName;
	
	@Column(name="old_web_address")
	private String oldWebAddress;
	
	@Column(name="new_web_address")
	private String newWebAddress;
	
	@Column(name="waiting_update")
	private boolean waitingUpdate;
	
}
