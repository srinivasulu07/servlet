package demo.servlet.welcome;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import demo.servlet.dao.LoginDao;
import demo.servlet.model.Login;
import demo.servlet.utility.ConnectionManager;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
//		RequestDispatcher rd=request.getRequestDispatcher("html/login.html");
//		rd.include(request, response);
		String uid=request.getParameter("userid");
//      System.out.println(uid);
		String pwd=request.getParameter("password");
      
		Login login = new Login();
		login.setUserId(uid);
		login.setPassword(pwd);
		LoginDao loginDao = new LoginDao();
		boolean credentials = loginDao.validateUser(login);
		
		PrintWriter pw=response.getWriter();
	       
        
        if(credentials) {
              pw.print("Welcome "+uid);
              RequestDispatcher rd=request.getRequestDispatcher("/WelcomeServlet");
      		rd.forward(request, response);
          }else {
                	response.sendRedirect("http://localhost:8090/WecomeLogin/html/login.html");
//            		RequestDispatcher rd=request.getRequestDispatcher("html/login.html");
//            		rd.include(request, response);
          }
        pw.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
