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
public abstract class Pessoa {
    private String nome;
    private ArrayList<Conta> listacontas;
    public Pessoa(String nome, ArrayList<Conta> listacontas){
        this. = -;
        this.listacontas =  listacontas;
    }
    public ArrayList getListaContas(){
        return this.listacontas;
    }
    public void setListaContas(Conta conta){
        this.listacontas.add(conta);
    }
    
}
