package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DbLabel;
import model.DbTweet;
import model.Tweet;
import model.TweetLabel;

/**
 * Servlet implementation class LabellingServlet
 */
@WebServlet("/LabellingServlet")
public class LabellingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static DbTweet dbt;
	private static DbLabel dbl;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LabellingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		dbt = new DbTweet();
		dbl = new DbLabel();
		dbt.openConnection();
		dbl.openConnection();
		
		String menu = new String();
		List<Tweet> tweetsLimit = new ArrayList<Tweet>();
		List<TweetLabel> tweetLabel = new ArrayList<TweetLabel>();
		try {
			//set menu in header
			menu = "<li><a href=\"/TwitterAggregator2/Filter\">Filters</a></li>"
					+ "<li><a href=\"/TwitterAggregator2/Tweets\">Tweets</a></li>"
					+ "<li class=\"active\"><a href=\"/TwitterAggregator2/Labelling\">Labeling</a></li>"
					+ "<li><a href=\"/TwitterAggregator2/PreprocessingInfo\">Preprocessing</a></li>"
					+ "<li><a href=\"/TwitterAggregator2/CrawlerInfo\">Crawler</a></li>"
					+ "<li><a href=\"about.html\">About</a></li>";
			request.setAttribute("menu",  menu);
			//get tweet from db
			tweetsLimit = dbt.getTweetsLimit();
			tweetLabel = dbl.getLabel();
			request.setAttribute("tweetsLimit", tweetsLimit);
			request.setAttribute("tweetLabel", tweetLabel);
			getServletContext().getRequestDispatcher("/labeling/TempLabeling.jsp").forward(request, response);
			//close db connection
			dbt.closeConnection();
			dbl.closeConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
