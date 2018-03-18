package services;

import java.util.List;

import domain.Config;

public interface ConfigService {
	Config getConfig();
	Config saveOrUpdate(Config config);
	void delete(String id);
}
