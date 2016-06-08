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
				<img src="images/register3.png" alt="Sign Up" height="30" width="30">
			</button>
			&nbsp; &nbsp; <a class=" transbtn" href="AboutUs.jsp">About Us</a>
		</div>
		<br>

		<div id="title" class="bigtext trans">The Social Stand</div>
	</div>

	<br>
	<div class="row">
		<div id="emptyleft" class="col-md-2"></div>
		<div id="articles" class="col-md-2 features">
			<form action="news" method="get">
				<input type="image" src="images/articles.png" alt="music"
					width="100%" height="80%" />
			</form>
		</div>
		<div id="" class="col-md-1"></div>
		<div id="video" class="col-md-2 features">
			<form action="trending" method="get">
				<input type="image" src="images/video.png" alt="music" width="100%"
					height="80%" />
			</form>
		</div>
		<div id="" class="col-md-1"></div>
		<div id="music" class="col-md-2 features">
			<form action="english" method="get">
				<input type="image" src="images/music.png" alt="music" width="100%"
					height="80%" />
			</form>
			<!-- 			<img src="music.png" alt="music" width="100%" height="80%"> -->
		</div>

		<div id="emptyright" class="col-md-2"></div>

	</div>
	<br>
	<br>
	<div class="row" class="middle" style="width: 100%; height: 100%">

		<div id="title" class="medtext">It's all here.</div>
	</div>
	<br>
	<br>
	<div class="row" class="middle" style="width: 100%; height: 100%">
		<center>
			<form action="Weekly" method="get">
				<input type="submit" class="transbtn" value="Get Started">
		</center>
		</form>
	</div>

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
						<h1 class="text-center">Login</h1>
					</div>
					<div class="row text-center">

						<% 
      if(request.getAttribute("callmodal")!=null)
      {
          String cm=request.getAttribute("callmodal").toString();
       	  if(cm.contentEquals("1"))
      {
       	  %>
						<script type="text/javascript">
    	  document.getElementById('myModal').style.display = "block";
    	  </script>
						<p style="color: red">Incorrect Password</p>
						<%  
      		
      }
       	  else if(cm.contentEquals("2"))
       	{
           	  %>
						<script type="text/javascript">
        	  document.getElementById('myModal').style.display = "block";
        	  </script>
						<p style="color: red">Email already registered. Please login.</p>
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

						<div class="col-md-12 col-sm-12">

							<!--
             Below we include the Login Button social plugin. This button uses
             the JavaScript SDK to present a graphical Login button that triggers
             the FB.login() function when clicked.
           -->

							<fb:login-button scope="public_profile,email"
								onlogin="checkLoginState();">
							</fb:login-button>
						</div>


						<!--         <div class="col-md-4 col-sm-12"> -->
						<!--             <button type="button" class="btn btn-danger btn-block">Google+</button> -->
						<!--         </div> -->
					</div>
					<div class="modal-body">

						<form action="login" class="form col-md-12 center-block">
							<div class="form-group">
								<input type="text" name="email" class="form-control input-lg"
									placeholder="Email">
							</div>
							<div class="form-group">
								<input type="password" name="pass1"
									class="form-control input-lg" placeholder="Password">
							</div>
							<div class="form-group">
								<button class="btn btn-primary btn-lg btn-block">Sign
									In</button>
								<span class="pull-right"><a href="register.jsp">Register</a></span><span><a
									href="FPass.jsp">Forgot Password?</a></span>
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


	<script>
  window.fbAsyncInit = function() {
    FB.init({
      appId      : '502185953306476',
      xfbml      : true,
      version    : 'v2.6'
    });
  };

  (function(d, s, id){
     var js, fjs = d.getElementsByTagName(s)[0];
     if (d.getElementById(id)) {return;}
     js = d.createElement(s); js.id = id;
     js.src = "//connect.facebook.net/en_US/sdk.js";
     fjs.parentNode.insertBefore(js, fjs);
   }(document, 'script', 'facebook-jssdk'));
</script>
------------------
	<script>
  // This is called with the results from from FB.getLoginStatus().
  function statusChangeCallback(response) {
    console.log('statusChangeCallback');
    console.log(response);
    // The response object is returned with a status field that lets the
    // app know the current login status of the person.
    // Full docs on the response object can be found in the documentation
    // for FB.getLoginStatus().
    if (response.status === 'connected') {
      // Logged into your app and Facebook.
      testAPI();
    } else if (response.status === 'not_authorized') {
      // The person is logged into Facebook, but not your app.
      document.getElementById('status').innerHTML = 'Please log ' +
        'into this app.';
    } else {
      // The person is not logged into Facebook, so we're not sure if
      // they are logged into this app or not.
      document.getElementById('status').innerHTML = 'Please log ' +
        'into Facebook.';
    }
  }

  // This function is called when someone finishes with the Login
  // Button.  See the onlogin handler attached to it in the sample
  // code below.
  function checkLoginState() {
    FB.getLoginStatus(function(response) {
      statusChangeCallback(response);
    });
  }

  window.fbAsyncInit = function() {
  FB.init({
    appId      : '502185953306476',
    cookie     : true,  // enable cookies to allow the server to access 
                        // the session
    xfbml      : true,  // parse social plugins on this page
    version    : 'v2.6' // use graph api version 2.5
  });

  // Now that we've initialized the JavaScript SDK, we call 
  // FB.getLoginStatus().  This function gets the state of the
  // person visiting this page and can return one of three states to
  // the callback you provide.  They can be:
  //
  // 1. Logged into your app ('connected')
  // 2. Logged into Facebook, but not your app ('not_authorized')
  // 3. Not logged into Facebook and can't tell if they are logged into
  //    your app or not.
  //
  // These three cases are handled in the callback function.

  FB.getLoginStatus(function(response) {
    statusChangeCallback(response);
  });

  };

  // Load the SDK asynchronously
  (function(d, s, id) {
    var js, fjs = d.getElementsByTagName(s)[0];
    if (d.getElementById(id)) return;
    js = d.createElement(s); js.id = id;
    js.src = "//connect.facebook.net/en_US/sdk.js";
    fjs.parentNode.insertBefore(js, fjs);
  }(document, 'script', 'facebook-jssdk'));

  // Here we run a very simple test of the Graph API after login is
  // successful.  See statusChangeCallback() for when this call is made.
  function testAPI() {
    console.log('Welcome!  Fetching your information.... ');
    FB.api('/me', function(response) {
      console.log('Successful login for: ' + response.name);
      document.getElementById('status').innerHTML =
        'Thanks for logging in, ' + response.name + '!';
    });
  }
</script>
</body>
</html>