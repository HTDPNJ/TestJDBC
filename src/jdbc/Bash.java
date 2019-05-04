package jdbc;

import java.sql.*;

public class Bash
{
    /*批处理操作，操作大量记录
    * */
    public static void main(String[] args) throws ClassNotFoundException, SQLException
    {
        //加载驱动类
        Class.forName("com.mysql.jdbc.Driver");
        //建立连接
        Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc","root","12345678");

        conn.setAutoCommit(false);//事务设定为手动提交


        Statement stmt=conn.createStatement();
        long start=System.currentTimeMillis();
        for(int i=0;i<20000;i++){
            stmt.addBatch("insert into t_user (username,pwd,regTime) values ('h"+i+"',666,now())");
        }
        System.out.println(System.currentTimeMillis()-start);
        stmt.executeBatch();

        conn.commit(); //事务提交
        stmt.close();
        conn.close();

    }
}
