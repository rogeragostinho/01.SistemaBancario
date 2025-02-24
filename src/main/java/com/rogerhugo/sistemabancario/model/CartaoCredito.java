package main.java.com.rogerhugo.sistemabancario.model;

public class CartaoCredito extends Cartao
{
    private double limitePreAprovado;

    public CartaoCredito(int numero, String dataEmissao)
    {
        super(numero, dataEmissao);
    }
}
