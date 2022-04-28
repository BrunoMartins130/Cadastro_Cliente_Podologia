/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javabeans.VistaDorsal;
import javax.swing.JOptionPane;


/**
 *
 * @author BRUNO
 */
public class VistaDorsalDao {

private Connection conecta;

public VistaDorsalDao() {

this.conecta = new ConnectionFactory().getConnection();

}
    public void InserirDorsal(VistaDorsal vistadorsal) {
        Boolean retorno = false;
         String sql = "INSERT INTO vistadorsal (patologiad1,patologiad2,patologiad3,patologiad4,patologiad5,txtFotod1,txtFotod2,idClienteVd) values (?,?,?,?,?,?,?,?)";
         try {
           
             PreparedStatement pstm = conecta.prepareStatement(sql);
             pstm.setString(1, vistadorsal.getPatologiad1());
             pstm.setString(2, vistadorsal.getPatologiad2());
             pstm.setString(3, vistadorsal.getPatologiad3());
             pstm.setString(4, vistadorsal.getPatologiad4());
             pstm.setString(5, vistadorsal.getPatologiad5());
             pstm.setString(6, vistadorsal.getTxtFotod1());
             pstm.setString(7, vistadorsal.getTxtFotod2());
             pstm.setInt(8, vistadorsal.getIdClienteVd());
             
            pstm.execute();
    


        
    } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "inserirDorsal" + e);
        } finally {

            try {
                if (conecta != null) {
                    conecta.close();
                }

            } catch (SQLException e) {
            } catch (Exception e) {

            }
        }

    

    }


 public VistaDorsal consultarVistaDorsal(Integer idClienteVd) {
       String sql = "select * from vistadorsal where idClienteVd=?";
        VistaDorsal vistadorsal = new VistaDorsal();
        
     try {
          PreparedStatement pstm = conecta.prepareStatement(sql);
          pstm.setInt(1, idClienteVd);
         ResultSet rs = pstm.executeQuery();
          if (rs.next()) {
           
          vistadorsal.setPatologiad1(rs.getString("patologiad1"));
          vistadorsal.setPatologiad2(rs.getString("patologiad2"));
          vistadorsal.setPatologiad3(rs.getString("patologiad3"));
          vistadorsal.setPatologiad4(rs.getString("patologiad4"));
          vistadorsal.setPatologiad5(rs.getString("patologiad5"));

 //faz a consulta do banco de dados e coloca no jLabel             
            
            vistadorsal.setTxtFotod1(rs.getString("txtFotod1"));
            vistadorsal.setTxtFotod2(rs.getString("txtFotod2"));
            
         }
          
          return vistadorsal;



     } catch (SQLException e) {
        
} finally {

            try {
                if (conecta != null) {
                    conecta.close();
                }

            } catch (SQLException e) {
            } catch (Exception e) {

            }
        }

        return null;






}

public void editarVistaDorsal(VistaDorsal vistadorsal) {
        Boolean retorno = false;
         String sql = "update vistadorsal set patologiad1=?,patologiad2=?,patologiad3=?,patologiad4=?,patologiad5=?,txtFotod1=?,txtFotod2=? where idClienteVd=?";
         try {
           
             PreparedStatement pstm = conecta.prepareStatement(sql);
             pstm.setString(1, vistadorsal.getPatologiad1());
             pstm.setString(2, vistadorsal.getPatologiad2());
             pstm.setString(3, vistadorsal.getPatologiad3());
             pstm.setString(4, vistadorsal.getPatologiad4());
             pstm.setString(5, vistadorsal.getPatologiad5());
             pstm.setString(6, vistadorsal.getTxtFotod1());
             pstm.setString(7, vistadorsal.getTxtFotod2());
             pstm.setInt(8, vistadorsal.getIdClienteVd());
             
            pstm.execute();
    


        
    } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "editarVistaDorsal" + e);
        } finally {

            try {
                if (conecta != null) {
                    conecta.close();
                }

            } catch (SQLException e) {
            } catch (Exception e) {

            }
        }

    

    }

 public void excluirVistaDorsal(VistaDorsal vistadorsal) {
        try {
            //1oasso - criar comando sql
            String sql = "delete from vistadorsal where idClienteVd = ?";
            //2passo - Organizar o sql e executalo
            PreparedStatement pstm = conecta.prepareStatement(sql);

            pstm.setInt(1, vistadorsal.getIdClienteVd());
            //3passo - Execute o comando
            pstm.execute();

            //4passo - fechar o conexao 
            pstm.close();

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "excluirVistaDorsal() " + erro);
            throw new RuntimeException(erro);
        }

    }
}


