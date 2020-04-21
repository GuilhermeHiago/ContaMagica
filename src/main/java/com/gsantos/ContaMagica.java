package com.gsantos;

public class ContaMagica {
    public static final int SILVER = 0;
    public static final int GOLD = 1;
    public static final int PLATINUM = 2;
    
    private static double saldo;
    private static int status;
    
    public ContaMagica(){
        saldo = 0;
        status = SILVER;
    }

    double getSaldo(){
        return saldo;
    }
	
    int getStatus(){
        switch(status){
            case PLATINUM:
                return PLATINUM;
            case GOLD:
                return GOLD;
            default:
                return SILVER;
        }
    }
	
    void deposito(double valor) throws INVALID_OPER_EXCEPTION{
        if (valor <= 0){
            throw new INVALID_OPER_EXCEPTION("Nao e possivel operar com valores >= 0");
        }

        switch(status){
            case PLATINUM:
                saldo += valor * 1.25;
            case GOLD:
                saldo += valor * 1.1;
                status = (saldo > 200000) ? GOLD : SILVER;
            default:
                saldo += valor;
                status = (saldo > 50000) ? GOLD : SILVER;
        }

    }

    void retirada(double valor) throws INVALID_OPER_EXCEPTION{
        if (valor <= 0){
            throw new INVALID_OPER_EXCEPTION("Nao e possivel operar com valores >= 0");
        }

        switch(status){
            case PLATINUM:
                saldo -= valor;
                status = (saldo < 100000) ? SILVER : GOLD;
            case GOLD:
                saldo -= valor;
                status = (saldo < 25000) ? SILVER : GOLD;
            default:
                saldo -= valor;
        }
    }
}
