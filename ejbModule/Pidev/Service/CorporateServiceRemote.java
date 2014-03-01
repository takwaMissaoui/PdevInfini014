package Pidev.Service;

import java.util.List;

import javax.ejb.Remote;

import Pidev.entite.Corporate;

@Remote
public interface CorporateServiceRemote {
	void add(Corporate C);
	void update(Corporate C);
	 Corporate findByID(int ID);
	 List<Corporate> findAll();
	 void delete(Corporate C);

}
