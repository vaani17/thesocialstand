<!DOCTYPE html>
<html>
<head><link rel="shortcut icon" href="images/STT9.ico" type="image/x-icon" />
<title>TheSocialStand</title>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link rel="stylesheet" href="styles.css">
<link rel="stylesheet" href="styles1.css">
<script src="http://code.jquery.com/jquery-latest.min.js"
	type="text/javascript"></script>
<script src="script.js"></script>
<style>
html,body {
	margin: 0;
	padding: 0;
	height: 100%;
	width: 100%;
}

#full-size {
	height: 80%; 41=-
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

ul {
	list-style-type: none;
}

.pure-button {
	position: relative;
	vertical-align: top;
	width: 100%;
	height: 40px;
	padding: 0;
	font-size: 20px;
	color: white;
	text-align: left;
	text-shadow: 0 1px 2px rgba(0, 0, 0, 0.25);
	background: #1abc9c;
	border: 0;
	border-bottom: 2px solid #12ab8d;
	cursor: pointer;
	-webkit-box-shadow: inset 0 -2px #12ab8d;
	box-shadow: inset 0 -2px #12ab8d;
}

.col-md-3 {
	padding: 0;
}

.pure-button:active {
	top: 1px;
	outline: none;
	-webkit-box-shadow: none;
	box-shadow: none;
}
}

/*  .fws */
/*  {  */
/*  	position: fixed;	  */
/*  	left: 0;  */
/*    top: 20%;  */
/*   width: 8em;  */
/*  }  */

/*  .fws1  */
/*  {  */
/*  	position: fixed;	  */
/*  	left:30%;  */
/*   top: 0;  */
/*   width: 100%;  */
/*  }  */

/*  .fws1-body {  */
/*   /* this will adjust body top margin to prevent content jumping when nav gets fix  */
*
/
/*     margin-top: 50px;  */
/*  /* adjust as per height of your menu */



 



*
/
/*  }  */
</style>
</head>
<body>

	<br>
	<br>

	<div class="col-md-3">
		<img src="images/STT9.png" width="30%" height="50%" />
	</div>

	<div class="fws1">
		<div class="col-md-9">
			<div class="col-md-4">
				<form action="news" method="get">
					<button class="pure-button">Read</button>
				</form>
			</div>

			<div class="col-md-4">

				<form action="trending" method="get">
					<button class="pure-button">Watch</button>
				</form>
			</div>
			<div class="col-md-4">

				<form action="english" method="get">
					<button class="pure-button">Listen</button>
				</form>
			</div>
		</div>
	</div>

	<br>
	<br>
	<br>
	<br>
	<br>
	<div class="fws">
		<div class="col-md-3">
			<div id='cssmenu'>

				<ul>

					<form action="trending" method="get">
						<li><button class="pure-button">Trending Videos</button></li>
					</form>
					<form action="newsvideo" method="get">
						<li><button class="pure-button">Latest News</button></li>
					</form>
					
				</ul>
			</div>
		</div>
	</div>
	
 
	<%
		String outp2 = request.getAttribute("linkswatch").toString();
	%>

	<div class="row">
		<div class="col-md-9">
			<div id="full-size" class="">
				<div class="panel">
					<%
						out.print(outp2);
					%>
				</div>
			</div>
		</div>
	</div>
	
	<br>
	<br>

</body>
</html>