package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DbTweet;
import model.DbUser;
import model.GetUserTimeline;
import model.User;

/**
 * Servlet implementation class CrawlerServlet
 */
@WebServlet("/CrawlerServlet")
public class CrawlerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static DbUser dbu;
	private static DbTweet dbt;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrawlerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		dbu = new DbUser();
		dbt = new DbTweet();
		dbu.openConnection();
		dbt.openConnection();
		
		boolean status = false;
		int countTweet = 0;
		int countLastTweetBeforeCrawl = 0;
		String lastCreatedAtBeforeCrawl = null;
		String errorMessage = null;
		String menu = new String();
		
		List<User> user = new ArrayList<User>();
		try {
			//set menu in header
			menu = "<li><a href=\"/TwitterAggregator2/Filter\">Filters</a></li>"
					+ "<li><a href=\"/TwitterAggregator2/Tweets\">Tweets</a></li>"
					+ "<li><a href=\"/TwitterAggregator2/Labelling\">Labeling</a></li>"
					+ "<li><a href=\"/TwitterAggregator2/PreprocessingInfo\">Preprocessing</a></li>"
					+ "<li class=\"active\"><a href=\"/TwitterAggregator2/CrawlerInfo\">Crawler</a></li>"
					+ "<li><a href=\"about.html\">About</a></li>";
			request.setAttribute("menu", menu);
			//count last tweet before crawl
			countLastTweetBeforeCrawl = dbt.countTweet();
			//get last created at before crawl
			lastCreatedAtBeforeCrawl = dbt.getLastCreatedAt();
			//get user from db
			user = dbu.getUser();
			//store user to list
			List<String> users = new ArrayList<String>();
			for(User t : user) {
				users.add(t.getScreenName());
			}
			//get user timeline
			GetUserTimeline gut = new GetUserTimeline();
			gut.getUserTimeline(users);
			//set status
			/*if(gut != null) {
				status = true;
				countTweet = gut.countTweet;
			}*/
			
			if(gut != null) {
				errorMessage = gut.errorMessage;
				//countTweet = gut.countTweet;
				if(errorMessage == null) {
					status = true;
					countTweet = gut.countTweet;
				} else {
					status = false;
				}
			}
			
			/*if(countTweet != 0) {
				status = true;
			}
			else {
				errorMessage = gut.errorMessage;
			}*/
			
			dbu.closeConnection();
			dbt.closeConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//set view
		if(status == true) {
			request.setAttribute("countTweet", countTweet);
			request.setAttribute("countLastTweetBeforeCrawl", countLastTweetBeforeCrawl);
			request.setAttribute("lastCreatedAtBeforeCrawl", lastCreatedAtBeforeCrawl);
			RequestDispatcher rd = request.getRequestDispatcher("/crawler/TempSuccess.jsp");
			rd.forward(request, response);
		} else {
			request.setAttribute("errorMessage", errorMessage);
			RequestDispatcher rd = request.getRequestDispatcher("/crawler/TempFailed.jsp");
			rd.forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
