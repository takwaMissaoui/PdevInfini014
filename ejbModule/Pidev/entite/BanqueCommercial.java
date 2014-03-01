package Pidev.entite;

import java.util.List;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity

public class BanqueCommercial extends Client {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double ValeurPropre;
	@OneToOne
	@JoinColumn(name="Scoreboard_FK")
	private ScoreboardPrices scoreboard;
	@OneToMany(fetch = FetchType.LAZY)
	private List<CurrencyAccount>account;
    
	
    
	public BanqueCommercial() {
		// TODO Auto-generated constructor stub
	}



	public double getValeurPropre() {
		return ValeurPropre;
	}



	public void setValeurPropre(double valeurPropre) {
		ValeurPropre = valeurPropre;
	}
	

}
