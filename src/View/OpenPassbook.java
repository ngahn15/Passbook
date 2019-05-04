/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Base;
import Controller.Message;
import Controller.OpenPassbookDAO;
import Controller.SearchDAO;
import Model.Customer;
import Model.Passbook;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author ngocn
 */
public class OpenPassbook extends javax.swing.JFrame {

    private Customer customer;
    private Passbook passbook;

    private int IDP;
    private int InterestRateID;
    private int InterestMethodID;
    private int TypeID;
    private String CustomerID;
    private Date OpenDate;
    private Date ExpDate;
    private String DepositsOriginal;
    private int TypePeriod;
    private int status;

    public OpenPassbook(Customer customer) {
        initComponents();
        if (customer != null) {
            this.customer = customer;
            setJlabelNOTNull();
        } else {
            this.setVisible(true);
        }
        curDate.setText(Base.Instance.dateToStringShow(new Date()));
        openDate.setDate(new Date());
    }

    public void setJlabelNOTNull() {
            search.setEnabled(false);
            fullname.setText(customer.getFullname());
            ID.setText(customer.getCMT());
            ID.setEnabled(false);
    }

    public void setJlabelNull() {

        String id = ID.getText();
        customer = new SearchDAO().getCustomerByID(id);
        if (customer != null) {
            fullname.setText(customer.getFullname());
        } else {
            int yes_no = JOptionPane.showConfirmDialog(null, "Không tồn tại khách hàng trong CSDL." + "Thêm mới khách hàng?");
            if (yes_no == 0) {
                CustomerRegister cusRegister = new CustomerRegister();
                cusRegister.setVisible(true);
                cusRegister.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            }
        }
        curDate.setText(Base.Instance.dateToStringShow(new Date()));
        openDate.setDate(new Date());
    }

    public void getText() {
        this.IDP = OpenPassbookDAO.randomID();
        this.CustomerID = customer.getCMT();
        this.InterestRateID = period.getSelectedIndex();
        this.TypeID = typePassbook.getSelectedIndex();
        this.TypePeriod = period.getSelectedIndex();
        this.InterestMethodID = interestmethod.getSelectedIndex();
        this.status = 0;
        this.DepositsOriginal = deposit.getText();
        this.OpenDate = openDate.getDate();
    }

    public void setExpDate() {
        Calendar epD = Calendar.getInstance();
        Date d;
        int t = period.getSelectedIndex();
        if (t == 1 || t == 0) {
            expDate.setText(null);
        } else if (t == 2) {
            epD.add(Calendar.MONTH, 1);
            d = epD.getTime();
            expDate.setText(Base.Instance.dateToStringShow(d));
        } else if (t == 3) {
            epD.add(Calendar.MONTH, 2);
            d = epD.getTime();
            expDate.setText(Base.Instance.dateToStringShow(d));
        } else if (t == 4) {
            epD.add(Calendar.MONTH, 3);
            d = epD.getTime();
            expDate.setText(Base.Instance.dateToStringShow(d));
        } else if (t == 5) {
            epD.add(Calendar.MONTH, 6);
            d = epD.getTime();
            expDate.setText(Base.Instance.dateToStringShow(d));
        } else if (t == 6) {
            epD.add(Calendar.MONTH, 9);
            d = epD.getTime();
            expDate.setText(Base.Instance.dateToStringShow(d));
        } else if (t == 7) {
            epD.add(Calendar.MONTH, 12);
            d = epD.getTime();
            expDate.setText(Base.Instance.dateToStringShow(d));
        } else if (t == 8) {
            epD.add(Calendar.MONTH, 18);
            d = epD.getTime();
            expDate.setText(Base.Instance.dateToStringShow(d));
        } else if (t == 9) {
            epD.add(Calendar.MONTH, 24);
            d = epD.getTime();
            expDate.setText(Base.Instance.dateToStringShow(d));
        }
        this.ExpDate = Base.Instance.stringToDate(expDate.getText());
    }

    public int validateMoney() {
        if (Base.Instance.checkStringNull((DepositsOriginal))) {
            return 1;
        } else if (Base.Instance.checkChar_((DepositsOriginal)) || Base.Instance.checkCharABC((DepositsOriginal))) {
            return 2;
        } else if (Base.Instance.inputDeposit_1(Integer.parseInt(DepositsOriginal.replace(".", "")))) {
            return 3;
        } else if (Base.Instance.inputDeposit_2(Integer.parseInt(DepositsOriginal.replace(".", "")))) {
            return 4;
        }
        return 0;
    }

