package services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.TempUser;
import repositories.TempUserRepository;

@Service
public class TempUserServiceImpl implements TempUserService{
	
	@Autowired
	private TempUserRepository tempUserRepository;

	@Autowired
    public TempUserServiceImpl(TempUserRepository userRepository) {
        this.tempUserRepository = userRepository;
    }
	
	
	@Override
	public List<TempUser> listAll() {
		List<TempUser> profiles = new ArrayList<TempUser>();
		profiles = tempUserRepository.findAll();
        return profiles;
	}

	@Override
	public TempUser getById(String id) {
		return tempUserRepository.findOne(id);
	}

	@Override
	public TempUser saveOrUpdate(TempUser profile) {
		return tempUserRepository.save(profile);
	}

	@Override
	public void delete(String id) {
		tempUserRepository.delete(id);
	}
		
}
