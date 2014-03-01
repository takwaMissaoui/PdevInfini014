package Pidev.entite;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@SuppressWarnings("serial")
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Client implements Serializable {
	/**
	 * 
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected int ID_Client;
	protected String Libelle;
	protected String Adresse;
	protected String Mail;
	protected Long Tel;

	@OneToMany(mappedBy = "Buyer", fetch = FetchType.LAZY)
	protected List<Transaction> transactionBuyer = new ArrayList<Transaction>();

	@OneToMany(mappedBy = "Seller", fetch = FetchType.LAZY)
	protected List<Transaction> transactionSeller = new ArrayList<Transaction>();

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "Client_Trader", joinColumns = { @JoinColumn(name = "Client_fk") }, inverseJoinColumns = { @JoinColumn(name = "Trader_fk") })
	protected List<Trader> trader = new ArrayList<Trader>();

	public Client() {

	}

	public int getID_Client() {
		return ID_Client;
	}

	public void setID_Client(int iD_Client) {
		ID_Client = iD_Client;
	}

	public String getLibelle() {
		return Libelle;
	}

	public void setLibelle(String libelle) {
		Libelle = libelle;
	}

	public String getAdresse() {
		return Adresse;
	}

	public void setAdresse(String adresse) {
		Adresse = adresse;
	}

	public String getMail() {
		return Mail;
	}

	public void setMail(String mail) {
		Mail = mail;
	}

	public Long getTel() {
		return Tel;
	}

	public void setTel(Long tel) {
		Tel = tel;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ID_Client;
		return result;
	}

	@Override
	public String toString() {
		return "Client [ID_Client=" + ID_Client + ", Libelle=" + Libelle
				+ ", Adresse=" + Adresse + ", Mail=" + Mail + ", Tel=" + Tel;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		if (ID_Client != other.ID_Client)
			return false;
		return true;
	}

	public List<Trader> getTrader() {
		return trader;
	}

	public void setTrader(List<Trader> trader) {
		this.trader = trader;
	}

	public List<Transaction> getTransactionBuyer() {
		return transactionBuyer;
	}

	public void setTransactionBuyer(List<Transaction> transactionBuyer) {
		this.transactionBuyer = transactionBuyer;
	}

	public List<Transaction> getTransactionSeller() {
		return transactionSeller;
	}

	public void setTransactionSeller(List<Transaction> transactionSeller) {
		this.transactionSeller = transactionSeller;
	}

	public void addTrader(Trader Tr) {
		Trader T = Tr;
		this.trader.add(T);
	}

	public boolean add(Trader e) {
		return trader.add(e);
	}

	public boolean add(Transaction e) {
		return transactionBuyer.add(e);
	}

	public void add(int index, Transaction element) {
		transactionSeller.add(index, element);
	}

}
