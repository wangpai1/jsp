package Contorller;

import Entity.User;
import Service.LoginSerivce;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out=response.getWriter();//获得输出流

        //获取参数值
        String strName = request.getParameter("UName");
        String strPwd = request.getParameter("PWD");

        String  sql = "select * from Students where StuName=? and stuPwd=?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, strName);
        pstmt.setString(2, strPwd);
        rs=pstmt.executeQuery();

        if(rs.next())
        {


            request.getRequestDispatcher("index.html").forward(request,response);

        }else{
            out.println("用户名密码错误");
        }




//            //资源释放
//            rs.close();
//            conn.close();
//            pstmt.close();
//
//        } catch (Exception e) {
//            System.out.println(e);
//        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
