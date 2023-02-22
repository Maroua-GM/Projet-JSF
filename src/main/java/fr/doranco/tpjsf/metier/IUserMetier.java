package fr.doranco.tpjsf.metier;

import java.util.List;

import fr.doranco.tpjsf.entity.User;

public interface IUserMetier {
	User getUserById(int id) throws Exception;

	User addUser(User user) throws Exception;

	void updateUser(User user) throws Exception;

	void deleteUser(int id) throws Exception;

	List<User> getUsers() throws Exception;

	User seConnecter(String email, String password) throws Exception;

}
