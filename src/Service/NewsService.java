package Service;

import DAL.SqlHelper;
import Entity.News;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NewsService {
    public static PreparedStatement pstmt(){

        return null;
    }
    public boolean AddNews(News news){

        String sql="insert into News (newsCategory,newsTitle,newsContent,newsAuthor,newsDate) values ( '"+news.getNewsCategory()+"','"+news.getNewsTitle()+"','"+news.getNewsContent()+"','"+news.getNewsAuthor()+"','"+news.getNewsDate()+"')";
        boolean result=SqlHelper.executeUpdate(sql);
        return result;
    }
    public boolean DeleteNews(int newsID){
        String sql="delete from News where newsID="+newsID;
        boolean result= SqlHelper.executeUpdate(sql);
        return result;
    }
    public boolean updateNews(News news){
        String date=news.getNewsDate().toString();
        String sql="update News set newsCategory = '"+news.getNewsCategory()+"', newsTitle=  '"+news.getNewsTitle()+"', newsContent = '"+news.getNewsContent()+"', newsAuthor = '"+news.getNewsAuthor()+"', newsDate='"+new java.sql.Date(news.getNewsDate().getTime())+"' where newsID="+news.getNewsID();
        boolean result=SqlHelper.executeUpdate(sql);
        return result;
    }

    public List<News> QueryNews() throws SQLException {
        String sql="select * from News";
        ResultSet rs=SqlHelper.executeQuery(sql);
        List<News> lstNews=new ArrayList<>();
        while (rs.next()){
            News news=new News();
            news.setNewsID(rs.getInt("newsID"));
            news.setNewsTitle(rs.getString("newsTitle"));
            news.setNewsCategory(rs.getString("newsCategory"));
            news.setNewsAuthor(rs.getString("newsAuthor"));
            news.setNewsContent(rs.getString("newsContent"));
            news.setNewsDate(rs.getDate("newsDate"));
            lstNews.add(news);
        }
        return lstNews;
    }
    public News GetNews(int newsID) throws SQLException {
        String sql="select * from News where newsID="+newsID;
        ResultSet rs=SqlHelper.executeQuery(sql);
        News news=new News();
        if(rs.next()){
            news.setNewsID(rs.getInt("newsID"));
            news.setNewsTitle(rs.getString("newsTitle"));
            news.setNewsCategory(rs.getString("newsCategory"));
            news.setNewsAuthor(rs.getString("newsAuthor"));
            news.setNewsContent(rs.getString("newsContent"));
            news.setNewsDate(rs.getDate("newsDate"));
        }
        return news;
    }
}
