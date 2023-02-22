package fr.doranco.tpjsf.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.doranco.tpjsf.entity.Adresse;

@ManagedBean(name = "adresseBean")
@SessionScoped
public class AdresseBean implements Serializable {

	private String numero;
	private String rue;
	private String codePostal;
	private String ville;

	private static final List<Adresse> adresseList = new ArrayList<Adresse>(Arrays.asList());

	public List<Adresse> getAdresseList() {
		return adresseList;
	}

	public AdresseBean() {
	}

	public List<String> getListeVille() {
		return Arrays.asList("paris", "lille", "lyon", "toulon");
	}

	public String getRue() {
		return rue;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public AdresseBean(String numero, String rue, String codePostal, String ville) {

		this.numero = numero;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
	}

	public void addAdresse() {
		adresseList.add(new Adresse(this.numero, this.rue, this.codePostal, this.ville));
	}

}
