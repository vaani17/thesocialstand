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

public class ListenServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException
	{
		response.setContentType("text/html");
		// TODO Auto-generated method stub
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
		//===================================================================================
		Document doc2 = Jsoup.connect("http://www.apple.com/itunes/charts/songs/").get();
		String in="http://www.apple.com";

		Elements question2 = doc2.select("div.section-content li").select("a");
		n=0;
		for(Element ele:question2)
		{
			n++;
			outp=outp+"<a href="+in+ele.attr("href")+">"+ele.text().replace("Buy Now on iTunes","")+"</a></br>";
			if(n==40)break;
		}
		//================================================================================
		Document doc3 = Jsoup.connect("http://www.radiomirchi.com/more/mirchi-top-20/").get();
		String in3="http://www.radiomrichi.com";
		//System.out.println(doc);
		Elements question3 = doc3.select("div.header");
		n=0;
		for(Element ele:question3)
		{
			n++;
			outp=outp+"<a href="+in3+ele.attr("href")+">"+ele.text()+"</a></br>";
			if(n==10)break;
		}
		
		request.setAttribute("linksmusic",outp);
		request.getRequestDispatcher("/music.jsp").forward(request, response);					
	}
}