<%@page import="model.TweetLabel"%>
<%@page import="model.User"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator" %>
<%@page import="java.util.Calendar" %>
<%@page import="java.text.SimpleDateFormat" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<section class="tw-content">
  <div class="container">
    <div class="row">

      <div class="alert alert-warning">
        <h3>Crawler tweet</h3>
        <p>You can gain more data from Twitter with this feature.</p>
      </div>

      <div class="panel panel-primary">
        <div class="panel-heading">
          <h3 class="panel-title">Crawling information</h3>
        </div>
        <div class="panel-body">
	<%
		Calendar cal = Calendar.getInstance();
		cal.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println( sdf.format(cal.getTime()) );
		List<TweetLabel> tl = (List<TweetLabel>)request.getAttribute("tweetLabel");
		List<User> u = (List<User>)request.getAttribute("user");
		int countLabel = tl.size();
		int countUser = u.size();
		int i = 0;
		int j = 0;
	%>
          We gain Tweet data from several users that competent in different fields such as
    <%
    	
    	for(TweetLabel tLabel : tl) {
    		if(tLabel.getLabelId() != 1) {
    			i++;
    			if(i != (countLabel-1)) {
    %>
    		<b>&quot;<%= tLabel.getLabel() %>&quot;</b>,&nbsp;
    <%
    			} else if (i == 14) {
    %>
    		and <b>&quot;<%= tLabel.getLabel() %>&quot;</b>.
    <%
    			}

    		}
    	}
    %>
         <br><br>
          The following users consist of:<br>
    <%
    	for(User usr : u) {
    		j++;
    		if(j != countUser) {
    			out.print("@" + usr.getScreenName() + ", ");
    		}
    		else {
    			out.print("and @" + usr.getName() + ".");
    		}
    	}
    %>
        </div>
      </div>

      <div class="tw-label">
        <form class="form-horizontal">
          <div class="form-group">
            <div class="col-md-4">
              <a href="/TwitterAggregator2/Crawler" class="btn btn-primary">Start Crawling</a>
              <a href="/TwitterAggregator2/Filter" class="btn btn-default">Cancel</a>
            </div>
          </div>
        </form>
      </div>
  </div>
</section>