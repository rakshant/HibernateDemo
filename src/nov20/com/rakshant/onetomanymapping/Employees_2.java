package nov20.com.rakshant.onetomanymapping;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EMPL")
public class Employees_2 {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long employeeId;

	@Column(name = "empName")
	private String name;

	public Employees_2() {

	}

	public Employees_2(String name) {
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

	@Override
	public String toString() {
		return name + "  " + employeeId;
	}

}
