package com.connect.socialMedia.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.connect.socialMedia.entities.User;

@Transactional
@Repository
public interface UserDao extends JpaRepository<User, Integer> {

	User findById(int id);

	User findByEmail(String email);
	
	@Modifying
	@Query("UPDATE User u SET u.userName=?1,u.mobileNo=?2,u.password=?3  WHERE u.id=?4")
	public void updateUser(String userName, long mobileNo,String password,int id);
	
	
	@Modifying
	@Query("UPDATE User u SET u.password=?1  WHERE u.id=?2")
	public void updateUserPassword(String password,int id);
	
	
	@Query("select count(*) from User u")
	Integer userCount();

}
