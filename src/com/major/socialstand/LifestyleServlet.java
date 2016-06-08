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

public class LifestyleServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException
	{

		Document doc11 = Jsoup.connect("http://www.readersdigest.ca/health/healthy-living//").get();

		Elements images2=doc11.select("li.views-row");
		String outp2="";
		int n1=0;
		
		for(Element ele:images2)
		{ 
			n1++;
			
			if(n1==1)
			{
				
				outp2=outp2+"<div class=\"row\">";
				outp2=outp2+"<div class=\"col s9 m3\">";
				outp2=outp2+"<div class=\"card\">";
				outp2=outp2+"<div class=\"card-image\">";
				outp2=outp2+"<img src=\""+ele.select("img").attr("abs:src")+"\">"+"</div>";
				//outp2=outp2+"<span class=\"card-title\">";
				
				outp2=outp2+"<div class=\"card-content\">";
				outp2=outp2+"<p>";
				outp2=outp2+"<form action=\"view\" method=\"get\">";
				outp2=outp2+"<center>"+ele.text();

				outp2=outp2+"<input type=\"hidden\""+"value=\""+ele.select("a").attr("href")+"\" name=\"rdlink\">";

				outp2=outp2+"</p></div>";
				outp2=outp2+"<div class=\"card-action\">";
				
				outp2=outp2+"<input type=\"submit\" value=\"Read  More\"/>";
				outp2=outp2+"</div>";
				//outp2=outp2+"</span>";
				//outp2=outp2+"<img src=\""+ele.select("img").attr("abs:src")+"\"  height=\"200px\" width=\"300px\">"+"\n\n"+"";
	
				outp2=outp2+"</center></form></div></div>";
			}
			
			else if(n1==2)
			{
				
				outp2=outp2+"<div class=\"col s9 m3\">";
				outp2=outp2+"<div class=\"card\">";
				outp2=outp2+"<div class=\"card-image\">";
				outp2=outp2+"<img src=\""+ele.select("img").attr("abs:src")+"\">"+"</div>";
				//outp2=outp2+"<span class=\"card-title\">";
				
				outp2=outp2+"<div class=\"card-content\">";
				outp2=outp2+"<p>";
				outp2=outp2+"<form action=\"view\" method=\"get\">";
				outp2=outp2+"<center>"+ele.text();

				outp2=outp2+"<input type=\"hidden\""+"value=\""+ele.select("a").attr("href")+"\" name=\"rdlink\">";

				outp2=outp2+"</p></div>";
				outp2=outp2+"<div class=\"card-action\">";
				
				outp2=outp2+"<input type=\"submit\" value=\"Read  More\"/>";
				outp2=outp2+"</div>";
				//outp2=outp2+"</span>";
				//outp2=outp2+"<img src=\""+ele.select("img").attr("abs:src")+"\"  height=\"200px\" width=\"300px\">"+"\n\n"+"";
	
				outp2=outp2+"</center></form></div></div>";			}

			else if(n1==3)
			{	
				
				outp2=outp2+"<div class=\"col s9 m3\">";
				outp2=outp2+"<div class=\"card\">";
				outp2=outp2+"<div class=\"card-image\">";
				outp2=outp2+"<img src=\""+ele.select("img").attr("abs:src")+"\">"+"</div>";
				//outp2=outp2+"<span class=\"card-title\">";
				
				outp2=outp2+"<div class=\"card-content\">";
				outp2=outp2+"<p>";
				outp2=outp2+"<form action=\"view\" method=\"get\">";
				outp2=outp2+"<center>"+ele.text();

				outp2=outp2+"<input type=\"hidden\""+"value=\""+ele.select("a").attr("href")+"\" name=\"rdlink\">";

				outp2=outp2+"</p></div>";
				outp2=outp2+"<div class=\"card-action\">";
				
				outp2=outp2+"<input type=\"submit\" value=\"Read  More\"/>";
				outp2=outp2+"</div>";
				//outp2=outp2+"</span>";
				//outp2=outp2+"<img src=\""+ele.select("img").attr("abs:src")+"\"  height=\"200px\" width=\"300px\">"+"\n\n"+"";
	
				outp2=outp2+"</center></form></div></div></div>";
				n1=0;
			}
			
			if(n1==40)break;
		}

		request.setAttribute("linksread",outp2);
		
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

