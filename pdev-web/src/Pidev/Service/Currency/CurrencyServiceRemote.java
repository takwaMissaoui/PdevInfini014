package Pidev.Service.Currency;

import java.util.List;

import javax.ejb.Remote;

import Pidev.entite.Currency;

@Remote
public interface CurrencyServiceRemote {

	public void add(Currency currency);

	public void update(Currency currency);

	public Currency findBy(String id);

	public List<Currency> findall();

	public List<Currency> findAvailables();


	public void delete(Currency currency);
	public void setLocal(Currency currency);
	public List<String> findallIds();
	
	public List<String> findallAvailableIds();

}
