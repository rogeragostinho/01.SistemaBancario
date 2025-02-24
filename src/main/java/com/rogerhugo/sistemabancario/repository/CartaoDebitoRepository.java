package main.java.com.rogerhugo.sistemabancario.repository;

import main.java.com.rogerhugo.sistemabancario.model.CartaoDebito;

public class CartaoDebitoRepository
{
    private CartaoDebito[] cartoesDebito;
    private int quantidade;

    public CartaoDebitoRepository(int capacidade)
    {
        this.cartoesDebito = new CartaoDebito[capacidade];
        this.quantidade = 0;
    }
}
