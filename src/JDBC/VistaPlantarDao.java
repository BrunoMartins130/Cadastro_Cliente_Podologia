package JDBC;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import View.TelaCadastroCliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javabeans.VistaPlantar;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author BRUNO
 */
public class VistaPlantarDao {


private Connection conecta;
    
public VistaPlantarDao() {

 this.conecta = new ConnectionFactory().getConnection();


}

public void Inserir(VistaPlantar vistaplantar) {
        Boolean retorno = false;
         String sql = "INSERT INTO vistaplantar (patologia1,patologia2,patologia3,patologia4,patologia5,txtFoto1,txtFoto2,idClienteVp) values (?,?,?,?,?,?,?,?)";
         try {
           
             PreparedStatement pstm = conecta.prepareStatement(sql);
             pstm.setString(1, vistaplantar.getPatologia1());
             pstm.setString(2, vistaplantar.getPatologia2());
             pstm.setString(3, vistaplantar.getPatologia3());
             pstm.setString(4, vistaplantar.getPatologia4());
             pstm.setString(5, vistaplantar.getPatologia5());
             pstm.setString(6, vistaplantar.getTxtFoto1());
             pstm.setString(7, vistaplantar.getTxtFoto2());
             pstm.setInt(8, vistaplantar.getIdClienteVp());
             
            pstm.execute();
    


        
    } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "inserir" + e);
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


 public VistaPlantar consultarVistaPlantar(Integer idClienteVp) {
       String sql = "select * from vistaplantar where idClienteVp=?";
        VistaPlantar vistaplantar = new VistaPlantar();
        
     try {
          PreparedStatement pstm = conecta.prepareStatement(sql);
          pstm.setInt(1, idClienteVp);
         ResultSet rs = pstm.executeQuery();
          if (rs.next()) {
           
          vistaplantar.setPatologia1(rs.getString("patologia1"));
          vistaplantar.setPatologia2(rs.getString("patologia2"));
          vistaplantar.setPatologia3(rs.getString("patologia3"));
          vistaplantar.setPatologia4(rs.getString("patologia4"));
          vistaplantar.setPatologia5(rs.getString("patologia5"));

 //faz a consulta do banco de dados e coloca no jLabel             
            
            vistaplantar.setTxtFoto1(rs.getString("txtFoto1"));
            vistaplantar.setTxtFoto2(rs.getString("txtFoto2"));
            
         }
          
          return vistaplantar;



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

public void editarVistaPlantar(VistaPlantar vistaplantar) {
        Boolean retorno = false;
         String sql = "update vistaplantar set patologia1=?,patologia2=?,patologia3=?,patologia4=?,patologia5=?,txtFoto1=?,txtFoto2=? where idClienteVp=?";
         try {
           
             PreparedStatement pstm = conecta.prepareStatement(sql);
             pstm.setString(1, vistaplantar.getPatologia1());
             pstm.setString(2, vistaplantar.getPatologia2());
             pstm.setString(3, vistaplantar.getPatologia3());
             pstm.setString(4, vistaplantar.getPatologia4());
             pstm.setString(5, vistaplantar.getPatologia5());
             pstm.setString(6, vistaplantar.getTxtFoto1());
             pstm.setString(7, vistaplantar.getTxtFoto2());
             pstm.setInt(8, vistaplantar.getIdClienteVp());
             
            pstm.execute();
    


        
    } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "editarVistaPlantar" + e);
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

 public void excluirVistaPlantar(VistaPlantar vistaplantar) {
        try {
            //1oasso - criar comando sql
            String sql = "delete from vistaplantar where idClienteVp = ?";
            //2passo - Organizar o sql e executalo
            PreparedStatement pstm = conecta.prepareStatement(sql);

            pstm.setInt(1, vistaplantar.getIdClienteVp());
            //3passo - Execute o comando
            pstm.execute();

            //4passo - fechar o conexao 
            pstm.close();

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "excluirVistaPlantar() " + erro);
            throw new RuntimeException(erro);
        }

    }



     }





