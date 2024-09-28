package tex.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;


@Entity
@Table(name="students")
public class Student {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Integer id;
	
	@Column()
	private String fullname;
	
	@Column()
	private Integer yearofstudies;
	
	@Column()
	private Double currentaveragegrade;
	
	@Column()
	private Integer remainingcourses;
	
	
	public Student() {
		
	}
	
	public Student(Integer id) {
		this.id=id;
	}

	public Student(String fullname, Integer yearofstudies, Double currentaveragegrade, Integer remainingcourses) {
		super();
		this.fullname = fullname;
		this.yearofstudies = yearofstudies;
		this.currentaveragegrade = currentaveragegrade;
		this.remainingcourses = remainingcourses;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public Integer getYearofstudies() {
		return yearofstudies;
	}

	public void setYearofstudies(Integer yearofstudies) {
		this.yearofstudies = yearofstudies;
	}

	public Double getCurrentaveragegrade() {
		return currentaveragegrade;
	}

	public void setCurrentaveragegrade(Double currentaveragegrade) {
		this.currentaveragegrade = currentaveragegrade;
	}

	public Integer getRemainingcourses() {
		return remainingcourses;
	}

	public void setRemainingcourses(Integer remainingcourses) {
		this.remainingcourses = remainingcourses;
	}
	
	
	
	
	
	
}
