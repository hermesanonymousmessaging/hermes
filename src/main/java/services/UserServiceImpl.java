package services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.User;
import repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
	
	
	@Override
	public List<User> listAll() {
		List<User> profiles = new ArrayList<User>();
		profiles = userRepository.findAll();
        return profiles;
	}

	@Override
	public User getById(String id) {
		return userRepository.findOne(id);
	}

	@Override
	public User saveOrUpdate(User profile) {
		return userRepository.save(profile);
	}

	@Override
	public void delete(String id) {
		userRepository.delete(id);
	}
		
}
