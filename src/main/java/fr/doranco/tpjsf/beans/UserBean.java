package fr.doranco.tpjsf.beans;

import java.time.LocalDate;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "userBean")
@SessionScoped
public class UserBean {

	@ManagedProperty(value = "DUPOND")
	private String nom;
	@ManagedProperty(value = "Michel")
	private String prenom;
	private LocalDate dateNaissance;
	@ManagedProperty(value = "homme")
	private String genre;
	@ManagedProperty(value = "dupond.michel@gmail.com")
	private String email;
	private String niveauDeService;

	public UserBean() {

	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public LocalDate getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNiveauDeService() {
		return niveauDeService;
	}

	public void setNiveauDeService(String niveauDeService) {
		this.niveauDeService = niveauDeService;
	}

}
