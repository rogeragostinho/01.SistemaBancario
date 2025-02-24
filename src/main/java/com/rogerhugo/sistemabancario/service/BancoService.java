package main.java.com.rogerhugo.sistemabancario.service;

import main.java.com.rogerhugo.sistemabancario.model.*;
import main.java.com.rogerhugo.sistemabancario.repository.CartaoDebitoRepository;
import main.java.com.rogerhugo.sistemabancario.repository.ClienteRepository;
import main.java.com.rogerhugo.sistemabancario.repository.ContaRepository;

public class BancoService
{
    private static ContaRepository repositorioContas;
    private static ClienteRepository repositorioClientes;
    private static CartaoDebitoRepository repositorioCartaoDebito;

    static
    {
        BancoService.repositorioContas = new ContaRepository(10);
        BancoService.repositorioClientes = new ClienteRepository(10);
        BancoService.repositorioCartaoDebito = new CartaoDebitoRepository(10);
    }

    public static void abrirContaCorrente(Cliente cliente, double valor)
    {
        if(valor < 20000)
        {
            System.out.println("Valor insuficiente para abrir uma conta");
            return;
        }

        // adiciona cliente ao repositorio de clientes se este não constar no mesmo
        if(BancoService.repositorioClientes.procurarClintePeloNumeroIdentificacao(cliente.getIdentificacao().getNumero()) == null)
            BancoService.repositorioClientes.addCliente(cliente);

        // criar a logica do cartao
        Conta conta = new ContaCorrente(repositorioContas.getNextNumeroConta(), cliente, BancoService.repositorioCartaoDebito.pegarCartao());
        conta.setSaldo(valor);
        repositorioContas.addConta(conta);
        System.out.println("Conta criada com sucesso");
    }

    public static void abrirContaPoupanca(Cliente cliente, double valor)
    {
        if(valor < 20000)
        {
            System.out.println("Valor insuficiente para abrir uma conta");
            return;
        }

        // adiciona cliente ao repositorio de clientes se este não constar no mesmo
        if(BancoService.repositorioClientes.procurarClintePeloNumeroIdentificacao(cliente.getIdentificacao().getNumero()) == null)
            BancoService.repositorioClientes.addCliente(cliente);

        Conta conta = new ContaPoupanca(repositorioContas.getNextNumeroConta(), cliente, BancoService.repositorioCartaoDebito.pegarCartao());
        conta.setSaldo(valor);
        repositorioContas.addConta(conta);
        System.out.println("Conta criada com sucesso");
    }

    public static void fazerDeposito(int numeroConta, double valor)
    {
        if(valor <= 0)
        {
            System.out.println("Não é possível depositar este valor");
            return;
        }

        Conta conta = repositorioContas.getConta(numeroConta);
        if(conta == null)
        {
            System.out.println("Conta inexistente");
            return;
        }

        conta.depositarValor(valor);
        System.out.println("Deposito feito com sucesso");
    }

    public static void fazerTransferencia(int numeroContaOrigem, int numeroContaDestino, double valor)
    {
        if(valor <= 0)
        {
            System.out.println("Não é possível transferir este valor");
            return;
        }

        Conta contaOrigem = repositorioContas.getConta(numeroContaOrigem);
        if(contaOrigem == null)
        {
            System.out.println("Conta de origem inexistente");
            return;
        }

        Conta contaDestino = repositorioContas.getConta(numeroContaDestino);
        if(contaOrigem == null)
        {
            System.out.println("Conta de destino inexistente");
            return;
        }

        if(contaOrigem.retirarValor(valor))
        {
            contaDestino.depositarValor(valor);
            System.out.println("Transferência feita com sucesso");
        }
        else
            System.out.println("Erro na transferencia");
    }

    public static void levantarValores(int numeroConta, String numeroIdentificacao, double valor)
    {
        if(valor <= 0)
        {
            System.out.println("Não é possível levantar este valor");
            return;
        }

        Conta conta = repositorioContas.getConta(numeroConta);
        if(conta == null)
        {
            System.out.println("Conta inexistente");
            return;
        }

        // verificando identidade
        if (!(conta.getCliente().getIdentificacao().getNumero().equals(numeroIdentificacao)))
        {
            System.out.println("Permissão não concedida para esta operação");
            return;
        }

        if (conta.retirarValor(valor))
            System.out.println("Levantamento feito, retirado " + valor + " kz");
    }

    public static ContaRepository getRepositorioContas() { return BancoService.repositorioContas; }

    public static ClienteRepository getRepositorioClientes() { return BancoService.repositorioClientes; }

    public static CartaoDebitoRepository getRepositorioCartaoDebito() { return BancoService.repositorioCartaoDebito; }
}
