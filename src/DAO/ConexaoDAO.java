package DAO;


import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import java.sql.SQLException;

public class ConexaoDAO {

    public Connection conectar() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/controle", "root", "");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Erro ao conectar !"+ e.getMessage());
        }
        return conn;
    }

}
