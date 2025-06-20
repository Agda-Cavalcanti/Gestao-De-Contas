package aula;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContaPoupancaTest {

    private ContaPoupanca conta;
    private Agencia agencia;

    @BeforeEach
    public void setUp() {
        agencia = new Agencia(2);
        conta = new ContaPoupanca(202, 0.05, agencia); // 5% de rendimento
    }

    @Test
    public void testCriacaoContaPoupanca() {
        assertEquals(202, conta.getNumero());
        assertEquals(agencia, conta.getAgencia());
        assertEquals(0.05, conta.getRendimento());
        assertEquals(0.0, conta.getSaldo());
    }

    @Test
    public void testSetRendimento() {
        conta.setRendimento(0.10); // atualizando para 10%
        assertEquals(0.10, conta.getRendimento());
    }

    @Test
    public void testDepositoECalculoDeSaldo() {
        conta.depositar(1000.0);
        assertEquals(1000.0, conta.getSaldo());
    }

    @Test
    public void testSaque() {
        conta.depositar(1000.0);
        conta.sacar(250.0);
        assertEquals(750.0, conta.getSaldo());
    }
}
