package services;

import java.util.List;

import domain.TempUser;

public interface TempUserService {
	List<TempUser> listAll();
	TempUser getById(String id);
	TempUser saveOrUpdate(TempUser user);
	void delete(String id);
}
