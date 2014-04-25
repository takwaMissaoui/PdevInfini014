package Pidev.Service.Admin;

import java.util.List;

import javax.ejb.Remote;

import Pidev.entite.Admin;
import Pidev.entite.BanqueCentrale;
import Pidev.entite.Currency;

@Remote
public interface AdminServiceRemote {
	void add(Admin admin);

	void update(Admin admin);

	void remove(Admin admin);
	
	Admin findByID(int id);

	List<Admin> findAll();

	void setLocalCurrency(Currency currency);

	void addCentralBank(BanqueCentrale banqueCentrale);

	void addCurrency(String id_currency, String name);

}
