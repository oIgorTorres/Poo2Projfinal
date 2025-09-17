
package model;


public class ItemVenda {
    private double precoTotal;
    private double precoUnitario;
    private int quantidadeProduto;
    private int fkIdVenda;
    private int fkIdProduto;

    public int getFkIdVenda() {
        return fkIdVenda;
    }

    public void setFkIdVenda(int fkIdVenda) {
        this.fkIdVenda = fkIdVenda;
    }

    public int getFkIdProduto() {
        return fkIdProduto;
    }

    public void setFkIdProduto(int fkIdProduto) {
        this.fkIdProduto = fkIdProduto;
    }
    

    public double getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(double precoTotal) {
        this.precoTotal = precoTotal;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public int getQuantidadeProduto() {
        return quantidadeProduto;
    }

    public void setQuantidadeProduto(int quantidadeProduto) {
        this.quantidadeProduto = quantidadeProduto;
    }
    
    
}
