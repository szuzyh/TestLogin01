import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Leo on 2016/12/9.
 */
public class Newuser extends HttpServlet {
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
        String tempName=req.getParameter("name");
        password=req.getParameter("password");
        try {
            name=dbAccess.query2(tempName).trim();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (name!=null){
            resp.sendRedirect("newusererror.jsp");
            name=null;
        }else {
            try {
                dbAccess.insert(tempName,password);
                resp.sendRedirect("newuserok.jsp");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
