package macc.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import macc.entity.User;

		

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	//名稱搜尋users的資料(create.html)
	@Query(value = "SELECT * FROM user WHERE userId = :userId", nativeQuery = true)
	User findByUsername(@Param("userId") String userId);

	//搜尋所有users的資料(users.html)
	@Query(value = "SELECT * FROM user", nativeQuery = true)
	List<User> findAll();
	

	//帳號、密碼尋找user的資料返回有或沒有(login.html , data.html)
	@Query(value = "SELECT * FROM user WHERE userId = :userId AND password = :password", nativeQuery = true)
    User findUser(@Param("userId") String userId, @Param("password") String password);
	
	//創建新帳號(create.html)
	@Modifying
	@Query(value = "INSERT INTO user (userId, password, email, role, firstlogin) VALUES (:userId, :password, :email, :role ,0)", nativeQuery = true)
	void saveUser(@Param("userId") String userId, @Param("password") String password, @Param("email") String email, @Param("role") String role);

	//根據ID做資料更新(data.html,update.html)
	@Modifying
	@Query(value = "UPDATE user SET  password = :password, email = :email, role = :role WHERE userId = :userId", nativeQuery = true)
	void updateUser(@Param("userId") String userId, @Param("password") String password, @Param("email") String email, @Param("role") String role);

	//根據ID做資料刪除(data.html,delete.html)
	@Modifying
	@Query(value = "DELETE FROM user WHERE userId = :userId", nativeQuery = true)
	void deleteUser(@Param("userId")String userId);

	@Query(value = "SELECT * FROM user WHERE userId = :userId", nativeQuery = true)
	User getUserById(String userId);

	@Modifying	
	@Query(value = "UPDATE user SET  password = :password, email = :email, role = :role,firstlogin = :firstlogin  WHERE userId = :userId", nativeQuery = true)
	void updateUserByLogin(String userId, String password, String email, String role ,int firstlogin);

}