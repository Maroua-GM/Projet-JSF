package fr.doranco.tpjsf.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import fr.doranco.tpjsf.entity.Adresse;
import fr.doranco.tpjsf.entity.User;
import fr.doranco.tpjsf.metier.UserMetier;

@ManagedBean(name = "userBean")
@SessionScoped
public class UserBean implements Serializable {

	UserMetier userMetier = new UserMetier();

	@ManagedProperty(value = "#{adresseBean}")
	private AdresseBean adresseBean;

	private int id;
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
	private String password;

//injection de l'adresse managed bean
	public AdresseBean getAdresseBean() {
		return adresseBean;
	}

	public void setAdresseBean(AdresseBean adresseBean) {
		this.adresseBean = adresseBean;
	}

	private static final List<User> userList = new ArrayList<User>(Arrays.asList());

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<User> getUserList() {
		return userList;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void addUser() {
		User user = new User();

	}

	public void inscription() throws Exception {

		User user = new User(this.nom, this.prenom, this.dateNaissance, this.genre, this.email, this.niveauDeService,
				this.telephone, this.fonctionActuelle, this.disponible, this.password);

		for (Adresse adresse : adresseBean.getAdresseList()) {
			user.getAdresses().add(adresse);
			this.adresses.add(adresse);
		}
		// demander la methode add User (la couche metier)
		User user2 = userMetier.addUser(user);
		userList.add(user);

	}

	public List<Adresse> getAdresses() {
		return adresses;
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
		adresses = new ArrayList<Adresse>();
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
