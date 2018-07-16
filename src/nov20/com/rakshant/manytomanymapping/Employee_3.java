package nov20.com.rakshant.manytomanymapping;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "EMPL")
public class Employee_3 {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long employeeId;

	@Column(name = "empName")
	private String name;

	@ManyToMany
	@JoinColumn(name = "project_id")
	private List<Project> project;

	public Employee_3() {

	}

	public Employee_3(String name) {
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

	public List<Project> getProject() {
		return project;
	}

	public void setProject(ArrayList<Project> project) {
		this.project = project;
	}

	@Override
	public String toString() {
		return name + "  " + employeeId;
	}

}
