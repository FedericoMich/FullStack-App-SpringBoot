package GitClass.BE.BEANS;

import javax.persistence.*;
@Entity
@Table(name = "course")
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name = "name")
	private String name;
	@Column(name = "year")
	private String year;
	
	
	public Course() {
	}
	public Course(String name, String year) {
		this.name = name;
		this.year = year;

	}
	public long getId() {
		return id;
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

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", year=" + year + "]";
	}
}
