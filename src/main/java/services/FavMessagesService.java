package services;

import java.util.List;

import domain.FavMessages;

public interface FavMessagesService {
	
	List<FavMessages> listAll();
	FavMessages getById(String Id);
	List<FavMessages> getByUserId(String userId);
	FavMessages saveOrUpdate(FavMessages msg);
	void delete(String id);
		
}
