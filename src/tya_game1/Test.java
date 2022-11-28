package tya_game1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.xdevapi.Statement;

public class Test {
	public static void main(String args[]) {

	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    
	    try{
	        Class.forName("com.mysql.jdbc.Driver");
	        String url = "jdbc:mysql://localhost:3306/tya_game";
	        conn = DriverManager.getConnection(url, "root", "mirim");
	        String SQL = "insert into ranking(name, score) values(?, ?);";
	        pstmt = conn.prepareStatement(SQL);
	        pstmt.setString(1, "임채영");
	        pstmt.setInt(2, 100);
	        pstmt.executeUpdate();
	        
	    }
	    catch(ClassNotFoundException e11){
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