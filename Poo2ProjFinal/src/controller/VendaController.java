
package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.ItemVenda;
import model.Venda;


public class VendaController {
     public boolean venda(Venda usu) {
        String sql = "INSERT INTO CATALOGO (nome, dataValidade, FKidVendedor, FkidCliente)"
                + "Values (?, ?, ?, ?)";

        GerenciarConexoes gerenciador = new GerenciarConexoes();

        PreparedStatement comando = null;
        ResultSet resultado = null;

        try {
            comando = gerenciador.prepararComando(sql);

            comando.setDouble(1, usu.getValorTotal());
            comando.setDate(2,new java.sql.Date(usu.getDataVenda().getTime()));
            comando.setInt(3, usu.getFkIdVendedor());
            comando.setInt(4, usu.getFkIdCliente());
        

            comando.executeUpdate();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            gerenciador.fecharConexao(comando);
        }
        return false;
    }
     
      public boolean itemVenda(ItemVenda usu) {
        String sql = "INSERT INTO ITEMVENDA (precoTotal, precoUnitario, quantidadeProduto,FkidVenda,FkidProduto)"
                + "Values (?, ?, ?)";

        GerenciarConexoes gerenciador = new GerenciarConexoes();

        PreparedStatement comando = null;
        ResultSet resultado = null;

        try {
            comando = gerenciador.prepararComando(sql);

            comando.setDouble(1, usu.getPrecoTotal());
            comando.setDouble(2,usu.getPrecoUnitario());
            comando.setInt(3,usu.getQuantidadeProduto());
            comando.setInt(4, usu.getFkIdVenda());
            comando.setInt(5, usu.getFkIdProduto());
        

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
