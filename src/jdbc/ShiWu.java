package jdbc;

import java.sql.*;
/*
* 测试事务*/
public class ShiWu
{
    public static void main(String[] args)
    {


        //建立连接
        Connection conn= null;
        PreparedStatement ps1=null;
        PreparedStatement ps2=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");  //加载驱动类
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc","root","12345678");
            conn.setAutoCommit(false); //设置为手动提交

            ps1=conn.prepareStatement("insert into t_user (username,pwd) values (?,?)");
            ps1.setObject(1,"hello");
            ps1.setObject(2,"12345");
            ps1.execute();
            System.out.println("插入一个用户");
            Thread.sleep(6000);

            ps2=conn.prepareStatement("insert into t_user (username,pwd) values(?,?,?)");
            ps2.setObject(1,"lao gao");
            ps2.setObject(2,"12345");
            ps2.execute();
            System.out.println("插入第二个用户");
            conn.commit();

        } catch(ClassNotFoundException e){
            e.printStackTrace();
            try {
                conn.rollback();
            }
            catch (SQLException e1) {
                e1.printStackTrace();
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
