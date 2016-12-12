
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 27721_000 on 2016/12/11.
 */
public class SearchServlet extends HttpServlet {
   static List<String> datas=new ArrayList<String>();

    static {
        datas.add("apple");
        datas.add("applet");
        datas.add("Japplet");
        datas.add("James");
        datas.add("boy");
        datas.add("bgcolor");
    }

    @java.lang.Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       req.setCharacterEncoding("UTF-8");
       resp.setCharacterEncoding("UTF-8");
        String keyword=req.getParameter("keyword");
        List<String> listData=getData(keyword);
        resp.getWriter().write(JSONArray.fromObject(listData).toString());

    }

    public List<String> getData(String keyword){
        List<String> list=new ArrayList<String>();
        for (String s: datas
             ) {
            if (s.contains(keyword)){
                list.add(s);
            }
        }
        return list;
    }
}
