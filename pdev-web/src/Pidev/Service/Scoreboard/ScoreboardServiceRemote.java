package Pidev.Service.Scoreboard;

import java.util.List;

import javax.ejb.Remote;

import Pidev.entite.ScoreboardPrices;

@Remote
public interface ScoreboardServiceRemote {
	void add(ScoreboardPrices scoreBP);

	void update(ScoreboardPrices scoreBP);

	ScoreboardPrices findByID(int id);

	List<ScoreboardPrices> findAll();

	void delete(ScoreboardPrices scoreBP);

}
