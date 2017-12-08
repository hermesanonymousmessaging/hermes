package repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import domain.Ban;

public interface BanRepository extends MongoRepository<Ban, String> {
    public Ban findByUserId(String userId);

}