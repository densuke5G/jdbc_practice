package jp.co.sss.jdbc.chapter05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;

import jp.co.sss.jdbc.chapter01.DBManager;

public class Sample0501 {

	public static void main(String[] args) throws IOException {
		insert();
	}
	
	public static void insert() {
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
            
            String sql = "INSERT INTO employee VALUES (?, ?, ?, ?)";
            
            preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setString(1, empId);
            preparedStatement.setString(2, empName);
            preparedStatement.setString(3, gender);
            preparedStatement.setString(4, birthday);
            
            int cnt = preparedStatement.executeUpdate();
            
            System.out.println(cnt + "件のデータを登録");
            
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(connection);
			DBManager.close(preparedStatement);
		}
	}

}
