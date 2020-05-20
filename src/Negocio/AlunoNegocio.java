/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Model.AlunoModel;
import Persistencia.AlunoPersistencia;
import java.util.List;

/**
 *
 * @author johns
 */
public class AlunoNegocio {
    
   private static final long serialVersionUID = 1L;
   private AlunoPersistencia alunoPersistencia;
   
   public AlunoNegocio(){
       super();
       alunoPersistencia = new AlunoPersistencia();
   }
   
   public void Adicionar(AlunoModel alunoModel) throws Exception{
       alunoPersistencia.InserirAluno(alunoModel);
   }
   
   public void Alterar(AlunoModel alunoModel) throws Exception{
       alunoPersistencia.AtualizarAluno(alunoModel);
   }
   
   public void Remover(AlunoModel alunoModel) throws Exception{
       alunoPersistencia.ExcluirAluno(alunoModel.getMatricula());
   }
   
   public List<AlunoModel> ObterConsulta(){
       return alunoPersistencia.ObterTodosAlunos();
   }
   
   public AlunoModel ObterAlunoPorId(int matricula){
       return alunoPersistencia.ObterAlunoPorId(matricula);
   }
}
