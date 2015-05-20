<%@page import="model.TweetLabel"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="model.Tweet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<section class="tw-content">
  <div class="container">
    <div class="row">

      <div class="alert alert-warning">
        <h3>Labeling tweet</h3>
        <p>Please select the filter which is fit with each tweet.</p>
      </div>

      <div class="list-group">

  <%
    List<Tweet> tw = (List<Tweet>)request.getAttribute("tweetsLimit");
    List<TweetLabel> tl = (List<TweetLabel>)request.getAttribute("tweetLabel");
    int i = 1;
  %>
        <form action="/TwitterAggregator2/SaveLabel" method="post">
  <%
    for(Tweet t : tw) {
  %>
          <div class="col-md-12">
            <h4> <span class="mdi-image-filter-drama"></span> RAW Tweet: <%= i %></h4>
          </div>

          <div class="list-group-item">
            <div class="row-picture">
              <img class="circle" src="<%= t.getProfileImageURL() %>" alt="icon">
            </div>
            <div class="row-content">
              <div class="panel panel-info">
                <div class="panel-heading">
                  <h3 class="panel-title">
                  <a href=""><%= t.getName() %></a> <small>@<%= t.getScreenName() %> <span class="time"> <%= t.getCreatedAt() %></span></small>
                  </h3>
                </div>
                <div class="panel-body">
                  <p><%= t.getTweetText() %></p>
                </div>
              </div>
            </div>
          </div>

          <input type="hidden" name="<%= "tweetId" + i %>" value="<%= t.getTweetId() %>">

            <div class="tw-label">
              <div class="form-horizontal">
                <div class="form-group">
                  <label for="select" class="col-md-2 control-label">Tweet Label</label>
                  <div class="col-md-3">
                    <select class="form-control" id="select" name="<% out.print("class" + i); %>">
                    <option value = 1>No Label</option>
  <%
      for(TweetLabel tLabel : tl) {
        if(tLabel.getLabelId() != 1 && tLabel.getLabelId() != 9) {
  %>
                      <option value = "<%= tLabel.getLabelId() %>"><%= tLabel.getLabel() %></option>
  <%
        }
      }
  %>
                    </select>
                  </div>
                </div>
              </div>
            </div>

            <div class="list-group-separator"></div>

  <%
      i++;
    }
  %>
            <div class="tw-label">
              <div class="form-horizontal">
                <div class="form-group">
                  <div class="col-md-3 col-md-offset-9">
                    <a href="../TwitterAggregator2/home/filter.jsp" class="btn btn-default">Cancel</a>
                    <input type="submit" class="btn btn-primary" value="Submit">
                  </div>
                </div>
              </div>
            </div>
        </form>

      </div>
  </div>
</section>