    public int validateCombobox_1() {
        if (typePassbook.getSelectedIndex() == 0) {
            return 1;
        }
        return 0;
    }

    public int validateCombobox_2() {
        if (period.getSelectedIndex() == 0) {
            return 1;
        }

        if (typePassbook.getSelectedIndex() == 1) {
            if (period.getSelectedIndex() > 1) {
                return 2;
            }
        } else if (typePassbook.getSelectedIndex() == 2) {
            if (period.getSelectedIndex() < 1 || period.getSelectedIndex() > 10) {
                return 2;
            }
        } else if (typePassbook.getSelectedIndex() == 3) {
            if (period.getSelectedIndex() < 10) {
                return 2;
            }
        }
        return 0;
    }

    public int validateCombobox_3() {
        if (interestmethod.getSelectedIndex() == 0) {
            return 1;
        }
        return 0;
    }

    public void showMesage(String mes) {
        JOptionPane.showMessageDialog(null, mes);
    }

    public void OpenPassbook() {
        getText();
        System.out.println(Long.parseLong(DepositsOriginal.replace(".", "")));
        if (validateMoney() == 0 && validateCombobox_1() == 0 && validateCombobox_2() == 0 && validateCombobox_3() == 0) {
            this.passbook = new Passbook(IDP, InterestRateID, InterestMethodID, TypeID, CustomerID, OpenDate, ExpDate, Long.parseLong(DepositsOriginal.replace(".", "")), TypePeriod, status);
            int n = OpenPassbookDAO.Instance.add(passbook);
            if (n != 0) {
                showMesage(Message.Instance.openPassbook_Success);
//                System.out.println(passbookPanel.toString());
                reset();
            } else {
                showMesage("wrong answer!");
            }
        } else {
            int kt = validateMoney();
            if (kt == 1) {
                showMesage(Message.Instance.money_1);
            } else if (kt == 2) {
                showMesage(Message.Instance.money_2);
            } else if (kt == 3) {
                showMesage(Message.Instance.money_3);
            } else if (kt == 4) {
                showMesage(Message.Instance.money_4);
            }

            kt = validateCombobox_1();
            if (kt == 1) {
                showMesage(Message.Instance.combobox_1);
            }

            kt = validateCombobox_2();
            if (kt == 1) {
                showMesage(Message.Instance.combobox_2_1);
            } else if (kt == 2) {
                showMesage(Message.Instance.combobox_2_2);
            }

            kt = validateCombobox_3();
            if (kt == 1) {
                showMesage(Message.Instance.combobox_3);
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        curDate = new javax.swing.JTextField();
        Customer = new javax.swing.JPanel();
        JLabel = new javax.swing.JLabel();
        ID = new javax.swing.JTextField();
        search = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        fullname = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        passbookPanel = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        deposit = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        typePassbook = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        period = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        interestmethod = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        openDate = new com.toedter.calendar.JDateChooser();
        expDate = new javax.swing.JTextField();
        openPassbook = new javax.swing.JButton();
        reset = new javax.swing.JButton();
        back1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Ngày giao dịch:");

        curDate.setEnabled(false);

        Customer.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin khách hàng"));
        Customer.setToolTipText("Thông tin khách hàng");
        Customer.setName("Thông tin khách hàng"); // NOI18N

        JLabel.setText("Mã khách hàng");

        search.setText("Tìm");
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });

        jLabel2.setText("Tên khách hàng");

        javax.swing.GroupLayout CustomerLayout = new javax.swing.GroupLayout(Customer);
        Customer.setLayout(CustomerLayout);
        CustomerLayout.setHorizontalGroup(
            CustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CustomerLayout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(CustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JLabel)
                    .addComponent(jLabel2))
                .addGap(66, 66, 66)
                .addGroup(CustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CustomerLayout.createSequentialGroup()
                        .addComponent(fullname, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(690, 690, 690))
                    .addGroup(CustomerLayout.createSequentialGroup()
                        .addComponent(ID, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(72, 72, 72)
                        .addComponent(search)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        CustomerLayout.setVerticalGroup(
            CustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CustomerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(CustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLabel)
                    .addComponent(ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(search))
                .addGap(18, 18, 18)
                .addGroup(CustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(fullname))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setText("Mở sổ tiết kiệm");

        passbookPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin sổ"));

        jLabel6.setText("Số tiền gửi (VND)");

        jLabel4.setText("Loại hình tiết kiệm");

        typePassbook.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--- Chọn loại hình tiết kiêm ---", "Không kỳ hạn", "Có kỳ hạn", "An sinh" }));
        typePassbook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                typePassbookActionPerformed(evt);
            }
        });

        jLabel5.setText("Kỳ hạn");

        period.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--- Chọn loại kỳ hạn ---", "0 tháng - 0.2%", "1 tháng - 4.1%", "2 tháng - 4.1%", "3 tháng - 4.6%", "6 tháng - 5.1%", "9 tháng - 5.5%", "12 tháng - 6.6%", "18 tháng - 6.7%", "24 tháng - 6.7%" }));
        period.setToolTipText("");
        period.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        period.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                periodFocusLost(evt);
            }
        });
        period.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                periodActionPerformed(evt);
            }
        });

        jLabel7.setText("Phương thức rút lãi");

        interestmethod.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--- Chọn phương thức rút lãi ---", "Rút lãi theo tháng", "Lãi nhập gốc" }));

        jLabel9.setText("Ngày kết thúc");

        jLabel8.setText("Ngày bắt đầu");

        openDate.setDateFormatString("dd-MM-yyyy");

        expDate.setEnabled(false);

        javax.swing.GroupLayout passbookPanelLayout = new javax.swing.GroupLayout(passbookPanel);
        passbookPanel.setLayout(passbookPanelLayout);
        passbookPanelLayout.setHorizontalGroup(
            passbookPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(passbookPanelLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(passbookPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addGap(43, 43, 43)
                .addGroup(passbookPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(typePassbook, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(deposit)
                    .addComponent(period, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(interestmethod, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(openDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(128, 128, 128)
                .addComponent(jLabel9)
                .addGap(40, 40, 40)
                .addComponent(expDate, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(141, Short.MAX_VALUE))
        );
        passbookPanelLayout.setVerticalGroup(
            passbookPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(passbookPanelLayout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(passbookPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(deposit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(passbookPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(typePassbook, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(passbookPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(period, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(passbookPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(interestmethod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(passbookPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(openDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addGroup(passbookPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(expDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 17, Short.MAX_VALUE))
        );

        openPassbook.setText("Mở sổ");
        openPassbook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openPassbookActionPerformed(evt);
            }
        });

        reset.setText("Reset");
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });

        back1.setText("Quay lại");
        back1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(curDate, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(325, 325, 325)
                        .addComponent(back1)
                        .addGap(69, 69, 69)
                        .addComponent(openPassbook)
                        .addGap(81, 81, 81)
                        .addComponent(reset))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(passbookPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Customer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(395, 395, 395))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(curDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(Customer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(passbookPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(openPassbook)
                    .addComponent(reset)
                    .addComponent(back1))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void typePassbookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_typePassbookActionPerformed
        int t = typePassbook.getSelectedIndex();
        if (t == 0) {
            period.setEnabled(true);
            period.setSelectedIndex(0);
            interestmethod.setSelectedIndex(0);
        } else if (t == 1) {
            period.setEnabled(false);
            period.setSelectedIndex(1);
        } else {
            period.setEnabled(true);
            period.setSelectedIndex(2);

        }
    }//GEN-LAST:event_typePassbookActionPerformed

    private void periodFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_periodFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_periodFocusLost

    private void periodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_periodActionPerformed
        setExpDate();
    }//GEN-LAST:event_periodActionPerformed

    private void openPassbookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openPassbookActionPerformed
        OpenPassbook();
        infoPassbook ip = new infoPassbook(passbook);
        ip.setVisible(true);
        ip.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_openPassbookActionPerformed

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
        reset();
    }//GEN-LAST:event_resetActionPerformed

    private void back1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_back1ActionPerformed

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        setJlabelNull();
    }//GEN-LAST:event_searchActionPerformed
    public void reset() {
        setJlabelNOTNull();
        deposit.setText("");
        period.setSelectedIndex(0);
        interestmethod.setSelectedIndex(0);
        curDate.setText(Base.Instance.dateToStringShow(new Date()));
        openDate.setDate(new Date());

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Customer;
    private javax.swing.JTextField ID;
    private javax.swing.JLabel JLabel;
    private javax.swing.JButton back1;
    private javax.swing.JTextField curDate;
    private javax.swing.JTextField deposit;
    private javax.swing.JTextField expDate;
    private javax.swing.JLabel fullname;
    private javax.swing.JComboBox<String> interestmethod;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private com.toedter.calendar.JDateChooser openDate;
    private javax.swing.JButton openPassbook;
    private javax.swing.JPanel passbookPanel;
    private javax.swing.JComboBox<String> period;
    private javax.swing.JButton reset;
    private javax.swing.JButton search;
    private javax.swing.JComboBox<String> typePassbook;
    // End of variables declaration//GEN-END:variables
}
