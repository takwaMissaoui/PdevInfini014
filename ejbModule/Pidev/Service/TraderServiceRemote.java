package Pidev.Service;

import java.util.List;

import javax.ejb.Remote;

import Pidev.entite.Trader;

@Remote
public interface TraderServiceRemote {
	void add(Trader trader);

	void update(Trader trader);

	Trader findByID(int id);

	List<Trader> findAll();

	void delete(Trader trader);

}
