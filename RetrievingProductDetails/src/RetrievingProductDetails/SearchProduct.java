package RetrievingProductDetails;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

/**
 * Servlet implementation class SearchProduct
 */
@WebServlet("/searchProduct")
public class SearchProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchProduct() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    private ResultSet searchID(String id, Connection conn) throws SQLException {
    	PreparedStatement query = (PreparedStatement) conn.prepareStatement("SELECT * FROM product_tbl WHERE product_id = ?");
    	query.setString(1, id);
    	return query.executeQuery();
    }
    
    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ResultSet res; 
		Connection con; 
		PrintWriter out = response.getWriter();  
		String id = request.getParameter("productID");
		Connection conn = null;
		// TODO Auto-generated method stub
		try {
			con = DatabaseConnection.initializeDatabase();
			res = searchID(id, con);
			
			response.setContentType("text/html");  
	        out.println("<html>" // Begin HTML
	        		+ "<head>" // Head
					+ "<style>"
					+ "table {"
					+ "  font-family: arial, sans-serif;"
					+ "  border-collapse: collapse;"
					+ "  width: 100%; }"
					+ "td, th {"
					+ "  border: 1px solid #dddddd;"
					+ "  text-align: left;"
					+ "  padding: 8px;}"
					+ "tr:nth-child(even) {"
					+ "  background-color: #dddddd;}"
					+ "</style>"
					+ "</head>" // End Head
	        		+ "<body>"); // Body
	        // Form
	        out.println("<form action=\"searchProduct\" method=\"post\">"
	        		+ "Enter the Product ID to search: " 
	        		+ "<input type=\"text\" name=\"productID\" size=\"20\">"
	        		+ "<input type=\"submit\" value=\"Search\" /></form>");
	        // Table
	        out.println("<table style = \"width:50%\"><tr>\n"
	        		+ "<th>ID</th>"
	        		+ "<th>Name</th>"
	        		+ "<th>Description</th>"
	        		+ "</tr>");
			if (res.next()) {
				int prod_id = res.getInt("product_id");
				String name = res.getString("product_name");
				String details = res.getString("product_details");
				
				out.println("<tr><td>" + prod_id + "</td><td>" +  name + "</td><td>" + details + "</td></tr></table>"); 
			} else {
				out.println("No product with id " + id + " was found!");
			}
			out.println("</body></html>"); //End Body and HTML
            con.close();  
		} catch (ClassNotFoundException e) {
			log("Sorry, couldn't found JDBC driver. Make sure you have added JDBC Maven Dependency Correctly");
			e.printStackTrace();
			return;
		} catch (SQLException e) {
			log("MySQL Database Error!");
			e.printStackTrace();
			return;
		}
	}

}
