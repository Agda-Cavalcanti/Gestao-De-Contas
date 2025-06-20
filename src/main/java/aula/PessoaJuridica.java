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
public class PessoaJuridica extends Pessoa{
    private int cnpj;
    PessoaJuridica(String nome, ArrayList<Conta> listacontas, int cnpj){
        super(nome, listacontas);
        this.cnpj = cnpj;
    }
    public int getCnpj(){
        return this.cnpj;
    }
    
    public void setCnpj(int cnpj){
        this.cnpj = cnpj;
    }
}
