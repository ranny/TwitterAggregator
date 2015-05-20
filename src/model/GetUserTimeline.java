package model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import twitter4j.Status;
import twitter4j.TwitterException;

public class GetUserTimeline {

	TwitterAuth ta = new TwitterAuth();
	DbTweet dbt = new DbTweet();
	
	public int countTweet = 0;
	public String errorMessage = null;
	
	public void getUserTimeline(List<String> users) throws Exception {
		if(ta.getAccessToken() == null) {
			ta.oauthLogin();
		}
		System.out.println("OK!");
		
		try {
			dbt.openConnection();
			
			//check if tweet have stored
			List<Tweet> tw = new ArrayList<Tweet>();
			tw = dbt.getTweets();
			Boolean check = false;
			int count = 0;
			
			List<Status> statuses;
			for(String user : users) {
				if(user.length()!=0) {
					statuses = ta.twitter.getUserTimeline(user);
				}
				else {
					user = ta.twitter.verifyCredentials().getScreenName();
					statuses = ta.twitter.getUserTimeline();
				}
				System.out.println("Showing @" + user + "'s timeline.");
				//print tweet
				for(Status status : statuses) {
					System.out.println(
							"USER: "
							+status.getUser().getId()+","
							+"@"+status.getUser().getScreenName()+","
							+status.getUser().getName()+","
							+status.getUser().getDescription()+","
							+status.getUser().getFollowersCount()+","
							+status.getUser().getFriendsCount()+","
							+status.getUser().isVerified()
					);
					System.out.println(
							"TWEET: "
							+status.getId()+","
							+status.getText()+","
							+status.getCreatedAt()+","
							+status.getSource()+","
							+status.getSource()+","
							+status.isRetweet()+","
							+status.isFavorited()+","
							+status.getRetweetCount()+","
							+status.getUser().getId()
					);
					System.out.println(
							"CHECK: "
							+status.isTruncated()+","
							+status.getId()
					);
					//create Tweet Instance
					Tweet t = new Tweet(status.getId(), status.getText(), parseTwitterDate(status.getCreatedAt().toString()), status.getSource(), status.isRetweet(),
										status.isFavorited(), status.getRetweetCount(), status.isTruncated(), status.getUser().getId());
					
					//insert tweet
					if(tw.isEmpty()) {
						dbt.insertTweet(t);
						count++;
					} else {
						for(Tweet twt : tw) {
							if(status.getId() == twt.getTweetId()) {
								check = false;
								break;
							} else {
								check = true;
							}
						}
						if(check == true) {
							dbt.insertTweet(t);
							count++;
							System.out.println("Tweet tersimpan");
						} else {
							System.out.println("Tweet tidak tersimpan");
						}
					}
				}
			}
			dbt.closeConnection();
			System.out.println("Jumlah tweet tersimpan: " + count);
			countTweet = count;
		}
		catch(TwitterException te) {
			te.printStackTrace();
			System.out.println("Failed to get timeline: " + te.getMessage());
			errorMessage = te.getMessage();
			//System.exit(-1);
		}
	}
	
	public static String parseTwitterDate(String dateStr) throws ParseException {
		DateFormat readFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss ZZZZZ yyyy");
		DateFormat writeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		Date date = null;
		try {
			date = readFormat.parse(dateStr);
		}
		catch(ParseException pe) {
			pe.printStackTrace();
		}
		
		String formattedDate = "";
		if(date != null) {
			formattedDate = writeFormat.format(date);
		}
		
		return formattedDate;
	}
	
}
