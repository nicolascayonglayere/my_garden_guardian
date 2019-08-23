package fr.ncg.mygardenguardian.entites;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "culture", schema = "garden_guardian")
public class Culture implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_culture")
	private Integer idCulture;
	@Column(name = "nom", nullable = false)
	private String nom;
	@ManyToOne
	@JoinColumn(name = "id_plante", nullable = false)
	private Plante plante;
	@OneToMany(mappedBy = "culture")
	private List<OperationCulturale> operationsCulturales;
	@OneToMany(mappedBy = "culture")
	private List<Intrant> intrants;
	@OneToMany(mappedBy = "culture")
	private List<CultureInstance> listeCulturesInstances;
	@Column(name = "en_construction", nullable = false, columnDefinition = "boolean default true")
	private boolean enConstruction;
	@ManyToOne
	@JoinColumn(name = "id_utilisateur")
	private Utilisateur utilisateur;
	@Column(name = "recommandation_basse", nullable = false)
	private Integer recommandationBasse;
	@Column(name = "recommandation_haute", nullable = false)
	private Integer recommandationHaute;

	public Culture() {
	}

	public Culture(String nom, boolean enConstruction, Integer recommandationBasse, Integer recommandationHaute) {
		this.nom = nom;
		this.enConstruction = enConstruction;
		this.recommandationBasse = recommandationBasse;
		this.recommandationHaute = recommandationHaute;
	}

	public boolean isEnConstruction() {
		return this.enConstruction;
	}

	public void setEnConstruction(boolean enConstruction) {
		this.enConstruction = enConstruction;
	}

	public Integer getIdCulture() {
		return this.idCulture;
	}

	public void setIdCulture(Integer idCulture) {
		this.idCulture = idCulture;
	}

	public Plante getPlante() {
		return this.plante;
	}

	public void setPlante(Plante plante) {
		this.plante = plante;
	}

	public List<OperationCulturale> getOperationsCulturales() {
		return this.operationsCulturales;
	}

	public void setOperationsCulturales(List<OperationCulturale> operationsCulturales) {
		this.operationsCulturales = operationsCulturales;
	}

	public List<Intrant> getIntrants() {
		return this.intrants;
	}

	public void setIntrants(List<Intrant> intrants) {
		this.intrants = intrants;
	}

	public void addIntrant(Intrant i) {
		if (this.intrants == null) {
			this.intrants = new ArrayList<Intrant>();
		}
		this.intrants.add(i);
	}

	public void addOperationCulturale(OperationCulturale op) {
		if (this.operationsCulturales == null) {
			this.operationsCulturales = new ArrayList<OperationCulturale>();
		}
		this.operationsCulturales.add(op);
	}

	public List<CultureInstance> getlisteCulturesInstances() {
		return this.listeCulturesInstances;
	}

	public void setlisteCulturesInstances(List<CultureInstance> listeCulturesInstances) {
		this.listeCulturesInstances = listeCulturesInstances;
	}

	public void addCultureInstance(CultureInstance culture) {
		if (this.listeCulturesInstances == null) {
			this.listeCulturesInstances = new ArrayList<CultureInstance>();
		}
		this.listeCulturesInstances.add(culture);
	}

	public Utilisateur getUtilisateur() {
		return this.utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Integer getRecommandationBasse() {
		return this.recommandationBasse;
	}

	public void setRecommandationBasse(Integer recommandationBasse) {
		this.recommandationBasse = recommandationBasse;
	}

	public Integer getRecommandationHaute() {
		return this.recommandationHaute;
	}

	public void setRecommandationHaute(Integer recommandationHaute) {
		this.recommandationHaute = recommandationHaute;
	}

	@Override
	public String toString() {
		return "Culture [idCulture=" + this.idCulture + ", nom=" + this.nom + ", plante=" + this.plante
//				+ ", operationsCulturales=" + this.operationsCulturales + ", intrants=" + this.intrants
				+ ", enConstruction=" + this.enConstruction + ", utilisateur=" + this.utilisateur
				+ ", recommandationBasse=" + this.recommandationBasse + ", recommandationHaute="
				+ this.recommandationHaute + "]";
	}

}
