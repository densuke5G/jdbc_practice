package jp.co.sss.jdbc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class JdbcTraing05 {
	public static void main(String[] args) throws IOException {
		insert();
	}

	public static void insert() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			System.out.println("部署を新規登録します");
			System.out.println("部署名");
			String dname = br.readLine();
			System.out.println("場所");
			String place = br.readLine();

			connection = DBManagerEducation.getConnection();
			String sql = "INSERT INTO dept VALUES (dept_seq.nextval, ?, ?)";

			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, dname);
			preparedStatement.setString(2, place);
			preparedStatement.executeUpdate();

			System.out.println("部署を登録しました");
			

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManagerEducation.close(preparedStatement);
			DBManagerEducation.close(connection);
		}
	}
}
