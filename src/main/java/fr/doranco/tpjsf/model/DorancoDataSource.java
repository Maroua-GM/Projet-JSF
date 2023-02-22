package fr.doranco.tpjsf.model;

import java.sql.Connection;
import java.sql.DriverManager;

public final class DorancoDataSource {
	private static DorancoDataSource INSTANCE = null;

	public DorancoDataSource() {

	}

	public synchronized static DorancoDataSource getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new DorancoDataSource();
		}
		return INSTANCE;
	}

	public Connection getConnexion() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/doranco-bd";
		String login = "root";
		String password = "root";
		Connection connection = DriverManager.getConnection(url, login, password);
		return connection;
	}

}
