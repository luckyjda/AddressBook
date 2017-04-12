package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dao.fakedao.UserFakeDao;
import domain.User;

public class UserDao {
	
	final String driver = "com.mysql.jdbc.Driver";
	// URL指向要访问的数据库名scutcs
	final String url = "jdbc:mysql://127.0.0.1:3306/test";
	// MySQL配置时的用户名
	final String username = "root";
	// Java连接MySQL配置时的密码
	final String password = "jda";
	//数据库是否为模拟
	public static boolean isFake = true;

	public static void main(String[] args) {
		String driver = "com.mysql.jdbc.Driver";
		// URL指向要访问的数据库名scutcs
		String url = "jdbc:mysql://127.0.0.1:3306/test";
		// MySQL配置时的用户名
		String user = "root";
		// Java连接MySQL配置时的密码
		String password = "jda";
		try {
			// 加载驱动程序
			Class.forName(driver);
			// 连续数据库
			Connection conn = DriverManager.getConnection(url, user, password);
			if (!conn.isClosed()) {
				System.out.println("Succeeded connecting to the Database!");
			}
			// statement用来执行SQL语句
			Statement statement = conn.createStatement();
			// 要执行的SQL语句
			String sql = "select * from user";
			ResultSet rs = statement.executeQuery(sql);
			System.out.println("-----------------");
			System.out.println("执行结果如下所示:");
			System.out.println("-----------------");
			System.out.println(" 用户名" + "\t" + " 密码");
			System.out.println("-----------------");
			String name = null;
			while (rs.next()) {
				// 选择username这列数据
				name = rs.getString("username");
				// 首先使用ISO-8859-1字符集将name解码为字节序列并将结果存储新的字节数组中。
				// 然后使用GB2312字符集解码指定的字节数组
				name = new String(name.getBytes("ISO-8859-1"), "GB2312");
				// 输出结果
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
	 * 查找用户
	 * @param userName
	 * @return  存在该用户返回用户bean ,若不存在则返回null
	 */
	public User getUser(String userName) {
		User user = null;
		try {
			// 加载驱动程序
			Class.forName(driver);
			// 连续数据库
			Connection conn = DriverManager.getConnection(url, username, password);
			if (!conn.isClosed()) {
				System.out.println("Succeeded connecting to the Database!");
			}
			// 要执行的SQL语句
			String sql = "select * from user where username = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userName);
			ResultSet rs = pstmt.executeQuery();
			String name = null;
			while (rs.next()) {
				// 选择username这列数据
				name = rs.getString("username");
				// 首先使用ISO-8859-1字符集将name解码为字节序列并将结果存储新的字节数组中。
				// 然后使用GB2312字符集解码指定的字节数组
				name = new String(name.getBytes("ISO-8859-1"), "GB2312");
				// 输出结果
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
	
	public User getUser_(String userName) {
		if(isFake){
			return UserFakeDao.getUser(userName);
		}else {
			return getUser(userName);
		}
	}
}
