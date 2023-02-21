package fr.doranco.tpjsf.enums;

public enum GenreEnum {

	HOMME("Homme"), FEMME("Femme");

	private String genre;

	private GenreEnum(String genre) {
		this.genre = genre;
	}

	public String getValue() {
		return genre;
	}

}
