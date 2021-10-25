package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//DatabaseDAO connects to the mysql database called cdw_sapp
public abstract class DatabaseDAO {
	
	protected Connection connection = null;
	protected Statement statement = null;
	protected ResultSet resultSet = null;
	protected PreparedStatement prepareStatement = null;
	
	public void getConnection(String username, String password) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cdw_sapp?"+ "autoReconnect=false&useSSL=false", username, password);
			this.statement = this.connection.createStatement();

		} catch (SQLException e) {
			throw new SQLException();
		} catch (ClassNotFoundException e) {
			throw new ClassNotFoundException();
		} catch (IllegalAccessException e) {
			throw new IllegalAccessException();
		} catch (InstantiationException e) {
			throw new InstantiationException();
		}
	}
	
	public void closeConnection() throws Exception {
		try {
			connection.close();
		} catch (Exception e) {
			System.out.println(e);
			throw new Exception();
		}
	}

}
