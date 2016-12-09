import java.sql.*;

/**
 * Created by Leo on 2016/12/9.
 */
public class DBAccess {

    String driver="com.mysql.jdbc.Driver";
    String url="jdbc:mysql://localhost:3306/user";
    String user="root";
    String password="zyh441424";
    Connection connection=null;
    Statement statement=null;

    public void init(){
        try {
            Class.forName(driver);
            connection= DriverManager.getConnection(url,user,password);
            statement=connection.createStatement();
        } catch (ClassNotFoundException e) {
            System.out.println("未找到驱动程序");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insert(String  name,String password) throws SQLException {
        String str="insert into users value('"+name+"','"+password+"')";
        statement.execute(str);
    }

    public void update(String name,String password) throws SQLException {
        String str="update users set password='"+password+"' where name='"+name+"'";
        statement.execute(str);
    }

    public String query1(String name) throws SQLException {
        String str="select password from users where name='"+name+"'";
        ResultSet set=statement.executeQuery(str);
        set.next();
        return set.getString("password");
    }
    public String query2(String name) throws SQLException {
        String str="select name from users where name='"+name+"'";
        ResultSet set=statement.executeQuery(str);
        set.next();
        return set.getString("name");
    }

    public void submit() throws SQLException {
        statement.close();
        connection.close();
    }

}
