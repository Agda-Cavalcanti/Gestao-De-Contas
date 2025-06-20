package aula;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.github.stefanbirkner.systemlambda.SystemLambda;

public class ContaCorrenteTest {

    private ContaCorrente conta;
    private Agencia agencia;

    @BeforeEach
    public void setUp() {
        agencia = new Agencia(1);
        conta = new ContaCorrente(101, 3000.0, agencia);
    }

    @Test
    public void testCriacaoContaCorrente() {
        assertEquals(101, conta.getNumero());
        assertEquals(agencia, conta.getAgencia());
        assertEquals(3000.0, conta.getSalario());
        assertEquals(0.0, conta.getSaldo());
    }

    @Test
    public void testDepositoEAtualizacaoSaldo() {
        conta.depositar(500.0);
        assertEquals(500.0, conta.getSaldo());
    }

    @Test
    public void testSaque() {
        conta.depositar(1000.0);
        conta.sacar(200.0);
        assertEquals(800.0, conta.getSaldo());
    }

    @Test
    public void testSetSalario() {
        conta.setSalario(4500);
        assertEquals(4500.0, conta.getSalario());
    }

    @Test
    public void testSetSalarioParaZero() {
        conta.setSalario(0);
        assertEquals(0.0, conta.getSalario());
    }

    @Test
    public void testSetSalarioNegativo() {
        conta.setSalario(-100);
        assertEquals(-100.0, conta.getSalario());
    }

    @Test
    public void testCriacaoContaCorrenteComSalarioNegativo() {
        ContaCorrente contaNegativa = new ContaCorrente(102, -500.0, agencia);
        assertEquals(-500.0, contaNegativa.getSalario());
    }

    @Test
    public void testImprimirSaidaCorreta() throws Exception {
        conta.setSalario(5000);
        String output = SystemLambda.tapSystemOut(() -> {
            conta.imprimir();
        });
        String expectedOutput = "Seu salário é : 5000.0".trim();
        assertTrue(output.trim().contains(expectedOutput));
    }
}