package jdbc;

import java.sql.*;

public class PreparedStatementExecuteQuery
{
    public static void main(String[] args) throws ClassNotFoundException, SQLException
    {
        //加载驱动类
        Class.forName("com.mysql.jdbc.Driver");
        //建立连接
        Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc","root","12345678");
        String sql="select id,username,pwd from t_user where id>?";
        PreparedStatement ps=conn.prepareStatement(sql);
        ps.setObject(1,2);
        ResultSet res=ps.executeQuery();

        while(res.next()){
            System.out.println(res.getInt(1)+"---"+res.getObject(2)+"-----"+res.getObject(3));
        }
            res.close();
            ps.close();
            conn.close();

    }
}
