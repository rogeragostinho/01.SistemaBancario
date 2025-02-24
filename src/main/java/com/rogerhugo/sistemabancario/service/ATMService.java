package main.java.com.rogerhugo.sistemabancario.service;

import main.java.com.rogerhugo.sistemabancario.model.Conta;

public class ATMService
{
    private static Conta conta;

    public static void iniciarSesao(int numeroCartao, int pin)
    {
        Conta conta = BancoService.getRepositorioContas().getContaPeloNumeroCartao(numeroCartao);
        if(conta == null)
        {
            System.out.println("Cartao invalido");
            return;
        }

        if(!(conta.getCartaoDebito().verificarPin(pin)))
        {
            System.out.println("Pin incorreto");
            return;
        }

        ATMService.setConta(conta);

        System.out.println("Conta acessada");
    }

    public static void consultarSaldo()
    {
        System.out.println("Saldo: " + ATMService.conta.getSaldo());
    }

    public static void levantarValores(double valor)
    {
        if(valor > ATMService.conta.getSaldo())
        {
            System.out.println("Saldo insuficiente");
            return;
        }

        conta.retirarValor(valor);

        System.out.println("Levantamento feito");
    }

    public static void fazerTransferencia(int numeroContaDestino, double valor)
    {
        Conta contaDestino = BancoService.getRepositorioContas().getConta(numeroContaDestino);
        if(contaDestino == null)
        {
            System.out.println("Conta de destino inexistente");
            return;
        }

        ATMService.conta.retirarValor(valor);
        contaDestino.setSaldo(valor);

        System.out.println("Transferencia feita");
    }

    public static void fecharSessao()
    {
        ATMService.conta = null;
    }

    public static void setConta(Conta conta)
    {
        ATMService.conta = conta;
    }
}
