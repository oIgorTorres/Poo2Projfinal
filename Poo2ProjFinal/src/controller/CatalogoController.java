
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
     
     public List<Catalogo> consultar(){
    //Montar o comando a ser executado
        //os ? são variáveis que são preenchidas mais adiante
        String sql = "SELECT * from Catalogo ";

        
        GerenciarConexoes gerenciador = new GerenciarConexoes();

        //Declara as variáveis como nulas antes do try
        //para poder usar o finally
        PreparedStatement comando = null;
        ResultSet resultado = null;

        //Crio a list de usuários, vazia ainda
        List<Catalogo> lista = new ArrayList<>();

        try {
            //prepara o sql, analisando o formato e as variáveis
            comando = gerenciador.prepararComando(sql);

            //executa o comando e guarda o resultado da consulta
            //o resultado é semelhante a uma grade
            resultado = comando.executeQuery();

            while (resultado.next()) {
                Catalogo catalogo = new Catalogo();
                
                catalogo.setIdCatalogo(resultado.getInt("idCatalogo"));
                catalogo.setNome(resultado.getString("Nome"));
                catalogo.setDataValidade(resultado.getDate("dataValidade"));

                lista.add(catalogo);

            }

        } catch (SQLException e) {
            //caso ocorra um erro relacionado ao banco de dados
            //exibe popup com o erro

            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            //depois de executar o try, dando erro ou não executa o finally
            gerenciador.fecharConexao(comando, resultado);
        }
        return lista;

     }     
     
}
