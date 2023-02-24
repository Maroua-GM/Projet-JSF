package fr.doranco.tpjsf.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fr.doranco.tpjsf.entity.User;
import fr.doranco.tpjsf.utils.Dates;

public class UserDaoTest {

	private final UserDao dao = new UserDao();

	@Test
	public void testGetUsers() {
	}

	@Test
	public void testGetUserByEmail() throws Exception {
		User bbd = dao.getUserByEmail("maroua@gmail.com");

		User user = new User();
		user.setId(1);
		user.setNom("benkhedir");
		user.setPrenom("maroua");
		user.setGenre("femme");
		user.setEmail("maroua@gmail.com");
		user.setDateNaissance(Dates.stringToDate("1993-08-22"));
		user.setNiveauDeService("premium");
		user.setTelephone("0987654");
		user.setDisponible("oui");
		user.setFonctionActuelle("technicien");
		user.setPassword("maroua");

		assertEquals(user, bbd);

		// assertEquals(null, dao.getUserByEmail("ljkkljlkjkl"));

	}

	@Test(expected = IllegalArgumentException.class)
	public void testGetUserByEmailException() throws Exception {
		dao.getUserByEmail(null);
		dao.getUserByEmail("");
	}

}
