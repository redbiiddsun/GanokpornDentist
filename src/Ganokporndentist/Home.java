/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ganokporndentist;

import javax.swing.JFrame;
import keeptoo.Drag;
import Ganokporndentist.lib.*;
import java.awt.CardLayout;
import java.awt.HeadlessException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.HashMap;
import javax.swing.JOptionPane;

/**
 *
 * @author Phanasorn Srisayam
 */
public class Home extends javax.swing.JFrame {

    /**
     * Creates new form Home
     */
    CardLayout cardLayout;
    HashMap<String, Integer> HashMapcmbUser = new HashMap<String, Integer>();
    HashMap<String, Integer> HashMapcmbEPD = new HashMap<String, Integer>();
    HashMap<String, Integer> HashMapcmbAPatient = new HashMap<String, Integer>();
    HashMap<String, Integer> HashMapcmbADoctor = new HashMap<String, Integer>();
    HashMap<String, Integer> HashMapcmbAEPD = new HashMap<String, Integer>();
    
    public Home() {
        initComponents();
        cardLayout = (CardLayout)(pnlCards.getLayout());
        btnOverview.doClick();
        DBconnection.getConnection();
        getComboBox();
        cmbEAPatient();
        cmbAPatient();
        cmbADoctor();
        countP();
        countD();
        countA();

    }
    
    
    public void countP(){
        
        String i;
        
        
        
        
        try {
           Statement st = DBconnection.getConnection().createStatement();
           ResultSet rs = st.executeQuery("SELECT COUNT(*) FROM patient" );
           
           while(rs.next())
           {
               i = rs.getString(1);
               lblP.setText(i);
           }
        } catch (Exception e) {
           e.printStackTrace();
        }
        
    }
    
    public void countD(){
        
        String ii;
        
        try {
           Statement st = DBconnection.getConnection().createStatement();
           ResultSet rs = st.executeQuery("SELECT COUNT(*) FROM doctor" );
           
           while(rs.next())
           {
               ii = rs.getString(1);
               lblD.setText(ii);
           }
        } catch (Exception e) {
           e.printStackTrace();
        }
        
    }
    
    public void countA(){
        
        String iii;
        
        
        
        
        try {
           Statement st = DBconnection.getConnection().createStatement();
           ResultSet rs = st.executeQuery("SELECT COUNT(*) FROM reserve" );
           
           while(rs.next())
           {
               iii = rs.getString(1);
               lblA.setText(iii);
           }
        } catch (Exception e) {
           e.printStackTrace();
        }
        
    }
    
    public void cmbEAPatient(){
        cmbAList.addItem("");
        
        try {
           Statement st = DBconnection.getConnection().createStatement();
           ResultSet rs = st.executeQuery("SELECT reserve.reserve_id, patient.National_ID, doctor.Firstname, reserve.Date FROM ((reserve INNER JOIN doctor ON reserve.Doctor_ID = doctor.Doctor_ID) INNER JOIN patient ON patient.Patient_ID = patient.Patient_ID)");
           
           while(rs.next())
           {
               String Name = rs.getString(2) + " " + rs.getString(4);
               int ID = rs.getInt(1);
               HashMapcmbAEPD.put(Name, ID);
               cmbAList.addItem(Name);
               
           }
        } catch (Exception e) {
           e.printStackTrace();
        }
        
    }
    
    public void cmbAPatient(){
        cmbAPatient.addItem("");
        //String selection = (String) cmbCatagorie.getSelectedItem();
        
        try {
           Statement st = DBconnection.getConnection().createStatement();
           ResultSet rs = st.executeQuery("SELECT * FROM  `patient` ");
           
           while(rs.next())
           {
               String Name = rs.getString(3) + " " + rs.getString(4);
               int ID = rs.getInt(1);
               HashMapcmbAPatient.put(Name, ID);
               cmbAPatient.addItem(Name);
               //cmbEAPatient.addItem(Name);
               
           }
        } catch (Exception e) {
           e.printStackTrace();
        }
        
    }
        public void cmbADoctor(){
        cmbADoctor.addItem("");
        //String selection = (String) cmbCatagorie.getSelectedItem();
        
        try {
           Statement st = DBconnection.getConnection().createStatement();
           ResultSet rs = st.executeQuery("SELECT * FROM  `doctor` ");
           
           while(rs.next())
           {
               String Name = rs.getString(3) + " " + rs.getString(4);
               int ID = rs.getInt(1);
               HashMapcmbADoctor.put(Name, ID);
               cmbADoctor.addItem(Name);
               //qqqcmbEADoctor.addItem(Name);
           }
        } catch (Exception e) {
           e.printStackTrace();
        }
        
    }
    
    public boolean checkRegistertext(){
        
        return !(txtFirstname.getText().equals("")
                || txtLastname.getText().equals("")
                || txtEmail.getText().equals("")
                || txtPassword.getPassword().equals(""));
    }
    public boolean checkDoctorRegistertext(){
        
        return !(txtDoctorFirstname.getText().equals("")
                || txtDoctorLastname.getText().equals("")
                || txtDoctorPhone.getText().equals("")
                || txtDoctorNationalID.getText().equals("")
                || txtDoctorAdresses.getText().equals("")); 
    }
    
    public boolean checkEdittext(){
        
        return !(txtEFirstname.getText().equals("")
                || txtELastname.getText().equals("")
                || txtEEmail.getText().equals("")); 
    }
    
    public boolean checkPatientRegistertext(){
        
        return !(txtPatientFirstname.getText().equals("")
                || txtPatientLastname.getText().equals("")
                || txtPatientAddress.getText().equals("")
                || txtPatientPhone.getText().equals("")
                || txtPatientNationalID.getText().equals(""));
    }
    
    public boolean checkEPDtext(){
        
        return !(txtEPDFirstname.getText().equals("")
                || txtEPDLastname.getText().equals("")
                || txtEPDPhone.getText().equals("")
                || txtEPDNationalID.getText().equals("")
                || txtEPDAddress.getText().equals(""));
    }
    
