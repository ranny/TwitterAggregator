<%@page import="model.TweetLabel"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="model.Tweet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tweet Labelling</title>
</head>
<body>
	<%
		List<Tweet> tw = (List<Tweet>)request.getAttribute("tweetsLimit");
		List<TweetLabel> tl = (List<TweetLabel>)request.getAttribute("tweetLabel");
		int i = 1;
	%>
	<form action="/TwitterAggregator/SaveLabel" method="post">
	<%
		for(Tweet t : tw) {
	%>
		<fieldset>
			<% out.print("<b>Tweet #" + i + " by " + t.getName() + " (@"+ t.getScreenName() +") - created at " + t.getCreatedAt() + ":</b><br> " + t.getTweetText()); %> <br>
			<input type="hidden" name="<%= "tweetId" + i %>" value="<%= t.getTweetId() %>">
	<%
			for(TweetLabel tLabel : tl) {
				if(tLabel.getLabelId() != 1) {
	%>
			<input type="radio" name="<% out.print("class" + i); %>" value="<%= tLabel.getLabelId() %>"><%= tLabel.getLabel() %>&nbsp;&nbsp;	
	<%
				}
			}
	%>
		</fieldset>
		<br>
	<%
			i++;
		}
	%>
			<input type="submit" value="submit">
	</form>
</body>
</html>