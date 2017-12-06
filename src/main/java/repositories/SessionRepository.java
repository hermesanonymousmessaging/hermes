package repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import domain.Session;

public interface SessionRepository extends MongoRepository<Session, String> {
    public List<Session> findByChannelId(String channelId);
    public List<Session> findById(String sessionId);

}