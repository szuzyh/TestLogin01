import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Leo on 2016/12/9.
 */
public class Validate extends HttpServlet {
    String name=null;
    String password=null;
    DBAccess dbAccess;

    @Override
    public void init() throws ServletException {
        dbAccess=new DBAccess();
        dbAccess.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        name=req.getParameter("name");
        String temppass=req.getParameter("password");
        try {
            password=dbAccess.query1(name).trim();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (!temppass.equals(password)){
            resp.sendRedirect("error.jsp");
        }else {
            resp.sendRedirect("ok.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
