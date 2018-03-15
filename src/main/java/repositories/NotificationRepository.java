package repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import domain.Notification;

public interface NotificationRepository extends MongoRepository<Notification, String> {
	public List<Notification> findById(String id);
	public List<Notification> findByChannelId(String channelId);
	public List<Notification> findByRecipientId(String recipientId);
}