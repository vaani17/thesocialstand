<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<link rel="shortcut icon" href="images/STT9.ico" type="image/x-icon" />
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link href="index.css" type="text/css" rel="stylesheet" />
<link href="modal.css" type="text/css" rel="stylesheet" />

<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<title>TheSocialStand</title>
<meta name="generator" content="Bootply" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<link href="css/bootstrap.min.css" rel="stylesheet">
<!--[if lt IE 9]>
        <script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
<link href='http://fonts.googleapis.com/css?family=Poiret+One'
	rel='stylesheet' type='text/css'>
</head>

<body background="images/mix.jpg">

	<div class="row" class="middle" style="width: 100%; height: 100%">
		<br>
		<div class="up">
			<button id="myBtn">
				<img src="images/view.png" alt="Sign Up" height="30" width="80">
			</button>
			&nbsp; &nbsp;
		</div>
		</div>
		<br> <br> <br>


		<%
			if (request.getAttribute("modal") != null) {
				String cm = request.getAttribute("modal").toString();
				String data = request.getAttribute("healtharticle").toString();
				String d[] = data.split("nitts");
		%>


		<!-- The Modal -->
		<div id="myModal" class="modal">

			<!--login modal-->
			<div id="loginModal" class="modal show" tabindex="-1" role="dialog"
				aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true">X</button>
							<h1 class="text-center">
								<%
									out.print(d[0]);
								%>
							</h1>
						</div>
						<div class="row text-center">

							<%
								if (cm.contentEquals("1")) {
							%>
							<script type="text/javascript">
								document.getElementById('myModal').style.display = "block";
							</script>
							<p style="color: black">
								<%
									out.print(d[1]);
								%>
							</p>
							<%
								}
								}
							%>

						</div>
						<div class="row text-center">
							<br>
							<!--         <div class="col-md-4 col-sm-12"> -->
							<!--             <button type="button" class="btn btn-primary btn-block">Facebook</button> -->
							<!--         </div> -->


							<!--         <div class="col-md-4 col-sm-12"> -->
							<!--             <button type="button" class="btn btn-danger btn-block">Google+</button> -->
							<!--         </div> -->
						</div>
						<div class="modal-body">

							<form action="login" class="form col-md-12 center-block">

								<div class="form-group">
									<button class="btn btn-primary btn-lg btn-block">Like</button>
									<!--       <span class="pull-right"><a href="register.jsp">Register</a></span><span><a href="FPass.jsp">Forgot Password?</a></span> -->
								</div>
							</form>
						</div>
						<div class="modal-footer"></div>
					</div>
				</div>
			</div>
			<!-- script references -->
			<script
				src="//ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
			<script src="js/bootstrap.min.js"></script>
		</div>

		<script>
			// Get the modal
			var modal = document.getElementById('myModal');

			// Get the button that opens the modal
			var btn = document.getElementById("myBtn");

			// Get the <span> element that closes the modal
			var span = document.getElementsByClassName("close")[0];

			// When the user clicks the button, open the modal 
			btn.onclick = function() {
				modal.style.display = "block";
			}

			// When the user clicks on <span> (x), close the modal
			span.onclick = function() {
				modal.style.display = "none";
			}

			// When the user clicks anywhere outside of the modal, close it
			window.onclick = function(event) {
				if (event.target == modal) {
					modal.style.display = "none";
				}
			}
		</script>

</body>
</html>