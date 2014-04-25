package Pidev.entite;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;


@SuppressWarnings("serial")
@Entity
public class Corporate extends Client {
	/**
	 * 
	 */

	private double capitale;
	
	@OneToMany(fetch = FetchType.LAZY)
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
