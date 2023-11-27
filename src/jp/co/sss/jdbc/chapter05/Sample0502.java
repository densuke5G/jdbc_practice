package jp.co.sss.jdbc.chapter05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;

import jp.co.sss.jdbc.chapter01.DBManager;

public class Sample0502 {

	public static void main(String[] args) throws IOException {
		update();
	}

	public static void update() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			System.out.println("社員を登録します");
			
			System.out.println("社員IDを入力してください。"); 
            String empId = br.readLine(); 
            System.out.println("社員名を入力してください。"); 
            String empName = br.readLine(); 
            System.out.println("性別を入力してください（男性：1、女性：2)。"); 
            String gender = br.readLine(); 
            System.out.println("生年月日を入力してください（西暦年/月/日)。"); 
            String birthday = br.readLine(); 
            
            connection = DBManager.getConnection();
            
            String sql = "UPDATE employee SET emp_name = ?, gender = ?, birthday = ? where emp_id = ?";
            
            preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setString(4, empId);
            preparedStatement.setString(1, empName);
            preparedStatement.setString(2, gender);
            preparedStatement.setString(3, birthday);
			
            int cnt = preparedStatement.executeUpdate();
            
            System.out.println(cnt + "件のデータを更新");
            
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(connection);
			DBManager.close(preparedStatement);
		}
	}

}
