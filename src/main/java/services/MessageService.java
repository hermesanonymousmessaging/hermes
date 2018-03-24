package services;

import java.util.List;

import domain.Message;

public interface MessageService {
	List<Message> listAll();
	Message getById(String id);
	Message saveOrUpdate(Message message);
	void delete(String id);
	List<Message> getByUserIdAndChannelId(String userId, String channelId);
}
