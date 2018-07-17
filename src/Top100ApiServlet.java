import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

// Declaring a WebServlet called Top50ApiServlet, which maps to url "/api/single-star"
@WebServlet(name = "Top100ApiServlet", urlPatterns = "/api/top100")
public class Top100ApiServlet extends HttpServlet {
    private static final long serialVersionUID = 2L;
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("application/json"); // Response mime type

		// Output stream to STDOUT
        PrintWriter out = response.getWriter();
        
        Scanner scanner = new Scanner(new File("/root/Coin/Top100_trim.json"));
        
		System.out.println("Succefully loaded\n");
	
		out.write(scanner.nextLine());
        response.setStatus(200);
        
        scanner.close();
        out.close();
	}

}
