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
public abstract class Conta implements OperacaoBancaria {
    private int numero;
    private double saldo = 0;
    private Agencia agencia;
    
    public Conta(int numero, Agencia agencia){
        this.numero = numero;
        this.agencia = agencia;
    }
    
    
    public double getSaldo(){
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public int getNumero() {
        return numero;
    }
    public Agencia getAgencia() {
        return agencia;
    }

    public void setAgencia(Agencia agencia) {
        this.agencia = agencia;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void depositar(double valor){
        this.saldo = this.saldo + valor;
    }
    public void sacar(double valor){
        if (this.saldo >= valor){
            this.saldo = this.saldo - valor; 
        }          
    }
}
