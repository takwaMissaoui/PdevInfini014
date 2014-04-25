package Pidev.entite;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "t_trader")
public class Trader implements Serializable  {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_trader")
	private int idTradeur;

	private String libelle;

	@Column(nullable = false, unique = true)
	private String login;

	@Column(nullable = false)
	private String password;

	@Column(nullable = false, unique = true)
	private String mail;

	public Trader() {
		// TODO Auto-generated constructor stub
	}

	public int getIdTradeur() {
		return idTradeur;
	}

	public void setIdTradeur(int idTradeur) {
		this.idTradeur = idTradeur;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idTradeur;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Trader other = (Trader) obj;
		if (idTradeur != other.idTradeur)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Trader [idTradeur=" + idTradeur + ", libelle=" + libelle
				+ ", login=" + login + ", password=" + password + ", mail="
				+ mail + "]";
	}
	
	

}
