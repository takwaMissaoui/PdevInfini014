package Pidev.Service.Notification;

import java.util.List;

import javax.ejb.Remote;

import Pidev.entite.Notification;

@Remote
public interface NotificationServiceRemote {
	
	void add(Notification notification);
	void update(Notification notification);
	void remove(Notification notification);
	Notification findBy(int id);
	List<Notification> findAll();
	List<Notification> findUnread(String idDestination);
	void setRead();
	
	
	

}
