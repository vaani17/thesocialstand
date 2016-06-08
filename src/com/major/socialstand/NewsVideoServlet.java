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

public class NewsVideoServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException
	{


		Document doc2 = Jsoup.connect("https://www.youtube.com/playlist?list=PLFgquLnL59alF0GjxEs0V_XFCe7LM3ReH").get();
	
		Elements question2 = doc2.select("a.pl-video-title-link");
		int n=0;
		String outp1="";
		String in="http://www.youtube.com";
		for(Element ele:question2)
		{
			n++;
			outp1=outp1+"<a href="+in+ele.attr("href")+">"+ele.text()+"</a></br>";
		
			if(n==10)break;
		}
		
		
		request.setAttribute("linkswatch",outp1);
		
		if(request.getParameter("username")!=null)
		{
			request.setAttribute("username",request.getParameter("username"));
		request.setAttribute("favorites",request.getParameter("favorites"));
		request.getRequestDispatcher("/AfterLogin.jsp").forward(request,response);	
		}
		else
		request.getRequestDispatcher("/watch.jsp").forward(request, response);					

	}

}

