package Pidev.entite;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;


@SuppressWarnings("serial")
@Entity
public class Corporate extends Client {
	/**
	 * 
	 */

	private double capitale;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "Corporate_Account", joinColumns = { @JoinColumn(name = "Corporate_fk") }, inverseJoinColumns = { @JoinColumn(name = "Account_fk") })
	private Set<CurrencyAccountCorporate> account;

	public Corporate() {

	}

	public double getCapitale() {
		return capitale;
	}

	public void setCapitale(double capitale) {
		this.capitale = capitale;
	}

	public Set<CurrencyAccountCorporate> getAccount() {
		return account;
	}

	public void setAccount(Set<CurrencyAccountCorporate> account) {
		this.account = account;
	}



}
