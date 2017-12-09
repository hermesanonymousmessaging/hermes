package repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import domain.FavChannels;

public interface FavChannelsRepository extends MongoRepository<FavChannels, String> {
    public List<FavChannels> findByUserId(String userId);
    

}