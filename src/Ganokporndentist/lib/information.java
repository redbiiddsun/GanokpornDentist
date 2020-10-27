/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ganokporndentist.lib;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Phanasorn Srisayam
 */
public class information {
    
    public static int InfoID = 0 ;
    public static String InfoName = null ;
    public static String InfoEmail = null ;
    public static String InfoSurName = null ;
    
    public information(){
        DBconnection.getConnection();
    }
    
    public static void getID(int ID){
        
        InfoID = ID;
        System.out.println("User Log information: ID is "+ InfoID);
        
    }
    
    public static void getName(String Name){
        
        InfoName = Name;
        System.out.println("User Log information: Name is "+ InfoName);
        
    }
    
    public static void getSurname(String Surname){
        
        InfoSurName = Surname;
        System.out.println("User Log information: Lastname is "+ InfoSurName);
    
    }
    
    public static void getEmail(String email){
        
        InfoEmail = email;
        System.out.println("User Log information: Email is "+ InfoEmail);

    }
    
    public static void getInfo(){
        
        ResultSet rs;
        PreparedStatement ps;
        
        try{
            ps = DBconnection.getConnection().prepareStatement("SELECT * FROM user where id =" + InfoID );
            rs = ps.executeQuery();
          
           
            while (rs.next()){
               getName(rs.getString(4));
               getSurname(rs.getString(5));
               getEmail(rs.getString(2));
               
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    
}
