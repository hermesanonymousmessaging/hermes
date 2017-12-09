package repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import domain.FavMessages;

public interface FavMessagesRepository extends MongoRepository<FavMessages, String> {
    public List<FavMessages> findByUserId(String userId);
    

}