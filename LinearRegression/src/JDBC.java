//STEP 1. Import required packages
import java.sql.*;

public class JDBC  {
   // JDBC driver name and database URL
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost/Java";
 static double x[]=new double[1000];
 static double y[]=new double[1000];
 static int z[]= new int[1000];
 static int a[]=new int[1000];
 static int s[]=new int[1000];
   //  Database credentials
   static final String USER = "staff";
   static final String PASS = "qwerty";
    int n=0;
   int nvalue(){
    return n;
}
   double[] yvalue(){
       return(y);
       
   }
   double[] xvalue(){
       return(x);
       
   }
    int[] zvalue(){
       return(z);
    }
   
     int[] bvalue(){
       return(a);
       
   }
     int[] svalue(){
         return(s);
     }
   public  void dbms() {
   Connection conn = null;
   Statement stmt = null;
   try{
      //STEP 2: Register JDBC driver
      Class.forName("com.mysql.jdbc.Driver");//jar

      //STEP 3: Open a connection
      System.out.println("Connecting to a selected database...");
      conn = DriverManager.getConnection(DB_URL, USER, PASS);
      System.out.println("Connected database successfully...");
      
      //STEP 4: Execute a query
      System.out.println("Creating statement...");
      stmt = conn.createStatement();

      String sql = "SELECT * FROM house";
      ResultSet rs = stmt.executeQuery(sql);
     
      //STEP 5: Extract data from result set
      while(rs.next()){
         //Retrieve by column name
         String type  = rs.getString("type");
         if("1BHK".equals(type))
         {
             z[n]=1;
         }
          if("2BHK".equals(type))
         {
             z[n]=2;
         }
          if("H".equals(type))
         {
             z[n]=3;
         }
         
    
         a[n] = rs.getInt("balcony");
         
         x[n] = rs.getFloat("sq_feet");
         y[n] = rs.getFloat("price");
         s[n] = rs.getInt("swimming");
         System.out.print("type: " + type);
        
         System.out.print(", sq: " + x[n]);
        System.out.println(", price: " + y[n]);
        ++n;
      }
         // x[n]=sq;
           // y[n]=price;
         //Display values

        
      
      rs.close();
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            conn.close();
      }catch(SQLException se){
      }// do nothing
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   }//end try
   System.out.println("Goodbye!n="+n);
}//end main
   public static void main(String args[])
   {
       JDBC j=new JDBC();
       j.dbms();
   }
}//end JDBCExample