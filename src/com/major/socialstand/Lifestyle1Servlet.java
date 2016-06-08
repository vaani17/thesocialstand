package com.major.socialstand;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Lifestyle1Servlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException
	{
		String link=request.getParameter("rdlink");
		System.out.print(link);
		Document doc = Jsoup.connect(link).get();
		Element desc=doc.select("span#slideshow-slide-description").first();
		Element title=doc.select("span#slideshow-slide-title").first();
		String outp="";

		outp=outp+title.text()+"nitts"+"\n"+desc.text();
		request.setAttribute("article",outp);
		request.setAttribute("modal","1");

		request.getRequestDispatcher("/read.jsp").forward(request, response);		
				
//		if(request.getParameter("username")!=null)
//		{
//			request.setAttribute("username",request.getParameter("username"));
//			request.setAttribute("favorites",request.getParameter("favorites"));
//			request.getRequestDispatcher("/AfterLogin.jsp").forward(request,response);	
//		}
//		else
//			request.getRequestDispatcher("/read.jsp").forward(request, response);					
	}
}
