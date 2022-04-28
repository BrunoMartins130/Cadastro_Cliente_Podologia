/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JDBC;

import JDBC.ConnectionFactory;
import View.TelaCadastroCliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javabeans.Anamnese;
import javabeans.Clientes;
import javax.swing.JOptionPane;

/**
 *
 * @author BRUNO
 */
public class AnamneseDao {

    private Connection conecta;
//contrutor

    public AnamneseDao() {

        this.conecta = new ConnectionFactory().getConnection();

    }

    public Anamnese consultarAnamnese(Integer idCliente) {
        String sql = "select * from anamnese where idCliente=?";
        Anamnese aname = new Anamnese();
        try {

            PreparedStatement pstm = conecta.prepareStatement(sql);
            pstm.setInt(1, idCliente);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                aname.setIdAnamnese(rs.getInt("idAnamnese"));
                aname.setQueixa(rs.getString("queixa"));
                aname.setCirurgia(rs.getString("cirurgia"));
                aname.setEtilante(rs.getString("etilante"));
                aname.setEsporte(rs.getString("esporte"));
                aname.setMedicamento(rs.getString("medicamento"));
                aname.setAlergico(rs.getString("alergico"));
                aname.setQualCirurgia(rs.getString("qualCirurgia"));
                aname.setQualEtilante(rs.getString("qualEtilante"));
                aname.setQualEsporte(rs.getString("qualEsporte"));
                aname.setQualMedicamento(rs.getString("qualMedicamento"));
                aname.setQualAlergia(rs.getString("qualAlergia"));
                aname.setObservacao2(rs.getString("observacao2"));
                aname.setDiabetes(rs.getString("diabetes"));
                aname.setPressaoAlta(rs.getString("pressaoAlta"));
                aname.setConvulsao(rs.getString("convulsao"));
                aname.setProblemasCirculatorios(rs.getString("problemasCirculatorios"));
                aname.setMarcapassoPino(rs.getString("marcapassoPino"));
                aname.setOutros(rs.getString("outros"));
                aname.setQualPossui(rs.getString("qualPossui"));

            }
            return aname;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "consultarAnamnese" + e);
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

//metodo cadastrar Anamnese
    public void cadastrarAnamnese(Anamnese anamnese) {
try {
        

//1 passo criar comando sql
//query antes de alterar
            // String sql = "insert into anamnese(queixa,cirurgia,etilante,esporte,medicamento,alergico,observacao2,qualCirurgia) values (?,?,?,?,?,?,?,?)";        
//2 organizar o sql e executa-lo
//query alterada com todas as colunas da tabela
            String sql = "insert into anamnese(queixa,cirurgia,etilante,esporte,medicamento,alergico,qualCirurgia,qualEtilante,qualEsporte,qualMedicamento,qualAlergia,observacao2,diabetes,pressaoAlta,convulsao,problemasCirculatorios,MarcapassoPino,outros,qualPossui,idCliente) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pstm = conecta.prepareStatement(sql);
            
            pstm.setString(1, anamnese.getQueixa());
            pstm.setString(2, anamnese.getCirurgia());
            pstm.setString(3, anamnese.getEtilante());
            pstm.setString(4, anamnese.getEsporte());
            pstm.setString(5, anamnese.getMedicamento());
            pstm.setString(6, anamnese.getAlergico());
            pstm.setString(7, anamnese.getQualCirurgia());
            pstm.setString(8, anamnese.getQualEtilante());
            pstm.setString(9, anamnese.getQualEsporte());
            pstm.setString(10, anamnese.getQualMedicamento());
            pstm.setString(11, anamnese.getQualAlergia());
            pstm.setString(12, anamnese.getObservacao2());
            pstm.setString(13, anamnese.getDiabetes());
            pstm.setString(14, anamnese.getPressaoAlta());
            pstm.setString(15, anamnese.getConvulsao());
            pstm.setString(16, anamnese.getProblemasCirculatorios());
            pstm.setString(17, anamnese.getMarcapassoPino());
            pstm.setString(18, anamnese.getOutros());
            pstm.setString(19, anamnese.getQualPossui());
            pstm.setInt(20, anamnese.getIdCliente());

            //3passo - executa o comando
            pstm.execute();

            //4 passo - fechar a conexao 
            pstm.close();

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "cadastarAnamnese" + erro);
            throw new RuntimeException(erro);
     }   

    }

 public void editarAnamnese(Anamnese anamnese) {

        try {

//1 passo criar comando sql
//query antes de alterar
           
//2 organizar o sql e executa-lo
//query alterada com todas as colunas da tabela
                         
            String sql = "update anamnese set queixa=?,cirurgia=?,etilante=?,esporte=?,medicamento=?,alergico=?,qualCirurgia=?,qualEtilante=?,qualEsporte=?,qualMedicamento=?,qualAlergia=?,observacao2=?,diabetes=?,pressaoAlta=?,convulsao=?,problemasCirculatorios=?,MarcapassoPino=?,outros=?,qualPossui=? where idCliente=?";
            PreparedStatement pstm = conecta.prepareStatement(sql);
            
            pstm.setString(1, anamnese.getQueixa());
            pstm.setString(2, anamnese.getCirurgia());
            pstm.setString(3, anamnese.getEtilante());
            pstm.setString(4, anamnese.getEsporte());
            pstm.setString(5, anamnese.getMedicamento());
            pstm.setString(6, anamnese.getAlergico());
            pstm.setString(7, anamnese.getQualCirurgia());
            pstm.setString(8, anamnese.getQualEtilante());
            pstm.setString(9, anamnese.getQualEsporte());
            pstm.setString(10, anamnese.getQualMedicamento());
            pstm.setString(11, anamnese.getQualAlergia());
            pstm.setString(12, anamnese.getObservacao2());
            pstm.setString(13, anamnese.getDiabetes());
            pstm.setString(14, anamnese.getPressaoAlta());
            pstm.setString(15, anamnese.getConvulsao());
            pstm.setString(16, anamnese.getProblemasCirculatorios());
            pstm.setString(17, anamnese.getMarcapassoPino());
            pstm.setString(18, anamnese.getOutros());
            pstm.setString(19, anamnese.getQualPossui());
            pstm.setInt(20, anamnese.getIdCliente());

            //3passo - executa o comando
            pstm.execute();

            //4 passo - fechar a conexao 
            pstm.close();

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "editarAnamnese " + erro);
            throw new RuntimeException(erro);
        }

    }

public void excluirClienteAname(Anamnese anamnese) {
        try {
            //1oasso - criar comando sql
            String sql = "delete from anamnese where idCliente = ?";
            //2passo - Organizar o sql e executalo
            PreparedStatement pstm = conecta.prepareStatement(sql);

            pstm.setInt(1, anamnese.getIdCliente());
            //3passo - Execute o comando
            pstm.execute();

            //4passo - fechar o conexao 
            pstm.close();

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "excluirClienteAname" + erro);
            throw new RuntimeException(erro);
        }
}
}