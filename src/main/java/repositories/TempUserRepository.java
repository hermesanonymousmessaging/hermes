package repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import domain.TempUser;

public interface TempUserRepository extends MongoRepository<TempUser, String> {
    public List<TempUser> findByFirstName(String firstName);
    public List<TempUser> findByFirstNameIgnoreCase(String firstName);
    
    public List<TempUser> findByLastName(String lastName);
    public List<TempUser> findByLastNameIgnoreCase(String lastName);
    
    public List<TempUser> findByUsername(String username);
    public List<TempUser> findByUsernameIgnoreCase(String username);
    
    public List<TempUser> findByEmail(String email);
    public List<TempUser> findByEmailIgnoreCase(String email);
    
    public TempUser findByPhoneNumber(String phoneNumber);
    
    public TempUser findByConfirmationToken(String confirmationToken);
}