/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funcionario;

/**
 *
 * @author aluno.saolucas
 */
public class Funcionario {

    private String nome;
    private double valor_hora;
    private int horas;
    
    public Funcionario(String n, double v, int h){
            nome = n;
            valor_hora = v;
            horas = h;
            }
   
    public String getNome(){
            return nome;
    }

    public double getValor_hora() {
        return valor_hora;
    }

    public int getHoras() {
        return horas;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setValor_hora(double valor_hora) {
        this.valor_hora = valor_hora;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }
    
    @Override
    public String toString(){
        return "Funcionário: "+nome+"\nvalor da hora: "+valor_hora+"\nQuantidade de horas trabalhadas: "+horas;
    }
    
    public double calcularSalario(){
        double salario = horas*4.5*valor_hora;
        return salario;
    }
    
    
            
    public static void main(String[] args) {
        
        Funcionario funcionario = new Funcionario("José", 50, 40);
        
        
        System.out.println(funcionario.toString());
        System.out.println(funcionario.calcularSalario());

        

        
    }
    
}
