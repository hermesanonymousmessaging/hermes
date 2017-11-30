package services;

import java.util.List;

import domain.Channel;

public interface ChannelService {
	List<Channel> listAll();
	Channel getById(String id);
	Channel saveOrUpdate(Channel channel);
	void delete(String id);
}
