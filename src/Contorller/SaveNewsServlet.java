package Contorller;

import Entity.News;
import Service.NewsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(urlPatterns = "/SaveNewsServlet")
public class SaveNewsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        News news=new News();
        news.setNewsID(Integer.parseInt(request.getParameter("newsID")));
        news.setNewsTitle(request.getParameter("newsTitle"));
        String newsDate=request.getParameter("newsDate");
        SimpleDateFormat sDateFormat=new SimpleDateFormat("yyyy-MM-dd"); //加上时间
        Date date= null;
        try {
            date = sDateFormat.parse(newsDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        news.setNewsDate(date);
        news.setNewsContent(request.getParameter("newsContent"));
        news.setNewsAuthor(request.getParameter("newsAuthor"));
        news.setNewsCategory(request.getParameter("newsCategory"));

        NewsService service=new NewsService();
        service.updateNews(news);
        request.getRequestDispatcher("ShowNewsServlet").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}
