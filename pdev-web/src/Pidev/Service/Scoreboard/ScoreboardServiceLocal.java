package Pidev.Service.Scoreboard;

import java.util.List;

import javax.ejb.Local;

import Pidev.entite.ScoreboardPrices;
@Local
public interface ScoreboardServiceLocal {
	void add(ScoreboardPrices scoreBP);

	void update(ScoreboardPrices scoreBP);

	ScoreboardPrices findByID(int id);

	List<ScoreboardPrices> findAll();

	void delete(ScoreboardPrices scoreBP);
}
