package jdbc;

import java.io.*;
import java.sql.*;

/*
* 二进制大对象的使用*/
public class BLOBDemo
{
    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException
    {
        //加载驱动类
        Class.forName("com.mysql.jdbc.Driver");
        //建立连接
        Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc","root","12345678");
        PreparedStatement ps=null;

        /*ps=conn.prepareStatement("insert into t_user (username,heading) values (?,?)");

        ps.setObject(1,"hthead");
        ps.setBlob(2,new FileInputStream("C:\\Users\\Oliver\\Desktop\\hongtao.jpg"));
*/

         ps=conn.prepareStatement("select * from t_user where id=?");
        ps.setObject(1,1004);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            Blob c=rs.getBlob("heading");
            InputStream is=c.getBinaryStream();
            int temp=0;
            OutputStream os=new FileOutputStream(".\\my.jpg");
            while((temp=is.read())!=-1){
                os.write(temp);
            }

        }
        ps.execute();
        ps.close();
        conn.close();

    }
}
