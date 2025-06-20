package aula;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AgenciaTest {

    @Test
    public void testCriacaoAgencia() {
        // Cenário básico
        Agencia agencia = new Agencia(123);
        assertEquals(123, agencia.getNumero(), "O número da agência deve ser 123 após a criação.");
    }

    @Test
    public void testSetNumero() {
        // Cenário básico de alteração
        Agencia agencia = new Agencia(123);
        agencia.setNumero(456);
        assertEquals(456, agencia.getNumero(), "O número da agência deve ser 456 após a alteração.");
    }

    // --- Novas Sugestões ---

    @Test
    public void testCriacaoAgenciaComNumeroZero() {
        Agencia agencia = new Agencia(0);
        assertEquals(0, agencia.getNumero(), "Deve permitir a criação de agência com número 0.");
    }

    @Test
    public void testCriacaoAgenciaComNumeroGrande() {
        Agencia agencia = new Agencia(999999);
        assertEquals(999999, agencia.getNumero(), "Deve permitir a criação de agência com um número grande.");
    }

    @Test
    public void testSetNumeroParaZero() {
        Agencia agencia = new Agencia(100);
        agencia.setNumero(0);
        assertEquals(0, agencia.getNumero(), "Deve permitir definir o número da agência para 0.");
    }

    @Test
    public void testSetNumeroParaNumeroDiferente() {
        Agencia agencia = new Agencia(100);
        agencia.setNumero(200);
        assertNotEquals(100, agencia.getNumero(), "O número da agência não deve mais ser o valor inicial.");
    }

}