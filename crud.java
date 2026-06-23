import java.util.*;
import java.sql.*;
public class crud {
    private static final String DB_URL="jdbc:mysql://localhost:3306/ecommerce";
    private static final String DB_USER="root";
    private static final String DB_PASSWORD="Sumedha@1901";
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
       try {
//load driver
           Class.forName("com.mysql.cj.jdbc.Driver");
//create connetion
           Connection con =
           DriverManager.getConnection(
           DB_URL,
           DB_USER,
           DB_PASSWORD);
           //crud operations
                System.out.println("1. Create Product: ");
                System.out.println("Product Id: ");
                Integer id=sc.nextInt();
                System.out.println("Product Name: ");
                String name=sc.next();
                System.out.println("Product Price: ");
                Integer price=sc.nextInt();
                System.out.println("Product Quantity: ");
                Integer q=sc.nextInt();
                PreparedStatement pstmt=
                con.prepareStatement
                ("INSERT INTO products (p_id,p_name,price,quantity) VALUES (?,?,?,?)");
                pstmt.setInt(1,id);
                pstmt.setString(2, name);
                pstmt.setInt(3,price);
                pstmt.setInt(4,q);
                pstmt.executeUpdate();
                






                Statement s=con.createStatement();
                ResultSet rs =
                s.executeQuery(
                "select * from products");
                //process result set
                System.out.println("1. Read Products: ");
                while(rs.next()) {

                    System.out.println(
                    rs.getInt("p_id")+" "+
                    rs.getString("p_name")+" "+
                    rs.getInt("price")+" "+
                    rs.getInt("quantity")+" ");
                }
        //close connection
                rs.close();
                s.close();
                con.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        sc.close();
    }
}
