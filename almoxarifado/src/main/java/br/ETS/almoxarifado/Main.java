package br.ETS.almoxarifado;

import br.ETS.almoxarifado.produto.DadosProduto;
import br.ETS.almoxarifado.produto.ProdutoService;

import java.util.Scanner;

public class Main {

    private static ProdutoService produtoService = new ProdutoService();
    private static Scanner scanner = new Scanner(System.in);

    private static int exibirMenu(){
        System.out.println("Almoxarifado ETS");
        // print com multiplas linhas
        System.out.println("""
                Selecione um opção:
                1 - Inserir novo produto no almoxarifado
                2 - Listar os produtos no almoxarifado
                3 - Adicionar determinada quantidade de um produto no almoxarifado
                4 - Remover determinada quantidade de um produto no almoxarifado
                5 - Remover produto do almoxarifado
                6 - Encerrar a aplicação
                """);

        return Integer.parseInt(scanner.nextLine());
    }

    public static void main(String[] args) {

        var opcao = exibirMenu();

        while (opcao != 6){
            try{
                switch (opcao){
                    case 1 -> adicionarNovoProduto();
                    case 2 -> exibirProdutosCadastrardos();
                    case 3 -> adiconarQuantidadeProduto();
                    case 4 -> removerQuantidadeProduto();
                    case 5 -> removerProdutoDoAlmoxarifado();
                }
            } catch (RegraDaAplicacaoException e) {
                System.out.println(e.getMessage());
                System.out.println("Pressione ENTER para voltar ao menu principal");
                scanner.nextLine();
            }

            opcao=exibirMenu();
        }


    }

    private static void adicionarNovoProduto(){
        System.out.println("Insira o ID do produto que deseja cadastrar: ");
        var id = Integer.parseInt(scanner.nextLine());
        System.out.println("Insira o nome do produto que deseja cadastrar: ");
        var produto = scanner.nextLine();
        System.out.println("Insira o part number do produto: ");
        var partNumber = scanner.nextLine();
        System.out.println("Insira a divisão do produto: ");
        var divisao = scanner.nextLine();
        System.out.println("Insira a quantidade inicial do produto: ");
        var quantidade = Integer.parseInt(scanner.nextLine());

        produtoService.adicionarNovoProduto(new DadosProduto(id, produto, partNumber, divisao, quantidade));
    }

    private static void exibirProdutosCadastrardos() {
        System.out.println("Os produtos cadastrados são: ");
        var produtos = produtoService.exibirProdutoDoAlmoxarifado();
        produtos.forEach(System.out::println);
        System.out.println("Pressione ENTER para voltar ao menu principal");
        scanner.nextLine();
    }

    private static void adiconarQuantidadeProduto(){
        System.out.println("Informe o id do produto: ");
        var id  = Integer.parseInt(scanner.nextLine());

        System.out.println("Digitar a quantidade que deseja ser adiconado");
        var quantidade = Integer.parseInt(scanner.nextLine());

        produtoService.adicionarQuantidadeDeUmProduto(id, quantidade);

        System.out.printf("A quantidade de %d foi adicionada ao produto com id %d \n", quantidade, id);
        System.out.println("Pressione ENTER para voltar ao menu principal");
        scanner.nextLine();
    }

    private static void removerQuantidadeProduto(){
        System.out.println("Informe o id do produto: ");
        var id  = Integer.parseInt(scanner.nextLine());

        System.out.println("Digitar a quantidade que deseja ser removida");
        var quantidade = Integer.parseInt(scanner.nextLine());

        produtoService.removerQuantidadeDeUmProduto(id, quantidade);

        System.out.printf("A quantidade de %d foi removida ao produto com id %d \n", quantidade, id);
        System.out.println("Pressione ENTER para voltar ao menu principal");
        scanner.nextLine();
    }

    private static void removerProdutoDoAlmoxarifado(){
        System.out.println("Informe o id do produto que voce deseja remover do almoxarifado");
        var id = Integer.parseInt(scanner.nextLine());

        produtoService.removerOProdutoDoAlmoxarifado(id);

        System.out.printf("O produto com id %d foi removido com sucesso \n", id);
        System.out.println("Pressione ENTER para voltar ao menu principal");
        scanner.nextLine();
    }

}