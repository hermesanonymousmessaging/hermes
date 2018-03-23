package services;

import java.util.List;

import domain.Channel;
import domain.FavMessages;

public interface ChannelService {
	List<Channel> listAll();
	Channel getById(String id);
	Channel saveOrUpdate(Channel channel);
	void delete(String id);
	String getChannelName(String id);
}
