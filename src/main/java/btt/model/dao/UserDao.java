package btt.model.dao;

import java.util.ArrayList;

import btt.model.bean.User;

public class UserDao {
	public ArrayList<User> getUsers()
	{
		ArrayList<User> list = new ArrayList<User>();
		list.add(new User(1,"abc","123","active"));
		list.add(new User(2,"bcd","123","deactive"));
		return list;
	}
}
