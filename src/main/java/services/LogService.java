package services;

import java.util.List;

import domain.Log;

public interface LogService {
	List<Log> listAll();
	Log getById(String id);
	Log saveOrUpdate(Log log);
	void delete(String id);
}
