package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginForwordServlet extends HttpServlet {

	private static final long serialVersionUID = -1912222886837122490L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		String userName = request.getParameter("username");
		System.out.println("name:" + userName);
		request.getRequestDispatcher("/main.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
