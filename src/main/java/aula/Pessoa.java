package aula;

import java.util.ArrayList;

public abstract class Pessoa {
    private String nome;
    private ArrayList<Conta> listacontas;

    public Pessoa(String nome, ArrayList<Conta> listacontas){
        this.nome = nome;
        this.listacontas =  listacontas;
    }

    public String getNome(){
        return this.nome;
    }

    public ArrayList<Conta> getListaContas(){
        return this.listacontas;
    }

    public void setListaContas(Conta conta){
        this.listacontas.add(conta);
    }
}