package repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import domain.Config;


public interface ConfigRepository extends MongoRepository<Config, String> {
    public Config findByName(String name);
}