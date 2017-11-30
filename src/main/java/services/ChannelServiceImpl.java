package services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.Channel;
import repositories.ChannelRepository;

@Service
public class ChannelServiceImpl implements ChannelService{
	
	@Autowired
	private ChannelRepository channelRepository;

	@Autowired
    public ChannelServiceImpl(ChannelRepository channelRepository) {
        this.channelRepository = channelRepository;
    }
	
	
	@Override
	public List<Channel> listAll() {
		List<Channel> channels = new ArrayList<Channel>();
		channels = channelRepository.findAll();
        return channels;
	}

	@Override
	public Channel getById(String id) {
		return channelRepository.findOne(id);
	}

	@Override
	public Channel saveOrUpdate(Channel channel) {
		return channelRepository.save(channel);
	}

	@Override
	public void delete(String id) {
		channelRepository.delete(id);
	}
		
}
