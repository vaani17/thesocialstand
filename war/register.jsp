<!DOCTYPE html>
<html lang="en">
	<head>
	<link rel="shortcut icon" href="images/STT9.ico" type="image/x-icon" />
		<meta http-equiv="content-type" content="text/html; charset=UTF-8">
		<meta charset="utf-8">
		<title>Login</title>
		<meta name="generator" content="Bootply" />
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
		<link href="css/bootstrap.min.css" rel="stylesheet">
		<!--[if lt IE 9]>
			<script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script>
		<![endif]-->
		<link href="css/styles.css" rel="stylesheet">
    <link href="css/mystyle.css" rel="stylesheet">
  	</head>
	
	<body>
        <div class="modal-header">
          <h1 class="text-center">Login</h1>
      </div>
    <div class="modal-body">
    <div class="row text-center">
    <%
    if(request.getAttribute("error")!=null)
    {
    	String cr=request.getAttribute("error").toString();
     	  if(cr.contentEquals("1"))
    	%><p style="color:red">User not registered. Please register.</p> <% 
    }
    %>
    </div>
    <form class="form col-md-4 center-block"></form>
         <form action="register" class="form col-md-4 center-block">
            <div class="form-group">
            <input type="text" class="form-control input-lg" name="uname" placeholder="Username" required/>
            </div>
            <div class="form-group">
              <input type="password" class="form-control input-lg" name="pass1" placeholder="Choose Password" required/>
            </div>
            <div class="form-group">
              <input type="password" class="form-control input-lg" name="pass2" placeholder="Confirm Password" required/>
            </div>
            <div class="form-group">
              <input type="email" class="form-control input-lg" name="email" placeholder="Email Id" required/>
            </div>
            <div class="form-group"><h3>Favorites</h3><h4>
              <input type="checkbox" name="fav" value="sports"> Sports 
              <input type="checkbox"  name="fav" value="technology"> Technology
              <input type="checkbox"  name="fav" value="news"> News
              
            	<input type="checkbox"  name="fav" value="health"> Health
              <input type="checkbox"  name="fav" value="entertainment"> Entertainment
              
              <input type="checkbox"  name="fav" value="music"> Music
              <input type="checkbox"  name="fav" value="videos"> Trending Videos
<!--               <input type="checkbox"  name="fav" value="entertainment"> Entertainment -->
              
              
            </h4></div>
            
<!--             <section title=".squaredTwo"> -->
<!--             <div class="squaredTwo"> -->
<!--             <input type="checkbox" value="sports" id="squaredTwo" name="fav" checked> -->
<!--             <label for="squaredTwo"></label> -->
<!--             </div> -->
<!--             </section> -->
                        
          
            <div class="form-group"> 
            <button class="btn btn-primary btn-lg btn-block">Register</button>
            </div>
          </form>
          <form class="form col-md-4 center-block"></form>
    </div>
 
    <!-- script references -->
		<script src="//ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
		<script src="js/bootstrap.min.js"></script>
	</body>
</html>