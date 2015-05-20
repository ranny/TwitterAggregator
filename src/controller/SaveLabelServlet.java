package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DbTweet;
import model.Tweet;

/**
 * Servlet implementation class SaveLabel
 */
@WebServlet("/SaveLabelServlet")
public class SaveLabelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private DbTweet dbt = new DbTweet();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveLabelServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		dbt.openConnection();
		
		for(int i = 1; i <= 50; i++) {
			long tweetId = Long.parseLong(request.getParameter("tweetId" + i));
			int label = 1;
			if(request.getParameter("class" + i) != null) {
				label = Integer.parseInt(request.getParameter("class" + i));
			}
			
			System.out.println(tweetId +" : "+ label);
			
			Tweet t = new Tweet();
			t.setTweetId(tweetId);
			t.setLabel(label);
			boolean update = dbt.updateLabel(t);
			if(update == true) {
				System.out.println("Tersimpan!");
			}
			else {
				System.out.println("Data tidak tersimpan");
			}
			
			if(i == 50) {
				System.out.println("Selesai!");
			}
		}
	}

}
