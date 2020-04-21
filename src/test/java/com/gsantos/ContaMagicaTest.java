package com.gsantos;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceLock;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

//import org.junit.jupiter.*;
//import org.omg.CORBA.INITIALIZE;

/**
 * Unit test for simple App.
 */
public class ContaMagicaTest
{
    private ContaMagica c;

    @BeforeEach
    public void initialize(){
        c = new ContaMagica();
    }

    @Test
    public void depositoNegativo(){
        try {
            c.deposito(-100);
            fail("Shold show an error");   
        } catch (Exception e) {
            assertEquals("Nao e possivel operar com valores >= 0", e.getMessage());
        }
    }

    @Test
    public void retiradaNegativa(){
        try {
            c.retirada(-100);
            fail("Shold show an error");   
        } catch (Exception e) {
            assertEquals("Nao e possivel operar com valores >= 0", e.getMessage());
        }
    }

    @Test
    public void retiradaMaiorQueSaldo(){
        try {
            c.retirada(100);
            fail("Shold show an error");   
        } catch (Exception e) {
            assertEquals("Nao e possivel retirar valor maior que o saldo presente", e.getMessage());
        }
    }


    @ParameterizedTest
    @CsvSource({
        "500.0, 0",
        "60000.0, 1",
        "300000.0, 1"
    })
    public void transicaoSilverDeposito(double valor, int estado) throws INVALID_OPER_EXCEPTION{
        c.deposito(valor);            

        assertEquals(estado, c.getStatus());
    }

    @ParameterizedTest
    @CsvSource({
        "500.0, 1",
        "200000.0, 2",
    })
    public void transicaoGoldDeposito(double valor, int estado) throws INVALID_OPER_EXCEPTION{
        // Deposito para ir para gold
        c.deposito(60000);

        c.deposito(valor);

        assertEquals(estado, c.getStatus());
    }

    @ParameterizedTest
    @CsvSource({
        "100000, 2",
        "150000, 1",
        "200000, 1",
    })
    public void transicaoPlatinumRetirada(double valor, int estado) throws INVALID_OPER_EXCEPTION{
        // Deposito para ir para platinum
        c.deposito(60000);
        c.deposito(150000);

        c.retirada(valor);

        assertEquals(estado, c.getStatus());
    }

    @ParameterizedTest
    @CsvSource({
        "150, 1",
        "50000, 0",
    })
    public void transicaoGoldRetirada(double valor, int estado) throws INVALID_OPER_EXCEPTION{
        // Deposito para ir para platinum
        c.deposito(60000);

        c.retirada(valor);

        assertEquals(estado, c.getStatus());
    }

    @Test
    public void bonusDepositoGold() throws INVALID_OPER_EXCEPTION{
        c.deposito(60000);
        c.deposito(20000);

        double saldoEsperado = 60000 + (20000 * 1.1);

        assertEquals(saldoEsperado, c.getSaldo());
    }

    @Test
    public void bonusDepositoPlatinum() throws INVALID_OPER_EXCEPTION{
        c.deposito(60000);
        c.deposito(150000);

        System.out.println(c.getSaldo());
        // Saldo ate chegar no Platinum
        double saldoEsperado = 60000 + (150000 * 1.1);

        c.deposito(50000);

        saldoEsperado += (50000 * 1.25);

        assertEquals(saldoEsperado, c.getSaldo());
    }
}
