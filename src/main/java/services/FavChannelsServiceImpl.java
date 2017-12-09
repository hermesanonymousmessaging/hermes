package services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.FavChannels;
import repositories.FavChannelsRepository;

@Service

public class FavChannelsServiceImpl implements FavChannelsService{
	
	@Autowired
	private FavChannelsRepository favChannelsRepository;

	@Autowired
    public FavChannelsServiceImpl(FavChannelsRepository favChannelsRepository) {
        this.favChannelsRepository = favChannelsRepository;
    }
	
	@Override
	public List<FavChannels> listAll() {
		List<FavChannels> favmsgs = new ArrayList<FavChannels>();
		favmsgs = favChannelsRepository.findAll();
        return favmsgs;
	}

	@Override
	public FavChannels getById(String Id) {
		return favChannelsRepository.findOne(Id);
	}
	
	@Override
	public List<FavChannels> getByUserId(String userId) {
		return favChannelsRepository.findByUserId(userId);
	}

	@Override
	public FavChannels saveOrUpdate(FavChannels favmsg) {
		return favChannelsRepository.save(favmsg);
	}

	@Override
	public void delete(String id) {
		favChannelsRepository.delete(id);
	}

}