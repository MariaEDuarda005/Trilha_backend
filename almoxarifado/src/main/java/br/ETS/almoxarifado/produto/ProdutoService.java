package br.ETS.almoxarifado.produto;

import br.ETS.almoxarifado.RegraDaAplicacaoException;
import br.ETS.almoxarifado.connection.ConnectionFactory;

import java.sql.Connection;
import java.util.ArrayList;

public class ProdutoService {

    private ArrayList<Produto> produtos = new ArrayList<>();

    private ConnectionFactory connectionFactory;

    public ProdutoService(){
        this.connectionFactory = new ConnectionFactory();
    }

    public void adicionarNovoProduto(DadosProduto dadosProduto){
        var produto = new Produto(dadosProduto);

        if (produtos.contains(produto)){
            throw new RegraDaAplicacaoException("Já existe um produto com esse id");
        }

        //produtos.add(produto);
        Connection connection = connectionFactory.recuperarConexao();
        new ProdutoDAO(connection).salvar(dadosProduto);
    }

    public ArrayList<Produto> exibirProdutoDoAlmoxarifado(){
        Connection connection = connectionFactory.recuperarConexao();
        return new ProdutoDAO(connection).listar();
    }


    public Produto encontrarProdutoPeloId(int id){
        Connection connection = connectionFactory.recuperarConexao();
        Produto produto = new ProdutoDAO(connection).listarPorId(id);

        if (produto != null){
            return produto;
        } else {
            throw new RegraDaAplicacaoException("Não existe produto com esse ID");
        }
    }

    // atualizar a quantidade do produto
    public void adicionarQuantidadeDeUmProduto(int id, int quantidadeASerAdicionada){
        var produto = encontrarProdutoPeloId(id); // devolvendo a referencia de um objeto que está no array

        if (quantidadeASerAdicionada <= 0){
            throw new RegraDaAplicacaoException("Quantidade a ser adicionada deve ser maior que 0");
        }

        //produto.setQuantidade(produto.getQuantidade() + quantidadeASerAdicionada); // para ele somar e não só atualiazar

        Connection connection = connectionFactory.recuperarConexao();
        new ProdutoDAO(connection).alterar(produto.getId(), produto.getQuantidade() + quantidadeASerAdicionada);
    }

    // remover quantidade, não pode remover numero negativo e não pode remover se for maior que o estoque
    public void removerQuantidadeDeUmProduto(int id, int quantidadeASerRemovida){
        var produto = encontrarProdutoPeloId(id);

        if (quantidadeASerRemovida > produto.getQuantidade()){
            throw new RegraDaAplicacaoException("Não é possivel remover uma quantidade maior que a do estoque");
        }
        if (quantidadeASerRemovida <= 0){
            throw new RegraDaAplicacaoException("A quantidade removida deve ser maior que zero");
        }

        // produto.setQuantidade(produto.getQuantidade() - quantidadeASerRemovida);
        Connection connection = connectionFactory.recuperarConexao();
        new ProdutoDAO(connection).alterar(produto.getId(), produto.getQuantidade() - quantidadeASerRemovida);

    }

    // remover um objeto
    public void removerOProdutoDoAlmoxarifado(int id){
        if (encontrarProdutoPeloId(id) != null){
            Connection connection = connectionFactory.recuperarConexao();
            new ProdutoDAO(connection).deletar(id);
        } else {
            throw new RegraDaAplicacaoException("Não foi encontrado o produto com este ID");
        }
    }

}
