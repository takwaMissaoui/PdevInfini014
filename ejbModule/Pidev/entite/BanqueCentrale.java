package Pidev.entite;


import javax.persistence.Entity;

@Entity

public class BanqueCentrale extends Client {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String Type;
	
    public BanqueCentrale() {
	
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}

}
