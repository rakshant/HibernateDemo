package nov20.com.rakshant.onetoonemapping;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="EMPLTEST")
public class Employees {

	@Id
	@GeneratedValue
	@Column(name="id")
	private Long employeeId;
	
	@Column(name="empName")
	private String name;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="PROFILE_ID")
	private Profile profile;

	public Employees() {
		
	}
	
	public Employees(String name) {
		this.name = name;		
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}
}

