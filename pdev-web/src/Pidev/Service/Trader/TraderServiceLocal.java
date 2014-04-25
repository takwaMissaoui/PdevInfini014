package Pidev.Service.Trader;

import java.util.List;

import javax.ejb.Local;

import Pidev.entite.Trader;
@Local
public interface TraderServiceLocal {
	void add(Trader trader);

	void update(Trader trader);

	Trader findByID(int id);
    Trader findByLogin(String login);
	List<Trader> findAll();

	void delete(Trader trader);
}
