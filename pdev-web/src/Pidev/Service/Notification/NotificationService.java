package Pidev.Service.Notification;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import Pidev.entite.Currency;
import Pidev.entite.Notification;


@Stateless
 @LocalBean
public class NotificationService implements NotificationServiceLocal,NotificationServiceRemote {
	
	@PersistenceContext
	private EntityManager em;
	
	

	public NotificationService() {
	
	}

	@Override
	public void add(Notification notification) {
		em.persist(notification);
		
	}

	@Override
	public void update(Notification notification) {
	
		em.merge(notification);
		
	}

	@Override
	public void remove(Notification notification) {
	
		Notification not =findBy(notification.getId());
		em.remove(not);
		
	}

	@Override
	public Notification findBy(int id) {
		
		return em.find(Notification.class, id);
		
	}

	@Override
	public List<Notification> findAll() {
		
		return em.createQuery("from Notification",Notification.class).getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Notification> findUnread(String idDestination) {
	
		
		Query query = em.createQuery("select  n from Notification n where  n.id_destination=:par AND n.read =:param ");
		
		query.setParameter("param",false);
		query.setParameter("par",idDestination);
		
		return query.getResultList();
		
		
	}
	
	@Override
	public void setRead() {
		
		Query query = em
				.createQuery("update  Notification n SET n.read=:param ");
		query.setParameter("param", true);
		query.executeUpdate ();
		
		
	}
	
	
}
