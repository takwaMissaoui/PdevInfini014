package Pidev.Service.CurrencyAccountCorporate;

import java.util.List;

import javax.ejb.Local;

import Pidev.entite.CurrencyAccountCorporate;
@Local
public interface CurrencyAccountCorporateServiceLocal {
	void add(CurrencyAccountCorporate accountC);

	void update(CurrencyAccountCorporate accountC);

	CurrencyAccountCorporate findByID(int id);

	List<CurrencyAccountCorporate> findAll();

	void delete(CurrencyAccountCorporate accountC);
}
