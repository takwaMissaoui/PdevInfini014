package Pidev.entite;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "t_Client")
public class Client implements Serializable {
	/**
	 * 
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	protected int idClient;

	protected String libelle;

	@Column(unique = true)
	protected String address;

	@Column(unique = true, nullable = false)
	protected String mail;

	@Column(unique = true, nullable = false)
	protected String login;

	@Column(nullable = false)
	protected String pass;

	@Column(name = "num_telephone")
	protected String tel;
	
	protected String descreption;

	@OneToMany(mappedBy = "buyer", fetch = FetchType.LAZY)
	protected List<Transaction> transactionBuyer;

	@OneToMany(mappedBy = "seller", fetch = FetchType.LAZY)
	protected List<Transaction> transactionSeller;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "Client_Trader", joinColumns = { @JoinColumn(name = "Client_fk") }, inverseJoinColumns = { @JoinColumn(name = "Trader_fk") })
	protected Set<Trader> trader;

	public Client() {

	}

	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idClient;
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
		Client other = (Client) obj;
		if (idClient != other.idClient)
			return false;
		return true;
	}

	public Set<Trader> getTrader() {
		return trader;
	}

	public void setTrader(Set<Trader> trader) {
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

	@Override
	public String toString() {
		return "Client [idClient=" + idClient + ", libelle=" + libelle
				+ ", address=" + address + ", mail=" + mail + ", login="
				+ login + ", pass=" + pass + ", tel=" + tel
				+ ", transactionBuyer=" + transactionBuyer
				+ ", transactionSeller=" + transactionSeller + ", trader="
				+ trader + "]";
	}

	public String getDescreption() {
		return descreption;
	}

	public void setDescreption(String descreption) {
		this.descreption = descreption;
	}

}
