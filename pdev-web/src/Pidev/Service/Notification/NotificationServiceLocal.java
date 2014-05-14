package Pidev.Service.Notification;

import java.util.List;

import javax.ejb.Local;

import Pidev.entite.Notification;
@Local
public interface NotificationServiceLocal {
	
	void add(Notification notification);
	void update(Notification notification);
	void remove(Notification notification);
	Notification findBy(int id);
	List<Notification> findAll();
	List<Notification> findUnread(String idDestination);
	void setRead();
}
