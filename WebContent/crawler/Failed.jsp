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

      <div class="panel panel-danger">
        <div class="panel-heading">
          <h3 class="panel-title">Crawling information</h3>
        </div>
        <div class="panel-body">
	<%
		//get error message
		String errorMessage = (String)request.getAttribute("errorMessage");
	%>
          <%= errorMessage %>
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