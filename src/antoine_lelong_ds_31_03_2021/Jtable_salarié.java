/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package antoine_lelong_ds_31_03_2021;

import java.awt.Font;
import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author antoi
 */
public class Jtable_salarié extends JFrame{
    public Jtable_salarié(){
        super();
        try {
	   Connection conn = MySQL.getConnexion();
           Statement stmNbSal = (Statement) conn.createStatement();
           ResultSet resNbSal = stmNbSal.executeQuery("SELECT count(idSal) FROM Salarie");
           int nbSal=0;
           while (resNbSal.next()){
               nbSal = resNbSal.getInt("count(idSal)");
           }
           
           Statement stmInfo = (Statement) conn.createStatement();
           String reqInfo = "SELECT * FROM Salarie";
	   ResultSet resInfo = stmInfo.executeQuery(reqInfo);
           
           String entetes[] = {"idSal", "Nom", "prénoms", "age", "fonction", "service", "grade"};
           String donnees[][] = new String[nbSal][8];
           
           int i=0;
	   while (resInfo.next()) {
                donnees[i][0]= resInfo.getString("idSal");
                donnees[i][1]= resInfo.getString("nom");
                donnees[i][2]= resInfo.getString("nom");
                donnees[i][3]= resInfo.getString("prenoms");
                donnees[i][4]= resInfo.getString("age");
                donnees[i][5]= resInfo.getString("fonction");
                donnees[i][6]= resInfo.getString("service");
                donnees[i][7]= resInfo.getString("grade");
                i++;
            }
           DefaultTableModel model = new DefaultTableModel(donnees, entetes);
           JTable table = new JTable(model);
           table.setShowGrid(true);
           table.setShowVerticalLines(true);
           TableColumn col = null;
            for (int j = 0; j < 2; j++) {
                col = table.getColumnModel().getColumn(j);
                col.setPreferredWidth(150);
            }
            for (int j=0; j<nbSal;j++){
                table.setRowHeight(j,30);
            }
            table.setFont(new Font("Serif", Font.PLAIN, 20));
           JScrollPane pane = new JScrollPane(table);
           JFrame f = new JFrame("Information des étudiants");
           JPanel panel = new JPanel();
           panel.setLayout(new GridLayout(1,1));
           panel.add(pane);
           f.add(panel);
           f.setSize(1000, 400);
           //f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           f.setVisible(true);
           f.setLocationRelativeTo(null);
        }
        catch (SQLException e) {
            System.out.println("Erreur lors du chargement "+e.getMessage()) ;
	}
    }
}

