
package concessionaria;

import java.util.Scanner;

public class SistemaConcessionaria {

    private Scanner leia;
    private Loja loja;

    public SistemaConcessionaria(Loja loja) {
        this.leia = new Scanner(System.in);
        this.loja = loja;
    }

    public void executar() {
        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\n===== CONCESSIONARIA =====");
            System.out.println("1 - Cadastrar veiculo");
            System.out.println("2 - Listar veiculos");
            System.out.println("3 - Buscar veiculo");
            System.out.println("4 - Atualizar veiculo");
            System.out.println("5 - Remover veiculo");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opcao: ");

            try {
                opcao = Integer.parseInt(leia.nextLine());

                switch (opcao) {
                    case 1:
                        cadastrarVeiculo();
                        break;

                    case 2:
                        listarVeiculos();
                        break;

                    case 3:
                        buscarVeiculo();
                        break;

                    case 4:
                        atualizarVeiculo();
                        break;

                    case 5:
                        removerVeiculo();
                        break;

                    case 0:
                        System.out.println("Sistema encerrado.");
                        break;

                    default:
                        System.out.println("Opcao invalida.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Digite um numero valido.");
            }
        }
    }

    private void cadastrarVeiculo() {
        try {
            System.out.println("\n--- CADASTRAR VEICULO ---");

            System.out.print("ID: ");
            int id = Integer.parseInt(leia.nextLine());

            if (loja.getEstoque().buscar(id) != null) {
                System.out.println("Ja existe um veiculo com esse ID.");
                return;
            }

            System.out.print("Marca: ");
            String marca = leia.nextLine();

            System.out.print("Modelo: ");
            String modelo = leia.nextLine();

            System.out.print("Ano: ");
            int ano = Integer.parseInt(leia.nextLine());

            System.out.print("Preco: ");
            double preco = Double.parseDouble(
                    leia.nextLine().replace(",", ".")
            );

            if (ano <= 0 || preco < 0) {
                System.out.println("Ano ou preco invalido.");
                return;
            }

            Produto produto = new Produto(
                    id, marca, modelo, ano, preco
            );

            loja.getEstoque().inserir(produto);

        } catch (NumberFormatException e) {
            System.out.println("Ano, ID ou preco invalido.");
        }
    }

    private void listarVeiculos() {
        System.out.println("\n--- VEICULOS CADASTRADOS ---");
        loja.getEstoque().listar();
    }

    private void buscarVeiculo() {
        try {
            System.out.println("\n--- BUSCAR VEICULO ---");
            System.out.println("1 - Buscar por ID");
            System.out.println("2 - Buscar por modelo");
            System.out.print("Escolha: ");

            int tipo = Integer.parseInt(leia.nextLine());
            Produto produto = null;

            if (tipo == 1) {
                System.out.print("Digite o ID: ");
                int id = Integer.parseInt(leia.nextLine());
                produto = loja.getEstoque().buscar(id);

            } else if (tipo == 2) {
                System.out.print("Digite o modelo: ");
                String modelo = leia.nextLine();
                produto = loja.getEstoque().buscar(modelo);

            } else {
                System.out.println("Opcao invalida.");
                return;
            }

            if (produto != null) {
                System.out.println("Veiculo encontrado:");
                System.out.println("ID: " + produto.getId());
                System.out.println("Marca: " + produto.getMarca());
                System.out.println("Modelo: " + produto.getModelo());
                System.out.println("Ano: " + produto.getAno());
                System.out.println("Preco: R$ " + produto.getPreco());
            } else {
                System.out.println("Veiculo nao encontrado.");
            }

        } catch (NumberFormatException e) {
            System.out.println("ID invalido.");
        }
    }

    private void atualizarVeiculo() {
        try {
            System.out.println("\n--- ATUALIZAR VEICULO ---");
            System.out.print("Digite o ID do veiculo: ");

            int id = Integer.parseInt(leia.nextLine());
            Produto existente = loja.getEstoque().buscar(id);

            if (existente == null) {
                System.out.println("Veiculo nao encontrado.");
                return;
            }

            System.out.println("Informe os novos dados.");

            System.out.print("Marca: ");
            String marca = leia.nextLine();

            System.out.print("Modelo: ");
            String modelo = leia.nextLine();

            System.out.print("Ano: ");
            int ano = Integer.parseInt(leia.nextLine());

            System.out.print("Preco: ");
            double preco = Double.parseDouble(
                    leia.nextLine().replace(",", ".")
            );

            if (ano <= 0 || preco < 0) {
                System.out.println("Ano ou preco invalido.");
                return;
            }

            Produto atualizado = new Produto(
                    id, marca, modelo, ano, preco
            );

            loja.getEstoque().atualizar(id, atualizado);

        } catch (NumberFormatException e) {
            System.out.println("ID, ano ou preco invalido.");
        }
    }

    private void removerVeiculo() {
        try {
            System.out.println("\n--- REMOVER VEICULO ---");
            System.out.print("Digite o ID do veiculo: ");

            int id = Integer.parseInt(leia.nextLine());

            Produto produto = loja.getEstoque().buscar(id);

            if (produto == null) {
                System.out.println("Veiculo nao encontrado.");
                return;
            }

            System.out.print("Confirma a remocao? (S/N): ");
            String confirmacao = leia.nextLine();

            if (confirmacao.equalsIgnoreCase("S")) {
                loja.getEstoque().remover(id);
            } else {
                System.out.println("Remocao cancelada.");
            }

        } catch (NumberFormatException e) {
            System.out.println("ID invalido.");
        }
    }
}
