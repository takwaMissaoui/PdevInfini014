package Pidev.entite;

import javax.persistence.Entity;

@Entity

	

public class Corporate extends Client  {
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private double Capitale;
	public Corporate() {
	super();
	}
	public double getCapitale() {
		return Capitale;
	}
	public void setCapitale(double capitale) {
		Capitale = capitale;
	}
	@Override
	public String toString() {
		return "Corporate [Capitale=" + Capitale + ", ID_Client=" + ID_Client
				+ ", Libelle=" + Libelle + ", Adresse=" + Adresse + ", Mail="
				+ Mail + ", Tel=" + Tel + ", transaction=" 
				+ ", trader=" + trader + "]";
	}
	
	
	

}
