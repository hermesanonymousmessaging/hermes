package services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.Channel;
import domain.Config;
import repositories.ConfigRepository;

@Service
public class ConfigServiceImpl implements ConfigService{
	
	@Autowired
	private ConfigRepository configRepository;

	@Autowired
    public ConfigServiceImpl(ConfigRepository configRepository) {
        this.configRepository = configRepository;
    }

	@Override
	public Config getConfig() {
		Config conf = configRepository.findByName("hermes");
		if(conf == null) {
			conf = new Config();
			conf = configRepository.save(conf);
		}
		return conf;
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Config saveOrUpdate(Config config) {
		return configRepository.save(config);
	}


		
}
