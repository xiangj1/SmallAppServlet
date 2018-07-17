import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

// Declaring a WebServlet called TokenAccessApiServlet, which maps to url "/api/single-star"
@WebServlet(name = "MessageServlet", urlPatterns = "/api/msg")
public class MessageServlet extends HttpServlet {
	private static final long serialVersionUID = 2L;

	// Create a dataSource which registered in web.xml
	// @Resource(name = "jdbc/moviedb")
	// private DataSource dataSource;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("application/json"); // Response mime type

		// Retrieve parameter id from url request.
		String token_name = request.getParameter("name");

		// Output stream to STDOUT
        PrintWriter out = response.getWriter();
        
        if(token_name.equals("top100"))
            out.write("TOP100 Global");
        else
            out.write("Top200 in Ethereum");
        response.setStatus(200);
        
        out.close();
	}

}
