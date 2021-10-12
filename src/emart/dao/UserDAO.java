package emart.dao;

import emart.dbutil.DBConnection;
import emart.pojo.UserPojo;
import emart.pojo.UserProfile;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO 
{
    public static final String MANAGER = "Manager";
    public static final String RECEPTIONIST = "Receptionist";

    public static boolean validateUser(UserPojo user)throws SQLException
    {
	Connection conn = DBConnection.getConnection();
	PreparedStatement ps = conn.prepareStatement("Select * from users where userid=? and password=? and usertype=?");
	ps.setString(1,user.getUserid());
	ps.setString(2,user.getPassword());
	ps.setString(3,user.getUsertype());
	ResultSet rs = ps.executeQuery();

	if (rs.next()) {
            UserProfile.setUsername(rs.getString("username"));
            UserProfile.setUsertype(rs.getString("usertype"));
            UserProfile.setUserid(rs.getString("userid"));
            return true;
        }
	return false;
    }

    public static boolean isUserPresent(String empId)throws SQLException
    {
	Connection conn = DBConnection.getConnection();
	PreparedStatement ps = conn.prepareStatement("Select 1 from users where empid=?");
	ps.setString(1,empId);
	ResultSet rs = ps.executeQuery();
	return rs.next();
    }   
    public static boolean isValidUserId(String userid) throws SQLException {
        PreparedStatement stmt = DBConnection.getConnection().prepareStatement("select 1 from users where userid = ?");
        stmt.setString(1, userid);
        ResultSet rs = stmt.executeQuery();
        return !(rs.next());
    }
}