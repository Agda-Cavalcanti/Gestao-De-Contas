package aula;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class PessoaJuridicaTest {

    private String nomeEmpresaPadrao;
    private int cnpjValidoInt;
    private Agencia agenciaPadrao;
    private Conta contaPadrao;

    @BeforeEach
    public void setUp() {
        nomeEmpresaPadrao = "Empresa ABC Ltda.";
        cnpjValidoInt = 123456789; // Exemplo de CNPJ que cabe em int
        agenciaPadrao = new Agencia(1);
        contaPadrao = new ContaCorrente(10, 5000.0, agenciaPadrao);
    }

    @Test
    public void testCriacaoPessoaJuridicaComSucesso() {
        ArrayList<Conta> contas = new ArrayList<>();
        contas.add(contaPadrao);
        PessoaJuridica pessoa = new PessoaJuridica(nomeEmpresaPadrao, contas, cnpjValidoInt);

        assertEquals(1, pessoa.getListaContas().size());
        assertTrue(pessoa.getListaContas().contains(contaPadrao));
        assertEquals(cnpjValidoInt, pessoa.getCnpj());
    }

    @Test
    public void testSetCnpj() {
        ArrayList<Conta> contas = new ArrayList<>();
        // Correção aqui: De 'PessoaEmpresaPadrao' para 'PessoaJuridica'
        PessoaJuridica pessoa = new PessoaJuridica(nomeEmpresaPadrao, contas, 99887766);

        int novoCnpj = 11223344;
        pessoa.setCnpj(novoCnpj);
        assertEquals(novoCnpj, pessoa.getCnpj());
    }

    @Test
    public void testSetListaContasAdicionaConta() {
        ArrayList<Conta> contasIniciais = new ArrayList<>();
        PessoaJuridica pessoa = new PessoaJuridica(nomeEmpresaPadrao, contasIniciais, cnpjValidoInt);

        assertEquals(0, pessoa.getListaContas().size());

        Conta outraConta = new ContaPoupanca(20, 0.03, agenciaPadrao);
        pessoa.setListaContas(contaPadrao);
        pessoa.setListaContas(outraConta);

        assertEquals(2, pessoa.getListaContas().size());
        assertTrue(pessoa.getListaContas().contains(contaPadrao));
        assertTrue(pessoa.getListaContas().contains(outraConta));
    }

    @Test
    public void testGetListaContasRetornaListaCorreta() {
        ArrayList<Conta> contas = new ArrayList<>();
        contas.add(contaPadrao);
        PessoaJuridica pessoa = new PessoaJuridica(nomeEmpresaPadrao, contas, cnpjValidoInt);

        ArrayList<Conta> listaRetornada = pessoa.getListaContas();
        assertEquals(1, listaRetornada.size());
        assertTrue(listaRetornada.contains(contaPadrao));
    }
}