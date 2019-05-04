package TestORM;

import Util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestORMDemo02
{
    public static void main(String[] args)
    {
        Connection conn=JDBCUtil.getMysqlConn();
        PreparedStatement ps= null;
        ResultSet rs=null;
       List<Map<String,Object>>list=new ArrayList<>();
        try {
            ps = conn.prepareStatement("select empname,salary,age from emp where id>?");
            ps.setObject(1,0);
            rs=ps.executeQuery();
            while (rs.next()){
                Map<String,Object>row=new HashMap<>();
                row.put("empname",rs.getObject(1));
                row.put("salary",rs.getObject(2));
                row.put("age",rs.getObject(3));
                list.add(row);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }finally{
            JDBCUtil.close(rs,ps,conn);
        }
        for(Map<String,Object> row:list){
            for(String key:row.keySet()){
                System.out.print(key+"---"+row.get(key)+"\t");
            }
            System.out.println();
        }
    }
}
