package macc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import macc.entity.User;




@Service
public interface UserService {
	
    boolean getUserId(String userId);
    
    User getUser(String userId, String password);

    List<User> getAllUsers();

    void saveUser(User user);

    void updateUser(User user);

    void updateUserLogin(User user);

    void deleteUser(String userId);

	User getUserById(String UserId);
	
	
	
}