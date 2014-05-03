package Pidev.entite;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@SuppressWarnings("serial")
@Entity

public class BanqueCommercial extends Client {
	/**
	 * 
	 */
	@Column(name = "req_confirmed")
	private boolean reqConfirmed;

	@Column(name = "fond_propre")
	private double fondPropre;

	@OneToOne( fetch = FetchType.LAZY)
	@JoinColumn(name = "Scoreboard_FK")
	private ScoreboardPrices scoreboard;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "Banque_Account", joinColumns = { @JoinColumn(name = "Banque_fk") }, inverseJoinColumns = { @JoinColumn(name = "Account_fk") })
	private Set<CurrencyAccountBanque> account;

	public BanqueCommercial() {
		this.reqConfirmed = false;
	}

	public double getFondPropre() {
		return fondPropre;
	}

	public void setFondPropre(double fondPropre) {
		this.fondPropre = fondPropre;
	}

	public boolean isReqConfirmed() {
		return reqConfirmed;
	}

	public void setReqConfirmed(boolean reqConfirmed) {
		this.reqConfirmed = reqConfirmed;
	}

	public ScoreboardPrices getScoreboard() {
		return scoreboard;
	}

	public void setScoreboard(ScoreboardPrices scoreboard) {
		this.scoreboard = scoreboard;
	}

	public Set<CurrencyAccountBanque> getAccount() {
		return account;
	}

	public void setAccount(Set<CurrencyAccountBanque> account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "BanqueCommercial [reqConfirmed=" + reqConfirmed
				+ ", fondPropre=" + fondPropre + ", scoreboard=" + scoreboard
				+ ", account=" + account + "]";
	}

}
