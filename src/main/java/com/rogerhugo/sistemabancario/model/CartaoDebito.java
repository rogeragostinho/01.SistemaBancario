package main.java.com.rogerhugo.sistemabancario.model;

public class CartaoDebito extends Cartao
{
    private double limiteSaque;
    private double limiteTransferencia;

    public CartaoDebito(int numero, String dataEmissao)
    {
        super(numero, dataEmissao);
    }
}
