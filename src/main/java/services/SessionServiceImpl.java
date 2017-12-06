package services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.Session;
import repositories.SessionRepository;

@Service
public class SessionServiceImpl implements SessionService{
	
	@Autowired
	private SessionRepository sessionRepository;

	@Autowired
    public SessionServiceImpl(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }
	
	
	@Override
	public List<Session> listAll() {
		List<Session> sessions = new ArrayList<Session>();
		sessions = sessionRepository.findAll();
        return sessions;
	}

	@Override
	public Session getById(String id) {
		return sessionRepository.findOne(id);
	}

	@Override
	public Session saveOrUpdate(Session session) {
		return sessionRepository.save(session);
	}

	@Override
	public void delete(String id) {
		sessionRepository.delete(id);
	}
		
}
