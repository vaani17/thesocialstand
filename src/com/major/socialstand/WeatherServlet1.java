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

public class WeatherServlet1 extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException
	{
		// Set response content type
		response.setContentType("text/html");

		// TODO Auto-generated method stub

		Document doc = Jsoup.connect("http://www.accuweather.com/en/in/delhi/202396/weather-forecast/202396").get();
		
		Elements question = doc.select("strong.temp");

		String outp=question.text();

		request.setAttribute("linksweather",outp);
		request.getRequestDispatcher("/weather1.jsp").forward(request, response);					

	}

}
