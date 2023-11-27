package jp.co.sss.jdbc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JdbcTraing04 {

	public static void main(String[] args) throws IOException {
		range();
	}

	public static void range() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			System.out.println("給与の範囲検索をします");
			System.out.println("最小値");
			String min = br.readLine();
			System.out.println("最大値");
			String max = br.readLine();

			connection = DBManagerEducation.getConnection();
			String sql = "SELECT ename, sal, job FROM emp WHERE sal >= ? AND sal <= ?";

			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, min);
			preparedStatement.setString(2, max);
			resultSet = preparedStatement.executeQuery();

			System.out.println("検索結果を表示します");
			System.out.println("社員NO\t給与\t職種");
			while (resultSet.next()) {
				System.out.print(resultSet.getString("ename") + "\t");
				System.out.print(resultSet.getString("sal") + "\t");
				System.out.println(resultSet.getString("job"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManagerEducation.close(preparedStatement);
			DBManagerEducation.close(connection);
			DBManagerEducation.close(resultSet);
		}
	}

}
