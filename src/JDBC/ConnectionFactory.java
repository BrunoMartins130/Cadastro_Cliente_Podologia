/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;





/**
 *
 * @author BRUNO
 */
public class ConnectionFactory {
                                // jdbc:mysql://localhost/marvin_seguros?serverTimezone=UTC","root","3635
private static final String URL = "jdbc:mysql://localhost:3306/podologiacadastro?serverTimezone=UTC";
private static final String USER = "root";
private static final String PASS = "";
private static final String DRIVER = "com.mysql.cj.jdbc.Driver";


  public static Connection getConnection() {
      try {
          Class.forName(DRIVER);
         return DriverManager.getConnection(URL,USER,PASS);
      } catch (ClassNotFoundException | SQLException e) {
          JOptionPane.showMessageDialog(null, "Conction Factory "+e);
     throw new RuntimeException("Erro na conexão com banco de dados: "+e);
       
      }
}
 public static void closeConnection(Connection con) {
     try {
         if (con != null) {
             con.close();
         }
     } catch (SQLException e) {
    throw new RuntimeException("Erro ao fechar a conexão com banco de dados: "+ e);
     }

}
public static void closeConnection(Connection con,PreparedStatement pstm) {
   closeConnection(con);
    try {
        if(pstm != null){
     pstm.close();
}
    } catch (Exception e) {
    }

}


   
}
