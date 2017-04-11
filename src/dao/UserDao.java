package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import domain.User;

public class UserDao {
	
	final String driver = "com.mysql.jdbc.Driver";
	// URLָ��Ҫ���ʵ����ݿ���scutcs
	final String url = "jdbc:mysql://127.0.0.1:3306/test";
	// MySQL����ʱ���û���
	final String username = "root";
	// Java����MySQL����ʱ������
	final String password = "jda";

	public static void main(String[] args) {
		String driver = "com.mysql.jdbc.Driver";
		// URLָ��Ҫ���ʵ����ݿ���scutcs
		String url = "jdbc:mysql://127.0.0.1:3306/test";
		// MySQL����ʱ���û���
		String user = "root";
		// Java����MySQL����ʱ������
		String password = "jda";
		try {
			// ������������
			Class.forName(driver);
			// �������ݿ�
			Connection conn = DriverManager.getConnection(url, user, password);
			if (!conn.isClosed()) {
				System.out.println("Succeeded connecting to the Database!");
			}
			// statement����ִ��SQL���
			Statement statement = conn.createStatement();
			// Ҫִ�е�SQL���
			String sql = "select * from user";
			ResultSet rs = statement.executeQuery(sql);
			System.out.println("-----------------");
			System.out.println("ִ�н��������ʾ:");
			System.out.println("-----------------");
			System.out.println(" �û���" + "\t" + " ����");
			System.out.println("-----------------");
			String name = null;
			while (rs.next()) {
				// ѡ��username��������
				name = rs.getString("username");
				// ����ʹ��ISO-8859-1�ַ�����name����Ϊ�ֽ����в�������洢�µ��ֽ������С�
				// Ȼ��ʹ��GB2312�ַ�������ָ�����ֽ�����
				name = new String(name.getBytes("ISO-8859-1"), "GB2312");
				// ������
				System.out.println(name + "\t" + rs.getString("password"));
			}
			rs.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			System.out.println("Sorry,can`t find the Driver!");
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * �����û�
	 * @param userName
	 * @return  ���ڸ��û������û�bean ,���������򷵻�null
	 */
	public User getUser(String userName) {
		User user = null;
		try {
			// ������������
			Class.forName(driver);
			// �������ݿ�
			Connection conn = DriverManager.getConnection(url, username, password);
			if (!conn.isClosed()) {
				System.out.println("Succeeded connecting to the Database!");
			}
			// Ҫִ�е�SQL���
			String sql = "select * from user where username = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userName);
			ResultSet rs = pstmt.executeQuery();
			String name = null;
			while (rs.next()) {
				// ѡ��username��������
				name = rs.getString("username");
				// ����ʹ��ISO-8859-1�ַ�����name����Ϊ�ֽ����в�������洢�µ��ֽ������С�
				// Ȼ��ʹ��GB2312�ַ�������ָ�����ֽ�����
				name = new String(name.getBytes("ISO-8859-1"), "GB2312");
				// ������
				System.out.println(name + "\t" + rs.getString("password"));
				user = new User(name, rs.getString("password"));
			}
			rs.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			System.out.println("Sorry,can`t find the Driver!");
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
}
