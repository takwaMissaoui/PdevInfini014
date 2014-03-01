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
public class Position implements Serializable {
	@Id @GeneratedValue
    private int ID_Position;
	@ManyToOne (fetch = FetchType.EAGER)
	private BanqueCommercial BK;
	private Currency currency;
	private double Amount;
	
	public Position() {
		// TODO Auto-generated constructor stub
	}

	public int getID_Position() {
		return ID_Position;
	}

	public void setID_Position(int iD_Position) {
		ID_Position = iD_Position;
	}

	public BanqueCommercial getBK() {
		return BK;
	}

	public void setBK(BanqueCommercial bK) {
		BK = bK;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ID_Position;
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
		Position other = (Position) obj;
		if (ID_Position != other.ID_Position)
			return false;
		return true;
	}
	public void chargerPosition(double D){this.Amount+=D;}
    public void dechargerPosition(double D){this.Amount-=D;}

	@Override
	public String toString() {
		return "Position [ID_Position=" + ID_Position + ", BK=" + BK
				+ ", currency=" + currency + ", Amount=" + Amount + "]";
	}
    

}
