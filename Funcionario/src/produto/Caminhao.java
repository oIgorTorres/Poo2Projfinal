/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package produto;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aluno.saolucas
 */
public class Caminhao {

    private List<Caixa> carga;
    private double volumeMaximo;

    public Caminhao(double volumeMaximo) {
        carga = new ArrayList();
        this.volumeMaximo = volumeMaximo;
    }

    public boolean adicionarCaixa(Caixa caixa) {
        if (carga.size() <= 100) {
            carga.add(caixa);
            return true;
        }
        return false;
    }

    public boolean buscaCaixa(String codRastreio) {
        for (Caixa caixa : carga) {
            if (caixa.getCodRastreio().equals(codRastreio)) {
                return true;
            }
        }
        return false;
    }

    public boolean removerCaixa(String codRastreio) {
        for (Caixa caixa : carga) {
            if (caixa.getCodRastreio().equals(codRastreio)) {
                carga.remove(caixa);
                return true;
            }
        }
        return false;
    }

    public double calcularTotalCarga() {
        double valorTotal = 0.0;
        for (Caixa caixa : carga) {
            if (caixa.getItem() != null) {
                valorTotal += caixa.getItem().getPreco();
            }
        }
        return valorTotal;
    }

}
