package jp.co.sss.jdbc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class JdbcTraing07 {
	public static void main(String[] args) throws IOException {
		delete();
	}

	public static void delete() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			System.out.println("部署を削除します");
			System.out.println("部署NO");
			String deptno = br.readLine();

			connection = DBManagerEducation.getConnection();
			String sql = "DELETE FROM dept WHERE deptno = ?";

			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, deptno);
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
