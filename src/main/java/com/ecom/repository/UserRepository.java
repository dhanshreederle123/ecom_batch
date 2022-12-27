package com.ecom.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ecom.models.User;

public interface UserRepository extends JpaRepository<User,Integer>{
	public Optional<User> findByEmail(String email);
	
	public List<User> findByName(String name);
	
	public User findByEmailAndPassword(String email,String password);

	public List<User> findByActiveTrue();

	public List<User> findByAboutIsNotNull();
	
	public List<User> findByNameStartingwith(String prefix);

	public List<User> findByNameContaining(String infix);

	//pattern "a%"
	public List<User> findByNameLike(String likePattern);
	
	public List<User> findByNameOrderByNameDesc(String name);
	
	public List<User> findTop4ByUserId();
	
	//creating query method

    @Query("select u from User u")
    public List<User> getAllUser();
    
    @Query("select u from User u where u.userId= :userId and u.email= :email")
    public List<User> getUserByEmail(@Param("userId")int abcId,String email);
    
    


}
