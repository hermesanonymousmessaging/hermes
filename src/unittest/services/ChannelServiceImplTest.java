package services;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import domain.Channel;
import repositories.ChannelRepository;

import org.junit.Test;

public class ChannelServiceImplTest {
	
	@Test
    public void testlistAll() {
		
		//Setup
		
		Channel newChannel = new Channel();
		
		List<Channel> channels = Arrays.asList(newChannel);
		
		ChannelRepository mockito = mock(ChannelRepository.class);
		
		when(mockito.findAll()).thenReturn(channels);
		
		ChannelServiceImpl obj = new ChannelServiceImpl(mockito);
		
		//Test
		List<Channel> testChannels = obj.listAll();
		
		//Verify
		assertThat(testChannels,is(channels));
    }
	
	@Test
    public void testgetById() {
		
		//Setup
		Channel newChannel = new Channel();
		
		ChannelRepository mockito = mock(ChannelRepository.class);
		
		when(mockito.findOne(newChannel.getId())).thenReturn(newChannel);
		
		ChannelServiceImpl obj = new ChannelServiceImpl(mockito);
		
		//Test
		Channel testChannel = obj.getById(newChannel.getId());
		
		//Verify
		assertThat(testChannel.getId(),is(newChannel.getId()));
    }
	
	@Test
    public void testsaveOrUpdate() {
		
		//Setup
		Channel newChannel = new Channel();
		
		ChannelRepository mockito = mock(ChannelRepository.class);
		
		when(mockito.save(newChannel)).thenReturn(newChannel);
		
		ChannelServiceImpl obj = new ChannelServiceImpl(mockito);
		
		//Test
		Channel testChannel = obj.saveOrUpdate(newChannel);
		
		//Verify
		assertThat(testChannel,is(newChannel));
    }
}