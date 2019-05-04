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

public class TestORMDemo03
{
    public static void main(String[] args)
    {
        Connection conn=JDBCUtil.getMysqlConn();
        PreparedStatement ps= null;
        ResultSet rs=null;
        List<Emp>list=new ArrayList<>();
        try {
            ps = conn.prepareStatement("select empname,salary,age from emp where id>?");
            ps.setObject(1,0);
            rs=ps.executeQuery();
            while (rs.next()){
                Emp emp=new Emp(rs.getString(1),rs.getInt(3),rs.getDouble(2));
                list.add(emp);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }finally{
            JDBCUtil.close(rs,ps,conn);
        }
        for(Emp emp:list){
            System.out.println(emp.getEmpname()+"---"+emp.getAge()+"---"+emp.getSalary());
        }
    }
}
