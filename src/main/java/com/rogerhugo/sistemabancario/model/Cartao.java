package main.java.com.rogerhugo.sistemabancario.model;

public abstract class Cartao
{
    private int numero; // melhorar geração de numero
    private Conta conta;
    private int pin; // melhorar sistema de pin
    private String dataEmissao; // implementar Date
    private String dataValidade; // implementar Date

    public Cartao(int numero, String dataEmissao)
    {
        this.numero = numero;
        this.pin = 1111;
        this.dataEmissao = dataEmissao;
        calcularDataValidade();
    }

    @Override
    public String toString()
    {
        return "Cartao{" +
                "numero=" + numero +
                ", conta=" + conta +
                ", pin=" + pin +
                ", dataEmissao='" + dataEmissao + '\'' +
                ", dataValidade='" + dataValidade + '\'' +
                '}';
    }

    public boolean verificarPin(int pin){ return this.pin == pin; }

    public void calcularDataValidade()
    {
        this.dataValidade = "tres anos depois";
    }

    public int getNumero()
    {
        return numero;
    }

    public void setNumero(int numero)
    {
        this.numero = numero;
    }

    public Conta getConta()
    {
        return conta;
    }

    public void setConta(Conta conta)
    {
        this.conta = conta;
    }

    public String getDataEmissao()
    {
        return dataEmissao;
    }

    public void setDataEmissao(String dataEmissao)
    {
        this.dataEmissao = dataEmissao;
    }

    public String getDataValidade()
    {
        return dataValidade;
    }

    public void setDataValidade(String dataValidade)
    {
        this.dataValidade = dataValidade;
    }
}
