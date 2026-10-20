package concessionaria;

public class Principal {

    public static void main(String[] args) {

        Endereco endereco = new Endereco(
                "Rua das Flores",
                "100",
                "Centro",
                "Videira",
                "SC",
                "89560-000"
        );

        Loja loja = new Loja(
                "Concessionaria Central",
                endereco
        );

        SistemaConcessionaria sistema =
                new SistemaConcessionaria(loja);

        sistema.executar();
    }
}
