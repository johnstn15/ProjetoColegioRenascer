/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Model.ResponsavelModel;
import Util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author johns
 */
public class ResponsavelPersistencia {

    private Connection conexao;

    public ResponsavelPersistencia() {
        conexao = Conexao.getConexao();
    }

    public void InserirResponsavel(ResponsavelModel responsavelModel) {
        try {
            PreparedStatement preparedStatement
                    = conexao.prepareStatement("insert into responsavel"
                            + "(cpf, firstname, lastname, dob, email, telefone)"
                            + " values (?, ?, ?, ?, ?, ?)");

            preparedStatement.setString(1, responsavelModel.getCpf());
            preparedStatement.setString(2, responsavelModel.getFirstName());
            preparedStatement.setString(3, responsavelModel.getLastName());
            preparedStatement.setDate(4, new java.sql.Date(responsavelModel.getDob().getTime()));
            preparedStatement.setString(5, responsavelModel.getEmail());
            preparedStatement.setString(6, responsavelModel.getTelefone());

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void ExcluirResponsavel(int id) {
        try {
            PreparedStatement preparedStatement = conexao.prepareStatement("delete from responsavel where id=?");

            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void AtualizarResponsavel(ResponsavelModel responsavelModel) {
        try {

            PreparedStatement preparedStatement
                    = conexao.prepareStatement("update responsavel set cpf=?, firstname=?, "
                            + "lastname=?, dob=?, email=?, telefone=? where id=?");

            preparedStatement.setString(1, responsavelModel.getCpf());
            preparedStatement.setString(2, responsavelModel.getFirstName());
            preparedStatement.setString(3, responsavelModel.getLastName());
            preparedStatement.setDate(4, new java.sql.Date(responsavelModel.getDob().getTime()));
            preparedStatement.setString(5, responsavelModel.getEmail());
            preparedStatement.setString(6, responsavelModel.getTelefone());
            preparedStatement.setInt(7, responsavelModel.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<ResponsavelModel> ObterTodosResponsaveis() {
        List<ResponsavelModel> responsaveis = new ArrayList<ResponsavelModel>();

        try {

            Statement statement = conexao.createStatement();
            ResultSet rs = statement.executeQuery("select * from responsavel");

            while (rs.next()) {
                ResponsavelModel responsavelModel = new ResponsavelModel();

                responsavelModel.setId(rs.getInt("id"));
                responsavelModel.setCpf(rs.getString("cpf"));
                responsavelModel.setFirstName(rs.getString("firstname"));
                responsavelModel.setLastName(rs.getString("lastname"));
                responsavelModel.setDob(rs.getDate("dob"));
                responsavelModel.setEmail(rs.getString("email"));
                responsavelModel.setTelefone(rs.getString("telefone"));
                
                responsaveis.add(responsavelModel);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return responsaveis;
    }
    
    public ResponsavelModel ObterResponsavelPorId(int id){
        ResponsavelModel responsavelModel = new ResponsavelModel();

        return responsavelModel;
    }
}
