
package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Catalogo;
import model.ItemCatalogo;


public class CatalogoController {
    public boolean inserir(Catalogo usu) {
        String sql = "INSERT INTO CATALOGO (nome, dataValidade)"
                + "Values (?, ?)";

        GerenciarConexoes gerenciador = new GerenciarConexoes();

        PreparedStatement comando = null;
        ResultSet resultado = null;

        try {
            comando = gerenciador.prepararComando(sql);

            comando.setString(1, usu.getNome());
            comando.setDate(2,new java.sql.Date(usu.getDataValidade().getTime()));
        

            comando.executeUpdate();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            gerenciador.fecharConexao(comando);
        }
        return false;
    }
    
     public boolean itemCatalogo(ItemCatalogo usu) {
        String sql = "INSERT INTO ITEMCATALOGO (FkidProduto, FkidCatalogo)"
                + "Values (?, ?)";

        GerenciarConexoes gerenciador = new GerenciarConexoes();

        PreparedStatement comando = null;
        ResultSet resultado = null;

        try {
            comando = gerenciador.prepararComando(sql);

            comando.setInt(1, usu.getFkIdProduto());
            comando.setInt(2,usu.getFkIdCatalogo());
        

            comando.executeUpdate();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            gerenciador.fecharConexao(comando);
        }
        return false;
    }
     
     public List<ItemCatalogo> consultar(int offset){
     String sql = "Select * from itemCatalogo";
     
     List<ItemCatalogo> lista = new ArrayList<>();
     
     ItemCatalogo itemCatalogo = new ItemCatalogo();
     
     itemCatalogo.setFkIdProduto(offset);
     itemCatalogo.setFkIdCatalogo(offset);
     
     return lista;
     }     
     
}
