














package Pidev.entite;

import java.io.Serializable;
import java.util.Currency;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@SuppressWarnings("serial")
@Entity
public class Transaction implements Serializable {
	@Id
	@GeneratedValue
	private int ID_Transaction;
	@ManyToOne (fetch = FetchType.EAGER)
	private Client Buyer;
	@ManyToOne (fetch = FetchType.EAGER)
	
	private Client Seller;
	@Temporal(TemporalType.TIMESTAMP)
	private Date date_transaction;
    private Currency curr;
    private double CurrencyAmount;
    private double CurrPrice;
    private double Amount_Ctr_Price;
	


	public Currency getCurr() {
		return curr;
	}




	public void setCurr(Currency curr) {
		this.curr = curr;
	}




	public double getCurrencyAmount() {
		return CurrencyAmount;
	}




	public void setCurrencyAmount(double currencyAmount) {
		CurrencyAmount = currencyAmount;
	}




	public double getCurrPrice() {
		return CurrPrice;
	}




	public void setCurrPrice(double currPrice) {
		CurrPrice = currPrice;
	}




	public double getAmount_Ctr_Price() {
		return Amount_Ctr_Price;
	}




	public void setAmount_Ctr_Price(double amount_Ctr_Price) {
		Amount_Ctr_Price = amount_Ctr_Price;
	}




	public Transaction() {
		
	}




	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ID_Transaction;
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
		Transaction other = (Transaction) obj;
		if (ID_Transaction != other.ID_Transaction)
			return false;
		return true;
	}




	@Override
	public String toString() {
		return "Transaction [ID_Transaction=" + ID_Transaction ;
	}




	public int getID_Transaction() {
		return ID_Transaction;
	}




	public void setID_Transaction(int iD_Transaction) {
		ID_Transaction = iD_Transaction;
	}




	public Client getBuyer() {
		return Buyer;
	}




	public void setBuyer(Client buyer) {
		Buyer = buyer;
	}




	public Client getSeller() {
		return Seller;
	}




	public void setSeller(Client seller) {
		Seller = seller;
	}




	public Date getDate_transaction() {
		return date_transaction;
	}




	public void setDate_transaction(Date date_transaction) {
		this.date_transaction = date_transaction;
	}
	

}
