package repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import domain.Log;

public interface LogRepository extends MongoRepository<Log, String> {
}