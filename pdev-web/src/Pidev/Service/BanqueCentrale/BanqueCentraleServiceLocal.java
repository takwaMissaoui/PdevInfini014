package Pidev.Service.BanqueCentrale;

import java.util.List;

import javax.ejb.Local;

import Pidev.entite.BanqueCentrale;
import Pidev.entite.BanqueCommercial;
import Pidev.entite.Currency;

@Local
public interface BanqueCentraleServiceLocal {
	void add(BanqueCentrale B);

	void update(BanqueCentrale B);

	BanqueCentrale findByID(int ID);

	List<BanqueCentrale> findAll();

	void delete(BanqueCentrale B);

	void setAvailable_currency(Currency cl, boolean val);
	
	void accept_request(BanqueCommercial banqueCommerciale);
	
	void delete_request(BanqueCommercial banqueCommerciale);
}
