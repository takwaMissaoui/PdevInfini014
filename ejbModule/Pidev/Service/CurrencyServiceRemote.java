package Pidev.Service;

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

}
