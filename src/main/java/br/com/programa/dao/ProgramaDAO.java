package br.com.programa.dao;

import br.com.programa.connection.Conexao;
import br.com.programa.exe.entidades.Pessoa;
import br.com.programa.exe.entidades.Servico;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProgramaDAO {

    public void save(Pessoa pessoa, Servico servico) {
        String sql = "INSERT INTO paciente(nome, telefone, cep, descricao, preco, dataservico) VALUES (?, ?, ?, ?, ?, ?)";
        Connection conn = null;
        PreparedStatement pstm = null;
        try {
            conn = Conexao.createConnectionToMySQL();
            pstm = (PreparedStatement) conn.prepareStatement(sql);
            pstm.setString(1, pessoa.getNome());
            pstm.setString(2, pessoa.getTelefone());
            pstm.setString(3, pessoa.getCep());
            pstm.setString(4, servico.getDescricao());
            pstm.setDouble(5, servico.getPreco());
            pstm.setString(6, servico.getDataservico());
            pstm.execute();
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
    }

    public List<Pessoa> informacoesPaciente() {
        String sql = "SELECT * FROM paciente";
        List<Pessoa> pacientes = new ArrayList<Pessoa>();
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rst = null;
        try {
            conn = Conexao.createConnectionToMySQL();
            pstm = (PreparedStatement) conn.prepareStatement(sql);
            rst = pstm.executeQuery();
            while (rst.next()) {
                Pessoa pessoa = new Pessoa();
                pessoa.setId(rst.getInt("id"));
                pessoa.setNome(rst.getString("nome"));
                pessoa.setTelefone(rst.getString("telefone"));
                pessoa.setCep(rst.getString("cep"));
                pacientes.add(pessoa);
            }
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            try {
                if (rst != null) {
                    rst.close();
                }
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
            return pacientes;
    }
    public List<Servico> informacoesServico(int id) {
        String sql = "SELECT * FROM paciente WHERE id = ?";
        List<Servico> servicos = new ArrayList<Servico>();
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rst = null;
        try {
            conn = Conexao.createConnectionToMySQL();
            pstm = (PreparedStatement) conn.prepareStatement(sql);
            pstm.setInt(1, id);
            rst = pstm.executeQuery();
            while (rst.next()) {
                Servico servico = new Servico();
                servico.setDescricao(rst.getString("descricao"));
                servico.setPreco(rst.getDouble("preco"));
                servico.setDataservico(rst.getString("dataservico"));
                servicos.add(servico);
            }
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            try {
                if (rst != null) {
                    rst.close();
                }
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
        return servicos;
    }

    public void update(Pessoa pessoa, Servico servico) {
        String sql = "UPDATE paciente SET nome = ?, telefone = ?, cep = ?, descricao = ?, preco = ?, dataservico = ? WHERE id = ?";
        Connection conn = null;
        PreparedStatement pstm = null;
        try {
            conn = Conexao.createConnectionToMySQL();
            pstm = (PreparedStatement) conn.prepareStatement(sql);
            pstm.setString(1, pessoa.getNome());
            pstm.setString(2, pessoa.getTelefone());
            pstm.setString(3, pessoa.getCep());
            pstm.setString(4, servico.getDescricao());
            pstm.setDouble(5, servico.getPreco());
            pstm.setString(6, servico.getDataservico());
            pstm.setInt(7, pessoa.getId());
            pstm.execute();
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
    }

    public void delete(int id){
        String sql = "DELETE FROM paciente WHERE id = ?";
        Connection conn = null;
        PreparedStatement pstm = null;
        try {
            conn = Conexao.createConnectionToMySQL();
            pstm = (PreparedStatement) conn.prepareStatement(sql);
            pstm.setInt(1, id);
            pstm.execute();
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
    }

    public void deleteTable(){
        String sql = "TRUNCATE infos.paciente";
        Connection conn = null;
        PreparedStatement pstm = null;
        try{
            conn = Conexao.createConnectionToMySQL();
            pstm = (PreparedStatement) conn.prepareStatement(sql);
            pstm.execute();
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}