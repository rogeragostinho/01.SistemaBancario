package main.java.com.rogerhugo.sistemabancario.model;

public abstract class Conta
{
    private int numeroConta; // automatico
    private Cliente cliente;
    private String dataCriacao; // automatico
    private double saldo;
    private CartaoDebito cartaoDebito;

    public Conta(int numeroConta, Cliente cliente, CartaoDebito cartaoDebito)
    {
        this.numeroConta = numeroConta;
        this.cliente = cliente;
        this.cartaoDebito = cartaoDebito;
    }

    @Override
    public String toString()
    {
        return "Conta{" +
                "numeroConta=" + numeroConta +
                ", cliente=" + cliente +
                ", dataCriacao='" + dataCriacao + '\'' +
                ", saldo=" + saldo +
                ", cartaoDebito=" + cartaoDebito +
                '}';
    }

    public boolean retirarValor(double valor)
    {
        if(valor > this.saldo || valor == 0) return false;

        this.saldo -= valor;
        return true;
    }

    public boolean depositarValor(double valor)
    {
        if(valor <= 0) return false;

        this.saldo += valor;
        return true;
    }
    
    public int getNumeroConta()
    {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta)
    {
        this.numeroConta = numeroConta;
    }

    public Cliente getCliente()
    {
        return cliente;
    }

    public void setCliente(Cliente cliente)
    {
        this.cliente = cliente;
    }

    public String getDataCriacao()
    {
        return dataCriacao;
    }

    public void setDataCriacao(String dataCriacao)
    {
        this.dataCriacao = dataCriacao;
    }

    public double getSaldo()
    {
        return saldo;
    }

    public void setSaldo(double saldo)
    {
        this.saldo = saldo;
    }

    public CartaoDebito getCartaoDebito()
    {
        return cartaoDebito;
    }

    public void setCartaoDebito(CartaoDebito cartaoDebito)
    {
        this.cartaoDebito = cartaoDebito;
    }
}
