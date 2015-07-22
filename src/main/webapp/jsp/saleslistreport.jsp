<!DOCTYPE html>
<html>
<head lang="zh">
<meta charset="utf-8">
<%@ page pageEncoding="UTF-8"%>

<%@ include file="all2.jsp"%>
</head>
<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
	<h3 class="page-header">销售明细报表</h3>

	<div class="row placeholders">
		<form class="form-inline" action="salesCheckReport" method="get">
			<div class="form-group">
				<label for="query_customerName">销售流水号：</label> <input type="text"
					class="form-control" id="salesSerialNumber"
					name="salesSerialNumber" placeholder="销售流水号">
			</div>			
			<button type="submit" class="btn btn-primary">销售报表导出</button>
		</form>
	</div>
	
	
</div>

<!-- jQuery (necessary for Flat UI's JavaScript plugins) -->
<script src="<%=path%>/js/vendor/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="<%=path%>/js/vendor/video.js"></script>
<script src="<%=path%>/js/flat-ui.min.js"></script>
<script src="<%=path%>/js/customer.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		
	});
</script>
</body>
</html>