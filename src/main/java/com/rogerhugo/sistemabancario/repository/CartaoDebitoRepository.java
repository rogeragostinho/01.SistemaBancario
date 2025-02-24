package main.java.com.rogerhugo.sistemabancario.repository;

import main.java.com.rogerhugo.sistemabancario.model.CartaoDebito;

import java.util.Arrays;

public class CartaoDebitoRepository
{
    private CartaoDebito[] cartoesDebito;
    private int quantidade;

    public CartaoDebitoRepository(int capacidade)
    {
        this.cartoesDebito = new CartaoDebito[capacidade];
        this.quantidade = 0;

        CartaoDebito cartao;
        for(int i = 0; i < capacidade; i++)
        {
            cartao = new CartaoDebito(i+1, "23/02/2025");
            this.addCartao(cartao);
        }
    }

    @Override
    public String toString()
    {
        return "CartaoDebitoRepository{" +
                "cartoesDebito=" + Arrays.toString(cartoesDebito) +
                ", quantidade=" + quantidade +
                '}';
    }

    public void addCartao(CartaoDebito cartao)
    {
        this.cartoesDebito[quantidade] = cartao;
        this.quantidade++;
    }

    public CartaoDebito pegarCartao()
    {
        CartaoDebito cartao;
        for (int i = 0; i < this.quantidade; i++)
            if (this.cartoesDebito[i] != null)
            {
                cartao = this.cartoesDebito[i];
                this.cartoesDebito[i] = null;
                quantidade--;
                return cartao;
            }
        return null;
    }

    public int getNextNumeroCartao()
    {
        // ajustar codigo quando implementar lista
        if(this.quantidade == 0) return 1;

        return this.cartoesDebito[this.quantidade-1].getNumero() + 1;
    }
}
