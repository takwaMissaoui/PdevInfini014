package Pidev.entite;

import java.awt.Point;
import java.io.Serializable;
import java.util.Currency;
import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToOne;

@SuppressWarnings("serial")
@Entity
public class ScoreboardPrices implements Serializable {
	@Id
	private int id;
@OneToOne
private BanqueCommercial BK;
@ElementCollection   
@CollectionTable(name="Price")    
@MapKeyColumn(name = "Currency")    
@Column(name = "AskBid")
private Map<Currency, Point>Price;

	public ScoreboardPrices() {
	
	}
	public void add(Currency C,Point P){}
	public void update(Currency C,Point P){}
	public void delete(Currency C){}
	public Point getPrice(Currency C){return null;}
	public double getAsk(Currency C){return 0.0;}
	public double getBid(Currency C){return 0.0;}
	public Map<Currency,Point>FindAll(){return null;}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public BanqueCommercial getBK() {
		return BK;
	}
	public void setBK(BanqueCommercial bK) {
		BK = bK;
	}
	public Map<Currency, Point> getPrice() {
		return Price;
	}
	public void setPrice(Map<Currency, Point> price) {
		Price = price;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		ScoreboardPrices other = (ScoreboardPrices) obj;
		if (id != other.id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ScoreboardPrices [id=" + id + ", BK=" + BK + ", Price=" + Price
				+ "]";
	}
	

}
