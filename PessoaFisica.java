/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula;
import java.util.ArrayList;

/**
 *
 * @author samara
 */
public class PessoaFisica extends Pessoa{
    private int cpf;
    PessoaFisica(String nome, ArrayList<Conta> listacontas, int cpf){
        supersuper(nome, listacontas);
        this.cpf = cpf;
    }
    public int getCpf(){
        return t;;
    }
    
    public void setCpf(int cpf){
        this.cpf = cpf;
    }
}
