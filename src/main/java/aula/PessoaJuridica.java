package aula;

import java.util.ArrayList;

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