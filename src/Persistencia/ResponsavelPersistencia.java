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
import java.sql.SQLException;

/**
 *
 * @author johns
 */
public class ResponsavelPersistencia {
    
    private Connection conexao;
    
    public ResponsavelPersistencia(){
        conexao = Conexao.getConexao();
    }
    
    public void InserirResponsavel(ResponsavelModel responsavelModel){
        try{
            PreparedStatement preparedStatement = 
                    conexao.prepareStatement("insert into responsavel"
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
}
