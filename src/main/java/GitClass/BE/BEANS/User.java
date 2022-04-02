package GitClass.BE.BEANS;

import javax.persistence.*;
@Entity
@Table(name = "User")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name = "name")
	private String name;
	@Column(name = "surname")
	private String surname;
	@Column(name = "Userclass")
	private String userclass;
	
	public User() {
	}
	public User(long id, String name, String surname, String userclass) {
		this.name = name;
		this.surname = surname;
		this.userclass = userclass;
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getUserclass() {
		return userclass;
	}

	public void setUserclass(String userclass) {
		this.userclass = userclass;
	}
	
	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", surname=" + surname + ", userclass=" + userclass + "]";
	}

}
	


