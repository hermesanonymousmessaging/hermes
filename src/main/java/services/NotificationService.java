package services;

import java.util.List;

import domain.Notification;

public interface NotificationService {
	List<Notification> listAll();
	List<Notification> getByIdWithNames(String id);
	Notification getById(String id);
	Notification saveOrUpdate(Notification notification);
}
