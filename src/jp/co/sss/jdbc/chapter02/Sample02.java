package jp.co.sss.jdbc.chapter02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jp.co.sss.jdbc.chapter01.DBManager;

public class Sample02 {

	public static void main(String[] args) {
		select();
	}
	
	public static void select() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = DBManager.getConnection();
			
			String sql = "SELECT * FROM employee";
			
			preparedStatement = connection.prepareStatement(sql);
			
			resultSet = preparedStatement.executeQuery();
			
			System.out.println("emp_id\\temp_name\\tgender\\tbirthday");
			
			while (resultSet.next()) {
				System.out.print(resultSet.getString("emp_id") +  "\t");
				System.out.print(resultSet.getString("emp_name") +  "\t");
				System.out.print(resultSet.getString("gender") +  "\t");
				System.out.println(resultSet.getString("birthday"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(resultSet);
			DBManager.close(preparedStatement);
			DBManager.close(connection);
		}
	}
}
