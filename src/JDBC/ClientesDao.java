/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javabeans.Clientes;
import javabeans.WebServiceCep;
import javax.swing.JOptionPane;

/**
 *
 * @author BRUNO
 */
public class ClientesDao {

    private Connection conecta;
// construtor

    public ClientesDao() {
        this.conecta = new ConnectionFactory().getConnection();

    }

    //Médtodo cadastrar cliente
    public void cadastrarCliente(Clientes clientes) {
        try {
            //1oasso - criar comando sql
            String sql = "insert into clientes(nome,cpf,rg,nascimento,cep,endereco,numero,uf,bairro,cidade,telefone,celular,email,observacao) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            //2passo - Organizar o sql e executalo
            PreparedStatement pstm = conecta.prepareStatement(sql);

            pstm.setString(1, clientes.getNome());
            pstm.setString(2, clientes.getCpf());
            pstm.setString(3, clientes.getRg());
            pstm.setString(4, clientes.getNascimento());
            pstm.setString(5, clientes.getCep());
            pstm.setString(6, clientes.getEndereco());
            pstm.setInt(7, clientes.getNumero());
            pstm.setString(8, clientes.getUf());
            pstm.setString(9, clientes.getBairro());
            pstm.setString(10, clientes.getCidade());
            pstm.setString(11, clientes.getTelefone());
            pstm.setString(12, clientes.getCelular());
            pstm.setString(13, clientes.getEmail());
            pstm.setString(14, clientes.getObservacao());

            //3passo - Execute o comando
            pstm.execute();

            //4passo - fechar o conexao 
            //*********************** IMPORTANTE **************************************
            //PERCEBA COMO ALTEREI ESSE BLOCO TRY CATCH DO SEU METODO
            //DESSA FORMA VC FECHA A CONEXÃO COM O BANCO DE DADOS LOGO APÓS TODO O MÉTODO TER SIDO EXECUTADO
            //DESSA MANEIRA VC TEM A CERTEZA QUE FECHOU A CONEXÃO EIVTANDO PROBLEMAS
            //REPITA ESSA ALTERAÇÃO EM TODOS OS MÉTODOS QUE VC USA PARA SE CONECTAR AO BANCO DE DADOS
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "cadastrarCliente " + e);

            //TODO BLOCO TRY CATCH DEVE NECESSARIAMENTE TER O BLOCO FINALLY
            // COM ELE VC SE CERTIFICA QUE SE O METODO FOR OU NAO EXECUTADO
            //A CONEXAO COM O BANCO SERA FECHADA. TODO BANCO DE DADOS TEM UM LIMITE DE CONEXOES
            // ENTAO USANDO DESSA FORMA VC NUNCA TERÁ VARIAS INSTANCIAS ABERTAS DESNECESSÁRIAS
        } finally {
            try {

                if (conecta != null) {
                    conecta.close();
                }

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "cadastrarCliente() " + e);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "cadastrarCliente() " + e);
            }
        }

    }

//LISTAR TODOS OS CLIENTES
    public List<Clientes> listarclientes() {
        try {
//1 passo - criar vetor que vai armazenas os registros do banco 
            List<Clientes> listar = new ArrayList<Clientes>();
            //2 passo - criar o comando sql 
            String cmdsql = "SELECT * FROM clientes";

            PreparedStatement pstm = conecta.prepareStatement(cmdsql);
            //3 passo - Guardo o resultado do select dentro do objeto rs(resultSet)
            ResultSet rs = pstm.executeQuery();

            //4 passo - Enquanto houver registros (resultado do select)guarde o registo na lista 
            while (rs.next()) {
                Clientes c = new Clientes();
                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                c.setCpf(rs.getString("cpf"));
                c.setRg(rs.getString("rg"));
                c.setNascimento(rs.getString("nascimento"));
                c.setCep(rs.getString("cep"));
                c.setEndereco(rs.getString("endereco"));
                c.setNumero(rs.getInt("numero"));
                c.setUf(rs.getString("uf"));
                c.setBairro(rs.getString("bairro"));
                c.setCidade(rs.getString("cidade"));
                c.setTelefone(rs.getString("telefone"));
                c.setCelular(rs.getString("celular"));
                c.setEmail(rs.getString("email"));
                c.setObservacao(rs.getString("observacao"));
                listar.add(c);

            }

            return listar;
        } catch (Exception erro) {
            erro.printStackTrace();
            throw new RuntimeException(erro);
        }

    }

