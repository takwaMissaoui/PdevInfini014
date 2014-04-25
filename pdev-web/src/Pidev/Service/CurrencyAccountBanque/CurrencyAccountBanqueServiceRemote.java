package Pidev.Service.CurrencyAccountBanque;

import java.util.List;

import javax.ejb.Remote;

import Pidev.entite.CurrencyAccountBanque;

@Remote
public interface CurrencyAccountBanqueServiceRemote {
	void add(CurrencyAccountBanque accountB);

	void update(CurrencyAccountBanque accountB);

	CurrencyAccountBanque findByID(int id);

	List<CurrencyAccountBanque> findAll();

	void delete(CurrencyAccountBanque accountB);

}
