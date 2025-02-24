package main.java.com.rogerhugo.sistemabancario.model;
import java.util.List;

public class ContaPoupanca extends Conta
{
    private int numeroSaquesMensaisPossiveis;
    private int numeroTransferenciasMensaisPossiveis;
    private int numeroSaquesMensaisFeitos;
    private int numeroTransferenciasMensaisFeitas;
    private double percentualTaxaJuros;
    private List<Rendimento> rendimentos;

    public ContaPoupanca(int numeroConta, Cliente cliente, CartaoDebito cartaoDebito)
    {
        super(numeroConta, cliente, cartaoDebito);
    }
}
