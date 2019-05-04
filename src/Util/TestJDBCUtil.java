package Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestJDBCUtil
{
    public static void main(String[] args)
    {
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        conn=JDBCUtil.getMysqlConn();
        try {
            ps=conn.prepareStatement("insert into t_user (username) value (?)");
            ps.setString(1,"ht");
            ps.execute();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.close(rs,ps,conn);
        }
    }
}
