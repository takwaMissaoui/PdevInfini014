package Pidev.Service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import Pidev.entite.Transaction;

/**
 * Session Bean implementation class TransactionService
 */
@Stateless
@LocalBean
public class TransactionService implements TransactionServiceRemote {
	@PersistenceContext(unitName = "JPA")
	private EntityManager em;
    /**
     * Default constructor. 
     */
    public TransactionService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void add(Transaction T) {
		em.persist(T);
		
	}

	@Override
	public void update(Transaction T) {
		em.merge(T);
		
	}

	@Override
	public Transaction findByID(int ID) {
		return em.find(Transaction.class,ID);
	}

	@Override
	public List<Transaction> findAll() {
		return em.createQuery("from transaction",Transaction.class).getResultList();
	}

	@Override
	public void delete(Transaction T) {
		Transaction Ta=findByID(T.getID_Transaction());
		em.remove(Ta);
		
	}

}
