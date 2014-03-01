package Pidev.Service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import Pidev.entite.Position;

/**
 * Session Bean implementation class PositionService
 */
@Stateless
@LocalBean
public class PositionService implements PositionServiceRemote {
	@PersistenceContext(unitName = "JPA")
	private EntityManager em;
    /**
     * Default constructor. 
     */
    public PositionService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void add(Position P) {
		em.persist(P);
		
	}

	@Override
	public void update(Position P) {
	em.merge(P);
		
	}

	@Override
	public Position findByID(int ID) {
		return em.find(Position.class,ID);
	}

	@Override
	public List<Position> findAll() {
		return em.createQuery("from position",Position.class).getResultList();
	}

	@Override
	public void delete(Position P) {
		Position Po=findByID(P.getID_Position());
		em.remove(Po);
		
	}

}
