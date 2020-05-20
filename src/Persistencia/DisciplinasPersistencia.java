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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class DisciplinasPersistencia {
    
    private Connection conexao;
    
    public DisciplinasPersistencia(){
        conexao = Conexao.getConexao();
    }
    
    public void InserirDisciplinas(DisciplinasModel disciplinasModel){        
        try {
            
            PreparedStatement preparedStatement = conexao.prepareStatement("insert into disciplina (descricao) values (?)");
            preparedStatement.setString(1, disciplinasModel.getDescricao());
            preparedStatement.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }        
    }
    
    public void ExcluirDisciplinas(int id){
        try{
            
            PreparedStatement preparedStatement = conexao.prepareStatement("delete from displina where id=?");    
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    
    public void AtualizarDisciplinas(DisciplinasModel disciplinasModel){
        try {
            
            PreparedStatement preparedStatement = conexao.prepareStatement("update disciplina set descricao=? where id=?");
            preparedStatement.setString(1, disciplinasModel.getDescricao());
            preparedStatement.setInt(2, disciplinasModel.getId());
            preparedStatement.executeUpdate();
            
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    
    public List<DisciplinasModel> ObterTodasDisciplinas(){
        List<DisciplinasModel> disciplinas = new ArrayList<DisciplinasModel>();
        
        try{
            
            Statement statement = conexao.createStatement();
            ResultSet rs = statement.executeQuery("select * from disciplina");
            
            while (rs.next()){
                DisciplinasModel disciplinasModel = new DisciplinasModel();
                
                disciplinasModel.setId(rs.getInt("id"));
                disciplinasModel.setDescricao("descricao");
                
                disciplinas.add(disciplinasModel);
            }
            
        } catch (SQLException e){
            e.printStackTrace();
        }
        
        return disciplinas;
    }
    
    public DisciplinasModel ObterDisciplinasPorId(int id){
        DisciplinasModel disciplina = new DisciplinasModel();
        
        return disciplina;
    }
}
