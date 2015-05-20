<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<section class="tw-content">
  <div class="container">
    <div class="row">

      <div class="alert alert-warning">
        <h3>Tweets</h3>
        <p>You can see Tweets collection that we have gain.</p>
      </div>
      
      <div class="tw-label">
        <form class="form-horizontal">
          <div class="form-group">
            <div class="col-md-4">
	            <table class="table table-bordered">
				  <tr>
				  	<th>#</th>
				  	<th>Term</th>
				  	<th>Weight</th>
				  </tr>
				  <tr>
				  	<td>1</td>
				  	<td>di</td>
				  	<td>2.92876474828374635875</td>
				  </tr>
				  <tr>
				  	<td>2</td>
				  	<td>cinta</td>
				  	<td>2.92347346374639750035</td>
				  </tr>
				</table>
              <a href="/TwitterAggregator2/Preprocessing" class="btn btn-primary">Start Preprocessing</a>
              <a href="/TwitterAggregator2/Weighting" class="btn btn-primary">Start Weighting</a>
              <a href="/TwitterAggregator2/Filter" class="btn btn-default">Cancel</a>
            </div>
          </div>
        </form>
      </div>

      <div class="list-group">

      </div>
  </div>
</section>