package tex.model;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.JoinColumn;
import tex.model.Professor;


@Entity
@Table(name =  "Subjects", uniqueConstraints = @UniqueConstraint(columnNames = "title"))
public class Subject {

	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Integer id;
	
	@Column()
	private String title;
	
	@Column()
	private String details;
	
	@ManyToOne
	@JoinColumn(name="Professor_id")
	private Professor professor;

	public Subject() {
		
	}

	public Subject(Integer id) {
		this.id=id;
	}
	
	public Subject(String title, String details,Professor professor) {
		this.title = title;
		this.details = details;
		this.professor=professor;
			
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	
	
	
	
}
