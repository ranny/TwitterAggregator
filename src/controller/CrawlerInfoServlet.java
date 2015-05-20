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
import model.DbUser;
import model.TweetLabel;
import model.User;

/**
 * Servlet implementation class CrawlerServlet2
 */
@WebServlet("/CrawlerInfoServlet")
public class CrawlerInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static DbLabel dbl;
	private static DbUser dbu;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrawlerInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		dbl = new DbLabel();
		dbu = new DbUser();
		dbl.openConnection();
		dbu.openConnection();
		
		String menu = new String();
		List<TweetLabel> tweetLabel = new ArrayList<TweetLabel>();
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
			//get tweet label
			tweetLabel = dbl.getLabel();
			//get user
			user = dbu.getUser();
			request.setAttribute("tweetLabel", tweetLabel);
			request.setAttribute("user", user);
			getServletContext().getRequestDispatcher("/crawler/TempCrawler.jsp").forward(request, response);
			//close db connection
			dbl.closeConnection();
			dbu.closeConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
