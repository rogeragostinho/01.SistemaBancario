package main.java.com.rogerhugo.sistemabancario.model;

public class CartaoDebito extends Cartao
{
    private final static double LIMITE_SAQUE;
    private final static double LIMITE_TRANSFERENCIA;

    static
    {
        // ainda em desuso
        LIMITE_SAQUE = 100000;
        LIMITE_TRANSFERENCIA = 1000000;
    }

    public CartaoDebito(int numero, String dataEmissao)
    {
        super(numero, dataEmissao);
    }
}
