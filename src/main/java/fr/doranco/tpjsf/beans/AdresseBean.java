package fr.doranco.tpjsf.beans;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.doranco.tpjsf.entity.Adresse;

@ManagedBean(name = "adresseBean")
@SessionScoped
public class AdresseBean {

	private short numero;
	private String rue;
	private String codePostal;
	private String ville;

	private static final List<Adresse> adresseList = new ArrayList<Adresse>(Arrays.asList());

	public List<Adresse> getAdresseList() {
		return adresseList;
	}

	public static List<Adresse> getAdresselist() {
		return adresseList;
	}

	public AdresseBean() {
	}

	public List<String> getListeVille() {
		return Arrays.asList("paris", "lille", "lyon", "toulon");
	}

	public short getNumero() {
		return numero;
	}

	public void setNumero(short numero) {
		this.numero = numero;
	}

	public String getRue() {
		return rue;
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

	public AdresseBean(short numero, String rue, String codePostal, String ville) {

		this.numero = numero;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
	}

	public void addAdresse() {
		adresseList.add(new Adresse(this.numero, this.rue, this.codePostal, this.ville));
	}

}
