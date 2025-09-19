package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Produto;
import java.sql.Types;

public class ProdutoController {

    public boolean inserir(Produto usu) {
        String sql = "INSERT INTO PRODUTO (nome, estoque, preco, FkidCategoria)"
                + "Values (?, ?, ?, ?)";

        GerenciarConexoes gerenciador = new GerenciarConexoes();

        PreparedStatement comando = null;
        ResultSet resultado = null;

        try {
            comando = gerenciador.prepararComando(sql);

            comando.setString(1, usu.getNome());
            comando.setInt(2, usu.getEstoque());
            comando.setDouble(3, usu.getPreco());
           // comando.setInt(4, usu.getFkIdCategoria());
            comando.setNull(4, Types.INTEGER);
            

            comando.executeUpdate();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            gerenciador.fecharConexao(comando);
        }
        return false;
    }
}
