package aula;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ContaTest {

    private Conta conta;
    private Agencia agencia;

    @BeforeEach
    public void setUp() {
        agencia = new Agencia(1);
        // Cria uma classe anônima para testar a classe abstrata Conta
        conta = new Conta(123, agencia) {
            @Override
            public void imprimir() {
            }
        };
    }

    @Test
    public void testCriacaoConta() {
        assertEquals(123, conta.getNumero(), "O número da conta deve ser 123 na criação.");
        assertEquals(agencia, conta.getAgencia(), "A agência deve ser a agência fornecida na criação.");
        assertEquals(0.0, conta.getSaldo(), "O saldo inicial da conta deve ser 0.0.");
    }

    @Test
    public void testDeposito() {
        conta.depositar(200.0);
        assertEquals(200.0, conta.getSaldo(), "O saldo deve ser 200.0 após um depósito de 200.0.");
    }

    @Test
    public void testDepositoComMultiplosValores() {
        conta.depositar(100.0);
        conta.depositar(50.0);
        assertEquals(150.0, conta.getSaldo(), "O saldo deve ser 150.0 após múltiplos depósitos.");
    }

    @Test
    public void testDepositoDeValorZero() {
        conta.depositar(0.0);
        assertEquals(0.0, conta.getSaldo(), "O saldo deve permanecer 0.0 após um depósito de 0.0.");
    }

    @Test
    public void testDepositoDeValorNegativo() {
        double saldoInicial = conta.getSaldo();
        conta.depositar(-50.0);
        assertEquals(saldoInicial - 50.0, conta.getSaldo(), "O saldo deve diminuir se valor negativo for depositado (sem validação na classe).");
    }


    @Test
    public void testSaqueComSaldoSuficiente() {
        conta.depositar(300.0);
        conta.sacar(100.0);
        assertEquals(200.0, conta.getSaldo(), "O saldo deve ser 200.0 após saque de 100.0 de um saldo de 300.0.");
    }

    @Test
    public void testSaqueDeValorZero() {
        conta.depositar(100.0);
        conta.sacar(0.0);
        assertEquals(100.0, conta.getSaldo(), "O saldo deve permanecer o mesmo após saque de 0.0.");
    }

    @Test
    public void testSaqueDeValorNegativo() {
        conta.depositar(100.0);
        conta.sacar(-50.0);
        assertEquals(150.0, conta.getSaldo(), "O saldo deve aumentar se valor negativo for sacado (sem validação na classe).");
    }

    @Test
    public void testSaqueComSaldoExato() {
        conta.depositar(100.0);
        conta.sacar(100.0);
        assertEquals(0.0, conta.getSaldo(), "O saldo deve ser 0.0 após sacar o valor exato do saldo.");
    }

    @Test
    public void testSaqueComSaldoInsuficiente() {
        conta.depositar(100.0);
        conta.sacar(200.0);
        assertEquals(100.0, conta.getSaldo(), "O saldo deve permanecer o mesmo se o saque for maior que o saldo.");
    }

    @Test
    public void testMultiplasOperacoesDepositoSaque() {
        conta.depositar(500.0);
        conta.sacar(100.0);
        conta.depositar(200.0);
        conta.sacar(600.0);
        assertEquals(0.0, conta.getSaldo(), "O saldo final deve ser 0.0 após uma sequência de operações.");
    }

    @Test
    public void testSetters() {
        conta.setNumero(999);
        conta.setSaldo(1000.0);
        Agencia novaAgencia = new Agencia(2);
        conta.setAgencia(novaAgencia);

        assertEquals(999, conta.getNumero(), "O número da conta deve ser atualizado corretamente.");
        assertEquals(1000.0, conta.getSaldo(), "O saldo deve ser atualizado corretamente.");
        assertEquals(novaAgencia, conta.getAgencia(), "A agência deve ser atualizada corretamente.");
    }
}