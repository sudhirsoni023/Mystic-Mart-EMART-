package emart.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class DBConnection {
private static Connection conn;
static{
	    try{
		Class.forName("oracle.jdbc.OracleDriver");
		conn = DriverManager.getConnection("jdbc:oracle:thin:@//LAPTOP-6VPNB7HE:1521/xe", "grocery", "oracle");
		JOptionPane.showMessageDialog(null,"Connection Established Successfully","Success!!",JOptionPane.INFORMATION_MESSAGE);
	    }
	    catch(ClassNotFoundException cnfe)
	    {
		JOptionPane.showMessageDialog(null,"Error in Loading the driver","Driver Error!",JOptionPane.ERROR_MESSAGE);
		cnfe.printStackTrace();
		System.exit(1);
	    }
	    catch(SQLException sex)
	    {
		JOptionPane.showMessageDialog(null,"Error in Opening Connection","DB Error!",JOptionPane.ERROR_MESSAGE);
		sex.printStackTrace();
		System.exit(1);
	    }
      }
	    public static Connection getConnection()
	    {
		return conn;
	    }
      public static void closeConnection()
      {
	  try
	  {
	      conn.close();
	      JOptionPane.showMessageDialog(null,"Connection Closed Successfully","Success!!",JOptionPane.INFORMATION_MESSAGE);
	  }
	    catch(SQLException sex)
	    {
		JOptionPane.showMessageDialog(null,"Error in Opening Connection","DB Error!",JOptionPane.ERROR_MESSAGE);
		sex.printStackTrace();
	    }
      }
}
