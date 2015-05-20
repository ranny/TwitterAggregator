<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="model.TweetLabel"%>
<%@page import="model.User"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator" %>
<%@page import="java.util.Calendar" %>
<%@page import="java.util.Calendar" %>
<%@page import="java.text.SimpleDateFormat" %>
<%@page import="java.util.Date" %>

<section class="tw-content">
  <div class="container">
    <div class="row">

      <div class="alert alert-warning">
        <h3>Crawler tweet</h3>
        <p>You can gain more data from Twitter with this feature.</p>
      </div>

      <div class="panel panel-success">
        <div class="panel-heading">
          <h3 class="panel-title">Data information</h3>
        </div>
        <div class="panel-body">
	<%
		//get total tweet crawl
		int countTweet = (Integer)request.getAttribute("countTweet");
		int countLastTweetBeforeCrawl = (Integer)request.getAttribute("countLastTweetBeforeCrawl");
		String lastCreatedAtBeforeCrawl = (String)request.getAttribute("lastCreatedAtBeforeCrawl");
		//get current date
		Calendar cal = Calendar.getInstance();
		cal.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//convert last created at to date
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateInString = lastCreatedAtBeforeCrawl;
		Date date = formatter.parse(dateInString);
		lastCreatedAtBeforeCrawl = formatter.format(date);
	%>
          Last data crawler record since <%= lastCreatedAtBeforeCrawl %>: <strong><%= countLastTweetBeforeCrawl %></strong> tweets <br>
          New data crawler record since <%= sdf.format(cal.getTime()) %>: <strong><%= countTweet %></strong> tweets
        </div>
      </div>
      
      <div class="tw-label">
        <form class="form-horizontal">
          <div class="form-group">
            <div class="col-md-4">
              <a href="/TwitterAggregator2/Filter" class="btn btn-default">Back</a>
            </div>
          </div>
        </form>
      </div>
  </div>
</section>