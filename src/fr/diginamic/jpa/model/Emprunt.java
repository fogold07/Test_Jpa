package fr.diginamic.jpa.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "EMPRUNT")
public class Emprunt {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Temporal(TemporalType.DATE)
	@Column(name="DATE_DEBUT")
	private Date date_debut;
	
	@Column(name="DELAI", nullable = true)
	private int delai;
	
	@Temporal(TemporalType.DATE)
	@Column(name="DATE_FIN", nullable = true)
	private Date date_fin;
	
	@ManyToOne
	@JoinColumn(name="ID_CLIENT")
	private Client clientEmp;
	
	@ManyToMany
	@JoinTable(name = "COMPO",
			   joinColumns = @JoinColumn(name="ID_EMP", referencedColumnName = "ID"),
			   inverseJoinColumns = @JoinColumn(name="ID_LIV", referencedColumnName = "ID")
			)
	private Set<Livre> empLivres;
	
	public Emprunt() {
		empLivres = new HashSet<>();
	}
	
	

	public Set<Livre> getEmpLivres() {
		return empLivres;
	}



	public void setEmpLivres(Set<Livre> empLivres) {
		this.empLivres = empLivres;
	}



	public Client getClientEmp() {
		return clientEmp;
	}



	public void setClientEmp(Client clientEmp) {
		this.clientEmp = clientEmp;
	}



	public int getId() {
		return id;
	}

	public Date getDate_debut() {
		return date_debut;
	}

	public int getDelai() {
		return delai;
	}

	public Date getDate_fin() {
		return date_fin;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setDate_debut(Date date_debut) {
		this.date_debut = date_debut;
	}

	public void setDelai(int delai) {
		this.delai = delai;
	}

	public void setDate_fin(Date date_fin) {
		this.date_fin = date_fin;
	}



	@Override
	public String toString() {
		return "Emprunt [id=" + id + ", date_debut=" + date_debut + ", delai=" + delai + ", date_fin=" + date_fin + "]";
	}



}
