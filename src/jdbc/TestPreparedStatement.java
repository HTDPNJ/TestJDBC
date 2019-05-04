package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestPreparedStatement
{
    public static void main(String[] args) throws ClassNotFoundException, SQLException
    {
        //加载驱动类
        Class.forName("com.mysql.jdbc.Driver");
        //建立连接
        Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc","root","12345678");
        String sql="insert into t_user (username,pwd,regTime) values (?,?,?)";
        PreparedStatement ps=conn.prepareStatement(sql);
        ps.setString(1,"ht2");
        ps.setString(2,"1234");
        ps.setDate(3,new java.sql.Date(System.currentTimeMillis()));

        int count=ps.executeUpdate();
        System.out.println(count);

    }
}
