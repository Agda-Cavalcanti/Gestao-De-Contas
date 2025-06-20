package aula;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class PessoaFisicaTest {

    private String nomePadrao;
    private int cpfValidoInt; // Alterado para int
    private Agencia agenciaPadrao;
    private Conta contaPadrao;

    @BeforeEach
    public void setUp() {
        nomePadrao = "João da Silva";
        cpfValidoInt = 123456789; // Exemplo de CPF que cabe em int (9 dígitos)
        agenciaPadrao = new Agencia(1);
        contaPadrao = new ContaCorrente(1, 1000.0, agenciaPadrao);
    }

    @Test
    public void testCriacaoPessoaFisicaComSucesso() {
        ArrayList<Conta> contas = new ArrayList<>();
        contas.add(contaPadrao);
        PessoaFisica pessoa = new PessoaFisica(nomePadrao, contas, cpfValidoInt);

        // Nao podemos testar pessoa.getNome() diretamente, pois nao existe getter publico em Pessoa.
        assertEquals(1, pessoa.getListaContas().size());
        assertTrue(pessoa.getListaContas().contains(contaPadrao));
        assertEquals(cpfValidoInt, pessoa.getCpf());
    }

    @Test
    public void testSetCpf() {
        ArrayList<Conta> contas = new ArrayList<>();
        PessoaFisica pessoa = new PessoaFisica(nomePadrao, contas, 111222333);

        int novoCpf = 987654321;
        pessoa.setCpf(novoCpf);
        assertEquals(novoCpf, pessoa.getCpf());
    }

    @Test
    public void testSetListaContasAdicionaConta() { // Renomeado para refletir o método existente
        ArrayList<Conta> contasIniciais = new ArrayList<>();
        PessoaFisica pessoa = new PessoaFisica(nomePadrao, contasIniciais, cpfValidoInt);

        assertEquals(0, pessoa.getListaContas().size());

        Conta outraConta = new ContaPoupanca(2, 0.05, agenciaPadrao);
        pessoa.setListaContas(contaPadrao); // Usando o método original
        pessoa.setListaContas(outraConta);

        assertEquals(2, pessoa.getListaContas().size());
        assertTrue(pessoa.getListaContas().contains(contaPadrao));
        assertTrue(pessoa.getListaContas().contains(outraConta));
    }

    @Test
    public void testGetListaContasRetornaListaCorreta() {
        ArrayList<Conta> contas = new ArrayList<>();
        contas.add(contaPadrao);
        PessoaFisica pessoa = new PessoaFisica(nomePadrao, contas, cpfValidoInt);

        ArrayList<Conta> listaRetornada = pessoa.getListaContas();
        assertEquals(1, listaRetornada.size());
        assertTrue(listaRetornada.contains(contaPadrao));
    }
}