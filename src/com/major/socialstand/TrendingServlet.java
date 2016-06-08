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

public class TrendingServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException
	{

		Document doc = Jsoup.connect("https://www.youtube.com/feed/trending").get();
		String outp="";
		Elements question = doc.select("h3.yt-lockup-title").select("a");
		int n=0;
		String in="https://www.youtube.com";
		for(Element ele:question)
		{
			n++;
			//outp=outp+"<div class=\"row\"><div class=\"col-md-2\"></div>";
			outp=outp+"<div class=\"row\">";
			
			
			if(n%2!=0)
			{
				outp=outp+"<div class=\"col-md-6\">";
				outp=outp+"<center><iframe width=\"300\" height=\"200\" src=\""+in+ele.attr("href").replace("watch?v=","embed/")+"\" frameborder=\"0\" allowfullscreen></iframe></center>";
				outp=outp+"</div>";		
			}
			else
			{
				outp=outp+"<div class=\"col-md-6\">";
				outp=outp+"<center><iframe width=\"300\" height=\"200\" src=\""+in+ele.attr("href").replace("watch?v=","embed/")+"\" frameborder=\"0\" allowfullscreen></iframe></center>";
				outp=outp+"</div>";
				outp=outp+"</div><br>";
			}
				
			if(n==10)break;
		}

		
		request.setAttribute("linkswatch",outp);
		
		
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

