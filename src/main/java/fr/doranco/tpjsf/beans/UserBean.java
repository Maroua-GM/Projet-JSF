package fr.doranco.tpjsf.beans;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import fr.doranco.tpjsf.entity.Adresse;
import fr.doranco.tpjsf.entity.User;

@ManagedBean(name = "userBean")
@SessionScoped
public class UserBean {

	@ManagedProperty(value = "DUPOND")
	private String nom;
	@ManagedProperty(value = "Michel")
	private String prenom;
	private Date dateNaissance;
	@ManagedProperty(value = "homme")
	private String genre;
	@ManagedProperty(value = "dupond@gmail.com")
	private String email;
	@ManagedProperty(value = "medium")
	private String niveauDeService;
	private List<Adresse> adresses;
	@ManagedProperty(value = "00000000")
	private String telephone;
	@ManagedProperty(value = "Autre")
	private String fonctionActuelle;
	@ManagedProperty(value = "Non")
	private String disponible;
	private List<String> langageSouhaites;

	private static final List<User> userList = new ArrayList<User>(Arrays.asList(
//			new User("Benoit", "Leclerc", "1977/10/27", "homme", "benoit@doranco.fr", "medium", "adresse1",
//					"0101010101", "agent", "oui"),
//			new User("Paul", "Andrieux", "1965/06/12", "homme", "paul.andrieux@doranco.fr", "medium", "adresse1",
//					"0101010101", "agent", "oui"),
//			new User("Laura", "Treich", "1987/10/07", "femme", "laura.treich@doranco.fr", "medium", "adresse1",
//					"0101010101", "agent", "oui"),
//			new User("Nathalie", "Tango", "1980/07/17", "femme", "nathalie.tango@doranco.fr", "medium", "adresse1",
//					"0101010101", "agent", "oui")

	));

	public List<User> getUserList() {
		return userList;
	}

	public void inscription() {

		User user = new User(this.nom, this.prenom, this.dateNaissance, this.genre, this.email, this.niveauDeService,
				this.telephone, this.fonctionActuelle, this.disponible);

		for (Adresse adresse : AdresseBean.getAdresselist()) {
			user.getAdresses().add(adresse);
		}
		userList.add(user);

	}

	public void addAdresse() {
		Adresse adresse = new Adresse((short) 4, "qsdsqd", "qsdqsds", "qsdd");
		this.adresses.add(adresse);
	}

	public void deleteAction(User user) {
		userList.remove(user);
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

	@Override
	public String toString() {
		return "UserBean [" + (nom != null ? "nom=" + nom + ", " : "")
				+ (prenom != null ? "prenom=" + prenom + ", " : "")
				+ (dateNaissance != null ? "dateNaissance=" + dateNaissance + ", " : "")
				+ (genre != null ? "genre=" + genre + ", " : "") + (email != null ? "email=" + email + ", " : "")
				+ (niveauDeService != null ? "niveauDeService=" + niveauDeService : "") + "]";
	}

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

	public String getGenre() {
		return genre;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public List<Adresse> getAdresses() {
		return adresses;
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
