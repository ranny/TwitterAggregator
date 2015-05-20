package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PreprocessingInfoServlet
 */
@WebServlet("/PreprocessingInfoServlet")
public class PreprocessingInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PreprocessingInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String menu = new String();
		try {
			//set menu in header
			menu = "<li><a href=\"/TwitterAggregator2/Filter\">Filters</a></li>"
					+ "<li class=\"active\"><a href=\"/TwitterAggregator2/Tweets\">Tweets</a></li>"
					+ "<li><a href=\"/TwitterAggregator2/Labelling\">Labeling</a></li>"
					+ "<li><a href=\"/TwitterAggregator2/PreprocessingInfo\">Preprocessing</a></li>"
					+ "<li><a href=\"/TwitterAggregator2/CrawlerInfo\">Crawler</a></li>"
					+ "<li><a href=\"about.html\">About</a></li>";
			request.setAttribute("menu", menu);
			getServletContext().getRequestDispatcher("/preprocessing/TempPreprocessingInfo.jsp").forward(request, response);
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
