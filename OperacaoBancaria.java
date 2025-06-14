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
public interface OperacaoBancaria {
    public void depositar(double valor);   
    public int sacar(double valor);
    public void imprimir();    
}
