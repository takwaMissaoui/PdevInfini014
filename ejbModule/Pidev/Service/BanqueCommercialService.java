package Pidev.Service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import Pidev.entite.BanqueCommercial;

/**
 * Session Bean implementation class BanqueCommercialService
 */
@Stateless
@LocalBean
public class BanqueCommercialService implements BanqueCommercialServiceRemote {
	@PersistenceContext(unitName = "JPA")
	private EntityManager em;
    /**
     * Default constructor. 
     */
    public BanqueCommercialService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void add(BanqueCommercial B) {
		em.persist(B);
		
	}

	@Override
	public void update(BanqueCommercial B) {
		em.merge(B);
		
	}

	@Override
	public BanqueCommercial findByID(int ID) {
		return em.find(BanqueCommercial.class, ID);
	}

	@Override
	public List<BanqueCommercial> findAll() {
		return em.createQuery("from BanqueCommercial",BanqueCommercial.class).getResultList();
	}

	@Override
	public void delete(BanqueCommercial B) {
		BanqueCommercial Ba=findByID(B.getID_Client());
		em.remove(Ba);
		
	}

}
