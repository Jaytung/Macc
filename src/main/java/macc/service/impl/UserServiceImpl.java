package macc.service.impl;

import org.springframework.stereotype.Service;

import macc.dao.UserRepository;
import macc.entity.User;
import macc.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
	
    private UserRepository userRepository;
    public UserServiceImpl(UserRepository userRepository ) {
        this.userRepository = userRepository;
    }
    
    
    @Override
    public User getUserById(String userId) {
        return userRepository.getUserById(userId);
    }
    
    //搜尋有無帳號資料(帳號)
    @Override
    public boolean getUserId(String userId) {
        return (userRepository.findByUsername(userId) != null);
    }
    
    //搜尋有無帳號資料(帳號,密碼)
    @Override
    public User getUser(String userId ,String password) {
        return userRepository.findUser(userId, password);
    }
    
    //取得所有資料庫資料
    @Override
    public List<User> getAllUsers() {
        return  userRepository.findAll();
    }

    //創建新資料
    @Override
    public void saveUser(User user) {
    	userRepository.saveUser(user.getUserid(),user.getPassword(),user.getEmail(),user.getRole());
    }

    //更改帳號資料
    
    @Override
    public void updateUser(User user) {
    	userRepository.updateUser(user.getUserid(),user.getPassword(),user.getEmail(),user.getRole());
    }

    //刪除帳號資料(軟刪除)
    @Override
    public void deleteUser(String userId) {
        userRepository.deleteUser(userId);
    }


	@Override
	public void updateUserLogin(User user) {
		userRepository.updateUserByLogin(user.getUserid(),user.getPassword(),user.getEmail(),user.getRole(), user.getFirstlogin());
	    
		
	}


	
	
}