    public void getComboBox(){
        
        cmbUser.addItem("");
        
        try {
           Statement st = DBconnection.getConnection().createStatement();
           ResultSet rs = st.executeQuery("SELECT * FROM  `user` ");
           
           while(rs.next())
           {
               String Email = rs.getString(2);
               int userID = rs.getInt(1);
               HashMapcmbUser.put(Email, userID);
               cmbUser.addItem(Email);
               
           }
        } catch (Exception e) {
           e.printStackTrace();
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

        jLayeredPane1 = new javax.swing.JLayeredPane();
        jSplitPane1 = new javax.swing.JSplitPane();
        Menu = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnOverview = new keeptoo.KButton();
        btnAppointment = new keeptoo.KButton();
        btnUser = new keeptoo.KButton();
        btnPatient = new keeptoo.KButton();
        btnExit = new keeptoo.KButton();
        btnMinimize = new keeptoo.KButton();
        kButton9 = new keeptoo.KButton();
        btnDoctor = new keeptoo.KButton();
        btnEditPD = new keeptoo.KButton();
        pnlCards = new javax.swing.JPanel();
        Overview = new javax.swing.JPanel();
        kGradientPanel1 = new keeptoo.KGradientPanel();
        jLabel9 = new javax.swing.JLabel();
        lblD = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        kGradientPanel2 = new keeptoo.KGradientPanel();
        jLabel4 = new javax.swing.JLabel();
        lblP = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        kGradientPanel3 = new keeptoo.KGradientPanel();
        jLabel5 = new javax.swing.JLabel();
        lblA = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Patient = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        txtEmail1 = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        txtPatientFirstname = new javax.swing.JTextField();
        kGradientPanel12 = new keeptoo.KGradientPanel();
        jLabel26 = new javax.swing.JLabel();
        txtPatientLastname = new javax.swing.JTextField();
        kGradientPanel13 = new keeptoo.KGradientPanel();
        jLabel27 = new javax.swing.JLabel();
        txtPatientPhone = new javax.swing.JTextField();
        kGradientPanel14 = new keeptoo.KGradientPanel();
        jLabel30 = new javax.swing.JLabel();
        kGradientPanel15 = new keeptoo.KGradientPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtPatientAddress = new javax.swing.JTextArea();
        jLabel31 = new javax.swing.JLabel();
        txtPatientNationalID = new javax.swing.JTextField();
        kGradientPanel16 = new keeptoo.KGradientPanel();
        btnPatientSearch = new keeptoo.KButton();
        btnPatientRegister = new keeptoo.KButton();
        User = new javax.swing.JPanel();
        kGradientPanel6 = new keeptoo.KGradientPanel();
        txtELastname = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        btnSave = new keeptoo.KButton();
        txtEmail = new javax.swing.JTextField();
        kGradientPanel4 = new keeptoo.KGradientPanel();
        kGradientPanel9 = new keeptoo.KGradientPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        kGradientPanel7 = new keeptoo.KGradientPanel();
        kGradientPanel5 = new keeptoo.KGradientPanel();
        btnSearch = new keeptoo.KButton();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        kGradientPanel8 = new keeptoo.KGradientPanel();
        txtLastname = new javax.swing.JTextField();
        txtEEmail = new javax.swing.JTextField();
        kGradientPanel10 = new keeptoo.KGradientPanel();
        jLabel20 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        btnRemove = new keeptoo.KButton();
        jLabel21 = new javax.swing.JLabel();
        txtEFirstname = new javax.swing.JTextField();
        btnUserRegister = new keeptoo.KButton();
        jLabel22 = new javax.swing.JLabel();
        txtFirstname = new javax.swing.JTextField();
        kGradientPanel11 = new keeptoo.KGradientPanel();
        jLabel23 = new javax.swing.JLabel();
        cmbUser = new javax.swing.JComboBox<>();
        Doctor = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        txtEmail2 = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        txtDoctorFirstname = new javax.swing.JTextField();
        kGradientPanel22 = new keeptoo.KGradientPanel();
        jLabel43 = new javax.swing.JLabel();
        txtDoctorLastname = new javax.swing.JTextField();
        kGradientPanel23 = new keeptoo.KGradientPanel();
        jLabel44 = new javax.swing.JLabel();
        txtDoctorPhone = new javax.swing.JTextField();
        kGradientPanel24 = new keeptoo.KGradientPanel();
        jLabel45 = new javax.swing.JLabel();
        kGradientPanel25 = new keeptoo.KGradientPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtDoctorAdresses = new javax.swing.JTextArea();
        jLabel46 = new javax.swing.JLabel();
        txtDoctorNationalID = new javax.swing.JTextField();
        kGradientPanel26 = new keeptoo.KGradientPanel();
        btnDoctorRegister = new keeptoo.KButton();
        EditPatient = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        txtEmail3 = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        txtEPDFirstname = new javax.swing.JTextField();
        kGradientPanel17 = new keeptoo.KGradientPanel();
        jLabel36 = new javax.swing.JLabel();
        txtEPDLastname = new javax.swing.JTextField();
        kGradientPanel18 = new keeptoo.KGradientPanel();
        jLabel37 = new javax.swing.JLabel();
        txtEPDPhone = new javax.swing.JTextField();
        kGradientPanel19 = new keeptoo.KGradientPanel();
        jLabel38 = new javax.swing.JLabel();
        kGradientPanel20 = new keeptoo.KGradientPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtEPDAddress = new javax.swing.JTextArea();
        jLabel47 = new javax.swing.JLabel();
        txtEPDNationalID = new javax.swing.JTextField();
        kGradientPanel21 = new keeptoo.KGradientPanel();
        btnEditRegister = new keeptoo.KButton();
        cmbCatagorie = new javax.swing.JComboBox<>();
        cmbList = new javax.swing.JComboBox<>();
        btnEditSelect = new keeptoo.KButton();
        btnEPDSearch = new keeptoo.KButton();
        btnEPDClear = new keeptoo.KButton();
        Appointment = new javax.swing.JPanel();
        jLabell = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        cmbAPatient = new javax.swing.JComboBox<>();
        jLabel51 = new javax.swing.JLabel();
        cmbADoctor = new javax.swing.JComboBox<>();
        jLabel52 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        btnAConfirm = new keeptoo.KButton();
        btnASearch = new keeptoo.KButton();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        cmbEAPatient = new javax.swing.JComboBox<>();
        jLabel56 = new javax.swing.JLabel();
        cmbEADoctor = new javax.swing.JComboBox<>();
        jLabel57 = new javax.swing.JLabel();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        btnAConfirm1 = new keeptoo.KButton();
        btnEASearch = new keeptoo.KButton();
        cmbAList = new javax.swing.JComboBox<>();

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setUndecorated(true);
        setResizable(false);

        jSplitPane1.setDividerSize(0);

        Menu.setBackground(new java.awt.Color(230, 212, 241));
        Menu.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                MenuMouseDragged(evt);
            }
        });
        Menu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MenuMousePressed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_dentist_64px_1.png"))); // NOI18N

        btnOverview.setText("Overview");
        btnOverview.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnOverview.setkAllowGradient(false);
        btnOverview.setkAllowTab(true);
        btnOverview.setkBackGroundColor(new java.awt.Color(230, 212, 241));
        btnOverview.setkBorderRadius(0);
        btnOverview.setkHoverColor(new java.awt.Color(192, 192, 192));
        btnOverview.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btnOverview.setkIndicatorColor(new java.awt.Color(192, 192, 192));
        btnOverview.setkSelectedColor(new java.awt.Color(192, 192, 192));
        btnOverview.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOverviewActionPerformed(evt);
            }
        });

        btnAppointment.setText("Appointment");
        btnAppointment.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnAppointment.setkAllowGradient(false);
        btnAppointment.setkAllowTab(true);
        btnAppointment.setkBackGroundColor(new java.awt.Color(230, 212, 241));
        btnAppointment.setkBorderRadius(0);
        btnAppointment.setkHoverColor(new java.awt.Color(192, 192, 192));
        btnAppointment.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btnAppointment.setkIndicatorColor(new java.awt.Color(192, 192, 192));
        btnAppointment.setkSelectedColor(new java.awt.Color(192, 192, 192));
        btnAppointment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAppointmentActionPerformed(evt);
            }
        });

        btnUser.setText("User");
        btnUser.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnUser.setkAllowGradient(false);
        btnUser.setkAllowTab(true);
        btnUser.setkBackGroundColor(new java.awt.Color(230, 212, 241));
        btnUser.setkBorderRadius(0);
        btnUser.setkHoverColor(new java.awt.Color(192, 192, 192));
        btnUser.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btnUser.setkIndicatorColor(new java.awt.Color(192, 192, 192));
        btnUser.setkSelectedColor(new java.awt.Color(192, 192, 192));
        btnUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUserMouseClicked(evt);
            }
        });
        btnUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUserActionPerformed(evt);
            }
        });

        btnPatient.setText("Patient");
        btnPatient.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnPatient.setkAllowGradient(false);
        btnPatient.setkAllowTab(true);
        btnPatient.setkBackGroundColor(new java.awt.Color(230, 212, 241));
        btnPatient.setkBorderRadius(0);
        btnPatient.setkHoverColor(new java.awt.Color(192, 192, 192));
        btnPatient.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btnPatient.setkIndicatorColor(new java.awt.Color(192, 192, 192));
        btnPatient.setkSelectedColor(new java.awt.Color(192, 192, 192));
        btnPatient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPatientActionPerformed(evt);
            }
        });

        btnExit.setText("X");
        btnExit.setkAllowGradient(false);
        btnExit.setkBackGroundColor(new java.awt.Color(255, 98, 89));
        btnExit.setkBorderRadius(360);
        btnExit.setkForeGround(new java.awt.Color(80, 0, 4));
        btnExit.setkHoverForeGround(new java.awt.Color(80, 0, 4));
        btnExit.setkPressedColor(new java.awt.Color(255, 98, 89));
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        btnMinimize.setText("-");
        btnMinimize.setkAllowGradient(false);
        btnMinimize.setkBackGroundColor(new java.awt.Color(255, 191, 49));
        btnMinimize.setkBorderRadius(360);
        btnMinimize.setkForeGround(new java.awt.Color(140, 77, 0));
        btnMinimize.setkHoverEndColor(new java.awt.Color(140, 77, 0));
        btnMinimize.setkPressedColor(new java.awt.Color(255, 191, 49));
        btnMinimize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMinimizeActionPerformed(evt);
            }
        });

        kButton9.setEnabled(false);
        kButton9.setkBackGroundColor(new java.awt.Color(0, 153, 153));
        kButton9.setkBorderRadius(360);
        kButton9.setkEndColor(new java.awt.Color(0, 153, 153));
        kButton9.setkForeGround(new java.awt.Color(0, 153, 153));
        kButton9.setkHoverColor(new java.awt.Color(0, 153, 153));
        kButton9.setkHoverEndColor(new java.awt.Color(0, 153, 153));
        kButton9.setkHoverForeGround(new java.awt.Color(0, 153, 153));
        kButton9.setkHoverStartColor(new java.awt.Color(0, 153, 153));
        kButton9.setkIndicatorColor(new java.awt.Color(0, 153, 153));
        kButton9.setkPressedColor(new java.awt.Color(0, 153, 153));
        kButton9.setkSelectedColor(new java.awt.Color(0, 153, 153));

        btnDoctor.setText("Doctor");
        btnDoctor.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnDoctor.setkAllowGradient(false);
        btnDoctor.setkAllowTab(true);
        btnDoctor.setkBackGroundColor(new java.awt.Color(230, 212, 241));
        btnDoctor.setkBorderRadius(0);
        btnDoctor.setkHoverColor(new java.awt.Color(192, 192, 192));
        btnDoctor.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btnDoctor.setkIndicatorColor(new java.awt.Color(192, 192, 192));
        btnDoctor.setkSelectedColor(new java.awt.Color(192, 192, 192));
        btnDoctor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoctorActionPerformed(evt);
            }
        });

        btnEditPD.setText("Edit Patient/Doctor");
        btnEditPD.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnEditPD.setkAllowGradient(false);
        btnEditPD.setkAllowTab(true);
        btnEditPD.setkBackGroundColor(new java.awt.Color(230, 212, 241));
        btnEditPD.setkBorderRadius(0);
        btnEditPD.setkHoverColor(new java.awt.Color(192, 192, 192));
        btnEditPD.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btnEditPD.setkIndicatorColor(new java.awt.Color(192, 192, 192));
        btnEditPD.setkSelectedColor(new java.awt.Color(192, 192, 192));
        btnEditPD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEditPDMouseClicked(evt);
            }
        });
        btnEditPD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditPDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout MenuLayout = new javax.swing.GroupLayout(Menu);
        Menu.setLayout(MenuLayout);
        MenuLayout.setHorizontalGroup(
            MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuLayout.createSequentialGroup()
                .addGroup(MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MenuLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnMinimize, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(kButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(MenuLayout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnOverview, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPatient, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAppointment, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUser, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditPD, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        MenuLayout.setVerticalGroup(
            MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMinimize, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(btnOverview, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnPatient, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAppointment, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(btnUser, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEditPD, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(126, Short.MAX_VALUE))
        );

        jSplitPane1.setLeftComponent(Menu);

        pnlCards.setLayout(new java.awt.CardLayout());

        Overview.setBackground(new java.awt.Color(255, 255, 255));

        kGradientPanel1.setkBorderRadius(30);
        kGradientPanel1.setkEndColor(new java.awt.Color(255, 204, 255));
        kGradientPanel1.setkStartColor(new java.awt.Color(255, 204, 255));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Doctor");

        lblD.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lblD.setForeground(new java.awt.Color(255, 255, 255));
        lblD.setText("0");

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("People");

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap(123, Short.MAX_VALUE)
                .addComponent(lblD)
                .addGap(115, 115, 115))
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel9))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(lblD)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel11)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        kGradientPanel2.setkBorderRadius(30);
        kGradientPanel2.setkEndColor(new java.awt.Color(255, 204, 255));
        kGradientPanel2.setkStartColor(new java.awt.Color(255, 204, 255));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Patient");

        lblP.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lblP.setForeground(new java.awt.Color(255, 255, 255));
        lblP.setText("0");

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("People");

        javax.swing.GroupLayout kGradientPanel2Layout = new javax.swing.GroupLayout(kGradientPanel2);
        kGradientPanel2.setLayout(kGradientPanel2Layout);
        kGradientPanel2Layout.setHorizontalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel2Layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(lblP))
                    .addGroup(kGradientPanel2Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel4))))
                .addContainerGap(134, Short.MAX_VALUE))
        );
        kGradientPanel2Layout.setVerticalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(lblP)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addContainerGap())
        );

        kGradientPanel3.setkBorderRadius(30);
        kGradientPanel3.setkEndColor(new java.awt.Color(255, 204, 255));
        kGradientPanel3.setkStartColor(new java.awt.Color(255, 204, 255));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Total Appointment");

        lblA.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lblA.setForeground(new java.awt.Color(255, 255, 255));
        lblA.setText("0");

        javax.swing.GroupLayout kGradientPanel3Layout = new javax.swing.GroupLayout(kGradientPanel3);
        kGradientPanel3.setLayout(kGradientPanel3Layout);
        kGradientPanel3Layout.setHorizontalGroup(
            kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel3Layout.createSequentialGroup()
                .addGroup(kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel3Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel5))
                    .addGroup(kGradientPanel3Layout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addComponent(lblA)))
                .addContainerGap(108, Short.MAX_VALUE))
        );
        kGradientPanel3Layout.setVerticalGroup(
            kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(lblA)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jLabel2.setText("G A N O K P O R N");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jLabel3.setText("D e n t i s t");

        javax.swing.GroupLayout OverviewLayout = new javax.swing.GroupLayout(Overview);
        Overview.setLayout(OverviewLayout);
        OverviewLayout.setHorizontalGroup(
            OverviewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(OverviewLayout.createSequentialGroup()
                .addGroup(OverviewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(OverviewLayout.createSequentialGroup()
                        .addGap(247, 247, 247)
                        .addComponent(jLabel2))
                    .addGroup(OverviewLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(kGradientPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(kGradientPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(kGradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(OverviewLayout.createSequentialGroup()
                        .addGap(321, 321, 321)
                        .addComponent(jLabel3)))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        OverviewLayout.setVerticalGroup(
            OverviewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(OverviewLayout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(jLabel2)
                .addGap(42, 42, 42)
                .addComponent(jLabel3)
                .addGap(110, 110, 110)
                .addGroup(OverviewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(kGradientPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kGradientPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kGradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(344, 344, 344))
        );

        pnlCards.add(Overview, "Overview");

        Patient.setBackground(new java.awt.Color(255, 255, 255));

        jLabel24.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jLabel24.setText("Patient");

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(153, 153, 153));
        jLabel28.setText("Sign Up for New Patient");

        jLabel29.setForeground(new java.awt.Color(153, 153, 153));
        jLabel29.setText("For a non-exiting Patient ");

        txtEmail1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtEmail1.setForeground(new java.awt.Color(153, 153, 153));
        txtEmail1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jLabel25.setForeground(new java.awt.Color(153, 153, 153));
        jLabel25.setText("firstname");

        txtPatientFirstname.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtPatientFirstname.setForeground(new java.awt.Color(153, 153, 153));
        txtPatientFirstname.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        javax.swing.GroupLayout kGradientPanel12Layout = new javax.swing.GroupLayout(kGradientPanel12);
        kGradientPanel12.setLayout(kGradientPanel12Layout);
        kGradientPanel12Layout.setHorizontalGroup(
            kGradientPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 295, Short.MAX_VALUE)
        );
        kGradientPanel12Layout.setVerticalGroup(
            kGradientPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );

        jLabel26.setForeground(new java.awt.Color(153, 153, 153));
        jLabel26.setText("lastname");

        txtPatientLastname.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtPatientLastname.setForeground(new java.awt.Color(153, 153, 153));
        txtPatientLastname.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        javax.swing.GroupLayout kGradientPanel13Layout = new javax.swing.GroupLayout(kGradientPanel13);
        kGradientPanel13.setLayout(kGradientPanel13Layout);
        kGradientPanel13Layout.setHorizontalGroup(
            kGradientPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 295, Short.MAX_VALUE)
        );
        kGradientPanel13Layout.setVerticalGroup(
            kGradientPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );

        jLabel27.setForeground(new java.awt.Color(153, 153, 153));
        jLabel27.setText("Phone no.");

        txtPatientPhone.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtPatientPhone.setForeground(new java.awt.Color(153, 153, 153));
        txtPatientPhone.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        javax.swing.GroupLayout kGradientPanel14Layout = new javax.swing.GroupLayout(kGradientPanel14);
        kGradientPanel14.setLayout(kGradientPanel14Layout);
        kGradientPanel14Layout.setHorizontalGroup(
            kGradientPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 295, Short.MAX_VALUE)
        );
        kGradientPanel14Layout.setVerticalGroup(
            kGradientPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );

        jLabel30.setForeground(new java.awt.Color(153, 153, 153));
        jLabel30.setText("Address");

        javax.swing.GroupLayout kGradientPanel15Layout = new javax.swing.GroupLayout(kGradientPanel15);
        kGradientPanel15.setLayout(kGradientPanel15Layout);
        kGradientPanel15Layout.setHorizontalGroup(
            kGradientPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 294, Short.MAX_VALUE)
        );
        kGradientPanel15Layout.setVerticalGroup(
            kGradientPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );

        txtPatientAddress.setColumns(20);
        txtPatientAddress.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        txtPatientAddress.setRows(5);
        jScrollPane1.setViewportView(txtPatientAddress);

        jLabel31.setForeground(new java.awt.Color(153, 153, 153));
        jLabel31.setText("National ID ");

        txtPatientNationalID.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtPatientNationalID.setForeground(new java.awt.Color(153, 153, 153));
        txtPatientNationalID.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        javax.swing.GroupLayout kGradientPanel16Layout = new javax.swing.GroupLayout(kGradientPanel16);
        kGradientPanel16.setLayout(kGradientPanel16Layout);
        kGradientPanel16Layout.setHorizontalGroup(
            kGradientPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 295, Short.MAX_VALUE)
        );
        kGradientPanel16Layout.setVerticalGroup(
            kGradientPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );

        btnPatientSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_add_user_male_64px.png"))); // NOI18N
        btnPatientSearch.setText("Search");
        btnPatientSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPatientSearchActionPerformed(evt);
            }
        });

        btnPatientRegister.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_add_user_male_64px.png"))); // NOI18N
        btnPatientRegister.setText("Register");
        btnPatientRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPatientRegisterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PatientLayout = new javax.swing.GroupLayout(Patient);
        Patient.setLayout(PatientLayout);
        PatientLayout.setHorizontalGroup(
            PatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PatientLayout.createSequentialGroup()
                .addGroup(PatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PatientLayout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addGroup(PatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel28)
                            .addComponent(jLabel29)
                            .addGroup(PatientLayout.createSequentialGroup()
                                .addGroup(PatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel25)
                                    .addComponent(txtPatientFirstname, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(kGradientPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel27)
                                    .addComponent(txtPatientPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(kGradientPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel30)
                                    .addGroup(PatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(kGradientPanel15, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 158, Short.MAX_VALUE)
                                .addGroup(PatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel26)
                                        .addComponent(txtPatientLastname, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(kGradientPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel31)
                                        .addComponent(kGradientPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtPatientNationalID, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(PatientLayout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(txtEmail1, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(131, 131, 131))
            .addGroup(PatientLayout.createSequentialGroup()
                .addGroup(PatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PatientLayout.createSequentialGroup()
                        .addGap(393, 393, 393)
                        .addComponent(jLabel24))
                    .addGroup(PatientLayout.createSequentialGroup()
                        .addGap(348, 348, 348)
                        .addComponent(btnPatientSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(PatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PatientLayout.createSequentialGroup()
                    .addContainerGap(559, Short.MAX_VALUE)
                    .addComponent(btnPatientRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(175, 175, 175)))
        );
        PatientLayout.setVerticalGroup(
            PatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PatientLayout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addComponent(jLabel24)
                .addGap(56, 56, 56)
                .addComponent(jLabel28)
                .addGap(7, 7, 7)
                .addComponent(jLabel29)
                .addGap(31, 31, 31)
                .addGroup(PatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PatientLayout.createSequentialGroup()
                        .addComponent(jLabel25)
                        .addGap(18, 18, 18)
                        .addComponent(txtPatientFirstname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(kGradientPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PatientLayout.createSequentialGroup()
                        .addComponent(jLabel26)
                        .addGap(18, 18, 18)
                        .addComponent(txtPatientLastname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(kGradientPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(PatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PatientLayout.createSequentialGroup()
                        .addComponent(jLabel27)
                        .addGap(18, 18, 18)
                        .addComponent(txtPatientPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(kGradientPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PatientLayout.createSequentialGroup()
                        .addComponent(jLabel31)
                        .addGap(18, 18, 18)
                        .addComponent(txtPatientNationalID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(kGradientPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26)
                .addComponent(jLabel30)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(kGradientPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(txtEmail1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(btnPatientSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(76, Short.MAX_VALUE))
            .addGroup(PatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PatientLayout.createSequentialGroup()
                    .addContainerGap(479, Short.MAX_VALUE)
                    .addComponent(btnPatientRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(257, 257, 257)))
        );

        pnlCards.add(Patient, "Patient");

        User.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout kGradientPanel6Layout = new javax.swing.GroupLayout(kGradientPanel6);
        kGradientPanel6.setLayout(kGradientPanel6Layout);
        kGradientPanel6Layout.setHorizontalGroup(
            kGradientPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 295, Short.MAX_VALUE)
        );
        kGradientPanel6Layout.setVerticalGroup(
            kGradientPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );

        txtELastname.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtELastname.setForeground(new java.awt.Color(153, 153, 153));
        txtELastname.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jLabel12.setForeground(new java.awt.Color(153, 153, 153));
        jLabel12.setText("password");

        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_save_32px_1.png"))); // NOI18N
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        txtEmail.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtEmail.setForeground(new java.awt.Color(153, 153, 153));
        txtEmail.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        kGradientPanel4.setkEndColor(new java.awt.Color(153, 153, 153));
        kGradientPanel4.setkStartColor(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout kGradientPanel4Layout = new javax.swing.GroupLayout(kGradientPanel4);
        kGradientPanel4.setLayout(kGradientPanel4Layout);
        kGradientPanel4Layout.setHorizontalGroup(
            kGradientPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        kGradientPanel4Layout.setVerticalGroup(
            kGradientPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 559, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout kGradientPanel9Layout = new javax.swing.GroupLayout(kGradientPanel9);
        kGradientPanel9.setLayout(kGradientPanel9Layout);
        kGradientPanel9Layout.setHorizontalGroup(
            kGradientPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 295, Short.MAX_VALUE)
        );
        kGradientPanel9Layout.setVerticalGroup(
            kGradientPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );

        jLabel13.setForeground(new java.awt.Color(153, 153, 153));
        jLabel13.setText("lastname");

        jLabel14.setForeground(new java.awt.Color(153, 153, 153));
        jLabel14.setText("For a non-exiting user ");

        jLabel15.setForeground(new java.awt.Color(153, 153, 153));
        jLabel15.setText("lastname");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(153, 153, 153));
        jLabel16.setText("Sign Up");

        jLabel17.setForeground(new java.awt.Color(153, 153, 153));
        jLabel17.setText("firstname");

        javax.swing.GroupLayout kGradientPanel7Layout = new javax.swing.GroupLayout(kGradientPanel7);
        kGradientPanel7.setLayout(kGradientPanel7Layout);
        kGradientPanel7Layout.setHorizontalGroup(
            kGradientPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 295, Short.MAX_VALUE)
        );
        kGradientPanel7Layout.setVerticalGroup(
            kGradientPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout kGradientPanel5Layout = new javax.swing.GroupLayout(kGradientPanel5);
        kGradientPanel5.setLayout(kGradientPanel5Layout);
        kGradientPanel5Layout.setHorizontalGroup(
            kGradientPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 294, Short.MAX_VALUE)
        );
        kGradientPanel5Layout.setVerticalGroup(
            kGradientPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(153, 153, 153));
        jLabel18.setText("Edit/Remove exiting User");

        jLabel19.setForeground(new java.awt.Color(153, 153, 153));
        jLabel19.setText("For a exiting user ");

        javax.swing.GroupLayout kGradientPanel8Layout = new javax.swing.GroupLayout(kGradientPanel8);
        kGradientPanel8.setLayout(kGradientPanel8Layout);
        kGradientPanel8Layout.setHorizontalGroup(
            kGradientPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 295, Short.MAX_VALUE)
        );
        kGradientPanel8Layout.setVerticalGroup(
            kGradientPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );

        txtLastname.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtLastname.setForeground(new java.awt.Color(153, 153, 153));
        txtLastname.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        txtEEmail.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtEEmail.setForeground(new java.awt.Color(153, 153, 153));
        txtEEmail.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        javax.swing.GroupLayout kGradientPanel10Layout = new javax.swing.GroupLayout(kGradientPanel10);
        kGradientPanel10.setLayout(kGradientPanel10Layout);
        kGradientPanel10Layout.setHorizontalGroup(
            kGradientPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 295, Short.MAX_VALUE)
        );
        kGradientPanel10Layout.setVerticalGroup(
            kGradientPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );

        jLabel20.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(153, 153, 153));
        jLabel20.setText("User");

        txtPassword.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtPassword.setForeground(new java.awt.Color(153, 153, 153));
        txtPassword.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        btnRemove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_delete_trash_32px.png"))); // NOI18N
        btnRemove.setText("Remove");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        jLabel21.setForeground(new java.awt.Color(153, 153, 153));
        jLabel21.setText("email");

        txtEFirstname.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtEFirstname.setForeground(new java.awt.Color(153, 153, 153));
        txtEFirstname.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        btnUserRegister.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_add_user_male_64px.png"))); // NOI18N
        btnUserRegister.setText("Register");
        btnUserRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUserRegisterActionPerformed(evt);
            }
        });

        jLabel22.setForeground(new java.awt.Color(153, 153, 153));
        jLabel22.setText("firstname");

        txtFirstname.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtFirstname.setForeground(new java.awt.Color(153, 153, 153));
        txtFirstname.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        javax.swing.GroupLayout kGradientPanel11Layout = new javax.swing.GroupLayout(kGradientPanel11);
        kGradientPanel11.setLayout(kGradientPanel11Layout);
        kGradientPanel11Layout.setHorizontalGroup(
            kGradientPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 295, Short.MAX_VALUE)
        );
        kGradientPanel11Layout.setVerticalGroup(
            kGradientPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );

        jLabel23.setForeground(new java.awt.Color(153, 153, 153));
        jLabel23.setText("email");

        cmbUser.setAutoscrolls(true);
        cmbUser.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        cmbUser.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout UserLayout = new javax.swing.GroupLayout(User);
        User.setLayout(UserLayout);
        UserLayout.setHorizontalGroup(
            UserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UserLayout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(UserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addComponent(jLabel14)
                    .addComponent(jLabel22)
                    .addComponent(txtFirstname, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(txtLastname, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kGradientPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(kGradientPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(UserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(kGradientPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(UserLayout.createSequentialGroup()
                            .addComponent(btnUserRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(19, 19, 19)))
                    .addComponent(kGradientPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addComponent(kGradientPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addGroup(UserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(UserLayout.createSequentialGroup()
                        .addComponent(cmbUser, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(63, 63, 63))
                    .addGroup(UserLayout.createSequentialGroup()
                        .addGroup(UserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(UserLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel18)
                            .addComponent(jLabel19)
                            .addComponent(jLabel17)
                            .addComponent(txtEFirstname, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13)
                            .addComponent(txtELastname, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel23)
                            .addComponent(txtEEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(kGradientPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(kGradientPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(kGradientPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(184, 184, 184))))
            .addGroup(UserLayout.createSequentialGroup()
                .addGap(395, 395, 395)
                .addComponent(jLabel20)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        UserLayout.setVerticalGroup(
            UserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UserLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jLabel20)
                .addGap(71, 71, 71)
                .addGroup(UserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(UserLayout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addGap(7, 7, 7)
                        .addComponent(jLabel14)
                        .addGap(45, 45, 45)
                        .addComponent(jLabel22)
                        .addGap(18, 18, 18)
                        .addComponent(txtFirstname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(kGradientPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel15)
                        .addGap(18, 18, 18)
                        .addComponent(txtLastname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(kGradientPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel21)
                        .addGap(18, 18, 18)
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(kGradientPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel12)
                        .addGap(8, 8, 8)
                        .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addComponent(kGradientPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53)
                        .addComponent(btnUserRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(UserLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(UserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(kGradientPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(UserLayout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addGap(8, 8, 8)
                                .addComponent(jLabel19)
                                .addGap(32, 32, 32)
                                .addGroup(UserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cmbUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(59, 59, 59)
                                .addComponent(jLabel17)
                                .addGap(18, 18, 18)
                                .addComponent(txtEFirstname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(kGradientPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel13)
                                .addGap(18, 18, 18)
                                .addComponent(txtELastname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(kGradientPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel23)
                                .addGap(18, 18, 18)
                                .addComponent(txtEEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(kGradientPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 139, Short.MAX_VALUE)
                                .addGroup(UserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(25, 25, 25))
        );

        pnlCards.add(User, "User");

        Doctor.setBackground(new java.awt.Color(255, 255, 255));

        jLabel39.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jLabel39.setText("Doctor");

        jLabel40.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(153, 153, 153));
        jLabel40.setText("Sign Up for New Doctor");

        jLabel41.setForeground(new java.awt.Color(153, 153, 153));
        jLabel41.setText("For a non-exiting Doctor");

        txtEmail2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtEmail2.setForeground(new java.awt.Color(153, 153, 153));
        txtEmail2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jLabel42.setForeground(new java.awt.Color(153, 153, 153));
        jLabel42.setText("firstname");

        txtDoctorFirstname.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtDoctorFirstname.setForeground(new java.awt.Color(153, 153, 153));
        txtDoctorFirstname.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        javax.swing.GroupLayout kGradientPanel22Layout = new javax.swing.GroupLayout(kGradientPanel22);
        kGradientPanel22.setLayout(kGradientPanel22Layout);
        kGradientPanel22Layout.setHorizontalGroup(
            kGradientPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 295, Short.MAX_VALUE)
        );
        kGradientPanel22Layout.setVerticalGroup(
            kGradientPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );

        jLabel43.setForeground(new java.awt.Color(153, 153, 153));
        jLabel43.setText("lastname");

        txtDoctorLastname.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtDoctorLastname.setForeground(new java.awt.Color(153, 153, 153));
        txtDoctorLastname.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        javax.swing.GroupLayout kGradientPanel23Layout = new javax.swing.GroupLayout(kGradientPanel23);
        kGradientPanel23.setLayout(kGradientPanel23Layout);
        kGradientPanel23Layout.setHorizontalGroup(
            kGradientPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 295, Short.MAX_VALUE)
        );
        kGradientPanel23Layout.setVerticalGroup(
            kGradientPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );

        jLabel44.setForeground(new java.awt.Color(153, 153, 153));
        jLabel44.setText("Phone no.");

        txtDoctorPhone.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtDoctorPhone.setForeground(new java.awt.Color(153, 153, 153));
        txtDoctorPhone.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        javax.swing.GroupLayout kGradientPanel24Layout = new javax.swing.GroupLayout(kGradientPanel24);
        kGradientPanel24.setLayout(kGradientPanel24Layout);
        kGradientPanel24Layout.setHorizontalGroup(
            kGradientPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 295, Short.MAX_VALUE)
        );
        kGradientPanel24Layout.setVerticalGroup(
            kGradientPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );

        jLabel45.setForeground(new java.awt.Color(153, 153, 153));
        jLabel45.setText("Adresses");

        javax.swing.GroupLayout kGradientPanel25Layout = new javax.swing.GroupLayout(kGradientPanel25);
        kGradientPanel25.setLayout(kGradientPanel25Layout);
        kGradientPanel25Layout.setHorizontalGroup(
            kGradientPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 294, Short.MAX_VALUE)
        );
        kGradientPanel25Layout.setVerticalGroup(
            kGradientPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );

        txtDoctorAdresses.setColumns(20);
        txtDoctorAdresses.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        txtDoctorAdresses.setRows(5);
        jScrollPane3.setViewportView(txtDoctorAdresses);

        jLabel46.setForeground(new java.awt.Color(153, 153, 153));
        jLabel46.setText("National ID ");

        txtDoctorNationalID.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtDoctorNationalID.setForeground(new java.awt.Color(153, 153, 153));
        txtDoctorNationalID.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        javax.swing.GroupLayout kGradientPanel26Layout = new javax.swing.GroupLayout(kGradientPanel26);
        kGradientPanel26.setLayout(kGradientPanel26Layout);
        kGradientPanel26Layout.setHorizontalGroup(
            kGradientPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 295, Short.MAX_VALUE)
        );
        kGradientPanel26Layout.setVerticalGroup(
            kGradientPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );

        btnDoctorRegister.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_add_user_male_64px.png"))); // NOI18N
        btnDoctorRegister.setText("Register");
        btnDoctorRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoctorRegisterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout DoctorLayout = new javax.swing.GroupLayout(Doctor);
        Doctor.setLayout(DoctorLayout);
        DoctorLayout.setHorizontalGroup(
            DoctorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DoctorLayout.createSequentialGroup()
                .addGroup(DoctorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DoctorLayout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addGroup(DoctorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel40)
                            .addComponent(jLabel41)
                            .addGroup(DoctorLayout.createSequentialGroup()
                                .addGroup(DoctorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel42)
                                    .addComponent(txtDoctorFirstname, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(kGradientPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel44)
                                    .addComponent(txtDoctorPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(kGradientPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel45)
                                    .addGroup(DoctorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(kGradientPanel25, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 158, Short.MAX_VALUE)
                                .addGroup(DoctorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DoctorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel43)
                                        .addComponent(txtDoctorLastname, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(kGradientPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel46)
                                        .addComponent(kGradientPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnDoctorRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtDoctorNationalID, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(DoctorLayout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(txtEmail2, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(131, 131, 131))
            .addGroup(DoctorLayout.createSequentialGroup()
                .addGap(391, 391, 391)
                .addComponent(jLabel39)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        DoctorLayout.setVerticalGroup(
            DoctorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DoctorLayout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addComponent(jLabel39)
                .addGap(58, 58, 58)
                .addComponent(jLabel40)
                .addGap(7, 7, 7)
                .addComponent(jLabel41)
                .addGap(31, 31, 31)
                .addGroup(DoctorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(DoctorLayout.createSequentialGroup()
                        .addGroup(DoctorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(DoctorLayout.createSequentialGroup()
                                .addComponent(jLabel42)
                                .addGap(18, 18, 18)
                                .addComponent(txtDoctorFirstname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(kGradientPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(DoctorLayout.createSequentialGroup()
                                .addComponent(jLabel43)
                                .addGap(18, 18, 18)
                                .addComponent(txtDoctorLastname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(kGradientPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(DoctorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(DoctorLayout.createSequentialGroup()
                                .addComponent(jLabel44)
                                .addGap(18, 18, 18)
                                .addComponent(txtDoctorPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(kGradientPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(DoctorLayout.createSequentialGroup()
                                .addComponent(jLabel46)
                                .addGap(18, 18, 18)
                                .addComponent(txtDoctorNationalID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(kGradientPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(26, 26, 26)
                        .addComponent(jLabel45)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(kGradientPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnDoctorRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addComponent(txtEmail2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(213, Short.MAX_VALUE))
        );

        pnlCards.add(Doctor, "Doctor");

        EditPatient.setBackground(new java.awt.Color(255, 255, 255));

        jLabel32.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jLabel32.setText("Edit");

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(153, 153, 153));
        jLabel33.setText("Sign Up for New Patient");

        jLabel34.setForeground(new java.awt.Color(153, 153, 153));
        jLabel34.setText("For a non-exiting Patient ");

        txtEmail3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtEmail3.setForeground(new java.awt.Color(153, 153, 153));
        txtEmail3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jLabel35.setForeground(new java.awt.Color(153, 153, 153));
        jLabel35.setText("firstname");

        txtEPDFirstname.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtEPDFirstname.setForeground(new java.awt.Color(153, 153, 153));
        txtEPDFirstname.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        javax.swing.GroupLayout kGradientPanel17Layout = new javax.swing.GroupLayout(kGradientPanel17);
        kGradientPanel17.setLayout(kGradientPanel17Layout);
        kGradientPanel17Layout.setHorizontalGroup(
            kGradientPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 295, Short.MAX_VALUE)
        );
        kGradientPanel17Layout.setVerticalGroup(
            kGradientPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );

        jLabel36.setForeground(new java.awt.Color(153, 153, 153));
        jLabel36.setText("lastname");

        txtEPDLastname.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtEPDLastname.setForeground(new java.awt.Color(153, 153, 153));
        txtEPDLastname.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        javax.swing.GroupLayout kGradientPanel18Layout = new javax.swing.GroupLayout(kGradientPanel18);
        kGradientPanel18.setLayout(kGradientPanel18Layout);
        kGradientPanel18Layout.setHorizontalGroup(
            kGradientPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 295, Short.MAX_VALUE)
        );
        kGradientPanel18Layout.setVerticalGroup(
            kGradientPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );

        jLabel37.setForeground(new java.awt.Color(153, 153, 153));
        jLabel37.setText("Phone no.");

        txtEPDPhone.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtEPDPhone.setForeground(new java.awt.Color(153, 153, 153));
        txtEPDPhone.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        javax.swing.GroupLayout kGradientPanel19Layout = new javax.swing.GroupLayout(kGradientPanel19);
        kGradientPanel19.setLayout(kGradientPanel19Layout);
        kGradientPanel19Layout.setHorizontalGroup(
            kGradientPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 295, Short.MAX_VALUE)
        );
        kGradientPanel19Layout.setVerticalGroup(
            kGradientPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );

        jLabel38.setForeground(new java.awt.Color(153, 153, 153));
        jLabel38.setText("Adresses");

        javax.swing.GroupLayout kGradientPanel20Layout = new javax.swing.GroupLayout(kGradientPanel20);
        kGradientPanel20.setLayout(kGradientPanel20Layout);
        kGradientPanel20Layout.setHorizontalGroup(
            kGradientPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 294, Short.MAX_VALUE)
        );
        kGradientPanel20Layout.setVerticalGroup(
            kGradientPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );

        txtEPDAddress.setColumns(20);
        txtEPDAddress.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        txtEPDAddress.setRows(5);
        jScrollPane2.setViewportView(txtEPDAddress);

        jLabel47.setForeground(new java.awt.Color(153, 153, 153));
        jLabel47.setText("National ID ");

        txtEPDNationalID.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtEPDNationalID.setForeground(new java.awt.Color(153, 153, 153));
        txtEPDNationalID.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        javax.swing.GroupLayout kGradientPanel21Layout = new javax.swing.GroupLayout(kGradientPanel21);
        kGradientPanel21.setLayout(kGradientPanel21Layout);
        kGradientPanel21Layout.setHorizontalGroup(
            kGradientPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 295, Short.MAX_VALUE)
        );
        kGradientPanel21Layout.setVerticalGroup(
            kGradientPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );

        btnEditRegister.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_add_user_male_64px.png"))); // NOI18N
        btnEditRegister.setText("Edit");
        btnEditRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditRegisterActionPerformed(evt);
            }
        });

        cmbCatagorie.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "patient", "doctor" }));

        btnEditSelect.setText("Confirm");
        btnEditSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditSelectActionPerformed(evt);
            }
        });

        btnEPDSearch.setText("Search");
        btnEPDSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEPDSearchActionPerformed(evt);
            }
        });

        btnEPDClear.setText("Clear");
        btnEPDClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEPDClearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout EditPatientLayout = new javax.swing.GroupLayout(EditPatient);
        EditPatient.setLayout(EditPatientLayout);
        EditPatientLayout.setHorizontalGroup(
            EditPatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EditPatientLayout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addGroup(EditPatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(EditPatientLayout.createSequentialGroup()
                        .addGroup(EditPatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(EditPatientLayout.createSequentialGroup()
                                .addGap(287, 287, 287)
                                .addComponent(jLabel32))
                            .addGroup(EditPatientLayout.createSequentialGroup()
                                .addComponent(cmbCatagorie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(btnEditSelect, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(EditPatientLayout.createSequentialGroup()
                                .addComponent(jLabel33)
                                .addGap(43, 43, 43)
                                .addComponent(btnEPDClear, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel34)
                            .addComponent(txtEmail3, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(EditPatientLayout.createSequentialGroup()
                                .addComponent(cmbList, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(btnEPDSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(471, Short.MAX_VALUE))
                    .addGroup(EditPatientLayout.createSequentialGroup()
                        .addGroup(EditPatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel35)
                            .addComponent(txtEPDFirstname, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(kGradientPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel37)
                            .addComponent(txtEPDPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(kGradientPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel38)
                            .addGroup(EditPatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(kGradientPanel20, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(EditPatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EditPatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel36)
                                .addComponent(txtEPDLastname, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(kGradientPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel47)
                                .addComponent(kGradientPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnEditRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtEPDNationalID, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(146, 146, 146))))
        );
        EditPatientLayout.setVerticalGroup(
            EditPatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EditPatientLayout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addComponent(jLabel32)
                .addGap(21, 21, 21)
                .addGroup(EditPatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbCatagorie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditSelect, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(41, 41, 41)
                .addGroup(EditPatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEPDSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(99, 99, 99)
                .addGroup(EditPatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(btnEPDClear, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(5, 5, 5)
                .addComponent(jLabel34)
                .addGap(31, 31, 31)
                .addGroup(EditPatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(EditPatientLayout.createSequentialGroup()
                        .addComponent(jLabel35)
                        .addGap(18, 18, 18)
                        .addComponent(txtEPDFirstname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(kGradientPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel37)
                        .addGap(18, 18, 18)
                        .addComponent(txtEPDPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(kGradientPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel38)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(kGradientPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(EditPatientLayout.createSequentialGroup()
                        .addComponent(jLabel36)
                        .addGap(18, 18, 18)
                        .addComponent(txtEPDLastname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(kGradientPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel47)
                        .addGap(18, 18, 18)
                        .addComponent(txtEPDNationalID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(kGradientPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(135, 135, 135))
                    .addComponent(btnEditRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEmail3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(99, Short.MAX_VALUE))
        );

        pnlCards.add(EditPatient, "EditPD");

        Appointment.setBackground(new java.awt.Color(255, 255, 255));

        jLabell.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jLabell.setText("Appointment");

        jLabel48.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(153, 153, 153));
        jLabel48.setText("New Appointment");

        jLabel49.setForeground(new java.awt.Color(153, 153, 153));
        jLabel49.setText("For a non-exiting appointment ");

        jLabel50.setForeground(new java.awt.Color(153, 153, 153));
        jLabel50.setText("Patient");

        jLabel51.setForeground(new java.awt.Color(153, 153, 153));
        jLabel51.setText("Doctor");

        jLabel52.setForeground(new java.awt.Color(153, 153, 153));
        jLabel52.setText("Date");

        btnAConfirm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_add_user_male_64px.png"))); // NOI18N
        btnAConfirm.setText("Confirm");
        btnAConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAConfirmActionPerformed(evt);
            }
        });

        btnASearch.setText("Search");
        btnASearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnASearchActionPerformed(evt);
            }
        });

        jLabel53.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(153, 153, 153));
        jLabel53.setText("Exiting Appointment");

        jLabel54.setForeground(new java.awt.Color(153, 153, 153));
        jLabel54.setText("For a exiting appointment ");

        jLabel55.setForeground(new java.awt.Color(153, 153, 153));
        jLabel55.setText("Patient");

        jLabel56.setForeground(new java.awt.Color(153, 153, 153));
        jLabel56.setText("Doctor");

        jLabel57.setForeground(new java.awt.Color(153, 153, 153));
        jLabel57.setText("Date");

        btnAConfirm1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_add_user_male_64px.png"))); // NOI18N
        btnAConfirm1.setText("Confirm");
        btnAConfirm1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAConfirm1ActionPerformed(evt);
            }
        });

        btnEASearch.setText("Search");
        btnEASearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEASearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout AppointmentLayout = new javax.swing.GroupLayout(Appointment);
        Appointment.setLayout(AppointmentLayout);
        AppointmentLayout.setHorizontalGroup(
            AppointmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AppointmentLayout.createSequentialGroup()
                .addContainerGap(348, Short.MAX_VALUE)
                .addComponent(jLabell)
                .addGap(345, 345, 345))
            .addGroup(AppointmentLayout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addGroup(AppointmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AppointmentLayout.createSequentialGroup()
                        .addComponent(btnAConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(btnASearch, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(AppointmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel52)
                        .addComponent(cmbADoctor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel51)
                        .addComponent(jLabel50)
                        .addComponent(jLabel48)
                        .addComponent(jLabel49, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cmbAPatient, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(AppointmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAConfirm1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(AppointmentLayout.createSequentialGroup()
                        .addGroup(AppointmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(cmbAList, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel57, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbEADoctor, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel56, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel55, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel53, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel54, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbEAPatient, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jDateChooser2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addComponent(btnEASearch, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(42, 42, 42))
        );
        AppointmentLayout.setVerticalGroup(
            AppointmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AppointmentLayout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(jLabell)
                .addGroup(AppointmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AppointmentLayout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addComponent(jLabel48)
                        .addGap(7, 7, 7)
                        .addComponent(jLabel49)
                        .addGap(27, 27, 27)
                        .addGroup(AppointmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel50)
                            .addComponent(btnEASearch, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbAList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(AppointmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbAPatient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnASearch, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel51)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbADoctor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel52)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(btnAConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AppointmentLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 111, Short.MAX_VALUE)
                        .addComponent(jLabel53)
                        .addGap(7, 7, 7)
                        .addComponent(jLabel54)
                        .addGap(100, 100, 100)
                        .addComponent(jLabel55)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbEAPatient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel56)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbEADoctor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel57)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(btnAConfirm1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(117, 117, 117))))
        );

        pnlCards.add(Appointment, "Appointment");

        jSplitPane1.setRightComponent(pnlCards);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MenuMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuMousePressed
        // TODO add your handling code here:
        new Drag(Menu).onPress(evt);
    }//GEN-LAST:event_MenuMousePressed

    private void MenuMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuMouseDragged
        // TODO add your handling code here:
        new Drag(Menu).moveWindow(evt);
    }//GEN-LAST:event_MenuMouseDragged

    private void btnMinimizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMinimizeActionPerformed
        // TODO add your handling code here:
        setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_btnMinimizeActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUserActionPerformed
        // TODO add your handling code here:
        cardLayout.show(pnlCards, "User");
    }//GEN-LAST:event_btnUserActionPerformed

    private void btnUserRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUserRegisterActionPerformed
        // TODO add your handling code here:
        String Firstname = txtFirstname.getText();
        String Lastname = txtLastname.getText();
        String Email = txtEmail.getText();
        String Password = String.valueOf(txtPassword.getPassword());
        
        
        //Check Method: checkRegistertext()
        
        //boolean i = checkRegistertext();
        //System.out.println(i);

        if(checkRegistertext() == true){
            

            try{

                PreparedStatement ps = DBconnection.con.prepareStatement("INSERT INTO `user` (`Email`, `Password`, `Name`, `Lastname`) VALUES (?,?,?,?)");

                ps.setString(1,Firstname);
                ps.setString(2,Lastname);
                ps.setString(3,Email);
                ps.setString(4,Password);

                int ii= ps.executeUpdate();
                System.out.println(ii + " records affected"); // LOG
                JOptionPane.showMessageDialog(null, "Your registeration has been added. Please DO NOT share username and password with anyone", "Registration Complete", 2);

            }catch(Exception e) {
                e.printStackTrace();
            }

        }
        else{
            
            JOptionPane.showMessageDialog(null, "Please fill the Registeration form", "Message", 2);

         }
    }//GEN-LAST:event_btnUserRegisterActionPerformed

    private void btnUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUserMouseClicked
        // TODO add your handling code here:
        

    }//GEN-LAST:event_btnUserMouseClicked

    private void btnOverviewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOverviewActionPerformed
        // TODO add your handling code here:
        cardLayout.show(pnlCards, "Overview");
    }//GEN-LAST:event_btnOverviewActionPerformed

    private void btnAppointmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAppointmentActionPerformed
        // TODO add your handling code here:
        cardLayout.show(pnlCards, "Appointment");
    }//GEN-LAST:event_btnAppointmentActionPerformed

    private void btnDoctorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoctorActionPerformed
        // TODO add your handling code here:
        cardLayout.show(pnlCards, "Doctor");
    }//GEN-LAST:event_btnDoctorActionPerformed

    private void btnPatientSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPatientSearchActionPerformed
        // TODO add your handling code here:
        PatientSearch ps = new PatientSearch();
        ps.setVisible(true);
    }//GEN-LAST:event_btnPatientSearchActionPerformed

    private void btnDoctorRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoctorRegisterActionPerformed
        // TODO add your handling code here:
        String Firstname = txtDoctorFirstname.getText();
        String Lastname = txtDoctorLastname.getText();
        String Phone = txtDoctorPhone.getText();
        String Address  = txtDoctorAdresses.getText();
        int NationalID = Integer.parseInt(txtDoctorNationalID.getText());
        
        if(checkDoctorRegistertext() == true){
            

            try{

                PreparedStatement ps = DBconnection.con.prepareStatement("INSERT INTO `doctor` (`National_ID`, `Firstname`, `Lastname`, `Phonenumber`, `Address`) VALUES (?,?,?,?,?)");
                
                ps.setInt(1, NationalID);
                ps.setString(2,Firstname);
                ps.setString(3,Lastname);
                ps.setString(4,Phone);
                ps.setString(5,Address);
                
                int ii= ps.executeUpdate();
                System.out.println(ii + " Doctor records affected"); // LOG
                JOptionPane.showMessageDialog(null, "Your doctor registeration has been added. ", "Registration Completed (Doctor)", 2);
                
                txtDoctorFirstname.setText("");
                txtDoctorLastname.setText("");
                txtDoctorPhone.setText("");
                txtDoctorAdresses.setText("");
                txtDoctorNationalID.setText("");

            }catch(HeadlessException | SQLException e) {
                e.printStackTrace();
            }

        }
    }//GEN-LAST:event_btnDoctorRegisterActionPerformed

    private void btnEditRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditRegisterActionPerformed
        // TODO add your handling code here:
        
        String selection2 = (String) cmbList.getSelectedItem();
        String selection1 = (String) cmbCatagorie.getSelectedItem();
        int ID = HashMapcmbEPD.get(selection2);
        String StringID = String.valueOf(ID);
        
        if(checkEPDtext() == true){
            
            try {
                
                PreparedStatement ps = DBconnection.con.prepareStatement("UPDATE `"+ selection1 +"` SET `National_ID` =?, `Firstname` =?, `Lastname` =?, `Phonenumber` =?, `Address` =?  WHERE `"+selection1+"`.`National_ID` = " + StringID);

                /*
                txtEPDFirstname.getText().equals("")
                || txtEPDLastname.getText().equals("")
                || txtEPDPhone.getText().equals("")
                || txtEPDNationalID.getText().equals("")
                || txtEPDAddress.getText().equals(""));
                */
                
                ps.setInt(1 , Integer. valueOf(txtEPDNationalID.getText()));
                ps.setString(2 ,txtEPDFirstname.getText());
                ps.setString(3 ,txtEPDLastname.getText());
                ps.setString(4 ,txtEPDPhone.getText());
                ps.setString(5 ,txtEPDAddress.getText());
                
                ps.executeUpdate();
            
                JOptionPane.showMessageDialog(null, selection2 + " information update completed. ", "Message", 2);
                
                txtEPDFirstname.setText("");
                txtEPDLastname.setText("");
                txtEPDPhone.setText("");
                txtEPDNationalID.setText("");
                txtEPDAddress.setText("");
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Please fill the form", "Message", 2);
        }
        
    }//GEN-LAST:event_btnEditRegisterActionPerformed

    private void btnPatientRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPatientRegisterActionPerformed
        // TODO add your handling code here:
        
        try{
            if(checkPatientRegistertext() == true){
            String Firstname = txtPatientFirstname.getText();
            String Lastname = txtPatientLastname.getText();
            String Phone = txtPatientPhone.getText();
            String Address  = txtPatientAddress.getText();
            int NationalID = Integer.parseInt(txtPatientNationalID.getText());
            

            try{
                
                PreparedStatement ps = DBconnection.con.prepareStatement("INSERT INTO `patient` (`National_ID`, `Firstname`, `Lastname`, `Phonenumber`, `Address`) VALUES (?,?,?,?,?)");
                
                ps.setInt(1, NationalID);
                ps.setString(2,Firstname);
                ps.setString(3,Lastname);
                ps.setString(4,Phone);
                ps.setString(5,Address);
                

                int ii= ps.executeUpdate();
                System.out.println(ii + " records affected"); // LOG
                JOptionPane.showMessageDialog(null, "Your registeration has been added. ", "Registration Completed (Patient)", 2);

            }catch(HeadlessException | SQLException e) {
                e.printStackTrace();
            }

        }
        else{
            JOptionPane.showMessageDialog(null, "Please fill the Registeration form", "Message", 2);
        }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Please only fill a number in NationalD", "Message", 2);
        }
    }//GEN-LAST:event_btnPatientRegisterActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        String Slecteditem = (String) cmbUser.getSelectedItem();
        int ID = HashMapcmbUser.get(Slecteditem);
        
        try {
           Statement st = DBconnection.getConnection().createStatement();
           ResultSet rs = st.executeQuery("SELECT * FROM `user` WHERE `ID` = " + ID);
           
           while(rs.next())
           {
               txtEFirstname.setText(rs.getString(4));
               txtELastname.setText(rs.getString(5));
               txtEEmail.setText(rs.getString(2));
            }
        } catch (Exception e) {
           e.printStackTrace();
        }
        
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        // TODO add your handling code here:
        String Slecteditem = (String) cmbUser.getSelectedItem();
        int ID = HashMapcmbUser.get(Slecteditem);
        
        try {
            
            Statement st = DBconnection.getConnection().createStatement();
            int i = st.executeUpdate("DELETE FROM `user` WHERE `user`.`ID` = " + ID);
            
            JOptionPane.showMessageDialog(null, "Delete completed.. ", "Delete Message", 2);
            
        } catch (Exception e) {
           e.printStackTrace();
        }
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        String Slecteditem = (String) cmbUser.getSelectedItem();
        int ID = HashMapcmbUser.get(Slecteditem);
        
        if(checkEdittext() == true){
            
            try {
                
                PreparedStatement ps = DBconnection.con.prepareStatement("UPDATE `user` SET `Email` =?, `name` =?, `Lastname` =?  WHERE `user`.`ID` = " + ID);

                ps.setString(1 , txtEEmail.getText());
                ps.setString(2 ,txtEFirstname.getText());
                ps.setString(3 ,txtELastname.getText());
                
                ps.executeUpdate();
            
                JOptionPane.showMessageDialog(null, "Update completed. ", "Delete Message", 2);
                
                txtEEmail.setText("");
                txtEFirstname.setText("");
                txtELastname.setText("");
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Delete completed.. ", "Delete Message", 2);
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnPatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPatientActionPerformed
        // TODO add your handling code here:
        cardLayout.show(pnlCards, "Patient");
    }//GEN-LAST:event_btnPatientActionPerformed

    private void btnEditSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditSelectActionPerformed
        // TODO add your handling code here:
        cmbList.removeAllItems();
        cmbList.addItem("");
        String selection = (String) cmbCatagorie.getSelectedItem();
        
        try {
           Statement st = DBconnection.getConnection().createStatement();
           ResultSet rs = st.executeQuery("SELECT * FROM  `" + selection +"` ");
           
           while(rs.next())
           {
               String Name = rs.getString(2) + " " + rs.getString(3);
               int ID = rs.getInt(1);
               HashMapcmbEPD.put(Name, ID);
               cmbList.addItem(Name);
               
           }
        } catch (Exception e) {
           e.printStackTrace();
        }
        
        
    }//GEN-LAST:event_btnEditSelectActionPerformed

    private void btnEditPDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditPDMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEditPDMouseClicked

    private void btnEditPDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditPDActionPerformed
        // TODO add your handling code here:
        cardLayout.show(pnlCards, "EditPD");
    }//GEN-LAST:event_btnEditPDActionPerformed

    private void btnEPDSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEPDSearchActionPerformed
        // TODO add your handling code here:
        String selection2 = (String) cmbList.getSelectedItem();
        String selection1 = (String) cmbCatagorie.getSelectedItem();
        int ID = HashMapcmbEPD.get(selection2);
        
        try {
           Statement st = DBconnection.getConnection().createStatement();
           ResultSet rs = st.executeQuery("SELECT * FROM  `" + selection1 + "` WHERE `National_ID` ='" + ID + "'");
           
           while(rs.next())
           {
              System.out.println("INPUTING TEXT TO COMBOBOX"); 
              txtEPDFirstname.setText(rs.getString(2));
              txtEPDLastname.setText(rs.getString(3));
              txtEPDPhone.setText(rs.getString(4));
              txtEPDNationalID.setText(rs.getString(1));
              txtEPDAddress.setText(rs.getString(5));
               
               
           }
           System.out.println("INPUTING TEXT DONE");
        } catch (Exception e) {
           e.printStackTrace();
        }
        
        
        
    }//GEN-LAST:event_btnEPDSearchActionPerformed

    private void btnEPDClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEPDClearActionPerformed
        // TODO add your handling code here:
        cmbList.removeAllItems();
        txtEPDFirstname.setText("");
        txtEPDLastname.setText("");
        txtEPDPhone.setText("");
        txtEPDNationalID.setText("");
        txtEPDAddress.setText("");
    }//GEN-LAST:event_btnEPDClearActionPerformed

    private void btnAConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAConfirmActionPerformed
        
       java.sql.Date sqldate = new java.sql.Date(jDateChooser1.getDate().getTime());
       

       try{
           PreparedStatement ps = DBconnection.con.prepareStatement("INSERT INTO `reserve` (`Doctor_ID`, `Patient_ID`, `Date`) VALUES (?,?,?)");
           
           ps.setInt(1, HashMapcmbAPatient.get(cmbAPatient.getSelectedItem()));
           ps.setInt(2, HashMapcmbADoctor.get(cmbADoctor.getSelectedItem()));
           ps.setDate(3, sqldate);
                
                

           int ii= ps.executeUpdate();
           System.out.println(ii + " records affected"); // LOG
           JOptionPane.showMessageDialog(null, "Your registeration has been added. ", "Registration Completed (Patient)", 2);

        }catch(HeadlessException | SQLException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnAConfirmActionPerformed

    private void btnASearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnASearchActionPerformed
        // TODO add your handling code here:
        cmbAPatient.removeAllItems();
        cmbADoctor.removeAllItems();
        cmbAPatient();
        cmbADoctor();
    }//GEN-LAST:event_btnASearchActionPerformed

    private void btnAConfirm1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAConfirm1ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "This Function is not avaliable yet!!! added. ", "Error", 2);
    }//GEN-LAST:event_btnAConfirm1ActionPerformed

    private void btnEASearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEASearchActionPerformed
        // TODO add your handling code here:
        int ID = HashMapcmbAEPD.get((String) cmbAList.getSelectedItem());
        
        try {
           Statement st = DBconnection.getConnection().createStatement();
           ResultSet rs = st.executeQuery("SELECT reserve.reserve_id, patient.National_ID,patient.FirstName, patient.Lastname, doctor.Firstname, doctor.Lastname, reserve.Date FROM ((reserve INNER JOIN doctor ON reserve.Doctor_ID = doctor.Doctor_ID) INNER JOIN patient ON patient.Patient_ID = patient.Patient_ID) WHERE reserve.reserve_id="+ID);
           
           while(rs.next())
           {
              System.out.println("INPUTING TEXT TO COMBOBOX"); 
              cmbEAPatient.setSelectedItem(rs.getString(3) + " " + rs.getString(4));
              cmbEAPatient.setSelectedItem(rs.getString(5) + " " + rs.getString(6));
              jDateChooser2.setDate(rs.getDate(7));
                
           }
           System.out.println("INPUTING TEXT DONE");
        } catch (Exception e) {
           e.printStackTrace();
        }
        
    }//GEN-LAST:event_btnEASearchActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Appointment;
    private javax.swing.JPanel Doctor;
    private javax.swing.JPanel EditPatient;
    private javax.swing.JPanel Menu;
    private javax.swing.JPanel Overview;
    private javax.swing.JPanel Patient;
    private javax.swing.JPanel User;
    private keeptoo.KButton btnAConfirm;
    private keeptoo.KButton btnAConfirm1;
    private keeptoo.KButton btnASearch;
    private keeptoo.KButton btnAppointment;
    private keeptoo.KButton btnDoctor;
    private keeptoo.KButton btnDoctorRegister;
    private keeptoo.KButton btnEASearch;
    private keeptoo.KButton btnEPDClear;
    private keeptoo.KButton btnEPDSearch;
    private keeptoo.KButton btnEditPD;
    private keeptoo.KButton btnEditRegister;
    private keeptoo.KButton btnEditSelect;
    private keeptoo.KButton btnExit;
    private keeptoo.KButton btnMinimize;
    private keeptoo.KButton btnOverview;
    private keeptoo.KButton btnPatient;
    private keeptoo.KButton btnPatientRegister;
    private keeptoo.KButton btnPatientSearch;
    private keeptoo.KButton btnRemove;
    private keeptoo.KButton btnSave;
    private keeptoo.KButton btnSearch;
    private keeptoo.KButton btnUser;
    private keeptoo.KButton btnUserRegister;
    private javax.swing.JComboBox<String> cmbADoctor;
    private javax.swing.JComboBox<String> cmbAList;
    private javax.swing.JComboBox<String> cmbAPatient;
    private javax.swing.JComboBox<String> cmbCatagorie;
    private javax.swing.JComboBox<String> cmbEADoctor;
    private javax.swing.JComboBox<String> cmbEAPatient;
    private javax.swing.JComboBox<String> cmbList;
    private javax.swing.JComboBox<String> cmbUser;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabell;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSplitPane jSplitPane1;
    private keeptoo.KButton kButton9;
    private keeptoo.KGradientPanel kGradientPanel1;
    private keeptoo.KGradientPanel kGradientPanel10;
    private keeptoo.KGradientPanel kGradientPanel11;
    private keeptoo.KGradientPanel kGradientPanel12;
    private keeptoo.KGradientPanel kGradientPanel13;
    private keeptoo.KGradientPanel kGradientPanel14;
    private keeptoo.KGradientPanel kGradientPanel15;
    private keeptoo.KGradientPanel kGradientPanel16;
    private keeptoo.KGradientPanel kGradientPanel17;
    private keeptoo.KGradientPanel kGradientPanel18;
    private keeptoo.KGradientPanel kGradientPanel19;
    private keeptoo.KGradientPanel kGradientPanel2;
    private keeptoo.KGradientPanel kGradientPanel20;
    private keeptoo.KGradientPanel kGradientPanel21;
    private keeptoo.KGradientPanel kGradientPanel22;
    private keeptoo.KGradientPanel kGradientPanel23;
    private keeptoo.KGradientPanel kGradientPanel24;
    private keeptoo.KGradientPanel kGradientPanel25;
    private keeptoo.KGradientPanel kGradientPanel26;
    private keeptoo.KGradientPanel kGradientPanel3;
    private keeptoo.KGradientPanel kGradientPanel4;
    private keeptoo.KGradientPanel kGradientPanel5;
    private keeptoo.KGradientPanel kGradientPanel6;
    private keeptoo.KGradientPanel kGradientPanel7;
    private keeptoo.KGradientPanel kGradientPanel8;
    private keeptoo.KGradientPanel kGradientPanel9;
    private javax.swing.JLabel lblA;
    private javax.swing.JLabel lblD;
    private javax.swing.JLabel lblP;
    private javax.swing.JPanel pnlCards;
    private javax.swing.JTextArea txtDoctorAdresses;
    private javax.swing.JTextField txtDoctorFirstname;
    private javax.swing.JTextField txtDoctorLastname;
    private javax.swing.JTextField txtDoctorNationalID;
    private javax.swing.JTextField txtDoctorPhone;
    private javax.swing.JTextField txtEEmail;
    private javax.swing.JTextField txtEFirstname;
    private javax.swing.JTextField txtELastname;
    private javax.swing.JTextArea txtEPDAddress;
    private javax.swing.JTextField txtEPDFirstname;
    private javax.swing.JTextField txtEPDLastname;
    private javax.swing.JTextField txtEPDNationalID;
    private javax.swing.JTextField txtEPDPhone;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEmail1;
    private javax.swing.JTextField txtEmail2;
    private javax.swing.JTextField txtEmail3;
    private javax.swing.JTextField txtFirstname;
    private javax.swing.JTextField txtLastname;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextArea txtPatientAddress;
    private javax.swing.JTextField txtPatientFirstname;
    private javax.swing.JTextField txtPatientLastname;
    private javax.swing.JTextField txtPatientNationalID;
    private javax.swing.JTextField txtPatientPhone;
    // End of variables declaration//GEN-END:variables
}
