import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "GetCookie",urlPatterns = "/GetCookie")
public class GetCookie extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie coo[]=request.getCookies();

        for(Cookie co: coo)
        {
            System.out.println(co.getName()+":"+co.getValue());
            response.getWriter().println(co.getValue());
        }
    }
}
