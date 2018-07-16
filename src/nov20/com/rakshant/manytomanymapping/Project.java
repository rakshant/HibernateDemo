package nov20.com.rakshant.manytomanymapping;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Project")
public class Project {

	@Id
	@GeneratedValue
	@Column(name = "Id")
	private Long projectID;

	@Column(name = "projectName")
	private String projectName;

	@ManyToMany(cascade = CascadeType.ALL)
	private List<Employee_3> empl;

	public Project() {
	}

	public Project(String projectName) {
		this.projectName = projectName;
	}

	public Long getProjectID() {
		return projectID;
	}

	public void setProjectID(Long projectID) {
		this.projectID = projectID;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public List<Employee_3> getEmpl() {
		return empl;
	}

	public void setEmpl(List<Employee_3> empl) {
		this.empl = empl;
	}

}
