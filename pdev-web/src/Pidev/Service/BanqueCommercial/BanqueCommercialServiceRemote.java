package Pidev.Service.BanqueCommercial;

import java.util.List;

import javax.ejb.Remote;

import Pidev.entite.AskBid;
import Pidev.entite.BanqueCommercial;
import Pidev.entite.Currency;

@Remote
public interface BanqueCommercialServiceRemote {
	void add(BanqueCommercial B);
	void update(BanqueCommercial B);
	BanqueCommercial findByID(int ID);
	 List<BanqueCommercial> findAll();
	 void delete(BanqueCommercial B);
	 void updatePrices(Currency currency,AskBid ask_bid);
	 //il faut crree un trader apres avoir saisie les donnees de chak trader
	// void addTrader(Trader trader);
	 //void removeTrader(Trader trader);
	 //void modifyTrader(Trader trader);
	 //void addCurrencyAccountBanque(CurrencyAccountBanque currencyAB);
	 

}
