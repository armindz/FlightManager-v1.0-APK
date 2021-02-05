package database;

import android.os.StrictMode;

import java.sql.*;

public class DatabaseConnection {
	
	private static String url = "jdbc:mysql://10.0.0.5:3306/flightmanager";
	private static String root = "user";
	private static String password = "sifra";

	public static Connection getConnection() {

		try {

			StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
			StrictMode.setThreadPolicy(policy);

			Class.forName("com.mysql.jdbc.Driver").newInstance();
			return DriverManager.getConnection(url, root, password);

		}

		catch (Exception e) {
			System.out.println("Something went wrong : ");
			e.printStackTrace();
		}

		return null;

	}

}
