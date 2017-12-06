package services;

import java.util.List;

import domain.Session;

public interface SessionService {
	List<Session> listAll();
	Session getById(String id);
	Session saveOrUpdate(Session session);
	void delete(String id);
}
