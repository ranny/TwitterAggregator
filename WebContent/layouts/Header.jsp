<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<header>
  <nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
      <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-responsive-collapse">
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="/TwitterAggregator2/Filter"><span class="mdi-communication-comment"></span> Twitter Agregrator</a>
      </div>
      <div class="navbar-collapse collapse navbar-responsive-collapse">
        <ul class="nav navbar-nav navbar-right">
        <!-- menu -->
        <%
        	String menu = "";
        	if((String)request.getAttribute("menu") != null) {
        		menu = (String)request.getAttribute("menu");
        	}
        	
        	out.println(menu);
        %>
        </ul>
      </div>
    </div>
  </nav>
</header>