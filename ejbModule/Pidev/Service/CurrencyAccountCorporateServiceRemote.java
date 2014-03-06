package Pidev.Service;

import java.util.List;

import javax.ejb.Remote;

import Pidev.entite.CurrencyAccountCorporate;

@Remote
public interface CurrencyAccountCorporateServiceRemote {
	void add(CurrencyAccountCorporate accountC);

	void update(CurrencyAccountCorporate accountC);

	CurrencyAccountCorporate findByID(int id);

	List<CurrencyAccountCorporate> findAll();

	void delete(CurrencyAccountCorporate accountC);

}
