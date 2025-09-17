package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Produto;

public class ProdutoController {

    public boolean produto(Produto usu) {
        String sql = "INSERT INTO CATALOGO (nome, estoque, preco, FkidCategoria)"
                + "Values (?, ?, ?, ?)";

        GerenciarConexoes gerenciador = new GerenciarConexoes();

        PreparedStatement comando = null;
        ResultSet resultado = null;

        try {
            comando = gerenciador.prepararComando(sql);

            comando.setString(1, usu.getNome());
            comando.setInt(2, usu.getEstoque());
            comando.setInt(3, usu.getFkIdCategoria());

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
