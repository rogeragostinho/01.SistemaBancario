package main.java.com.rogerhugo.sistemabancario.model;

public class Identificacao
{
    private String numero;
    private String dataEmissao;
    private String dataValidade;

    public Identificacao(String numero, String dataEmissao, String dataValidade)
    {
        this.numero = numero;
        this.dataEmissao = dataEmissao;
        this.dataValidade = dataValidade;
    }

    @Override
    public String toString()
    {
        return "Identificacao{" +
                "numero='" + numero + '\'' +
                ", dataEmissao='" + dataEmissao + '\'' +
                ", dataValidade='" + dataValidade + '\'' +
                '}';
    }

    public String getNumero()
    {
        return this.numero;
    }

    public void setNumero(String numero)
    {
        this.numero = numero;
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
