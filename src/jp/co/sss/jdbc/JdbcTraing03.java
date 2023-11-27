package jp.co.sss.jdbc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JdbcTraing03 {

	public static void main(String[] args)throws IOException {
		select();
	}
	
	public static void select()  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			System.out.println("部署NOを入力してください");
			String deptno = br.readLine();
			
			connection = DBManagerEducation.getConnection();
			String sql = "SELECT * FROM emp WHERE deptno = ?";
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, deptno);
			resultSet = preparedStatement.executeQuery();
			
			System.out.println("検索結果を表示します");
			System.out.println("社員NO\t社員名\t上司名\t入社日\t給与\t職種\t部署NO"); 
            while (resultSet.next()) { 
                System.out.print(resultSet.getString("empno") + "\t"); 
                System.out.print(resultSet.getString("ename") + "\t"); 
                System.out.print(resultSet.getString("superior") + "\t"); 
                System.out.print(resultSet.getString("hiredate") + "\t"); 
                System.out.print(resultSet.getString("sal") + "\t"); 
                System.out.print(resultSet.getString("job") + "\t"); 
                System.out.println(resultSet.getString("deptno")); 
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
