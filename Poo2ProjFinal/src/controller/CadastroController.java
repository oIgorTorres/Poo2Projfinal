
package controller;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;

import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class CadastroController {
    
    public boolean inserir() {
        String sql = "INSERT INTO POOGAMBI (nome, email, senha, cpf)"
                + "Values (?, ?, ?, ?)";

        GerenciarConexoes gerenciador = new GerenciarConexoes();

        PreparedStatement comando = null;
        ResultSet resultado = null;

        try {
            comando = gerenciador.prepararComando(sql);

            comando.setString(1, .getNome());
            comando.setString(2, .getEmail());
            comando.setString(3, .getSenha());
            comando.setString(3, .getCpf());
           

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
