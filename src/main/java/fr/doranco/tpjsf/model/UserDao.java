package fr.doranco.tpjsf.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import fr.doranco.tpjsf.entity.User;

public class UserDao implements IUserDao {

	public UserDao() {
	}

	@Override
	public User getUserById(int id) throws Exception {

		return null;
	}

	@Override
	public User addUser(User user) throws Exception {
		if (user == null) {
			throw new NullPointerException("l'utilisateur ne doit pas etre null");
		}
		if (user.getNom() == null || user.getPrenom() == null || user.getGenre() == null
				|| user.getDateNaissance() == null || user.getDisponible() == null || user.getEmail() == null
				|| user.getFonctionActuelle() == null || user.getNom().trim().isEmpty()
				|| user.getPrenom().trim().isEmpty()) {
			// Verifier uniquement
			throw new IllegalArgumentException("Un ou plusieurs parametres sont manguants!");
		}
		Connection connection = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		try {
			connection = DorancoDataSource.getInstance().getConnexion();
			// On ajoute l'utilisateur
			String requete = "INSERT INTO `user` (`nom`, `prenom`, `sexe`, `email`, `date_naissance`, `qualite_service`, `telephone`, `disponible`, `fonction_Actuelle`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
		} finally {
			if (connection != null && !connection.isClosed()) {
				connection.close();
			}
			if (rs != null && !rs.isClosed()) {
				rs.close();
			}
			if (ps != null && !ps.isClosed()) {
				ps.close();
			}
		}
		return null;
	}

	@Override
	public void updateUser(int id) throws Exception {
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
	public User getUserByEmail(String email) throws Exception {
		if (email == null || email.trim().isEmpty()) {
			throw new IllegalArgumentException("il manque le email");
		}
		Connection connection = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		User user = null;
		// si l'email existe return true else false
		try {
			connection = DorancoDataSource.getInstance().getConnexion();
			// requete
			String requete = "select * from user where email=?";
			ps = connection.prepareStatement(requete);
			ps.setString(1, email);
			ps.execute();
			rs = ps.getResultSet();
			// si l'email existe return User else null

			if (rs != null && rs.next()) {
				user = new User();
				user.setEmail(email);
				user.setPassword(rs.getString("password"));
			}

		} finally {
			if (connection != null && !connection.isClosed()) {
				connection.close();
			}
			if (rs != null && !rs.isClosed()) {
				rs.close();
			}
			if (ps != null && !ps.isClosed()) {
				ps.close();
			}
		}

		return user;
	}

}
