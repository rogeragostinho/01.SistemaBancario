package main.java.com.rogerhugo.sistemabancario.model;

public enum TipoIdentificacao
{
    BILHETE_IDENTIDADE("bilhete de identidade"),
    PASSAPORTE("passaporte");

    String descricao;
    TipoIdentificacao(String descricao)
    {
        this.descricao = descricao;
    }

    public String getDescricao() { return this.descricao; }
}
