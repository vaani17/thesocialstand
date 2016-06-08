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

public class WatchServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException
	{
		response.setContentType("text/html");
		// TODO Auto-generated method stub
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

		
		request.setAttribute("linksvideo1",outp);

		//======================================================================

		Document doc2 = Jsoup.connect("https://www.youtube.com/playlist?list=PLFgquLnL59alF0GjxEs0V_XFCe7LM3ReH").get();
	
		Elements question2 = doc2.select("a.pl-video-title-link");
		n=0;
		String outp1="";
		in="http://www.youtube.com";
		for(Element ele:question2)
		{
			n++;
			outp1=outp1+"<a href="+in+ele.attr("href")+">"+ele.text()+"</a></br>";
		
			if(n==10)break;
		}
		
		
		request.setAttribute("linksvideo2",outp1);
		request.getRequestDispatcher("/video.jsp").forward(request, response);					
	}
}