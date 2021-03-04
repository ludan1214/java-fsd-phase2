package phase2.server;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SendLoginDetails
 */
@WebServlet("/sendLoginDetails")
public class SendLoginDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendLoginDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/dashboard").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
	    String password = request.getParameter("password");
	    UserManager manager = new UserManager();
	    User user = manager.login(username, password);
	    if (user != null) {
	    	HttpSession session = request.getSession();
	    	session.setAttribute("user", user);
	    	request.setAttribute("user", user);
	    	doGet(request, response);
	    } else {
	    	request.setAttribute("errorMessage", "Username/Password combination not found!");
	    	request.getRequestDispatcher("login.jsp").forward(request, response);
	    }
	}

}
