package Util;

import java.sql.*;
import java.util.Properties;

public class JDBCUtil
{
    public static Connection getMysqlConn(){
        //加载驱动类
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //建立连接
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc","root","12345678");
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }

    public static void close(ResultSet rs, Statement ps ,Connection conn){
        try{
            if(ps!=null){
                ps.close();
            }
        }catch(SQLException e){
            e.printStackTrace();
        }

        try{
            if(rs!=null){
                ps.close();
            }
        }catch(SQLException e){
            e.printStackTrace();
        }

        try{
            if(conn!=null){
                ps.close();
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
