package jp.co.sss.jdbc.chapter05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;

import jp.co.sss.jdbc.chapter01.DBManager;

public class Sample0503 {

	public static void main(String[] args) throws IOException {
		delete();
	}
	
	public static void delete() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			System.out.println("社員を削除します");
			
			System.out.println("社員IDを入力してください。"); 
            String empId = br.readLine(); 
            
            connection = DBManager.getConnection();
            String sql = "DELETE FROM employee WHERE emp_id = ?";
            
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, empId);
            
            int cnt = preparedStatement.executeUpdate();
            
            System.out.println(cnt + "件のデータを削除");
            
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(preparedStatement);
			DBManager.close(connection);
		}
	}

}
