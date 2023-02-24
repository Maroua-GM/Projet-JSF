package fr.doranco.tpjsf.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import fr.doranco.tpjsf.entity.Adresse;
import fr.doranco.tpjsf.entity.User;
import fr.doranco.tpjsf.utils.Dates;

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
			String requete = "INSERT INTO `user` (`nom`, `prenom`, `sexe`, `email`, `date_naissance`, `qualite_service`, `telephone`, `disponible`, `fonction_Actuelle`,`password`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?,?)";
			ps = connection.prepareStatement(requete, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, user.getNom());
			ps.setString(2, user.getPrenom());
			ps.setString(3, user.getGenre());
			ps.setString(4, user.getEmail());
			ps.setString(5, Dates.dateToString(user.getDateNaissance()));
			ps.setString(6, user.getNiveauDeService());
			ps.setString(7, user.getTelephone());
			ps.setString(8, user.getDisponible());
			ps.setString(9, user.getFonctionActuelle());
			ps.setString(10, user.getPassword());
			ps.executeUpdate();
			rs = ps.getGeneratedKeys();
			if (rs != null && rs.next()) {
				user.setId(rs.getInt(1));
				ps.close();
				rs.close();
				String requete2 = "INSERT INTO `adresse` (`numero`, `rue`, `ville`, `codePostal`, `User_idUser`) VALUES (?, ?, ?, ?, ?)";
				for (Adresse adresse : user.getAdresses()) {
					ps = connection.prepareStatement(requete2);
					ps.setString(1, adresse.getNumero());
					ps.setString(2, adresse.getRue());
					ps.setString(3, adresse.getVille());
					ps.setString(4, adresse.getCodePostal());
					ps.setInt(5, user.getId());
					ps.executeUpdate();
				}
			}

			return user;

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
				user.setNom(rs.getString("nom"));
				user.setPrenom(rs.getString("prenom"));
				user.setDateNaissance(Dates.dateSqlToUtil(rs.getDate("date_naissance")));
				user.setDisponible(rs.getString("disponible"));
				user.setFonctionActuelle(rs.getString("fonction_Actuelle"));
				user.setGenre(rs.getString("sexe"));
				user.setId(rs.getInt(1));
				user.setTelephone(rs.getString("telephone"));
				user.setNiveauDeService(rs.getString("qualite_service"));
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
