package main.java.com.rogerhugo.sistemabancario.model;

// Ainda em desuso
public class CartaoCredito extends Cartao
{
    private double limitePreAprovado;

    public CartaoCredito(int numero, String dataEmissao)
    {
        super(numero, dataEmissao);
    }
}
