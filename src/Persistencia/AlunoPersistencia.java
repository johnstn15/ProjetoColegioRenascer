/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Model.AlunoModel;
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
public class AlunoPersistencia {
  
    
    private Connection conexao;
    
    public AlunoPersistencia(){
        conexao = Conexao.getConexao();
    }
    
    public void InserirAluno(AlunoModel alunoModel){
        try{
            PreparedStatement preparedStatement = 
                    conexao.prepareStatement("INSERT INTO ALUNOS(cpf, firstName, "
                            + "lastName, dob, email) VALUES (?, ?, ?, ?, ?)");
            
            preparedStatement.setString(1, alunoModel.getCpf());
            preparedStatement.setString(2, alunoModel.getFirstName());
            preparedStatement.setString(3, alunoModel.getLastName());
            preparedStatement.setDate(4, new java.sql.Date(alunoModel.getDob().getTime()));
            preparedStatement.setString(5, alunoModel.getEmail());
            preparedStatement.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void ExcluirAluno(int matricula){
        try{
            PreparedStatement preparedStatement = conexao.prepareStatement("DELETE FROM ALUNOS WHERE matricula=?");
            
            preparedStatement.setInt(1, matricula);
            preparedStatement.executeUpdate();
            
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    
    public void AtualizarAluno(AlunoModel alunoModel){
        try{
            
            PreparedStatement preparedStatement = 
                    conexao.prepareStatement("UPDATE ALUNOS SET cpf=?, firstName=?,"
                            + " lastName=?, dob=?, email=?"
                            + "WHERE matricula=?");
            
            preparedStatement.setString(1, alunoModel.getCpf());
            preparedStatement.setString(2, alunoModel.getFirstName());
            preparedStatement.setString(3, alunoModel.getLastName());
            preparedStatement.setDate(4, new java.sql.Date(alunoModel.getDob().getTime()));
            preparedStatement.setString(5, alunoModel.getEmail());
            preparedStatement.setInt(6, alunoModel.getMatricula());
            preparedStatement.executeUpdate();
            
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    
    public List<AlunoModel> ObterTodosAlunos(){
        List<AlunoModel> alunos = new ArrayList<AlunoModel>();
        
        try {
            
            Statement statement = conexao.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM ALUNOS");
            
            while (rs.next()) {
                AlunoModel alunoModel = new AlunoModel();
                
                alunoModel.setMatricula(rs.getInt("matricula"));
                alunoModel.setCpf(rs.getString("cpf"));
                alunoModel.setFirstName(rs.getString("firstName"));
                alunoModel.setLastName(rs.getString("lastName"));
                alunoModel.setDob(rs.getDate("dob"));
                alunoModel.setEmail(rs.getString("email"));
                
                alunos.add(alunoModel);
            }
            
        } catch (SQLException e){
            e.printStackTrace();
        }
        
        return alunos;
    }
    
    public AlunoModel ObterAlunoPorId(int matricula){
        AlunoModel alunoModel = new AlunoModel();
        
        try {
            
            PreparedStatement preparedStatement = 
                    conexao.prepareStatement("SELECT * FROM ALUNOS WHERE matricula=?");

            preparedStatement.setInt(1, matricula);
            ResultSet rs = preparedStatement.executeQuery();
            
            if (rs.next()){
                alunoModel.setMatricula(rs.getInt("matricula"));
                alunoModel.setCpf(rs.getString("cpf"));
                alunoModel.setFirstName(rs.getString("firstName"));
                alunoModel.setLastName(rs.getString("lastName"));
                alunoModel.setDob(rs.getDate("dob"));
                alunoModel.setEmail(rs.getString("email"));
            }
            
        } catch (SQLException e){
            e.printStackTrace();
        }
        
        return alunoModel;
    }
} 

