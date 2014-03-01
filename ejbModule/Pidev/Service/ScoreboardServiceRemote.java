package Pidev.Service;

import java.util.List;

import javax.ejb.Remote;

import Pidev.entite.ScoreboardPrices;



@Remote
public interface ScoreboardServiceRemote {
	void add(ScoreboardPrices S);
	void update(ScoreboardPrices S);
	ScoreboardPrices findByID(int ID);
	 List<ScoreboardPrices> findAll();
	 void delete(ScoreboardPrices S);

}
