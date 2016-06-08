package com.major.socialstand;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.EntityUser;
import database.ofyService;

public class AddUserServlet extends HttpServlet
{	
	private static final long serialVersionUID=1L;

	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
	{
		String username=request.getParameter("uname");
		String password=request.getParameter("pass1");
		String email=request.getParameter("email");
		String[] favorites=request.getParameterValues("fav");
		
		if(username!=null && password!=null && email!=null)
		{  
			EntityUser a= ofyService.ofy().load().type(EntityUser.class).id(email).now();
	
			if(a!=null)
			{
				String val="2";
				request.setAttribute("callmodal",val);
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			}
			else
		{
				EntityUser user=new EntityUser(username, password, email, favorites);
				ofyService.ofy().save().entity(user);			
				request.setAttribute("username",username);
				request.setAttribute("favorites",favorites);
				request.getRequestDispatcher("/AfterLogin.jsp").forward(request, response);
			
		}
		}
	
	}
	
}