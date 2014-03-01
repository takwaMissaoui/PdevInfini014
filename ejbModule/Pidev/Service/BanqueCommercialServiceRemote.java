package Pidev.Service;

import java.util.List;

import javax.ejb.Remote;

import Pidev.entite.BanqueCommercial;

@Remote
public interface BanqueCommercialServiceRemote {
	void add(BanqueCommercial B);
	void update(BanqueCommercial B);
	BanqueCommercial findByID(int ID);
	 List<BanqueCommercial> findAll();
	 void delete(BanqueCommercial B);

}
