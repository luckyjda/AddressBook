package dao.fakedao;

import java.util.ArrayList;
import java.util.List;
import util.Utils;
import domain.User;

/**
 * 
* Title:UserFakeDao 
* Description: 模拟数据库数据  即UserDao 模拟数据 
* @author luckyjda
* @date 2017-4-12
 */
public class UserFakeDao {
	
	public static List<User> list = new ArrayList<User>();
	
	static {
		list.add(new User("luckyjda", "123"));
		list.add(new User("ping", "123"));
		list.add(new User("xin", "123"));
		list.add(new User("jda", "123"));
	}
	
	/**
	 * 容器是否包含用户
	 * @param user
	 * @return
	 */
	public static boolean isContainUser(User user) {
		boolean isContain = false;
		if(user != null) {
			for(User temp : list) {
				if(Utils.isNotNull(temp.getUserName()) && temp.getUserName().equals(user.getUserName())) {
					isContain = true;
					break;
				}
			}
		}
		return isContain;
	}
	
	/**
	 * 添加用户
	 * @param user
	 */
	public static void addUser(User user) {
		if(user != null && !isContainUser(user)) {
			list.add(user);
		}
	}
	
	/**
	 * 获取用户
	 * @param userName
	 * @return
	 */
	public static User getUser(String userName) {
		User user = null;
		if(list != null && !list.isEmpty() && Utils.isNotNull(userName)) {
			for(User temp : list) {
				if(Utils.isNotNull(temp.getUserName()) && temp.getUserName().equals(userName)) {
					user = temp;
					break;
				}
			}
		}
		return user;
	}
	
	/**
	 * 删除用户
	 * @param user
	 */
	public static boolean DelUser(User user) {
		if(user != null) {
			User temp  = getUser(user.getUserName());
			if(temp != null) {
				list.remove(temp);
				return true;
			}
		}
		return false;
	}
	

}
