package nov20.com.rakshant.HQL;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;


@NamedQueries({
	@NamedQuery(
			name = "totalsalaryofuser",
			query = "SELECT SUM(E.sal) FROM Employee E"
	),
	@NamedQuery(
			name = "orderbysalary",
			query = "SELECT E.name FROM Employee E ORDER BY E.sal"
	),
	@NamedQuery(
			name = "groupbycity",
			query = "SELECT COUNT(E.name) FROM Employee E GROUP BY E.city"
	),
	@NamedQuery(
			name = "salaryAavg",
			query = "select avg(E.sal) FROM Employee E"
	),

})
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
@Entity
@Table(name="EMPLOYEE")
public class Employee {

	@Id
	@GeneratedValue
	@Column(name="id")
	private Long employeeId;
	
	@Column(name="name")
	private String name;
	
	@Column(name="salary")
	private double sal;
	
	@Column(name="city")
	private String city;

	public Employee() {
		
	}
	
	public Employee(String name, double sal) {
		this.name = name;
		this.sal = sal;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
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

	public double getSal() {
		return sal;
	}

	public void setSal(double sal) {
		this.sal = sal;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", name=" + name
				+ ", sal=" + sal + ", city=" + city + "]";
	}

}

