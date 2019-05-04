package jdbc;

import java.io.*;
import java.sql.*;
/*
* 将字符串和文件内容插入到数据库中的clob字段
* 从数据库中读取字段*/
public class LargeText
{
    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException
    {
        //加载驱动类
        Class.forName("com.mysql.jdbc.Driver");
        //建立连接
        Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc","root","12345678");
        PreparedStatement ps=null;
        /*String sql="insert into t_user (username,info) value (?,?)";
        PreparedStatement ps=conn.prepareStatement(sql);
        ps.setObject(1,"ht");
       // ps.setClob(2,new FileReader(new File("C:\\Users\\Oliver\\Desktop\\copy.txt")));
        ps.setClob(2,new BufferedReader(new InputStreamReader(new ByteArrayInputStream("AAA".getBytes()))));
*/
        ps=conn.prepareStatement("select * from t_user where id=?");
        ps.setObject(1,1003);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            Clob c=rs.getClob("info");
            Reader r=c.getCharacterStream();
            int temp=0;
            while((temp=r.read())!=-1){
                System.out.print((char)temp);
            }
        }
        ps.execute();
        ps.close();
        conn.close();

    }
}
