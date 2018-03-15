package services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.Notification;
import repositories.ChannelRepository;
import repositories.NotificationRepository;

@Service
public class NotificationServiceImpl implements NotificationService{
	
	@Autowired
	private NotificationRepository notificationRepository;
	@Autowired
	private ChannelRepository channelRepository;

	@Autowired
    public NotificationServiceImpl(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }
	
	
	@Override
	public List<Notification> listAll() {
		List<Notification> notifications = new ArrayList<Notification>();
		notifications = notificationRepository.findAll();
        return notifications;
	}

	@Override
	public Notification getById(String id) {
		return notificationRepository.findOne(id);
	}

	@Override
	public Notification saveOrUpdate(Notification notification) {
		return notificationRepository.save(notification);
	}


	@Override
	public List<Notification> getByIdWithNames(String id) {
		List<Notification> notifications = notificationRepository.findByRecipientId(id);
		Collections.sort(notifications, Collections.reverseOrder());
		int size = notifications.size();
		if(size > 10)
			size = 10;
		notifications = notifications.subList(0, size);
		for(Notification notification : notifications) {
			notification.setChannelName(channelRepository.findOne(notification.getChannelId()).getName());
		}
		return notifications.subList(0, size);
	}	
}
