package Pidev.entite;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@SuppressWarnings("serial")
@Entity
public class Trader implements Serializable {
	@Id @GeneratedValue
	private int idTradeur;
    private String Libelle;
    private String Login;
    private String pass;
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
		return Libelle;
	}
	public void setLibelle(String libelle) {
		Libelle = libelle;
	}
	public String getLogin() {
		return Login;
	}
	public void setLogin(String login) {
		Login = login;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	@Override
	public String toString() {
		return "Trader [idTradeur=" + idTradeur + ", Libelle=" + Libelle
				+ ", Login=" + Login + ", pass=" + pass + "]";
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

}

