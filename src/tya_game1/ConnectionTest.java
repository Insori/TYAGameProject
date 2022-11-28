package tya_game1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionTest {
    public static void main(String[] args) {
        // Connection ��ü�� �ڵ��ϼ����� import�� ���� com.mysql.connection�� �ƴ�
        // java ǥ���� java.sql.Connection Ŭ������ import�ؾ� �Ѵ�.
        Connection conn = null;

        try{
            // 1. ����̹� �ε�
            // ����̹� �������̽��� ������ Ŭ������ �ε�
            // mysql, oracle �� �� ������ ���� Ŭ���� �̸��� �ٸ���.
            // mysql�� "com.mysql.jdbc.Driver"�̸�, �̴� �ܿ�� ���� �ƴ϶� ���۸��ϸ� �ȴ�.
            // ����� ������ �����ߴ� jar ������ ���� com.mysql.jdbc ��Ű���� Driver ��� Ŭ������ �ִ�.
            Class.forName("com.mysql.jdbc.Driver");

            // 2. �����ϱ�
            // ����̹� �Ŵ������� Connection ��ü�� �޶�� ��û�Ѵ�.
            // Connection�� ��� ���� �ʿ��� url ����, �����縶�� �ٸ���.
            // mysql�� "jdbc:mysql://localhost/�����db�̸�" �̴�.
            String url = "jdbc:mysql://localhost/tya_game";

            // @param  getConnection(url, userName, password);
            // @return Connection
            conn = DriverManager.getConnection(url, "root", "mirim");
            System.out.println("���� ����");

        }
        catch(ClassNotFoundException e){
            System.out.println("���� ����");
        }
        catch(SQLException e){
            System.out.println("����: " + e);
        }
        finally{
            try{
                if( conn != null && !conn.isClosed()){
                    conn.close();
                }
            }
            catch( SQLException e){
                e.printStackTrace();
            }
        }
    }
}