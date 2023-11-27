package jp.co.sss.jdbc.chapter01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBManager {
	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@localhost:1521/xepdb1";
	/** DB接続するためのユーザ名 */
	private static final String USER_NAME = "jdbc_user";
	/** DB接続するためのパスワード */
	private static final String PASSWORD = "systemsss";

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		//JDBCドライバクラスをJVMに登録 
		Class.forName(DRIVER);

		//DBに接続 
		Connection conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
		System.out.println("DBに接続しました");
		return conn;
	}

	public static void close(Connection connection) {
		if (connection != null) {
			try {
				connection.close();
				System.out.println("DBから切断しました");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void close(PreparedStatement preparedStatement) {
		if (preparedStatement != null) {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void close(ResultSet resultSet) {
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
