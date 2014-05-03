package Pidev.entite;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "t_currency_account_corporate")
public class CurrencyAccountCorporate implements Serializable,Comparable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_account_corporate")
	private int idAccountCorporate;

	@ManyToOne(fetch = FetchType.EAGER)
	private Currency currency;

	private double amount;

	public CurrencyAccountCorporate() {
		// TODO Auto-generated constructor stub
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public int getIdAccountCorporate() {
		return idAccountCorporate;
	}

	public void setIdAccountCorporate(int idAccountCorporate) {
		this.idAccountCorporate = idAccountCorporate;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idAccountCorporate;
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
		CurrencyAccountCorporate other = (CurrencyAccountCorporate) obj;
		if (idAccountCorporate != other.idAccountCorporate)
			return false;
		return true;
	}

	public void supplyAccount(double d) {
		this.amount += d;
	}

	public void liquidetAccount(double d) {
		this.amount -= d;
	}

	@Override
	public String toString() {
		return "CurrencyAccountCorporate [idAccountCorporate="
				+ idAccountCorporate + ", currency=" + currency + ", amount="
				+ amount + "]";
	}

	@Override
	public int compareTo(Object obj) {
		return((this.idAccountCorporate)-((CurrencyAccountCorporate)obj).getIdAccountCorporate());
	}

}
