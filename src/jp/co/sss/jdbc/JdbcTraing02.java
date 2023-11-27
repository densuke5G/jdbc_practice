package jp.co.sss.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JdbcTraing02 {

	public static void main(String[] args) {
		selectAllEmployee();
	}

	public static void selectAllEmployee() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = DBManagerEducation.getConnection();

			String sql = "SELECT e.empno, e.ename, d.dname FROM emp e INNER JOIN dept d ON e.deptno = d.deptno";

			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();

			System.out.println("社員NO\t社員名\t部署");

			while (resultSet.next()) {
				System.out.print(resultSet.getString("empno") + "\t");
				System.out.print(resultSet.getString("ename") + "\t");
				System.out.println(resultSet.getString("dname"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManagerEducation.close(resultSet);
			DBManagerEducation.close(preparedStatement);
			DBManagerEducation.close(connection);
		}
	}

}
