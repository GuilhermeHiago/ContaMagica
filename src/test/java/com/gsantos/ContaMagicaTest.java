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

    @ParameterizedTest
    @CsvSource({
        "500, 0",
        "60000, 1"
    })
    public void transicaoSilver(double valor, int estado) throws INVALID_OPER_EXCEPTION{
        c.deposito(valor);
        assertEquals(estado, c.getStatus());
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
}
