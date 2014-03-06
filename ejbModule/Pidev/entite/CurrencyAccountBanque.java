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
@Table(name = "t_currency_account_banque")
public class CurrencyAccountBanque implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_account_banque")
	private int idAccountBanque;

	@ManyToOne(fetch = FetchType.EAGER)
	private Currency currency;

	private float amount;

	public CurrencyAccountBanque() {
		// TODO Auto-generated constructor stub
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idAccountBanque;
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
		CurrencyAccountBanque other = (CurrencyAccountBanque) obj;
		if (idAccountBanque != other.idAccountBanque)
			return false;
		return true;
	}

	public int getIdAccountBanque() {
		return idAccountBanque;
	}

	public void setIdAccountBanque(int idAccountBanque) {
		this.idAccountBanque = idAccountBanque;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public void supplyAccount(double d) {
		this.amount += d;
	}

	public void liquidetAccount(double d) {
		this.amount -= d;
	}

	@Override
	public String toString() {
		return "CurrencyAccountBanque [idAccountBanque=" + idAccountBanque
				+ ", currency=" + currency + ", amount=" + amount + "]";
	}

}
