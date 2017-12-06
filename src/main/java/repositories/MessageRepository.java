package repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import domain.Message;

public interface MessageRepository extends MongoRepository<Message, String> {
	public List<Message> findByChannelId(String channelId);
	public List<Message> findBySessionId(String sessionId);
	
}