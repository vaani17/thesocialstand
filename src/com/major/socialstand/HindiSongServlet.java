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

public class HindiSongServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException
	{

		Document doc3 = Jsoup.connect("http://www.radiomirchi.com/more/mirchi-top-20/").get();
		String in3="http://www.radiomrichi.com";
		//System.out.println(doc);
		Elements question3 = doc3.select("div.header");
		int n=0;
		String outp="";
		for(Element ele:question3)
		{
			n++;
			outp=outp+"<a href="+in3+ele.attr("href")+">"+ele.text()+"</a></br>";
			if(n==10)break;
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

