package fr.ncg.mygardenguardian.entites;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
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
	@ManyToOne
	@JoinColumn(name = "id_plante", nullable = false)
	private Plante plante;
	@OneToMany(mappedBy = "culture")
	private List<OperationCulturale> operationsCulturales;
	@OneToMany(mappedBy = "culture")
	private List<Intrant> intrants;
	@OneToMany(mappedBy = "culture")
	private List<CalendrierCultural> listeParcelles;
	@Column(name = "en_construction", nullable = false, columnDefinition = "boolean default true")
	private boolean enConstruction;
	@ManyToOne
	@JoinColumn(name = "id_utilisateur")
	private Utilisateur utilisateur;

	public Culture() {
	}

	public Culture(boolean enConstruction) {
		this.enConstruction = enConstruction;
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

	public void addParcelle(Parcelle parcelle, Date date) {
		if (this.listeParcelles == null) {
			this.listeParcelles = new ArrayList<CalendrierCultural>();
		}
		CalendrierCultural cal = new CalendrierCultural();
		cal.setCulture(this);
		cal.setDate(date);
		cal.setIdCulture(this.getIdCulture());
		cal.setParcelle(parcelle);
		cal.setIdParcelle(parcelle.getIdParcelle());
		this.listeParcelles.add(cal);
		parcelle.getListeCultures().add(cal);

	}

	public List<CalendrierCultural> getListeParcelles() {
		return this.listeParcelles;
	}

	public void setListeParcelles(List<CalendrierCultural> listeParcelles) {
		this.listeParcelles = listeParcelles;
	}

	public Utilisateur getUtilisateur() {
		return this.utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	@Override
	public String toString() {
		return "Culture [idCulture=" + this.idCulture + ", plante=" + this.plante + ", intrants=" + this.intrants
				+ ", listeParcelles=" + this.listeParcelles + ", enConstruction=" + this.enConstruction + "]";
	}

}
