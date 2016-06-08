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

public class NewsServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException
	{

		Document doc = Jsoup.connect("https:news.google.co.in").userAgent("Chrome").get();
		Elements question = doc.select("div.esc-lead-article-title-wrapper").select("a");
		int n=0;
		String outp="";		
		
		for(Element ele:question)
		{ 
			n++;
			
			if(n==1)
			{
				outp=outp+"<div class=\"row\">";
				outp=outp+"<div class=\"col s12 m3\">";

				outp=outp+"<div class=\"card\">";
				outp=outp+"<div class=\"card-image\">";
				outp=outp+"<div class=\"col s12 m3\">";
				outp=outp+"<center>"+"<a href=\""+ele.attr("href")+"\">"+ele.text()+"</a></center>";
				outp=outp+"</div>";
			}
			
			else if(n==2)
			{
				outp=outp+"<div class=\"col-sm-3 panel\">";
				outp=outp+"<center>"+"<a href=\""+ele.attr("href")+"\">"+ele.text()+"</a></center>";
				outp=outp+"</div>";
			}

		
			else if(n==3)
			{	
				outp=outp+"<div class=\"col-sm-3 panel\">";
				outp=outp+"<center>"+"<a href=\""+ele.attr("href")+"\">"+ele.text()+"</a></center>";
				outp=outp+"</div></div><br>";
				n=0;
			}
			
		if(n==10)break;
		}

		request.setAttribute("linksread",outp);
		
		if(request.getParameter("username")!=null)
		{
			request.setAttribute("username",request.getParameter("username"));
		request.setAttribute("favorites",request.getParameter("favorites"));
		request.getRequestDispatcher("/AfterLogin.jsp").forward(request,response);	
		}
		else
		request.getRequestDispatcher("/read.jsp").forward(request, response);					

	}

}

