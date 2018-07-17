import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

// Declaring a WebServlet called TokenAccessApiServlet, which maps to url "/api/single-star"
@WebServlet(name = "TokenAccessApiServlet", urlPatterns = "/api/token")
public class TokenAccessApiServlet extends HttpServlet {
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
        try{
			Scanner scanner = new Scanner(new File("/root/Coin/CoinData/" + token_name + ".json"));
			
			System.out.println("Succefully loaded\n");
			
			// while(scanner.hasNextLine()) {
			// 	String str = scanner.nextLine();
			// 	String[] strings = str.split(" ");
				
			// 	JsonObject rank_info = new JsonObject();
			// 	rank_info.addProperty("rank", strings[1]);
			// 	rank_info.addProperty("address", strings[2]);
			// 	rank_info.addProperty("amount", strings[3]);
			// 	rank
			// }
			

			// JsonObject jsonObject = new JsonObject();
			

			// jsonObject.add(token_name, );
			// out.write(jsonObject.toString());
			out.write(scanner.nextLine());
			response.setStatus(200);
			scanner.close();
		} catch (Exception e) {
			String str = "{\"data\":[{\"rank\":\"1\",\"address\":\"Still Working\",\"amount\":\"Still Working\",\"percentage\":\"Still Working\"}],\"timestamp\":\"1531416506\"}";
			out.write(str);
			response.setStatus(200);
		}
        
        
        out.close();

		// try {
		// 	// Get a connection from dataSource
		// 	Connection dbcon = dataSource.getConnection();

		// 	// Construct a query with parameter represented by "?"
		// 	String query = "SELECT * from stars as s, stars_in_movies as sim, movies as m where m.id = sim.movieId and sim.starId = s.id and s.id = ?";

		// 	// Declare our statement
		// 	PreparedStatement statement = dbcon.prepareStatement(query);

		// 	// Set the parameter represented by "?" in the query to the id we get from url,
		// 	// num 1 indicates the first "?" in the query
		// 	statement.setString(1, id);

		// 	// Perform the query
		// 	ResultSet rs = statement.executeQuery();

		// 	JsonArray jsonArray = new JsonArray();

		// 	// Iterate through each row of rs
		// 	while (rs.next()) {
		// 		String starId = rs.getString("starId");
                
        //         // Create a JsonObject based on the data we retrieve from rs
		// 		JsonObject jsonObject = new JsonObject();
		// 		jsonObject.addProperty("star_id", starId);

		// 		jsonArray.add(jsonObject);
		// 	}
			
        //     // write JSON string to output
        //     out.write(jsonArray.toString());
        //     // set response status to 200 (OK)
        //     response.setStatus(200);

		// 	rs.close();
		// 	statement.close();
		// 	dbcon.close();
		// } catch (Exception e) {
		// 	// write error message JSON object to output
		// 	JsonObject jsonObject = new JsonObject();
		// 	jsonObject.addProperty("errorMessage", e.getMessage());
		// 	out.write(jsonObject.toString());

		// 	// set reponse status to 500 (Internal Server Error)
		// 	response.setStatus(500);
		// }
	}

}
