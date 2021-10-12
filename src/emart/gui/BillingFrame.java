package emart.gui;

import emart.dao.OrderDAO;
import emart.dao.ProductsDAO;
import emart.dao.ReceptionistDAO;
import emart.pojo.ProductsPojo;
import emart.pojo.ReceptionistPojo;
import java.sql.SQLException;
import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class BillingFrame extends javax.swing.JFrame {

    ArrayList<ProductsPojo> al = new ArrayList<>();
    DefaultTableModel dtm;
    double grandtotal=0.0;
    public BillingFrame() {
	initComponents();
	super.setLocationRelativeTo(null);
	dtm=(DefaultTableModel)tableOrders.getModel();
	txtProductId.requestFocus();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        btnLogout = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableOrders = new javax.swing.JTable();
        btnBack = new javax.swing.JButton();
        btnGenerateBill = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtProductId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panel.setBackground(new java.awt.Color(255, 0, 51));
        panel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Billing Options", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 36), new java.awt.Color(255, 255, 255))); // NOI18N
        panel.setForeground(new java.awt.Color(255, 255, 255));

        btnLogout.setBackground(new java.awt.Color(0, 0, 0));
        btnLogout.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnLogout.setForeground(new java.awt.Color(255, 255, 255));
        btnLogout.setText("Logout");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        tableOrders.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product ID", "Product Name", "Product Price", "Our Price", "Product Company", "Quantity", "Tax", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableOrders);

        btnBack.setBackground(new java.awt.Color(0, 0, 0));
        btnBack.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnBack.setForeground(new java.awt.Color(255, 255, 255));
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnGenerateBill.setBackground(new java.awt.Color(0, 0, 0));
        btnGenerateBill.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnGenerateBill.setForeground(new java.awt.Color(255, 255, 255));
        btnGenerateBill.setText("Generate Bill");
        btnGenerateBill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerateBillActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Product ID:");

        txtProductId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProductIdActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Payable Amount:");

        txtTotal.setEditable(false);

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel1)
                        .addGap(34, 34, 34)
                        .addComponent(txtProductId, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(230, 230, 230)
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 108, Short.MAX_VALUE)
                        .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(143, 143, 143)
                        .addComponent(btnGenerateBill)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtProductId, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGenerateBill, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        LoginFrame log = new LoginFrame();
	log.setVisible(true);
	this.dispose();
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
    ReceptionistOptionsFrame mrf = new ReceptionistOptionsFrame();
	mrf.setVisible(true);
	this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnGenerateBillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerateBillActionPerformed
        try
	{
	    String ordId=OrderDAO.getNextOrderId();
	    if(OrderDAO.addOrder(al, ordId)&& ProductsDAO.updateStocks(al))
	    {
		JOptionPane.showMessageDialog(null,"Order of Rs "+grandtotal+"/- created successfully");
		ViewOrdersFrame view = new ViewOrdersFrame();
		view.setVisible(true);
		this.dispose();
	    }
	    else
	    JOptionPane.showMessageDialog(null,"Order not Created");
	}
	catch(SQLException ex)
	{
	    JOptionPane.showMessageDialog(null,"Error in DB","Error!",JOptionPane.ERROR_MESSAGE);
	    ex.printStackTrace();
	} 
    }//GEN-LAST:event_btnGenerateBillActionPerformed

    private void txtProductIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProductIdActionPerformed
	if(txtProductId.getText().trim().isEmpty()){
	    JOptionPane.showMessageDialog(null,"Please Enter Product Id","Error",JOptionPane.ERROR_MESSAGE);
	return;
	}
	LoadItemList(txtProductId.getText().trim());
    }//GEN-LAST:event_txtProductIdActionPerformed

    
    public static void main(String args[]) {
	/* Set the Nimbus look and feel */
	//<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
	/* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
	 */
	try {
	    for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
		if ("Nimbus".equals(info.getName())) {
		    javax.swing.UIManager.setLookAndFeel(info.getClassName());
		    break;
		}
	    }
	} catch (ClassNotFoundException ex) {
	    java.util.logging.Logger.getLogger(BillingFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	} catch (InstantiationException ex) {
	    java.util.logging.Logger.getLogger(BillingFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	} catch (IllegalAccessException ex) {
	    java.util.logging.Logger.getLogger(BillingFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	} catch (javax.swing.UnsupportedLookAndFeelException ex) {
	    java.util.logging.Logger.getLogger(BillingFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	}
	//</editor-fold>
	//</editor-fold>
	//</editor-fold>
	//</editor-fold>
	//</editor-fold>
	//</editor-fold>
	//</editor-fold>
	//</editor-fold>
	//</editor-fold>
	//</editor-fold>
	//</editor-fold>
	//</editor-fold>
	//</editor-fold>
	//</editor-fold>
	//</editor-fold>
	//</editor-fold>
	//</editor-fold>
	//</editor-fold>
	//</editor-fold>
	//</editor-fold>
	//</editor-fold>
	//</editor-fold>
	//</editor-fold>
	//</editor-fold>
	//</editor-fold>
	//</editor-fold>
	//</editor-fold>
	//</editor-fold>
	//</editor-fold>
	//</editor-fold>
	//</editor-fold>
	//</editor-fold>
	//</editor-fold>
	//</editor-fold>
	//</editor-fold>
	//</editor-fold>
	//</editor-fold>
	//</editor-fold>
	//</editor-fold>
	//</editor-fold>
	//</editor-fold>
	//</editor-fold>
	//</editor-fold>
	//</editor-fold>
	//</editor-fold>
	//</editor-fold>
	//</editor-fold>
	//</editor-fold>
	//</editor-fold>
	//</editor-fold>
	//</editor-fold>
	//</editor-fold>
	//</editor-fold>
	//</editor-fold>
	//</editor-fold>
	//</editor-fold>
	//</editor-fold>
	//</editor-fold>
	//</editor-fold>
	//</editor-fold>
	//</editor-fold>
	//</editor-fold>
	//</editor-fold>
	//</editor-fold>

	/* Create and display the form */
	java.awt.EventQueue.invokeLater(new Runnable() {
	    public void run() {
		new BillingFrame().setVisible(true);
	    }
	});
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnGenerateBill;
    private javax.swing.JButton btnLogout;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panel;
    private javax.swing.JTable tableOrders;
    private javax.swing.JTextField txtProductId;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables

    private void showEmpData() {
    try
    {
	List<ReceptionistPojo> recepList = ReceptionistDAO.getAllReceptionistDetails();
	DefaultTableModel dtm= (DefaultTableModel)tableOrders.getModel();
	Object [] rows = new Object[5];
	for(ReceptionistPojo emp : recepList)
	{
	    rows[0] = emp.getEmpid();
	    rows[1] = emp.getEmpname();
	    rows[2] = emp.getUserid();
	    rows[3] = emp.getJob();
	    rows[4] = emp.getSalary();
	    dtm.addRow(rows);
	}
    }
catch(SQLException ex)
	{
	    JOptionPane.showMessageDialog(null,"Error in DB","Error!",JOptionPane.ERROR_MESSAGE);
	    ex.printStackTrace();
	}    
    }

    private void LoadItemList(String p_id) {
	try
	{
	    ProductsPojo p = ProductsDAO.getProductDetails(p_id);
	    if(p.getProductId()==null)
	    {
		 JOptionPane.showMessageDialog(null,"Please Enter valid Product Id","Error",JOptionPane.ERROR_MESSAGE);
		return;
	    }
	    int index = getProductId(p_id);
	    if(index==-1)
	    {
		Object [] rows = new Object[8];
		int quan=1;
		double amt = quan*p.getOurPrice();
		p.setQuantity(quan);
		p.setTotal(amt+(amt*p.getTax()/100));
		rows[0]=p.getProductId();
		rows[1]=p.getProductName();
		rows[2]=p.getProductPrice();
		rows[3]=p.getOurPrice();
		rows[4]=p.getProductCompany();
		rows[5]=p.getQuantity();
		rows[6]=p.getTax();
		rows[7]=p.getTotal();
		dtm.addRow(rows);
		al.add(p);
		grandtotal+=p.getTotal();
	    }
	    else
	    {
	      ProductsPojo prod = al.get(index);
	      int oldq = (int)dtm.getValueAt(index,5);
	      double amt = prod.getOurPrice();
	      int tax = prod.getTax();
	      amt = amt+(amt*tax/100);
	      double total = (double)dtm.getValueAt(index,7);
	      dtm.setValueAt(++oldq, index,5);
	      dtm.setValueAt(total+amt,index,7);
	      grandtotal+=amt;
	      prod.setQuantity(oldq);
	      prod.setTotal(total+amt);
	      al.set(index, prod);
	    }
            txtTotal.setText("Rs. " + grandtotal);
	}
	catch(SQLException sql)
	{
	    JOptionPane.showMessageDialog(null,"Error in DB","Error!",JOptionPane.ERROR_MESSAGE);
	    sql.printStackTrace();
	}
    }
    private int getProductId(String pid)
	{
	  int index = -1;
	  for(int i=0; i<al.size(); i++)
	  {
	      ProductsPojo p = al.get(i);
	      if(p.getProductId().equals(pid))
	      {
		  index=i;
		  break;
	      }
	  }
	  return index;
	}
}
