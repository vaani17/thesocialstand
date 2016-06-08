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

public class EntertainmentServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException
	{

		Document doc12 = Jsoup.connect("http://news.sky.com/entertainment").get();

		Elements images3=doc12.select("li.section-top-stories__item--even");
		String outp3="";
		int ent=0;
		for(Element ele:images3)
		{
			ent++;
			outp3=outp3+"<a href=\""+ele.select("a").attr("href")+"\">"+ele.text()+"</a></br>";
			outp3=outp3+"<img src=\""+ele.select("img").attr("abs:src")+"\"  height=\"200px\" width=\"300px\">"+"\n\n";
			if(ent==10)break;
		}

		request.setAttribute("linksread",outp3);
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

