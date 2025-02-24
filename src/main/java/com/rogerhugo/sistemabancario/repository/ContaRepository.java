package main.java.com.rogerhugo.sistemabancario.repository;

import main.java.com.rogerhugo.sistemabancario.model.Conta;

import java.util.Arrays;

public class ContaRepository
{
    private Conta[] contas;
    private int quantidade;

    public ContaRepository(int capacidade)
    {
        this.contas = new Conta[capacidade];
        this.quantidade = 0;
    }

    @Override
    public String toString()
    {
        return "ContaRepository{" +
                "contas=" + Arrays.toString(contas) +
                ", quantidade=" + quantidade +
                '}';
    }

    public void addConta(Conta conta)
    {
        this.contas[this.quantidade] = conta;
        this.quantidade++;
    }

    public Conta getConta(int numeroConta)
    {
        for(Conta conta: this.contas)
        {
            if(conta != null)
                if(conta.getNumeroConta() == numeroConta)
                    return conta;
        }
        return null;
    }

    public Conta getContaPeloNumeroCartao(int numeroCartao)
    {
        for(Conta conta: this.contas)
        {
            if(conta != null)
                if(conta.getCartaoDebito().getNumero() == numeroCartao)
                    return conta;
        }
        return null;
    }

    public int getNextNumeroConta()
    {
        if(this.quantidade == 0) return 1;

        return this.contas[this.quantidade-1].getNumeroConta() + 1;
    }
}
