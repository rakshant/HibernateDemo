package nov20.com.rakshant.onetomanymapping;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Depts")
public class Department {

	@Id
	@GeneratedValue
	@Column(name = "Id")
	private Long deptId;

	@Column(name = "deptName")
	private String deptName;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "EMP_ID")
	private Set<Employees_2> employees;

	public Department() {
	}

	public Department(String deptName) {
		this.deptName = deptName;
	}

	public Set<Employees_2> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employees_2> employees) {
		this.employees = employees;
	}

	public Long getDeptId() {
		return deptId;
	}

	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

}
