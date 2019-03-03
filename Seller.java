import java.io.*;
import java.lang.*;
import java.util.*;
import java.sql.*;
class Seller
{
      public static void main(String args[])throws Exception
      {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:rishavp","hr","hr");
            Statement stmt=con.createStatement();
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter seller name : ");
            String seller_id=br.readLine(); 
            ResultSet rs=stmt.executeQuery("select ratio from seller where seller.sellerid='"+seller_id+"'");
            rs.next();
            System.out.println(rs.getString(1));
            rs=stmt.executeQuery("select productid, ratio from product where sellerid= '"+seller_id+"'");
             while(rs.next())
             {
                     System.out.println(rs.getString(1)+"   "+rs.getString(2));
                     //System.out.println(rs.getString(2));
             }
           // int n=stmt.executeUpdate("insert into student values('1255','Siddhanth',101)");
            
            con.close();
    }
} 
     