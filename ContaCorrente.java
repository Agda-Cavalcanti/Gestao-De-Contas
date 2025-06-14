/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula;

/**
 *
 * @author samara
 */
public class ContaCorrente extends Conta{
    private double salario;
    public ContaCorrente(int numero, double salario, Agencia agencia){
        super(numero, agencia);
        this.salario = salario;
    }

    @Override
    public void imprimir() {
        System.out.println("Seu salário é : "+this.salario);
    }
    
    public double getSalario(){
        return this.salario;
    }
    
    public void setSalario(int salario){
        this.salario = salario;
    }       
}
