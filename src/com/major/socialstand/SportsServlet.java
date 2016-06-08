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

public class SportsServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException
	{

		Document doc13 = Jsoup.connect("http://www.rediff.com/sports").get();

		Elements images4=doc13.select("div.ingap");
		String outp4=" ";
		int spo=0;
		for(Element ele:images4)
		{
			spo++;
			
			outp4=outp4+"<a href=\""+ele.select("a").attr("href")+"\">"+ele.text()+"</a></br>";
			outp4=outp4+"<input type=\"hidden\""+"value=\""+ele.select("a").attr("href")+"\" name=\"slink\">";
			outp4=outp4+"<input type=\"submit\" value=\"Read  More\"/>";		
			
			if(!ele.select("a").attr("relimg").toString().contains("www.imreddiff"))
			outp4=outp4+"<img src=\""+ele.select("a").attr("relimg")+"\"  height=\"200px\" width=\"300px\">"+"\n\n";
			if(spo==10)break;
		}
	
			
			request.setAttribute("linksread",outp4);
			
			if(request.getParameter("username")!=null)
			{
				request.setAttribute("username",request.getParameter("username"));
			request.setAttribute("favorites",request.getParameter("favorites"));
			request.getRequestDispatcher("/AfterLogin.jsp").forward(request,response);	
			}
			else
				request.getRequestDispatcher("/read.jsp").forward(request,response);					
				
	}

}

