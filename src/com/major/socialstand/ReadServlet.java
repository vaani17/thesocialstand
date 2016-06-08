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

public class ReadServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException
	{ int n=0;
		response.setContentType("text/html");
//		Document doc = Jsoup.connect("https://news.google.co.in").userAgent("Chrome").get();
//		Elements question = doc.select("div.esc-lead-article-title-wrapper").select("a");
//		int n=0;
//		String outp="";		
//		
//		for(Element ele:question)
//		{ 
//			n++;
//			
//			if(n==1)
//			{
//				outp=outp+"<div class=\"row\">";
//				outp=outp+"<div class=\"col-sm-3 panel\">";
//				outp=outp+"<center>"+"<a href=\""+ele.attr("href")+"\">"+ele.text()+"</a></center>";
//				outp=outp+"</div>";
//			}
//			
//			else if(n==2)
//			{
//				outp=outp+"<div class=\"col-sm-3 panel\">";
//				outp=outp+"<center>"+"<a href=\""+ele.attr("href")+"\">"+ele.text()+"</a></center>";
//				outp=outp+"</div>";
//			}
//
//			else if(n==3)
//			{	
//				outp=outp+"<div class=\"col-sm-3 panel\">";
//				outp=outp+"<center>"+"<a href=\""+ele.attr("href")+"\">"+ele.text()+"</a></center>";
//				outp=outp+"</div></div><br>";
//				n=0;
//			}
//			
//		//outp=outp+"<a href="+in+ele.attr("href")+">"+ele.text()+"</a></br>";
//		//if(n==10)break;
//		}
//		//==================================================================
//		
		Document doc10 = Jsoup.connect("http://www.dailytech.com/").get();
		//String in="http://www.thehindu.com";

		//Elements question = doc.select("div.right").select("a");
		Elements images=doc10.select("div#RightNewsTextPanel");
		String outp1="";
		n=0;
		for(Element ele:images)
		{
			n++;
			outp1=outp1+"<a href="+ele.select("a").attr("href")+">"+ele.text()+"</a></br>\n";
			outp1=outp1+"<img src=\""+ele.select("img").attr("abs:src")+"\">"+"\n\n";
			if(n==40)break;
		}
		
		request.setAttribute("linkstech",outp1);
		
		//=========================================================================
		
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
				outp2=outp2+"<div class=\"col-sm-3 panel\">";

				outp2=outp2+"<center>"+"<form action=\"health\" method=\"get\">"+ele.text();

				outp2=outp2+"<input type=\"hidden\""+"value=\""+ele.select("a").attr("href")+" name=\"rdlink\">";
				outp2=outp2+"<input type=\"submit\" value=\"Read  More\"/>";		
				outp2=outp2+"<img src=\""+ele.select("img").attr("abs:src")+"\"  height=\"200px\" width=\"300px\">"+"\n\n"+"";
	
				outp2=outp2+"</form></center></div>";
			}
			
			else if(n1==2)
			{
				outp2=outp2+"<div class=\"col-sm-3 panel\">";
				outp2=outp2+"<center>"+"<form action=\"health\" method=\"get\">"+ele.text()+"<input type=\"submit\" class=\"panel\">";
				outp2=outp2+"<input type=\"hidden\""+"value=\""+ele.select("a").attr("href")+" name=\"rdlink\">";
				outp2=outp2+"<img src=\""+ele.select("img").attr("abs:src")+"\"  height=\"200px\" width=\"300px\">"+"\n\n"+"</form></center>";
							
				outp2=outp2+"</div>";
			}

			else if(n1==3)
			{	
				outp2=outp2+"<div class=\"col-sm-3 panel\">";

				outp2=outp2+"<center><form action=\"health\" method=\"get\">"+ele.text()+"<input type=\"submit\" class=\"panel\">";
				outp2=outp2+"<input type=\"hidden\""+"value=\""+ele.select("a").attr("href")+" name=\"rdlink\">";
				outp2=outp2+"<img src=\""+ele.select("img").attr("abs:src")+"\"  height=\"200px\" width=\"300px\">"+"\n\n"+"</form></center>";
							outp2=outp2+"</div></div><br>";
				n1=0;
			}
			
			if(n1==40)break;
		}

		request.setAttribute("linkslife",outp2);
		
		
		//================================================================================
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

		request.setAttribute("linksenter",outp3);
		
		//=====================================================================================
		Document doc13 = Jsoup.connect("http://www.rediff.com/sports").get();

		Elements images4=doc13.select("div.ingap");
		String outp4=" ";
		int spo=0;
		for(Element ele:images4)
		{
			spo++;
			outp4=outp4+"<a href=\""+ele.select("a").attr("href")+"\">"+ele.text()+"</a></br>";
			if(!ele.select("a").attr("relimg").toString().contains("www.imreddiff"))
			outp4=outp4+"<img src=\""+ele.select("a").attr("relimg")+"\"  height=\"200px\" width=\"300px\">"+"\n\n";
			if(spo==10)break;
		}


		request.setAttribute("linkssports",outp4);
		request.setAttribute("linkstech",outp1);
		request.setAttribute("linkslife",outp2);
		request.setAttribute("linksenter",outp3);
		
		request.getRequestDispatcher("/read.jsp").forward(request, response);					
	}
		
}