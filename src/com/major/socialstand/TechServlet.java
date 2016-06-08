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

public class TechServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException
	{

		Document doc = Jsoup.connect("http://digg.com/channel/technology").get();
		//System.out.println(doc);
		Elements question = doc.select("a.digg-story__title-link");
		int n=0;
		String outp="";
		for(Element ele:question)
		{
			n++;
			outp=outp+ele.text();
			if(n==10) break;
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

