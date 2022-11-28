package tya_game1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;

public class Test2 {
	public static void main(String args[]) {
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    Statement stmt = null;
	    ResultSet rs = null;
	    
	    try{
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/tya_game";
            conn = DriverManager.getConnection(url, "root", "mirim");
            String SQL = "SELECT name, score FROM ranking order by score desc";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(SQL);
            System.out.println("         ");
            
            while (rs.next()) {
            	String name = rs.getString("name"); 
            	int score = rs.getInt("score");
            	System.out.println(name + " " + score);  

            }

        }
        catch(ClassNotFoundException e1){
            System.out.println("    ̹   ε      ");
        }
        catch(SQLException e1){
            System.out.println("    : " + e1);
        }
        finally{
            try{
                if( conn != null && !conn.isClosed()){
                    conn.close();
                }
            }
            catch( SQLException e1){
                e1.printStackTrace();
            }
        }
	}
}