package phase2.server;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SendRegisterDetails
 */
@WebServlet("/sendRegisterDetails")
public class SendRegisterDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendRegisterDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String firstname = request.getParameter("firstname");
	    String lastname = request.getParameter("lastname");
	    String username = request.getParameter("username");
	    String password = request.getParameter("password");
	    UserManager manager = new UserManager();
	    if (manager.register(firstname,lastname,username,password)) {
	    	request.setAttribute("successMessage", "Registration Successful, Please Login");
	    	doGet(request, response);
	    } else {
	    	request.setAttribute("errorMessage", "Registration Failed, username already exists");
	    	request.getRequestDispatcher("register.jsp").forward(request, response);
	    }
		
	}

}
