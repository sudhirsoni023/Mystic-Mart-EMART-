package emart.pojo;

public class UserPojo {

    @Override
    public String toString() {
	return "UserPojo{" + "userid=" + userid + ", username=" + username + ", password=" + password + ", usertype=" + usertype + ", empid=" + empid + '}';
    }

    public String getUserid() {
	return userid;
    }

    public void setUserid(String userid) {
	this.userid = userid;
    }

    public String getUsername() {
	return username;
    }

    public void setUsername(String username) {
	this.username = username;
    }

    public String getPassword() {
	return password;
    }

    public void setPassword(String password) {
	this.password = password;
    }

    public String getUsertype() {
	return usertype;
    }

    public void setUsertype(String usertype) {
	this.usertype = usertype;
    }

    public String getEmpid() {
	return empid;
    }

    public void setEmpid(String empid) {
	this.empid = empid;
    }
    private String userid;
    private String username;
    private String password;
    private String usertype;
    private String empid; 
}
