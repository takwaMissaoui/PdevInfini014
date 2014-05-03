package Pidev.Service.Currency;

import java.util.List;

import javax.ejb.Local;

import Pidev.entite.Currency;
@Local
public interface CurrencyServiceLocal {

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
