package controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Produto;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import util.Utils;

public class ProdutoController {

    public boolean inserir(Produto usu) {
        String sql = "INSERT INTO PRODUTO (nome, estoque, preco, FkidCategoria, imagem)"
                + "Values (?, ?, ?, ?, ?)";

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
            comando.setBytes(5, Utils.converterIconToBytes(usu.getImagem()));

            comando.executeUpdate();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            gerenciador.fecharConexao(comando);
        }
        return false;
    }

    public List<Produto> consultar(int offset, String filtro) {
        //Montar o comando a ser executado
        //os ? são variáveis que são preenchidas mais adiante
        String sql = "SELECT * from Produto ";

        if (filtro != null) {
            sql = sql + "where nome like '%" + filtro + "%'";
        }
        sql = sql + "limit 3 offset ? ";

        //Cria uma instância do gerenciador de conexão
        //(conexão com o banco de dados,
        GerenciarConexoes gerenciador = new GerenciarConexoes();

        //Declara as variáveis como nulas antes do try
        //para poder usar o finally
        PreparedStatement comando = null;
        ResultSet resultado = null;

        //Crio a list de usuários, vazia ainda
        List<Produto> lista = new ArrayList<>();

        try {
            //prepara o sql, analisando o formato e as variáveis
            comando = gerenciador.prepararComando(sql);

            comando.setInt(1, offset);

            //executa o comando e guarda o resultado da consulta
            //o resultado é semelhante a uma grade
            resultado = comando.executeQuery();

            while (resultado.next()) {
                Produto produto = new Produto();

                produto.setIdProduto(resultado.getInt("idProduto"));
                produto.setNome(resultado.getString("nome"));
                produto.setEstoque(resultado.getInt("estoque"));
                produto.setPreco(resultado.getDouble("preco"));

                byte[] bytes = resultado.getBytes("imagem");

                if (bytes != null) {

                    ByteArrayInputStream bis = new ByteArrayInputStream(bytes);

                    BufferedImage imagem = ImageIO.read(bis);

                    produto.setImagem(new ImageIcon(imagem));
                }

                lista.add(produto);

            }

        } catch (SQLException | IOException e) {
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
