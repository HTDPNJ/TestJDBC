package jdbc;

import java.sql.*;
import java.util.Random;

/*测试时间类*/
public class DateDemo
{
    public static void main(String[] args) throws SQLException, ClassNotFoundException
    {
        //加载驱动类
        Class.forName("com.mysql.jdbc.Driver");
        //建立连接
        Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc","root","12345678");
        for(int i=0;i<1000;i++){
            String sql="insert into t_user (username,pwd,regTime,lastLogin) values (?,?,?,?)";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setObject(1,"httt"+i);
            ps.setObject(2,"123456");

            int rand=100000000+new Random().nextInt(1000000000);
            java.sql.Date date=new java.sql.Date(System.currentTimeMillis()-rand);
            Timestamp stamp=new Timestamp(System.currentTimeMillis()-rand);
            ps.setDate(3,date);
            ps.setTimestamp(4, stamp);
            ps.execute();
        }
    }
}
