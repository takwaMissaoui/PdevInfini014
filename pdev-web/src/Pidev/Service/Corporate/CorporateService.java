package Pidev.Service.Corporate;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import Pidev.entite.Corporate;

/**
 * Session Bean implementation class CorporateService
 */
@Stateless
@LocalBean
public class CorporateService implements CorporateServiceRemote,CorporateServiceLocal {
	@PersistenceContext
	private EntityManager em;

	/**
	 * Default constructor.
	 */
	public CorporateService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void add(Corporate corporate) {
		em.persist(corporate);
	}

	@Override
	public void update(Corporate corporate) {
		em.merge(corporate);

	}

	@Override
	public Corporate findByID(int id) {
		return em.find(Corporate.class, id);
	}

	@Override
	public List<Corporate> findAll() {
		return em.createQuery("from Corporate", Corporate.class)
				.getResultList();

	}

	@Override
	public void delete(Corporate corporate) {
		Corporate co = findByID(corporate.getIdClient());
		em.remove(co);
	}

}
