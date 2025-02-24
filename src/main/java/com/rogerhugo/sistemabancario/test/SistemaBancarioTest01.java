package main.java.com.rogerhugo.sistemabancario.test;

import main.java.com.rogerhugo.sistemabancario.model.*;
import main.java.com.rogerhugo.sistemabancario.service.BancoService;

public class SistemaBancarioTest01
{
    public static void main(String[] args)
    {
        // conta 1
        Identificacao identificacao1 = new BIlheteIdentidade("01LA02", "23-02-2023", "12-08-2027");
        Cliente cliente1 = new Cliente("Roger Hugo", TipoIdentificacao.BILHETE_IDENTIDADE, identificacao1, 921760220);
        BancoService.abrirContaCorrente(cliente1, 20000);

        // conta 2
        Identificacao identificacao2 = new BIlheteIdentidade("37LA02", "23-02-2023", "12-08-2027");
        Cliente cliente2 = new Cliente("Eren Yeager", TipoIdentificacao.BILHETE_IDENTIDADE, identificacao2, 921760220);
        BancoService.abrirContaPoupanca(cliente2, 90000);

        //Banco.imprimeContas();
        //Banco.imprimeCartoesDebito();

        Conta conta1 = BancoService.getRepositorioContas().getConta(1);
        Conta conta2 = BancoService.getRepositorioContas().getConta(2);

        //Banco.fazerTransferencia(1, 2, 15000);
        //Banco.fazerTransferencia(2, 1, 100000);

        //Banco.levantarValores(1, );

        System.out.println(conta1);
        System.out.println(conta2);
    }
}
