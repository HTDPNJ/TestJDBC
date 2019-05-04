package TestORM;

import Util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TestORMDemo01
{
    public static void main(String[] args)
    {
        Connection conn=JDBCUtil.getMysqlConn();
        PreparedStatement ps= null;
        ResultSet rs=null;
        List<Object[]> list=new ArrayList<>();
        try {
            ps = conn.prepareStatement("select empname,salary,age from emp where id>?");
            ps.setObject(1,0);
            rs=ps.executeQuery();
            while (rs.next()){
                Object[] obj=new Object[3];
               obj[0]=rs.getObject(1);
               obj[1]=rs.getObject(2);
               obj[2]=rs.getObject(3);
               list.add(obj);
               //System.out.println(rs.getString(1)+"---"+rs.getDouble(2)+"---"+rs.getInt(3));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }finally{
            JDBCUtil.close(rs,ps,conn);
        }
        for(Object[]obj:list){
            System.out.println(obj[0]);
        }
    }
}
