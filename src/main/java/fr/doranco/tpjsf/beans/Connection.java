package fr.doranco.tpjsf.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import fr.doranco.tpjsf.metier.UserMetier;

@ManagedBean(name = "connection")
@SessionScoped
public class Connection {

	// la couche metier
	private final UserMetier userMetier = new UserMetier();

	@ManagedProperty(value = "test@test.com")
	private String email;
	@ManagedProperty(value = "*******")
	private String password;

	public Connection() {
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	// la methode de connection
	public String seConnecter() throws Exception {
		// TODO if ok return "achats.xhtml"
		if (userMetier.seConnecter(this.email, this.password) != null) {
			return "achat";
		} else {
			return "error";
		}

	}

}
