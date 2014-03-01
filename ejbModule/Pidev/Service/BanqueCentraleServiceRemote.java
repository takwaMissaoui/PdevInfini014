package Pidev.Service;

import java.util.List;

import javax.ejb.Remote;

import Pidev.entite.BanqueCentrale;

@Remote
public interface BanqueCentraleServiceRemote {
	void add(BanqueCentrale B);
	void update(BanqueCentrale B);
	BanqueCentrale findByID(int ID);
	 List<BanqueCentrale> findAll();
	 void delete(BanqueCentrale B);

}
