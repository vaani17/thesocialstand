package com.major.socialstand;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




import database.EntityUser;
import database.ofyService;

public class LoginServlet extends HttpServlet
{	
	private static final long serialVersionUID=1L;

	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
	{
		String password=request.getParameter("pass1");
		String email=request.getParameter("email");
		
		request.setAttribute("callmodal","0");
		
		if(password!=null && email!=null)
		{
			EntityUser a= ofyService.ofy().load().type(EntityUser.class).id(email).now();
			if(a==null)
			{
				String nrmsg="1";
			    request.setAttribute("error",nrmsg);
				
				request.getRequestDispatcher("/register.jsp").forward(request, response);
			}
			else
			{
				if(a.getPassword().contentEquals(password))
				{
					String username=a.getUsername();
					request.setAttribute("username",username);
					String[] favorites=a.getFavorites();
					
					String outp="";
					for(String i:favorites)
					{
						outp=outp+","+i;
				
					}
					
					request.setAttribute("favorites",outp);
					request.getRequestDispatcher("/AfterLogin.jsp").forward(request, response);
				}
				else
				{
					String incpmsg="Incorrect password";
					request.setAttribute("error",incpmsg);
					String val="1";
					request.setAttribute("callmodal",val);
					request.getRequestDispatcher("/index.jsp").forward(request, response);
				}
				
			}
		}
	}
}