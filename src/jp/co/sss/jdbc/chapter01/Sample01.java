package jp.co.sss.jdbc.chapter01;

import java.sql.Connection;

public class Sample01 {
	public static void main(String[] args) {
		Connection connection = null;
		try {
			connection = DBManager.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(connection);
		}
	}
}