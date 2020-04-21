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
        return status;
    }
	
    void deposito(double valor) throws INVALID_OPER_EXCEPTION{
        if (valor <= 0){
            throw new INVALID_OPER_EXCEPTION("Nao e possivel operar com valores >= 0");
        }

        switch(status){
            case PLATINUM:
                saldo += valor * 1.25;
                break;
            case GOLD:
                saldo += valor * 1.1;
                status = (saldo > 200000) ? PLATINUM : GOLD;
                break;
            default:
                saldo += valor;
                status = (saldo > 50000) ? GOLD : SILVER;
        }

    }

    void retirada(double valor) throws INVALID_OPER_EXCEPTION{
        if (valor <= 0){
            throw new INVALID_OPER_EXCEPTION("Nao e possivel operar com valores >= 0");
        }
        else if(valor > saldo){
            throw new INVALID_OPER_EXCEPTION("Nao e possivel retirar valor maior que o saldo presente");
        }

        switch(status){
            case PLATINUM:
                saldo -= valor;
                status = (saldo < 100000) ? GOLD : PLATINUM;
                break;
            case GOLD:
                saldo -= valor;
                status = (saldo < 25000) ? SILVER : GOLD;
                break;
            default:
                saldo -= valor;
        }
    }
}
