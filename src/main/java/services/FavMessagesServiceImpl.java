package services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.FavMessages;
import repositories.FavMessagesRepository;

@Service

public class FavMessagesServiceImpl implements FavMessagesService{
	
	@Autowired
	private FavMessagesRepository favMessagesRepository;

	@Autowired
    public FavMessagesServiceImpl(FavMessagesRepository favMessagesRepository) {
        this.favMessagesRepository = favMessagesRepository;
    }
	
	@Override
	public List<FavMessages> listAll() {
		List<FavMessages> favmsgs = new ArrayList<FavMessages>();
		favmsgs = favMessagesRepository.findAll();
        return favmsgs;
	}

	@Override
	public FavMessages getById(String Id) {
		return favMessagesRepository.findOne(Id);
	}
	
	@Override
	public List<FavMessages> getByUserId(String userId) {
		return favMessagesRepository.findByUserId(userId);
	}

	@Override
	public FavMessages saveOrUpdate(FavMessages favmsg) {
		return favMessagesRepository.save(favmsg);
	}

	@Override
	public void delete(String id) {
		favMessagesRepository.delete(id);
	}

}
