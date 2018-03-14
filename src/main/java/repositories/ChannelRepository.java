package repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import domain.Channel;

public interface ChannelRepository extends MongoRepository<Channel, String> {
	public List<Channel> findById(String channelId);
	
	public List<Channel> findByName(String name);
	public List<Channel> findByNameIgnoreCase(String name);
	
	public List<Channel> findByOwnerId(String ownerId);
}