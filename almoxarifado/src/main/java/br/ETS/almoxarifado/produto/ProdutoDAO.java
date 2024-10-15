package br.ETS.almoxarifado.produto;

import java.lang.reflect.AnnotatedElement;
import java.sql.*;
import java.util.ArrayList;

// DAO - data access object
public class ProdutoDAO {

    private Connection connection;

    public ProdutoDAO(Connection connection){
        this.connection = connection; // para pegar a conexão
    }

    public void salvar(DadosProduto dadosProduto){

        String sql = "INSERT INTO tbmateriaisdiretos(ID, PRODUTO, PARTNUMBER, " +
                "DIVISAO, QUANTIDADE) " +
                "VALUES(?,?,?,?,?)";
        var produto = new Produto(dadosProduto);

        try {

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, dadosProduto.id());
            preparedStatement.setString(2, dadosProduto.produto());
            preparedStatement.setString(3, dadosProduto.partNumber());
            preparedStatement.setString(4, dadosProduto.divisao());
            preparedStatement.setInt(5, dadosProduto.quantidade());

            preparedStatement.execute();

            preparedStatement.close();
            connection.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public ArrayList<Produto> listar(){
        ArrayList<Produto> produtos = new ArrayList<>();
        String sql = "SELECT * FROM tbmateriaisdiretos";

        try {

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                // enquanto houver linhas na tabela, ele vai continuar lendo
                int id = resultSet.getInt(1);
                String nomeProduto = resultSet.getNString(2);
                String partNumber = resultSet.getNString(3);
                String divisao = resultSet.getNString(4);
                int quantidade = resultSet.getInt(5);

                // armazenar os dados
                DadosProduto dadosProduto = new DadosProduto(id, nomeProduto, partNumber, divisao, quantidade);
                Produto produto = new Produto(dadosProduto);
                produtos.add(produto);
            }

            preparedStatement.close();
            connection.close();
            resultSet.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return produtos;

    }

    public Produto listarPorId(int id){
        String sql = "SELECT * FROM tbmateriaisdiretos WHERE ID = ?";
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        Produto produto = null;

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                int numeroId = resultSet.getInt(1);
                String nomeProduto = resultSet.getNString(2);
                String partNumber = resultSet.getNString(3);
                String divisao = resultSet.getNString(4);
                int quantidade = resultSet.getInt(5);

                DadosProduto dadosProduto = new DadosProduto(numeroId, nomeProduto, partNumber, divisao, quantidade);
                produto = new Produto(dadosProduto);
            }

            resultSet.close();
            preparedStatement.close();
            connection.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return produto;
    }

    // tanto para alterar como para adicionar
    public void alterar(int id, int quantidade){
        PreparedStatement preparedStatement;
        String sql = "UPDATE tbmateriaisdiretos SET QUANTIDADE = ? WHERE ID = ?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, quantidade); // primeira interogação é o quant
            preparedStatement.setInt(2, id); // segunda interogação é o id

            preparedStatement.execute();

            preparedStatement.close();
            connection.close();

        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    // deletar os dados
    public void deletar(int id){
        String sql = "DELETE FROM tbmateriaisdiretos WHERE ID = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();

            preparedStatement.close();
            connection.close();

        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
