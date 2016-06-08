<!DOCTYPE html>
<html>
<head>
<title>TheSocialStand</title>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<style>
html,body {
	margin: 0;
	padding: 0;
	height: 100%;
	width: 100%;
}

#full-size {
	height: 80%;
	width: 100%;
	/* or overflow:auto; if you want scrollbars */
}

.row {
	margin: 0px;
}

.empty {
	margin: 0px;
}

.panel {
	border: 2px solid #428bca;
	word-wrap: break-word;
	overflow: scroll;
}
</style>
</head>
<body background="mix.jpg">
	<%
		String outp = request.getAttribute("linksweekly").toString();
		String retval[] = outp.split("nitts");
	%>

	<div class="row">
		<div class="col-md-4">
			<h1 color="black">READ</h1>
			<div id="full-size" class="panel">
				<%
					out.print(retval[0]);
				%>
			</div>
		</div>

		<div class="col-md-4">
			<h1 color="black">WATCH</h1>
			<div id="full-size" class="panel">
				<%
					out.print(retval[1]);
				%>
			</div>
		</div>

		<div class="col-md-4">
			<h1 color=black">LISTEN</h1>
			<div id="full-size" class="panel">
				<%
					out.print(retval[2]);
				%>
			</div>
		</div>

	</div>
</body>
</html>