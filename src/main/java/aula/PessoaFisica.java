package aula;

import java.util.ArrayList;

public class PessoaFisica extends Pessoa{
    private int cpf;

    PessoaFisica(String nome, ArrayList<Conta> listacontas, int cpf){
        super(nome, listacontas);
        this.cpf = cpf;
    }

    public int getCpf(){
        return cpf;
    }

    public void setCpf(int cpf){
        this.cpf = cpf;
    }
}