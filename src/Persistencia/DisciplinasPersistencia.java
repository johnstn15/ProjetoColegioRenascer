/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Model.DisciplinasModel;
import Util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Usuario
 */
public class DisciplinasPersistencia {
    
    private Connection conexao;
    
    public DisciplinasPersistencia(){
        conexao = Conexao.getConexao();
    }
    
    private void InserirDisciplinas(DisciplinasModel disciplinasModel){        
        try {
            
            PreparedStatement preparedStatement = conexao.prepareStatement("insert into disciplina (descricao) values (?)");
            preparedStatement.setString(1, disciplinasModel.getDescricao());
            preparedStatement.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }        
    }
    
    private void ExcluirDisciplinas(DisciplinasModel disciplinasModel){
        try{
            
            PreparedStatement preparedStatement = conexao.prepareStatement("");
            //Implementar
            
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
