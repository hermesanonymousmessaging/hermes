package repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import domain.User;

public interface UserRepository extends MongoRepository<User, String> {
    public User findByFirstName(String firstName);
    public List<User> findByLastName(String lastName);

}