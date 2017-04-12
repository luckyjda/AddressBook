package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.UserDao;
import domain.User;

/**
 * 
* Title:LoginServlet 
* Description: 登陆Servlet 
* @author luckyjda
* @date 2017-4-12
 */
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 6264381047408967619L;
	private UserDao userDao = new UserDao();

	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		User user = userDao.getUser_(userName);
		if(user == null) {
			responseError(response);
		}else if(!user.getPassword().equals(password)){
			responseError(response);
		}else {
//			request.getSession().setAttribute("user", user);
//			response.sendRedirect("/AddressBook/main.jsp");
//			request.getRequestDispatcher("/AddressBook/main.jsp").forward(request, response);
			//return;
			response.getWriter().write("success");
			response.flushBuffer();
		}
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		doGet(request, response);
	}
	
	public void responseError(HttpServletResponse response) throws IOException {
		response.getWriter().write("error");
		response.flushBuffer();
	}

}
