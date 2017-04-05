package gapp.model.dao;

import java.util.List;

import gapp.model.Users;


public interface UserDao {
	 Users getUsers(String email,String password );
	 List<Users> getUsers();
	 Users saveUser(Users user);
	 Users getUsers(String email );
	    
}