//ALTERAR cliente
    public void alterarCliente(Clientes clientes) {
        try {
            //1oasso - criar comando sql
            String sql = "update clientes set  nome=?, cpf=?, rg=?, nascimento=?, cep=?, endereco=?,numero=?, uf=?, bairro=?, cidade=?, telefone=?, celular=?, email=?, observacao=? where id=? ";
            //2passo - Organizar o sql e executalo
            PreparedStatement pstm = conecta.prepareStatement(sql);

            pstm.setString(1, clientes.getNome());
            pstm.setString(2, clientes.getCpf());
            pstm.setString(3, clientes.getRg());
            pstm.setString(4, clientes.getNascimento());
            pstm.setString(5, clientes.getCep());
            pstm.setString(6, clientes.getEndereco());
            pstm.setInt(7, clientes.getNumero());
            pstm.setString(8, clientes.getUf());
            pstm.setString(9, clientes.getBairro());
            pstm.setString(10, clientes.getCidade());
            pstm.setString(11, clientes.getTelefone());
            pstm.setString(12, clientes.getCelular());
            pstm.setString(13, clientes.getEmail());
            pstm.setString(14, clientes.getObservacao());
            pstm.setInt(15, clientes.getId());
            //3passo - Execute o comando
            pstm.execute();

            //4passo - fechar o conexao 
            pstm.close();

        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }

    }

    //excluir cliente
    public void excluirCliente(Clientes clientes) {
        try {
            //1oasso - criar comando sql
            String sql = "delete from clientes where id = ?";
            //2passo - Organizar o sql e executalo
            PreparedStatement pstm = conecta.prepareStatement(sql);

            pstm.setInt(1, clientes.getId());
            //3passo - Execute o comando
            pstm.execute();

            //4passo - fechar o conexao 
            pstm.close();

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "excluirCliente() " + erro);
            throw new RuntimeException(erro);
        }

    }
    //*************************************************************************************************************************************
    //ESSE MÉTODO VERIFICA NO BANCO QUAL SERÁ O PROXIMO ID A SER CADASTRADO, ASSIM O QUANDO FOR CADASTRAR UM CLEINTE NOVO
    // VC JA TEM O ID DELE PARA 'SETAR' O ID DO CLIENTE NO OBJETO ANAMNESE

    public Integer pegarProximoIdParaCadastrar() {
        Integer proximo_id = null;
        //ESSA QUERY RETORNA DO BANCO COM O PROXIMO ID A SER CADASTRADO NA TABELA CLIENTES
        String sql = "SELECT max(id)+1 as proximo_id FROM clientes";

        PreparedStatement pstm;
        try {
            pstm = conecta.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            //CASO TENHA SUCESSO NA CONSULTA ELE SETA ESSE PROXIMO ID NA VARIAVEL E RETORNA COM O VALOR
            if (rs.next()) {
                proximo_id = rs.getInt("proximo_id");
                return proximo_id;

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "pegarProximoIdParaCadastrar() " + ex);
            Logger.getLogger(ClientesDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public Clientes buscaCep(String cep) {

        WebServiceCep webServiceCep = WebServiceCep.searchCep(cep);

        Clientes obj = new Clientes();

        if (webServiceCep.wasSuccessful()) {
            obj.setEndereco(webServiceCep.getLogradouroFull());
            obj.setCidade(webServiceCep.getCidade());
            obj.setBairro(webServiceCep.getBairro());
            obj.setUf(webServiceCep.getUf());
            return obj;
        } else {
            JOptionPane.showMessageDialog(null, "Erro numero: " + webServiceCep.getResulCode());
            JOptionPane.showMessageDialog(null, "Descrição do erro: " + webServiceCep.getResultText());
            return null;
        }
//*******************************************************************************************************************************************
    }
}
