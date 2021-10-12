package emart.dao;

import emart.dbutil.DBConnection;
import emart.pojo.EmployeePojo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class EmployeeDAO {
    public static String getNextEmpId() throws SQLException
    {
	Connection conn = DBConnection.getConnection();
	Statement st = conn.createStatement();
	ResultSet rs = st.executeQuery("Select max(empid) from employees");
	rs.next();
	String empid = rs.getString(1);
	int empno = Integer.parseInt(empid.substring(1));
	empno = empno+1;
	return "E"+empno;
    }
    public static boolean addEmployee(EmployeePojo emp)throws SQLException
    {
	Connection conn=DBConnection.getConnection();
	PreparedStatement ps = conn.prepareStatement("Insert into employees values(?,?,?,?)");
	
	ps.setString(1,emp.getEmpid());
	ps.setString(2,emp.getEmpname());
	ps.setString(3,emp.getJob());
	ps.setDouble(4,emp.getSalary());
	int result = ps.executeUpdate();
	return result==1;
    }
    public static boolean removeEmployee(String empid)throws SQLException
    {
	Connection conn=DBConnection.getConnection();
	PreparedStatement ps = conn.prepareStatement("delete from users where empid=?");
	PreparedStatement ps1 = conn.prepareStatement("delete from employees where empid=?");
	ps.setString(1,empid);
	ps1.setString(1, empid);
	int x = ps.executeUpdate();
	int y = ps1.executeUpdate();
	return (x==1 || y==1);
    }
    
    public static boolean updateEmployee(EmployeePojo emp)throws SQLException
    {
	Connection conn=DBConnection.getConnection();
	PreparedStatement ps = conn.prepareStatement("Update employees set empname=?,job=?,salary=? where empid=?");
	ps.setString(1,emp.getEmpname());
	ps.setString(2,emp.getJob());
	ps.setDouble(3,emp.getSalary());
	ps.setString(4,emp.getEmpid());
	int result = ps.executeUpdate();
	if(result==0)
	    return false;
	else
	{
	    boolean res = UserDAO.isUserPresent(emp.getEmpid());
	    if(res==false)
		return true;
	ps = conn.prepareStatement("Update users set username=?,usertype=? where empid=?");
	ps.setString(1,emp.getEmpname());
	ps.setString(2,emp.getJob());
	ps.setString(3,emp.getEmpid());
	int y = ps.executeUpdate();
	return y==1;
	}
    }
    public static List<EmployeePojo> getAllEmployees() throws SQLException
    {
	Connection conn = DBConnection.getConnection();
	Statement st = conn.createStatement();
	ResultSet rs = st.executeQuery("Select * from employees order by empid");
	ArrayList<EmployeePojo> empList = new ArrayList<>();
	while(rs.next())
	{
	    EmployeePojo emp = new EmployeePojo();
	    emp.setEmpid(rs.getString(1));
	    emp.setEmpname(rs.getString(2));
	    emp.setJob(rs.getString(3));
	    emp.setSalary(rs.getDouble(4));
	    empList.add(emp);
	}
	return empList;
    }
    public static List<String> getAllEmployeesId() throws SQLException
    {
	Connection conn = DBConnection.getConnection();
	Statement st = conn.createStatement();
	ResultSet rs = st.executeQuery("Select empid from employees order by empid");
	List<String> empList = new ArrayList<>();
	while(rs.next())
	{
	    empList.add(rs.getString(1));
	}
	return empList;
    }
    
    public static EmployeePojo findEmployeeById(String empId)throws SQLException
    {
	Connection conn = DBConnection.getConnection();
	PreparedStatement ps = conn.prepareStatement("Select * from Employees where empid=?");
	ps.setString(1,empId);
	ResultSet rs = ps.executeQuery();
	rs.next();
	EmployeePojo e=new EmployeePojo();
	    e.setEmpid(rs.getString(1));
	    e.setEmpname(rs.getString(2));
	    e.setJob(rs.getString(3));
	    e.setSalary(rs.getDouble(4));
	return e;
    }
}