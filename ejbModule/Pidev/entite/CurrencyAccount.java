package Pidev.entite;

import java.io.Serializable;
import java.util.Currency;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
public class CurrencyAccount implements Serializable {
	@Id @GeneratedValue
	private int ID_Compte;
	@ManyToOne (fetch = FetchType.EAGER)
	private Corporate corporate;
	private Currency currency;
	private double Amount;

	public CurrencyAccount() {
		// TODO Auto-generated constructor stub
	}

	public int getID_Compte() {
		return ID_Compte;
	}

	public void setID_Compte(int iD_Compte) {
		ID_Compte = iD_Compte;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public double getAmount() {
		return Amount;
	}

	public void setAmount(double amount) {
		Amount = amount;
	}
	
	public Corporate getCorporate() {
		return corporate;
	}

	public void setCorporate(Corporate corporate) {
		this.corporate = corporate;
	}

	public void chargerAccount(double D){this.Amount+=D;}
    public void dechargerAccount(double D){this.Amount-=D;}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ID_Compte;
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
		CurrencyAccount other = (CurrencyAccount) obj;
		if (ID_Compte != other.ID_Compte)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CurrencyAccount [ID_Compte=" + ID_Compte + ", corporate="
				+ corporate + ", currency=" + currency + ", Amount=" + Amount
				+ "]";
	}
    
}
