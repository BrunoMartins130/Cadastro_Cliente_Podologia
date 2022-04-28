/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classeprincipal;

import java.sql.Connection;
import JDBC.ConnectionFactory;
import javax.swing.JOptionPane;

/**
 *
 * @author BRUNO
 */
public class ClassePrincipal {

    public static void main(String[] args) {


        try {
            JOptionPane.showMessageDialog(null, "Testando a conexão");
             Connection con = new ConnectionFactory().getConnection();
             JOptionPane.showMessageDialog(null,"Esta Conectado");
        } catch (Exception e) {
           e.printStackTrace();

            JOptionPane.showMessageDialog(null,"Falha na conexão");
        }
      //Testando a conexão
        
      


    }
    
}
