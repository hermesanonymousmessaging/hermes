package services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.Log;
import repositories.LogRepository;

@Service
public class LogServiceImpl implements LogService{
	
	@Autowired
	private LogRepository logRepository;

	@Autowired
    public LogServiceImpl(LogRepository logRepository) {
        this.logRepository = logRepository;
    }
	
	
	@Override
	public List<Log> listAll() {
		List<Log> logs = new ArrayList<Log>();
		logs = logRepository.findAll();
        return logs;
	}

	@Override
	public Log getById(String id) {
		return logRepository.findOne(id);
	}

	@Override
	public Log saveOrUpdate(Log log) {
		return logRepository.save(log);
	}

	@Override
	public void delete(String id) {
		logRepository.delete(id);
	}
		
}
