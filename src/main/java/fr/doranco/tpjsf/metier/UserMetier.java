package fr.doranco.tpjsf.metier;

import java.util.List;

import fr.doranco.tpjsf.entity.User;
import fr.doranco.tpjsf.model.UserDao;

public class UserMetier implements IUserMetier {

	private final UserDao userDao = new UserDao();

	@Override
	public User getUserById(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User addUser(User user) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateUser(User user) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteUser(int id) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public List<User> getUsers() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User seConnecter(String email, String password) throws Exception {

		User user = userDao.getUserByEmail(email);
		if (user != null) {
			// commparer les deux mots de passes
			if (user.getPassword().equals(password)) {
				return user;
			}

		}
		return null;

	}

}
