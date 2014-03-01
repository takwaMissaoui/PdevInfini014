package Pidev.Service;

import java.util.List;

import javax.ejb.Remote;

import Pidev.entite.Trader;

@Remote
public interface TraderServiceRemote {
	void add(Trader T);
	void update(Trader T);
	Trader findByID(int ID);
	 List<Trader> findAll();
	 void delete(Trader T);

}
