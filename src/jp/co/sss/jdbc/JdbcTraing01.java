package jp.co.sss.jdbc;

import java.sql.Connection;

public class JdbcTraing01 {

	public static void main(String[] args) {
		Connection connection = null;
		try {
			connection = DBManagerEducation.getConnection();
			System.out.println("接続に成功しました");
		} catch (Exception e) {
			System.out.println("接続に失敗しました");
		} finally {
			DBManagerEducation.close(connection);
		}
	}

}
