package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DbTweet;
import model.Preprocessing;
import model.Weighting;

/**
 * Servlet implementation class WeightingServlet
 */
@WebServlet("/WeightingServlet")
public class WeightingServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
	
	private static DbTweet dbt;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WeightingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//start measuring execute times
		long startTime = System.currentTimeMillis();
		
		dbt = new DbTweet();
		dbt.openConnection();
		
		Preprocessing prepro = new Preprocessing();
		Weighting weight = new Weighting();
		
		List<String> tweetText;
		String tweetPrepro = "";
		List<String> tweetResult = new ArrayList<String>();
		try {
			tweetText = dbt.getTweetsForPrepro();
			//load file: synonym, stopword supaya tidak berkali kali
			prepro.loadSynonymSpFromFile();
			prepro.loadSynonymFromFile();
			prepro.loadStopwordsFile();
			
			int i = 0;
			for(String text : tweetText) {
				prepro.doPreprocessing(text);
				tweetPrepro = prepro.result;
				tweetResult.add(tweetPrepro);
			}
			weight.countWeightPerTweet(tweetResult);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//end measuring execute times
		long endTime = System.currentTimeMillis();
		System.out.println("That took " + (endTime - startTime) + " milliseconds");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
