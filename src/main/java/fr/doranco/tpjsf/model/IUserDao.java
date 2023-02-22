package fr.doranco.tpjsf.model;

import java.util.List;

import fr.doranco.tpjsf.entity.User;

public interface IUserDao {

	User getUserById(int id) throws Exception;

	User addUser(User user) throws Exception;

	void updateUser(int id) throws Exception;

	void deleteUser(int id) throws Exception;

	List<User> getUsers() throws Exception;

	User getUserByEmail(String email) throws Exception;

}
