package jp.co.sss.jdbc.chapter03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jp.co.sss.jdbc.chapter01.DBManager;

public class Sample03 {

	public static void main(String[] args) throws IOException {
		selectByEmpName();
	}
	
	public static void selectByEmpName() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			System.out.println("社員名を入力してください。");
			String empName = br.readLine();
			
			connection = DBManager.getConnection();
			
			String sql = "SELECT * FROM employee WHERE emp_name LIKE ?";
			
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setString(1, "%" + empName + "%");
			
			resultSet = preparedStatement.executeQuery();
			
			System.out.println("emp_id\temp_name\tgender\tbirthday"); 
            while (resultSet.next()) { 
                System.out.print(resultSet.getString("emp_id") + "\t"); 
                System.out.print(resultSet.getString("emp_name") + "\t"); 
                System.out.print(resultSet.getString("gender") + "\t"); 
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
