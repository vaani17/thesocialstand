<!DOCTYPE html>
<html>
<head>
<link rel="shortcut icon" href="images/STT9.ico" type="image/x-icon" />
<title>TheSocialStand</title>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
	<link rel="stylesheet" href="styles.css">
	<link rel="stylesheet" href="styles1.css">
   <script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>
   <script src="script.js"></script>
<style>

.fws 
 { 
 	position: fixed;	 
 	left: 0; 
   top: 20%; 
   width: 8em; 
 }

.fws1 
 { 
 	position: fixed;	 
 	left:30%; 
   top: 0; 
   width: 100%; 
 } 

.fws1-body { 
 /* this will adjust body top margin to prevent content jumping when nav gets fix  */ 
     margin-top: 50px; 
 /* adjust as per height of your menu */; 
 } 

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
	border: 2px solid #000000;
	word-wrap: break-word;
	
	height:400px;
	width:300px;
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

.pure-button:active {
  top: 1px;
  outline: none;
  -webkit-box-shadow: none;
  box-shadow: none;
}

</style>
</head>
<body>

<br><br>

<div class="col-md-3">
<h3>The SocialStand</h3>
</div>


<br><br><br><br><br>
	 	
<% 
 if(request.getAttribute("username")==null)
 	request.getRequestDispatcher("index.jsp").forward(request, response);
 	String un=request.getAttribute("username").toString();
 	String fav=request.getAttribute("favorites").toString();

%>


<div class="fws">
<div class="col-md-3">
<div id='cssmenu'>

<ul>
<% 
 String pref[]=fav.split(",");
 
 for(String ele:pref)
 {
	 %>
 
	 <form action="<%=ele%>" method="get">  
	    <li><button class="pure-button"><%=ele%></button></li>
	    <input type="hidden" value="<%=un%>" name="username">	    
	    <input type="hidden" value="<%=fav%>" name="favorites">
	</form>

	 <%
 }
 %>
   </ul>
	</div>
	</div>
	</div>
	
	<%
	if(request.getAttribute("linksread")!=null)
	out.print(request.getAttribute("linksread"));
	
	%>

</body>
</html>