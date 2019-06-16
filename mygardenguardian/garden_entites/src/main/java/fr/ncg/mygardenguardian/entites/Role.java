package fr.ncg.mygardenguardian.entites;

import java.io.Serializable;

//@Entity
//@Table(name = "role", schema = "garden_guardian")
public class Role implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name = "id_role")
	private Integer idRole;

	// @Enumerated(EnumType.STRING)
//	@Column(name = "role", nullable = false)
	private String role;

	public Role() {
	}

	public Role(String role) {
		this.role = role;
	}

	public Integer getIdRole() {
		return this.idRole;
	}

	public void setIdRole(Integer idRole) {
		this.idRole = idRole;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Role [idRole=" + this.idRole + ", role=" + this.role + "]";
	}

}
