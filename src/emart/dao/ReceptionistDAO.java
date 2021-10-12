package emart.dao;

import emart.dbutil.DBConnection;
import emart.pojo.ReceptionistPojo;
import emart.pojo.UserPojo;
import java.sql.*;
import java.util.*;


public class ReceptionistDAO {
public static Map<String,String> getNonRegisteredReceptionists() throws SQLException
{
	Connection conn = DBConnection.getConnection();
	Statement st = conn.createStatement();
	ResultSet rs = st.executeQuery("Select empid,empname from employees where job='Receptionist' and empid not in(select empid from users where usertype='Receptionist')");
	HashMap<String,String> receptionistList = new HashMap<>();
	while(rs.next())
	{
	    String id = rs.getString(1);
	    String name = rs.getString(2);
	    receptionistList.put(id, name);  
	}
	return receptionistList;
}    
public static boolean addReceptionist(UserPojo user)throws SQLException
{
        Connection conn=DBConnection.getConnection();
	PreparedStatement ps = conn.prepareStatement("Insert into users values(?,?,?,?,?)");
	ps.setString(1,user.getUserid());
	ps.setString(2,user.getEmpid());
	ps.setString(3,user.getPassword());
	ps.setString(4,user.getUsertype());
	ps.setString(5,user.getUsername());
	int result = ps.executeUpdate();
	return result==1;
}
public static boolean updateReceptionist(UserPojo user)throws SQLException
    {
	Connection conn=DBConnection.getConnection();
	PreparedStatement ps = conn.prepareStatement("Update users set password=? where empid=?");
	ps.setString(1,user.getPassword());
	ps.setString(2,user.getEmpid());
	
	int result = ps.executeUpdate();
	return result==1; 
    }
public static List<ReceptionistPojo> getAllReceptionistDetails()throws SQLException
{
        Connection conn = DBConnection.getConnection();
	Statement st = conn.createStatement();
	ResultSet rs = st.executeQuery("Select users.empid,empname,userid,job,salary from users,employees where usertype='Receptionist' and users.empid=employees.empid");  
	
	ArrayList<ReceptionistPojo> list = new ArrayList<>();
	
	while(rs.next())
	{
	  ReceptionistPojo recep = new ReceptionistPojo();
	  recep.setEmpid(rs.getString(1));
	  recep.setEmpname(rs.getString(2));
	  recep.setUserid(rs.getString(3));
          recep.setJob(rs.getString(4));
	  recep.setSalary(rs.getDouble(5));
	  list.add(recep);
	}
	return list;
}
public static List<String> getAllReceptionistId() throws SQLException
    {
	Connection conn = DBConnection.getConnection();
	Statement st = conn.createStatement();
	ResultSet rs = st.executeQuery("Select empid from users where usertype='Receptionist' order by empid");
	List<String> recepList = new ArrayList<>();
	while(rs.next())
	{
	    recepList.add(rs.getString(1));
	}
	return recepList;
    }

public static ReceptionistPojo findReceptionistById(String recepId)throws SQLException
    {
	Connection conn = DBConnection.getConnection();
	PreparedStatement ps = conn.prepareStatement("Select * from users where empid=?");
	ps.setString(1,recepId);
	ResultSet rs = ps.executeQuery();
	rs.next();
	ReceptionistPojo rec=new ReceptionistPojo();
	    rec.setUserid(rs.getString(1));
	    rec.setEmpid(rs.getString(2));
	    rec.setEmpname(rs.getString(5));  
	return rec;
    }
public static List<String> getAllReceptionistUserId() throws SQLException
    {
	Connection conn = DBConnection.getConnection();
	Statement st = conn.createStatement();
	ResultSet rs = st.executeQuery("Select userid from users where usertype='Receptionist' order by userid");
	List<String> userList = new ArrayList<>();
	while(rs.next())
	{
	    userList.add(rs.getString(1));
	}
	return userList;
    }
public static boolean deleteReceptionist(String userid)throws SQLException
{
    Connection conn=DBConnection.getConnection();
	PreparedStatement ps = conn.prepareStatement("delete from users where userid=?");
	ps.setString(1,userid);
		
	return ps.executeUpdate()==1;
}
}
