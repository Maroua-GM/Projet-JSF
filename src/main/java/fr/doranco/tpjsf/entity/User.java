package fr.doranco.tpjsf.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class User {

	private int id;
	private String nom;
	private String prenom;
	private Date dateNaissance;
	private String genre;
	private String email;
	private String niveauDeService;
	private List<Adresse> adresses;
	private String telephone;
	private String fonctionActuelle;
	private String disponible;
	private List<String> langageSouhaites;
	private String password;

	public User() {
		adresses = new ArrayList<Adresse>();
		langageSouhaites = new ArrayList<String>();
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public User(String nom, String prenom, Date dateNaissance, String genre, String email, String niveauDeService,
			String telephone, String fonctionActuelle, String disponible, String password) {
		adresses = new ArrayList<Adresse>();
		langageSouhaites = new ArrayList<String>();
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.genre = genre;
		this.email = email;
		this.niveauDeService = niveauDeService;
		this.telephone = telephone;
		this.fonctionActuelle = fonctionActuelle;
		this.disponible = disponible;
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getFonctionActuelle() {
		return fonctionActuelle;
	}

	public void setFonctionActuelle(String fonctionActuelle) {
		this.fonctionActuelle = fonctionActuelle;
	}

	public String getDisponible() {
		return disponible;
	}

	public void setDisponible(String disponible) {
		this.disponible = disponible;
	}

	public List<String> getLangageSouhaites() {
		return langageSouhaites;
	}

	public List<Adresse> getAdresses() {
		return adresses;
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
