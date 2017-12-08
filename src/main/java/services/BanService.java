package services;

import java.util.List;

import domain.Ban;

public interface BanService {
	List<Ban> listAll();
	Ban getById(String id);
	Ban getByUserId(String userId);
	Ban saveOrUpdate(Ban ban);
	void delete(String id);
}
