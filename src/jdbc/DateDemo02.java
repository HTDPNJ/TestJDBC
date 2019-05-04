package jdbc;

import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Random;

/*测试时间类
* 取出指定范围时间内数据*/
public class DateDemo02
{
    public static void main(String[] args) throws SQLException, ClassNotFoundException, ParseException
    {
        //加载驱动类
        Class.forName("com.mysql.jdbc.Driver");
        //建立连接
        Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc","root","12345678");

        String sql="insert into t_user (username,pwd,regTime,lastLogin) values (?,?,?,?)";
        PreparedStatement ps=conn.prepareStatement(sql);
        ResultSet rs=null;

        ps=conn.prepareStatement("select * from t_user where regTime>?and regTime<?");
        java.sql.Date start=new java.sql.Date((str2Date("2019-4-20 17:03:45")));
        java.sql.Date end=new java.sql.Date((str2Date("2019-4-22 17:03:45")));

        ps.setObject(1,start);
        ps.setObject(2,end);
        rs=ps.executeQuery();
        while(rs.next()){
            System.out.println(rs.getInt("id")+"---"+rs.getObject("username")+"---"+rs.getObject("regTime")+"---"+rs.getObject("lastLogin"));
        }
    }
    public static long str2Date(String dataStr) throws ParseException
    {
        DateFormat format=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return format.parse(dataStr).getTime();
    }
}
