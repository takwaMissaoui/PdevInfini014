package Pidev.Service.Corporate;

import java.util.List;

import javax.ejb.Remote;

import Pidev.entite.Corporate;

@Remote
public interface CorporateServiceRemote {
	void add(Corporate corporate);

	void update(Corporate corporate);

	Corporate findByID(int id);

	List<Corporate> findAll();

	void delete(Corporate corporate);

}
