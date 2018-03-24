package services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.Message;
import repositories.MessageRepository;

@Service
public class MessageServiceImpl implements MessageService{
	
	@Autowired
	private MessageRepository messageRepository;

	@Autowired
    public MessageServiceImpl(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }
	
	
	@Override
	public List<Message> listAll() {
		List<Message> profiles = new ArrayList<Message>();
		profiles = messageRepository.findAll();
        return profiles;
	}

	@Override
	public Message getById(String id) {
		return messageRepository.findOne(id);
	}

	@Override
	public Message saveOrUpdate(Message message) {
		return messageRepository.save(message);
	}

	@Override
	public void delete(String id) {
		messageRepository.delete(id);
	}

	@Override
	public List<Message> getByUserIdAndChannelId(String userId, String channelId) {
		List<Message> messages = messageRepository.findByChannelId(channelId);
		List<Message> result = new ArrayList<Message>();
		for(Message message : messages){
			if(message.getSenderId().equals(userId)){
				result.add(message);
			}
		}
		return result;
	}
}
