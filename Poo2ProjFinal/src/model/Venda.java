
package model;

import java.util.Date;


public class Venda {
    private Date dataVenda;
    private double valorTotal;
    private int fkIdVendedor;
    private int fkIdCliente;

    public int getFkIdVendedor() {
        return fkIdVendedor;
    }

    public void setFkIdVendedor(int fkIdVendedor) {
        this.fkIdVendedor = fkIdVendedor;
    }

    public int getFkIdCliente() {
        return fkIdCliente;
    }

    public void setFkIdCliente(int fkIdCliente) {
        this.fkIdCliente = fkIdCliente;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
    
    
    
}
