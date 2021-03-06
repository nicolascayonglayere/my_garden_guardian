package fr.ncg.mygardenguardian.entites;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entite de persistence CoordonneesUtilisateur
 * 
 * @author nicolas
 *
 */
@Entity
@Table(name = "coordonnees_utilisateur", schema = "garden_guardian")
public class CoordonneesUtilisateur implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_coordonnee")
	private Integer idCoordonneesUtilisateur;
	@Column(name = "portable")
	private String numPortable;
	@Column(name = "email")
	private String email;
	@Column(name = "adresse")
	private String adresse;
	@Column(name = "ville")
	private String ville;
	@Column(name = "code_postal")
	private String codePostal;

	public CoordonneesUtilisateur() {
	}

	public CoordonneesUtilisateur(String numPortable, String email, String adresse, String ville, String codePostal) {
		this.numPortable = numPortable;
		this.email = email;
		this.adresse = adresse;
		this.ville = ville;
		this.codePostal = codePostal;
	}

	public Integer getIdCoordonneesUtilisateur() {
		return this.idCoordonneesUtilisateur;
	}

	public void setIdCoordonneesUtilisateur(Integer idCoordonneesUtilisateur) {
		this.idCoordonneesUtilisateur = idCoordonneesUtilisateur;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdresse() {
		return this.adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getVille() {
		return this.ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getNumPortable() {
		return this.numPortable;
	}

	public void setNumPortable(String numPortable) {
		this.numPortable = numPortable;
	}

	public String getCodePostal() {
		return this.codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	@Override
	public String toString() {
		return "CoordonneesUtilisateur [idCoordonneesUtilisateur=" + this.idCoordonneesUtilisateur + ", numPortable="
				+ this.numPortable + ", email=" + this.email + ", adresse=" + this.adresse + ", ville=" + this.ville
				+ ", codePostal=" + this.codePostal + "]";
	}

}
