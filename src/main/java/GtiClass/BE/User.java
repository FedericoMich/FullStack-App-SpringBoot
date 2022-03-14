package GtiClass.BE;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
	private String name;
    private String surname;
    private String repos;
	
    
  
    public String getNome() {
		return name;
	}
	public void setNome(String name) {
		this.name = name;
	}
	public String getCognome() {
		return surname;
	}
	public void setCognome(String surname) {
		this.surname = surname;
	}
	public String getRepos() {
		return repos;
	}
	public void setRepos(String repos) {
		this.repos = repos;
	}
	
}
