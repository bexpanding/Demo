package net.codejava;

import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {
	
	public User checkLogin(String email, String password) throws SQLException,
    ClassNotFoundException {
String jdbcURL = "jdbc:mysql://localhost:3306/test";
String dbUser = "root";
String dbPassword = "mysql";

Class.forName("com.mysql.cj.jdbc.Driver");
Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
String sql = "SELECT * FROM users WHERE email = ? and password = ?";
PreparedStatement statement = connection.prepareStatement(sql);
statement.setString(1, email);
statement.setString(2, password);

ResultSet result = statement.executeQuery();

User user = null;

if (result.next()) {
    user = new User();
    user.setFullname(result.getString("fullname"));
    user.setEmail(email);
}

connection.close();

return user;
}
}




