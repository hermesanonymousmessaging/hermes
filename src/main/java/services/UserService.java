package services;

import java.util.List;

import domain.User;

public interface UserService {
	List<User> listAll();
	User getById(String id);
	User saveOrUpdate(User user);
	void delete(String id);
}
