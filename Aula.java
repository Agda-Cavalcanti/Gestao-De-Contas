package aula;
/**
 * 
 * @author samara
 */
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Aula {
    public static void main(String[] args) {
        /**
        *   Sistem de controle bancário
        *   Classe conta
        */
        Scanner entrada = new Scanner(System.in);
        Random random = new Random();
        String nome;
        int cnpj, cpf, tipoConta, tipoConta2, numAgencia;
        PessoaJuridica p1;
        PessoaFisica p2;
        ContaCorrente c1;
        ContaPoupanca c2;
        double salario, rendimento, valor;
        ArrayList<Conta> listaContas = new ArrayList();
        
        /**
        *   Criando 3 Agências e escolhendo
        */               
        Agencia ag1 = new Agencia(1);
        Agencia ag2 = new Agencia(2); 
        Agencia ag3 = new Agencia(3);
        Agencia escolhaAgencia;
        
        System.out.println("Informe qual a agencia você deseja criar conta. Agencias dísponíveis: 1, 2 e 3");
        numAgencia = entrada.nextInt();
        if (numAgencia ==1)
            escolhaAgencia = ag1;
        else if (numAgencia ==2)
            escolhaAgencia = ag2;
        else
            escolhaAgencia = ag3;
                
        System.out.println("Informe o nome da Pessoa: ");
        nome = entrada.next();
        
        System.out.println("Deseja criar a conta para pessoa jurídica ou física: \n Digite \n 1: Juridica e \n 2: Física");
        int opcao = entrada.nextInt();
        
        switch (opcao){
            case 1:
                System.out.println("Informe o cnpj: ");
                cnpj = entrada.nextInt();
                p1 = new PessoaJuridica(nome, listaContas, cnpj);
                
                System.out.println("Deseja criar conta corrente? Digite 1- sim e 2- Não");
                tipoConta = entrada.nextInt();
                if (tipoConta==1){
                    System.out.println("Informe o salario: ");
                    salario = entrada.nextDouble();
                    c1 = new ContaCorrente(random.nextInt(100), salario, escolhaAgencia);
                    p1.setListaContas(c1);
                    System.out.println("O numero da sua conta é: "+c1.getNumero());
                    System.out.println("O numero da sua agencia é: "+c1.getAgencia().getNumero());
                }
                
                System.out.println("Deseja criar conta poupança? Digite 1- sim e 2- Não");
                tipoConta2 = entrada.nextInt();
                if (tipoConta2==1){
                    System.out.println("Informe o rendimento: ");
                    rendimento = entrada.nextDouble();
                    c2 = new ContaPoupanca(random.nextInt(100), rendimento, escolhaAgencia);
                    p1.setListaContas(c2);
                    System.out.println("O numero da sua conta é: "+c2.getNumero());
                    System.out.println("O numero da sua agencia é: "+c2.getAgencia().getNumero());
                }                
                break;
            case 2: 
                System.out.println("Informe o cpf: ");
                cpf = entrada.nextInt();
                p2 = new PessoaFisica(nome, listaContas, cpf);
                
                System.out.println("Deseja criar conta corrente? Digite 1- sim e 2- Não");
                tipoConta = entrada.nextInt();
                if (tipoConta==1){
                    System.out.println("Informe o salario: ");
                    salario = entrada.nextDouble();
                    c1 = new ContaCorrente(random.nextInt(100), salario, escolhaAgencia);
                    p2.setListaContas(c1);
                    System.out.println("O numero da sua conta é: "+c1.getNumero());
                    System.out.println("O numero da sua agencia é: "+c1.getAgencia().getNumero());
                }
                
                System.out.println("Deseja criar conta poupança? Digite 1- sim e 2- Não");
                tipoConta2 = entrada.nextInt();
                if (tipoConta2==1){
                    System.out.println("Informe o rendimento: ");
                    rendimento = entrada.nextDouble();
                    c2 = new ContaPoupanca(random.nextInt(100), rendimento, escolhaAgencia);
                    p2.setListaContas(c2);
                    System.out.println("O numero da sua conta é: "+c2.getNumero());
                    System.out.println("O numero da sua agencia é: "+c2.getAgencia().getNumero());
                }
                break;
        }        
    }    
}
