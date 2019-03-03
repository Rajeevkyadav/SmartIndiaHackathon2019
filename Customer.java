import java.io.*;
import java.lang.*;
import java.util.*;
import java.sql.*;
class Customer
{
      public static cust_id;
      public static void main(String args[])throws Exception
      {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:rishavp","hr","hr");
            Statement stmt=con.createStatement();
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter cust_id: ");
            cust_id=br.readLine();
            int choice;
            while(true)
            {      
                   System.out.print("1.Buy\n2.Return\n3.Exit\nEnter choice :");
                   choice=Integer.parseInt(br.readLine());
                   if(choice==3)
                   {
                          break;
                   }
                   else if(choice==1)
                   {
                          System.out.println("Enter productid : ");
                          buy(br.readLine());
                   }
                   else
                  {
                         System.out.println("Enter productid : ");
                         returnback();
                  }
            }
           
    }       
    public static buy(String productid)throws Exception
    {      
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:rishavp","hr","hr");
            Statement stmt=con.createStatement();    
            int n=stmt.executeUpdate("update product set p_total_demands+1 where productid='"+productid+"'"); 
            n=stmt.executeUpdate("update product set ratio=total_valid_returns/p_total_demands where productid='"+productid+"'");
            n=stmt.executeUpdate("update customer set total_transactions=total_transactions+1 where custid='"+this.cust_id+"'");
            n=stmt.executeUpdate("update customer set ratio= total_frauds/total_transactions where custid='"+this.cust_id+"'");
            n=stmt.executeUpdate("update customer set credits=credits+50 where custid='"+this.cust_id+"'");
            n=stmt.executeUpdate("update seller set s_total_demends=s_total_demands+1 where sellerid=(select sellerid from product where                             custid='"+this.cust_id+"')");
            n=stmt.executeUpdate("update seller set ratio= total_valid_returns/s_total_demands where sellerid=(select sellerid from product where                             custid='"+custid+"')");
            con.close(); 
    }
    public static returnBack(String productid)throws Exception
    {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:rishavp","hr","hr");
            Statement stmt=con.createStatement(); 
            int n=stmt.executeUpdate("Update customer set total_transactions=total_transactions+1 and total_frauds=total_frauds+1 and                                           ratio=total_frauds/total_transactions and credits=credits-50 where custid='"+custid+"'");
            int n=stmt.executeUpdate("update product set p_total_demands=p_total_demands+1 and total_valid_returns=total_valid_returns+1 and                                           ratio=total_valid_returns/p_total_demands where productid='"+productid+"'"); 
            int n=stmt.executeUpdate("Update seller set s_total_demands=s_total_demands+1 and total_valid_returns=total_valid_returns+1 and                                           ratio=total_valid_returns/s_total_demands where sellerid=(select sellerid from product where productid='"+productid+"')");
           con.close();
    }
} 
     