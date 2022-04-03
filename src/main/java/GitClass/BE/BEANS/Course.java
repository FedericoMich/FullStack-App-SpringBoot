package GitClass.BE.BEANS;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "course")
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "name")
	private String name;
	@Column(name = "year")
	private String year;
	

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_course", referencedColumnName = "id")
	List<User> user = new ArrayList<>();
	
	
	public Course() {
	}
	
	public Course(String name, String year) {
		this.name = name;
		this.year = year;

	}
	

	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	
	public List<User> getUser() {
		return user;
	}
	public void setUser(List<User> user) {
		this.user = user;
	}
	
}
