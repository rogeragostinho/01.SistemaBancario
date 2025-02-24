package main.java.com.rogerhugo.sistemabancario.model;

public class Cliente
{
    private static int contador = 1;
    private int numeroCliente;
    private String nome;
    private TipoIdentificacao tipoIdentificacao;
    private Identificacao identificacao;
    private int telefone;

    public Cliente(String nome, TipoIdentificacao tipoIdentificacao,Identificacao identificacao, int telefone)
    {
        this.numeroCliente = contador++;
        this.nome = nome;
        this.tipoIdentificacao = tipoIdentificacao;
        this.identificacao = identificacao;
        this.telefone = telefone;
    }

    @Override
    public String toString()
    {
        return "Cliente{" +
                "numeroCliente=" + numeroCliente +
                ", nome='" + nome + '\'' +
                ", tIpoIdentificacao=" + tipoIdentificacao.getDescricao() +
                ", identificacao=" + identificacao +
                ", telefone=" + telefone +
                '}';
    }

    public int getNumeroCliente()
    {
        return numeroCliente;
    }

    public void setNumeroCliente(int numeroCliente)
    {
        this.numeroCliente = numeroCliente;
    }

    public String getNome()
    {
        return nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public Identificacao getIdentificacao()
    {
        return this.identificacao;
    }

    public void setBI(Identificacao identificacao)
    {
        this.identificacao = identificacao;
    }

    public int getTelefone()
    {
        return telefone;
    }

    public void setTelefone(int telefone)
    {
        this.telefone = telefone;
    }
}
