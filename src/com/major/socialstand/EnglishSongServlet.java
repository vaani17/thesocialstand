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

public class EnglishSongServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException
	{

		Document doc = Jsoup.connect("http://soundhound.com/charts/?type=hottest_geos&filter=all").get();
		String outp="";
		//String in="http://www.radiomrichi.com";
		//System.out.println(doc);
		Elements question = doc.select("div.TrackList-cardBody-container a");
		int n=0;
		for(Element ele:question)
		{
			//Element title=doc.select("div.TrackList-cardBody-container-details-title").get(i++);
			if(!ele.attr("href").toString().contains("https"))
			System.out.println(ele.attr("abs:href"));
			outp=outp+"<a href="+ele.attr("abs:href")+" target=\"_blank\">"+ele.text()+"</a><br>";
		}

		request.setAttribute("linkslisten",outp);
		if(request.getParameter("username")!=null)
		{
			request.setAttribute("username",request.getParameter("username"));
		request.setAttribute("favorites",request.getParameter("favorites"));
		request.getRequestDispatcher("/AfterLogin.jsp").forward(request,response);	
		}
		else
		request.getRequestDispatcher("/listen.jsp").forward(request, response);					

	}

}

