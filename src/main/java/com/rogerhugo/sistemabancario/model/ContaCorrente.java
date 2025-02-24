package main.java.com.rogerhugo.sistemabancario.model;

public class ContaCorrente extends Conta
{
    private double taxaMensalManutencao;
    private CartaoCredito cartaoCredito;

    public ContaCorrente(int numeroConta, Cliente cliente, CartaoDebito cartaoDebito)
    {
        super(numeroConta, cliente, cartaoDebito);
    }
}
