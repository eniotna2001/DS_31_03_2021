/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package antoine_lelong_ds_31_03_2021;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 *
 * @author antoi
 */
public class MySQL {
     public static Connection getConnexion(){
        try {
		Class.forName("com.mysql.jdbc.Driver") ;
            }
             catch (ClassNotFoundException e){
		System.out.println("Erreur lors du chargement "+e.getMessage()) ;
            }            
        Connection connexion = null;
        try{
            String url = "jdbc:mysql://localhost:3306/XTOM";
            Properties props = new Properties();
            props.setProperty("user","root");
            props.setProperty("password","");
            connexion = DriverManager.getConnection(url,props) ;
        }
        catch (SQLException e) {
            System.out.println("Erreur lors du chargement "+e.getMessage()) ;
	}
        return connexion;
    }
     
     public static boolean verifConnexion(String login,String mdp){
        String nom="";
        String motdepasse="";
        Statement stmInfoUtili = null;
        ResultSet resIfnoUtili = null;
        try{
        Connection conn = MySQL.getConnexion();
        
        stmInfoUtili = (Statement) conn.createStatement() ;
        String req = "SELECT * FROM user";
	resIfnoUtili = stmInfoUtili.executeQuery(req) ;
          
        while (resIfnoUtili.next()) {
            nom = resIfnoUtili.getString("login");
            motdepasse = resIfnoUtili.getString("password");
        }
        }
        catch (SQLException e) {
            // Traitement des exceptions
	}
        if(login.equals(nom) && mdp.equals(motdepasse)){
            return true;
        }
        else{
            return false;
        }
    }
}
