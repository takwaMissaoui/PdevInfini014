package Pidev.Service.CurrencyAccountBanque;

import java.util.List;

import javax.ejb.Local;

import Pidev.entite.CurrencyAccountBanque;
@Local
public interface CurrencyAccountBanqueServiceLocal {
	void add(CurrencyAccountBanque accountB);

	void update(CurrencyAccountBanque accountB);

	CurrencyAccountBanque findByID(int id);

	List<CurrencyAccountBanque> findAll();

	void delete(CurrencyAccountBanque accountB);
}
