package Pidev.entite;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "currency")
public class Currency implements Serializable {

	@Id
	private String id_currency;
	@Column(unique = true)
	private String name;
	private boolean is_local_currency;
	private boolean is_available;

	public void setIs_local_currency(boolean is_local_currency) {
		this.is_local_currency = is_local_currency;
	}

	public Currency(String id_currency, String name) {
		super();
		this.id_currency = id_currency;
		this.name = name;
		this.is_available = false;
		this.is_local_currency = false;
	}

	public boolean isIs_available() {
		return is_available;
	}

	public void setIs_available(boolean is_available) {
		this.is_available = is_available;
	}

	public Currency() {
		super();
		this.is_available = false;
		this.is_local_currency = false;
	}

	public String getId_currency() {
		return id_currency;
	}

	public void setId_currency(String id_currency) {
		this.id_currency = id_currency;
	}

	public boolean isIs_local_currency() {
		return is_local_currency;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Currency [id_currency=" + id_currency + ", name=" + name
				+ ", is_local_currency=" + is_local_currency + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((id_currency == null) ? 0 : id_currency.hashCode());
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
		Currency other = (Currency) obj;
		if (id_currency == null) {
			if (other.id_currency != null)
				return false;
		} else if (!id_currency.equals(other.id_currency))
			return false;
		return true;
	}

}
