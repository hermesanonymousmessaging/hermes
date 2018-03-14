package repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import domain.User;

public interface UserRepository extends MongoRepository<User, String> {
    public List<User> findByFirstName(String firstName);
    public List<User> findByFirstNameIgnoreCase(String firstName);
    
    public List<User> findByLastName(String lastName);
    public List<User> findByLastNameIgnoreCase(String lastName);
    
    public User findByUsername(String username);
    public User findByUsernameIgnoreCase(String username);
    
    public User findByEmail(String email);
    public User findByEmailIgnoreCase(String email);
    
    public User findByPhoneNumber(String phoneNumber);
}