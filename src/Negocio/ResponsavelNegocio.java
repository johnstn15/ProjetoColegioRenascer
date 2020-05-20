/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Model.ResponsavelModel;
import Persistencia.ResponsavelPersistencia;
import java.util.List;

/**
 *
 * @author johns
 */
public class ResponsavelNegocio {

    private static final long serialVersionUID = 1L;
    private ResponsavelPersistencia responsavelPersistencia;

    public ResponsavelNegocio() {
        super();
        responsavelPersistencia = new ResponsavelPersistencia();
    }

    public void Adicionar(ResponsavelModel responsavelModel) throws Exception {
        responsavelPersistencia.InserirResponsavel(responsavelModel);
    }

    public void Alterar(ResponsavelModel responsavelModel) throws Exception {
        responsavelPersistencia.AtualizarResponsavel(responsavelModel);
    }

    public void Remover(ResponsavelModel responsavelModel) throws Exception {
        responsavelPersistencia.ExcluirResponsavel(responsavelModel.getId());
    }

    public List<ResponsavelModel> ObterConsulta() {
        return responsavelPersistencia.ObterTodosResponsaveis();
    }

    public ResponsavelModel ObterResponsavelPorId(int id) {
        return responsavelPersistencia.ObterResponsavelPorId(id);
    }

}
