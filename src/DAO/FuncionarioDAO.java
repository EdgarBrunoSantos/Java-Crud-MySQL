package DAO;

import java.sql.Connection;
import entidades.Funcionario;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;

public class FuncionarioDAO {

    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<Funcionario> lista = new ArrayList();

    public void cadastrarFuncionario(Funcionario funcionario) {
        String sql = "INSERT INTO funcionario (matricula,nome,cargo)VALUES(?,?,?) ";
        conn = new ConexaoDAO().conectar();
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, funcionario.getMatricula());
            pstm.setString(2, funcionario.getNome());
            pstm.setString(3, funcionario.getCargo());
            pstm.execute();
            pstm.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar" + e);
        }
    }

    public ArrayList<Funcionario> Pesquisar() {
        String sql = "SELECT * FROM funcionario ";
        conn = new ConexaoDAO().conectar();
        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                Funcionario funcionario = new Funcionario();
                funcionario.setId(rs.getInt("id"));
                funcionario.setMatricula(rs.getString("matricula"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setCargo(rs.getString("cargo"));
                lista.add(funcionario);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Pesquisar" + e);
        }
        return lista;
    }
    public void alterarFuncionario(Funcionario funcionario){
     String sql = "update funcionario set matricula=?,nome=?,cargo=? where id=?  ";
        conn = new ConexaoDAO().conectar();
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, funcionario.getMatricula());
            pstm.setString(2, funcionario.getNome());
            pstm.setString(3, funcionario.getCargo());
            pstm.setInt(4, funcionario.getId());
           
            pstm.executeUpdate();
            pstm.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro na alterção" + e);
        }
    }

    
    }

