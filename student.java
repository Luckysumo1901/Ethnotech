import java.util.*;
import java.sql.*;
public class student {
    private static final String DB_URL="jdbc:mysql://localhost:3306/st+d_manage";
    private static final String DB_USER="root";
    private static final String DB_PASSWORD="Sumedha@1901";
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        try {
           Class.forName("com.mysql.cj.jdbc.Driver");
           Connection con =
           DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
           
           System.out.println("Adding new records: ");
           System.out.println("Student Id: ");
           Integer id=sc.nextInt();
           System.out.println("Student Name: ");
           String name=sc.next();
           System.out.println("Branch name: ");
           String branch=sc.next();
           System.out.println("Year: ");
           Integer y=sc.nextInt();
           System.out.println("Email: ");
           String email=sc.next();
           System.out.println("CGPA: ");
           Double cgpa=sc.nextDouble();
           PreparedStatement pstmt=con.prepareStatement
           ("INSERT INTO student (sid,sname,branch,y,email,cgpa) VALUES (?,?,?,?,?,?)");
           pstmt.setInt(1,id);
           pstmt.setString(2, name);
           pstmt.setString(3,branch);
           pstmt.setInt(4,y);
           pstmt.setString(5, email);
           pstmt.setDouble(6, cgpa);
           pstmt.executeUpdate();
           System.out.println("Student record inserted succesfully");
           System.out.println();


           Statement s=con.createStatement();
                ResultSet rs =
                s.executeQuery(
                "select * from student");
                //process result set
                System.out.println("Read Student: ");
                while(rs.next()) {
                    System.out.println(
                    rs.getInt("sid")+" "+
                    rs.getString("sname")+" "+
                    rs.getString("branch")+" "+
                    rs.getInt("y")+" "+
                    rs.getString("email")+" "+
                    rs.getDouble("cgpa")+" ");
                }
            System.out.println("Student record retrived");
                rs.close();
                s.close();
                System.out.println();



            System.out.println("Update records: ");
            System.out.println("Enter Student Id to Update: ");
            Integer uid=sc.nextInt();
            System.out.println("Updated Year: ");
            Integer newy=sc.nextInt();
            System.out.println("Updated CGPA: ");
            Double newc=sc.nextDouble();
            PreparedStatement ups=con.prepareStatement
            ("update student set y=?, cgpa=? where sid=?");
            ups.setInt(1,newy);
            ups.setDouble(2,newc);
            ups.setInt(3,uid);
            ups.executeUpdate();
            System.out.println("Student record updated successfully");
            System.out.println();



            System.out.println("Deleted record: ");
            System.out.println("Delete Student Id: ");
            Integer did=sc.nextInt();
            PreparedStatement psd = con.prepareStatement(
                "DELETE FROM student WHERE sid=?"
            );
            psd.setInt(1, did);
            psd.executeUpdate();
            System.out.println("Student record deleted successfully");
            System.out.println();



            System.out.println("Search Student");
            System.out.println("Enter Student Id to search: ");
            Integer searchId = sc.nextInt();
            System.out.println("Enter Student Name to search: ");
            String searchName = sc.next();
            PreparedStatement searchStmt = con.prepareStatement(
                "SELECT * FROM student WHERE sid=? AND sname=?"
            );
            searchStmt.setInt(1, searchId);
            searchStmt.setString(2, searchName);
            ResultSet rsSearch = searchStmt.executeQuery();
            if(rsSearch.next()) {
                System.out.println("Student Found: " + 
                    rsSearch.getInt("sid") + " " + 
                    rsSearch.getString("sname") + " " +
                    rsSearch.getString("branch") + " " + 
                    rsSearch.getInt("y") + " " +
                    rsSearch.getString("email") + " " + 
                    rsSearch.getDouble("cgpa")+" "
                );
                System.out.println("Student record searched using id and name successfully");
            }
            else{
                System.out.println("Student Record not found!!");
            }
            System.out.println();



            System.out.println("Top 5 Students Based on CGPA");
            Statement topStmt = con.createStatement();
            ResultSet rsTop = topStmt.executeQuery("SELECT * FROM student ORDER BY cgpa DESC LIMIT 5");
            while (rsTop.next()) {
                System.out.println(
                    rsTop.getDouble("cgpa") + " " + rsTop.getInt("sid") + " " + rsTop.getString("sname")
                );
            }
            System.out.println("Top 5 Student records retrived successfully");
            rsTop.close();
            topStmt.close();
            System.out.println();



            System.out.println("Read Student Record based on Branch");
            System.out.println("Enter Branch Name: ");
            String repBranch = sc.next();
            PreparedStatement reportStmt = con.prepareStatement("SELECT * FROM student WHERE branch=?");
            reportStmt.setString(1, repBranch);
            ResultSet rsReport = reportStmt.executeQuery();
            while (rsReport.next()) {
                System.out.println(
                    rsReport.getInt("sid") + " " + 
                    rsReport.getString("sname") + " " +
                    rsReport.getString("email") + " " + 
                    rsReport.getDouble("cgpa")
                );
            }
            System.out.println("Student record retrived based on branch successfully");
            rsReport.close();
            reportStmt.close();
            con.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        sc.close();
    }
    
}
