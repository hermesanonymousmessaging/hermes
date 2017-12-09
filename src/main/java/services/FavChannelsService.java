package services;

import java.util.List;

import domain.FavChannels;

public interface FavChannelsService {
	
	List<FavChannels> listAll();
	FavChannels getById(String Id);
	List<FavChannels> getByUserId(String userId);
	FavChannels saveOrUpdate(FavChannels msg);
	void delete(String id);
		
}