package fr.ncg.mygardenguardian.webapp.formulaire;

public class AdhesionModifJardinierFormulaire {

	private Integer idUtilisateur;
	private Integer idParcelle;

	public Integer getIdUtilisateur() {
		return this.idUtilisateur;
	}

	public void setIdUtilisateur(Integer idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	public Integer getIdParcelle() {
		return this.idParcelle;
	}

	public void setIdParcelle(Integer idParcelle) {
		this.idParcelle = idParcelle;
	}

	@Override
	public String toString() {
		return "AdhesionModifJardinierFormulaire [idUtilisateur=" + this.idUtilisateur + ", idParcelle="
				+ this.idParcelle + "]";
	}

}
