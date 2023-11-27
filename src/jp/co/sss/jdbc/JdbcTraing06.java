package jp.co.sss.jdbc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class JdbcTraing06 {
	public static void main(String[] args) throws IOException {
		update();
	}

	public static void update() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			System.out.println("部署を変更します");
			System.out.println("部署NO");
			String deptno = br.readLine();
			System.out.println("部署名");
			String dname = br.readLine();
			System.out.println("場所");
			String loc = br.readLine();

			connection = DBManagerEducation.getConnection();
			String sql = "UPDATE dept SET dname = ?, loc = ? WHERE deptno = ?";

			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(3, deptno);
			preparedStatement.setString(1, dname);
			preparedStatement.setString(2, loc);
			preparedStatement.executeUpdate();

			System.out.println("部署を変更しました");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManagerEducation.close(preparedStatement);
			DBManagerEducation.close(connection);
		}
	}
}
