
import java.sql.*;

public class jdbc {

   public static void main(String[] args) {

       try {
//load driver
           Class.forName("com.mysql.cj.jdbc.Driver");
//create connetion
           Connection con =
           DriverManager.getConnection(
           "jdbc:mysql://localhost:3306/ecommerce",
           "root",
           "Sumedha@1901");
//statement 
           Statement stmt =
           con.createStatement();
           
//result set or execute query
          ResultSet rs =
           stmt.executeQuery(
           "select * from products");
//process result set
           while(rs.next()) {

               System.out.println(
               rs.getInt("p_id")+" "+
               rs.getString("p_name")+" "+
               rs.getInt("price")+" "+
               rs.getInt("quantity")+" ");
           }
//close connection
           rs.close();
           stmt.close();
           con.close();

       }
       catch(Exception e) {
           e.printStackTrace();
       }
   }
}