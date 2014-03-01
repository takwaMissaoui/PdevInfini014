package Pidev.Service;

import java.util.List;

import javax.ejb.Remote;

import Pidev.entite.Position;

@Remote
public interface PositionServiceRemote {
	void add(Position P);
	void update(Position P);
	Position findByID(int ID);
	 List<Position> findAll();
	 void delete(Position P);

}
