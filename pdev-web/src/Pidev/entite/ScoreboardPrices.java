package Pidev.entite;

import java.io.Serializable;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "t_scoreboard_prices")
public class ScoreboardPrices implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_scoreboard")
	private int id;
	
	
	@ElementCollection
	@CollectionTable(name = "Price")
	@MapKeyColumn(name = "Currency")
	@Column(name = "AskBid")
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable
    private Map<Currency,AskBid> price;

	public ScoreboardPrices() {

	}

	public void add(Currency currency, AskBid askbid) {
		this.price.put(currency, askbid);
	}

	public void update(Currency currency, AskBid askbid) {
		if(this.price.containsKey(currency))
			{this.price.remove(currency);
			 this.price.put(currency, askbid);
			}
		else this.price.put(currency, askbid);
	}

	public void delete(Currency currency) {
		if(this.price.containsKey(currency))
		this.price.remove(currency);
	}

	public AskBid getPriceCurrency(Currency currency) {
		return this.price.get(currency);
	}

	public double getAsk(Currency currency) {
		return this.price.get(currency).getAsk();
	}

	public double getBid(Currency currency) {
		return this.price.get(currency).getBid();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}





	public Map<Currency, AskBid> getPrice() {
		return price;
	}

	public void setPrice(Map<Currency, AskBid> price) {
		this.price = price;
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
		return "ScoreboardPrices [id=" + id + ", price=" + price + "]";
	}



}
