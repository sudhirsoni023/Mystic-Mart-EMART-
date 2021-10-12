package emart.dao;

import emart.dbutil.DBConnection;
import emart.pojo.ProductsPojo;
import emart.pojo.UserProfile;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO {
    public static String getNextOrderId() throws SQLException
    {
	Connection conn = DBConnection.getConnection();
	Statement st = conn.createStatement();
	ResultSet rs = st.executeQuery("Select max(order_id) from orders");
	rs.next();
	String ordId = rs.getString(1);
	 if(ordId==null)
	     return "O-101";
	 
	int ordNo = Integer.parseInt(ordId.substring(2));
	ordNo = ordNo+1;
	return "O-"+ordNo;
    }   
    public static boolean addOrder(ArrayList<ProductsPojo> al, String ordId) throws SQLException
    {
	Connection conn = DBConnection.getConnection();
	PreparedStatement ps = conn.prepareStatement("insert into orders values(?,?,?,?,?,?,?)");
	int count=0;
	for(ProductsPojo p:al)
	{
	    ps.setString(1, ordId);
            ps.setString(2, p.getProductId());
            ps.setInt(3, p.getQuantity());
            ps.setString(4, UserProfile.getUserid());
            ps.setDouble(5, p.getProductPrice());
            ps.setDouble(6, p.getOurPrice());
            ps.setInt(7, p.getTax());
            count += ps.executeUpdate();
	}
	return count==al.size();
    }
     public static List<ProductsPojo> getOrders(String orderId) throws SQLException {
        PreparedStatement ps = DBConnection.getConnection()
                .prepareStatement("select orders.order_id,orders.userid,orders.p_id,products.p_name,products.p_companyname,orders.p_price,orders.our_price,orders.p_tax, orders.quantity from orders, products where orders.p_id = products.p_id and orders.userid=? and orders.order_id=?");
        ps.setString(1, UserProfile.getUserid());
        ps.setString(2, orderId);
        ResultSet rs = ps.executeQuery();
        ArrayList<ProductsPojo> orders = new ArrayList<>();
        while (rs.next()) {

            ProductsPojo p = new ProductsPojo(
                    rs.getString("p_id"),
                    rs.getString("p_name"),
                    rs.getString("p_companyname"),
                    rs.getDouble("p_price"),
                    rs.getDouble("our_price"),
                    rs.getInt("p_tax"),
                    rs.getInt("quantity")
            );
            orders.add(p);
        }
        return orders;
    }

    public static List<ProductsPojo> getAllOrders(String orderId) throws SQLException {
        PreparedStatement ps = DBConnection.getConnection().prepareStatement("select orders.order_id, orders.userid, orders.p_id,products.p_name,products.p_companyname,orders.p_price,orders.our_price,orders.p_tax,orders.quantity from orders, products where orders.p_id = products.p_id and orders.order_id=?");
        ps.setString(1, orderId);
        ResultSet rs = ps.executeQuery();
        ArrayList<ProductsPojo> orders = new ArrayList<>();
        while (rs.next()) {

            ProductsPojo p = new ProductsPojo(
                    rs.getString("p_id"),
                    rs.getString("p_name"),
                    rs.getString("p_companyname"),
                    rs.getDouble("p_price"),
                    rs.getDouble("our_price"),
                    rs.getInt("p_tax"),
                    rs.getInt("quantity")
            );
            orders.add(p);
        }
        return orders;
    }

    public static List<String> getAllOrderIds(String userid) throws SQLException {
        String sql;
        if (userid == null) {
            sql = "select distinct order_id from orders order by order_id desc";
        } else {
            sql = "select distinct order_id from orders where userid=? order by order_id desc";
        }
        PreparedStatement ps = DBConnection.getConnection()
                .prepareStatement(sql);
        if (userid != null) {
            ps.setString(1, userid);
        }
        ResultSet rs = ps.executeQuery();
        ArrayList<String> ids = new ArrayList<>();
        while (rs.next()) {
            ids.add(rs.getString("order_id"));
        }
        return ids;
    }
}