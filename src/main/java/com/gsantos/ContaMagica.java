package com.gsantos;

public class ContaMagica {
    public static final int SILVER = 0;
    public static final int GOLD = 1;
    public static final int PLATINUM = 2;
    
    private static double  saldo;
    private static int status;
    
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
	
    void deposito(int valor) throws INVALID_OPER_EXCEPTION{
        if (valor <= 0){
            throw new INVALID_OPER_EXCEPTION("Nao e possivel depositar valores >= 0");
        }
    }

    void retirada(int valor) throws INVALID_OPER_EXCEPTION{

    }
}
