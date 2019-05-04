package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo02
{
    public static void main(String[] args) throws ClassNotFoundException, SQLException
    {
        //加载驱动类
        Class.forName("com.mysql.jdbc.Driver");
        //建立连接
        Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc","root","12345678");
        Statement stmt=conn.createStatement();

        /*//String name="liqi";
        //String sql="insert into t_user (username,pwd,regTime) value ('"+name+"',6666,now())";
        String sql="insert into t_user (username,pwd,regTime) value ('zhaoliu',6666,now())";*/
        //stmt.execute(sql);

        /*//测试sql注入
        String id="5 or 1=1";
        String sql="delete from t_user where id="+id;
        stmt.execute(sql);*/
    }
}
