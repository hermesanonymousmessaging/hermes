package services;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import domain.Log;
import repositories.LogRepository;

import org.junit.Test;

public class LogServiceImplTest {
	
	@Test
    public void testlistAll() {
		
		//Setup
		List<Log> logs = Arrays.asList(
				new Log("Testing listAll method with Mockito"));
		
		LogRepository mockito = mock(LogRepository.class);
		
		when(mockito.findAll()).thenReturn(logs);
		
		LogServiceImpl obj = new LogServiceImpl(mockito);
		
		//Test
		List<Log> testLogs = obj.listAll();
		
		//Verify
		assertThat(testLogs,is(logs));
    }
	
	@Test
    public void testgetById() {
		
		//Setup
		Log newLog = new Log("Testing getById method with Mockito");
		
		LogRepository mockito = mock(LogRepository.class);
		
		when(mockito.findOne(newLog.getId())).thenReturn(newLog);
		
		LogServiceImpl obj = new LogServiceImpl(mockito);
		
		//Test
		Log testLog = obj.getById(newLog.getId());
		
		//Verify
		assertThat(testLog.getId(),is(newLog.getId()));
    }
	
	@Test
    public void testsaveOrUpdate() {
		
		//Setup
		Log newLog = new Log("Testing saveOrUpdate method with Mockito");
		
		LogRepository mockito = mock(LogRepository.class);
		
		when(mockito.save(newLog)).thenReturn(newLog);
		
		LogServiceImpl obj = new LogServiceImpl(mockito);
		
		//Test
		Log testLog = obj.saveOrUpdate(newLog);
		
		//Verify
		assertThat(testLog,is(newLog));
    }
}