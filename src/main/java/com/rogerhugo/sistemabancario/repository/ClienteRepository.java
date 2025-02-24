package main.java.com.rogerhugo.sistemabancario.repository;

import main.java.com.rogerhugo.sistemabancario.model.Cliente;

import java.util.Arrays;

public class ClienteRepository
{
    private Cliente[] clientes;
    private int quantidade;

    public ClienteRepository(int capacidade)
    {
        this.clientes = new Cliente[capacidade];
        this.quantidade = 0;
    }

    @Override
    public String toString()
    {
        return "ClienteRepository{" +
                "clientes=" + Arrays.toString(clientes) +
                ", quantidade=" + quantidade +
                '}';
    }

    public Cliente procurarClintePeloNumeroIdentificacao(String numeroIdentificacao)
    {
        for(Cliente cliente: this.clientes)
            if(cliente != null)
                if(cliente.getIdentificacao().getNumero().equals(numeroIdentificacao))
                    return cliente;
        return null;
    }

    public void addCliente(Cliente cliente)
    {
        this.clientes[this.quantidade] = cliente;
        this.quantidade++;
    }

    //public int getNextNumero
}
