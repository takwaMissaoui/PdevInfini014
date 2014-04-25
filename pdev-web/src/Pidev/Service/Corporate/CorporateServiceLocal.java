package Pidev.Service.Corporate;

import java.util.List;

import javax.ejb.Local;

import Pidev.entite.Corporate;
@Local
public interface CorporateServiceLocal {
	void add(Corporate corporate);

	void update(Corporate corporate);

	Corporate findByID(int id);

	List<Corporate> findAll();

	void delete(Corporate corporate);

}
