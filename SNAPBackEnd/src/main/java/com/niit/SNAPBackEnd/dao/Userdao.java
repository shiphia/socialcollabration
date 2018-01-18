package com.niit.SNAPBackEnd.dao;
import java.util.ArrayList;

import com.niit.SNAPBackEnd.models.Users;

public interface Userdao {

	
	

	
		 ArrayList<Users> getAllUser();
		 public boolean saveUser(Users user);
		 public boolean updateOnlineStatus(Users user);
			public Users getUser(int userid);
			public boolean checkLogin(Users user);
			public Users getUserbyemail(String email);
			public Users getUserbyId(int uderid);
	}
