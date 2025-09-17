
package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Venda;


public class VendaController {
     public boolean cadastroVendedor(Venda usu) {
        String sql = "INSERT INTO CATALOGO (nome, dataValidade)"
                + "Values (?, ?)";

        GerenciarConexoes gerenciador = new GerenciarConexoes();

        PreparedStatement comando = null;
        ResultSet resultado = null;

        try {
            comando = gerenciador.prepararComando(sql);

            comando.setDouble(1, usu.getValorTotal());
            comando.setDate(2,new java.sql.Date(usu.getDataVenda().getTime()));
        

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
