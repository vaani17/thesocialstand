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

public class WeeklyServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
		response.setContentType("text/html");	
		
		Document doc1 = Jsoup.connect("https://news.google.co.in").userAgent("Chrome").get();
		String in1="http://www.storypick.com";
	    Elements question1 = doc1.select("div.esc-lead-article-title-wrapper").select("a");
		int n1=0;
	    String outp="TOP NEWS:";
		for(Element ele:question1)
		{ n1++;
		outp=outp+"</br>"+"<a href="+in1+ele.attr("href")+">"+ele.text()+"</a></br>";
		if(n1==10)break;
		}
		//================================================================================
		
		

		Document doc2 = Jsoup.connect("http://www.dailytech.com/").get();
		Elements question2=doc2.select("div#RightNewsTextPanel");
		int n2=0;
		outp=outp+"</br>"+"TECHNOLOGY:";
		for(Element ele:question2)
		{
			n2++;
			outp=outp+"<a href="+ele.select("a").attr("href")+">"+ele.text()+"</a></br>\n";
			outp=outp+"<img src=\""+ele.select("img").attr("abs:src")+"\">"+"\n\n";
			if(n2==40)break;
		}
		//================================================================================
		
		
		
		Document doc3 = Jsoup.connect("http://www.readersdigest.ca/health/healthy-living//").get();
		Elements question3=doc3.select("li.views-row");
		int n3=0;
		outp=outp+"</br>"+"HEALTH:";
		for(Element ele:question3)
		{
			n3++;
			outp=outp+"<a href=\""+ele.select("a").attr("href")+"\">"+ele.text()+"</a></br>";
			outp=outp+"<img src=\""+ele.select("img").attr("abs:src")+"\"  height=\"200px\" width=\"300px\">"+"\n\n";
			if(n3==40)break;
		}
		//================================================================================
		
		
		
		Document doc4 = Jsoup.connect("http://news.sky.com/entertainment").get();
		Elements question4=doc4.select("li.section-top-stories__item--even");
		int n4=0;
		outp=outp+"</br>"+"ENTERTAINMENT:";
		for(Element ele:question4)
		{
			n4++;
			outp=outp+"<a href=\""+ele.select("a").attr("href")+"\">"+ele.text()+"</a></br>";
			outp=outp+"<img src=\""+ele.select("img").attr("abs:src")+"\"  height=\"200px\" width=\"300px\">"+"\n\n";
			if(n4==10)break;
		}
		//================================================================================
		
		
		
		Document doc5 = Jsoup.connect("http://www.rediff.com/sports").get();
		Elements question5=doc5.select("div.ingap");
		int n5=0;
		outp=outp+"</br>"+"SPORTS:";
		for(Element ele:question5)
		{
			n5++;
			outp=outp+"<a href=\""+ele.select("a").attr("href")+"\">"+ele.text()+"</a></br>";
			if(!ele.select("a").attr("relimg").toString().contains("www.imreddiff"))
			outp=outp+"<img src=\""+ele.select("a").attr("relimg")+"\"  height=\"200px\" width=\"300px\">"+"\n\n";
			if(n5==10)break;
		}
		//================================================================================
		

		
		String in6="http://www.storypick.com";
		Document doc6 = Jsoup.connect("http://www.storypick.com/").get();
		Elements question6 = doc6.select("div.item-details");
		outp=outp+"</br>"+ "TOP STORIES:";
		int n6=0;
		for(Element ele:question6)
		{
			n6++;
			outp=outp+"</br>"+"<a href="+in6+ele.attr("href")+">"+ele.text()+"</a></br>";
			if(n6==10) break;
		}
		//================================================================================
		
		
		Document doc7 = Jsoup.connect("https://www.youtube.com/feed/trending").get();
		Elements question7 = doc7.select("h3.yt-lockup-title").select("a");
		int n7=0;
		outp=outp+"nitts"+"</br>"+"TRENDING:";
		String in7="https://www.youtube.com";
		for(Element ele:question7)
		{
			n7++;
			outp=outp+"<div class=\"row\"><div class=\"col-md-2\"></div>";
			
			
			if(n7%2!=0)
			{
				outp=outp+"<div class=\"col-md-5\">";
				outp=outp+"<center><iframe width=\"300\" height=\"200\" src=\""+in7+ele.attr("href").replace("watch?v=","embed/")+"\" frameborder=\"0\" allowfullscreen></iframe></center>";
				outp=outp+"</div>";		
			}
			else
			{
				outp=outp+"<div class=\"col-md-5\">";
				outp=outp+"<center><iframe width=\"300\" height=\"200\" src=\""+in7+ele.attr("href").replace("watch?v=","embed/")+"\" frameborder=\"0\" allowfullscreen></iframe></center>";
				outp=outp+"</div>";
				outp=outp+"</div><br>";
			}
				
			if(n7==10)break;
		}
		//================================================================================
		
		
		Document doc8 = Jsoup.connect("http://www.imdb.com/trailers/?ref_=nv_mv_tr_3").get();
		String in8="http://www.imdb.com";
		Elements question8 = doc8.select("div.trailer-caption").select("a");
		int n8=0;
		outp=outp+"</br>"+ "TRAILERS:";
		for(Element ele:question8)
		{
			n8++;
			outp=outp+"</br>"+"<a href="+in8+ele.attr("href")+">"+ele.text()+"</a></br>";
			if(n8==10) break;
		}
		//================================================================================
		

		Document doc9 = Jsoup.connect("http://soundhound.com/charts/?type=hottest_geos&filter=all").get();
		Elements question9 = doc9.select("div.TrackList-cardBody-container a");
		outp=outp+"nitts"+"</br>"+"LISTEN SONGS:";
		for(Element ele:question9)
		{
			//Element title=doc.select("div.TrackList-cardBody-container-details-title").get(i++);
			if(!ele.attr("href").toString().contains("https"))
			System.out.println(ele.attr("abs:href"));
			outp=outp+"<a href="+ele.attr("abs:href")+" target=\"_blank\">"+ele.text()+"</a><br>";
		}
		//===================================================================================
		
		
		Document doc10 = Jsoup.connect("http://www.apple.com/itunes/charts/songs/").get();
		String in10="http://www.apple.com";
		Elements question10 = doc10.select("div.section-content li").select("a");
		int n10=0;
		outp=outp+"</br>"+"ENGLISH TRACKS:";
		for(Element ele:question10)
		{
			n10++;
			outp=outp+"<a href="+in10+ele.attr("href")+">"+ele.text().replace("Buy Now on iTunes","")+"</a></br>";
			if(n10==40)break;
		}
		//================================================================================
		
		
		Document doc11 = Jsoup.connect("http://www.radiomirchi.com/more/mirchi-top-20/").get();
		String in11="http://www.radiomrichi.com";
		//System.out.println(doc);
		Elements question11 = doc11.select("div.header");
		int n11=0;
		outp=outp+"</br>"+"HINDI TRACKS:";
		for(Element ele:question11)
		{
			n11++;
			outp=outp+"<a href="+in11+ele.attr("href")+">"+ele.text()+"</a></br>";
			if(n11==10)break;
		}
		//================================================================================
		

		
		request.setAttribute("linksweekly",outp);
		request.getRequestDispatcher("/GetStarted.jsp").forward(request, response);	
		
	}
}