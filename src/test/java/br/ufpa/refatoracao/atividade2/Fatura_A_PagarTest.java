package br.ufpa.refatoracao.atividade2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by gilson on 11/08/15.
 */
public class Fatura_A_PagarTest {

    private Fatura_A_Pagar faturaAPagar;

    @Before
    public void setUp() throws Exception {
        faturaAPagar = new Fatura_A_Pagar();
    }

    @Test
    public void testCalcularValorConta() throws Exception {
        assertEquals(21D, faturaAPagar.calcularValorConta(1, 1, 2015, 0.1D, 10D), 0D);
        assertEquals(107D, faturaAPagar.calcularValorConta(11, 8, 2015, 0.05D, 100D), 0D);
        assertEquals(1015D, faturaAPagar.calcularValorConta(1, 8, 2015, 0.01D, 1000D), 0D);
        assertEquals(10397D, faturaAPagar.calcularValorConta(7, 1, 2015, 0.05D, 9900D), 0D);
    }
}