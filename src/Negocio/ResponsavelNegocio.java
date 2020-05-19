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
    private ResponsavelPersistencia persistencia;

    public ResponsavelNegocio() {
        super();
        persistencia = new ResponsavelPersistencia();
    }

    public void Adicionar(ResponsavelModel responsavelModel) throws Exception {
        persistencia.InserirResponsavel(responsavelModel);
    }

    public void Alterar(ResponsavelModel responsavelModel) throws Exception {
        persistencia.AtualizarResponsavel(responsavelModel);
    }

    public void Remover(ResponsavelModel responsavelModel) throws Exception {
        persistencia.ExcluirResponsavel(responsavelModel.getId());
    }

    public List<ResponsavelModel> ObterConsulta() {
        return persistencia.ObterTodosResponsaveis();
    }

    public ResponsavelModel ObterResponsavelPorId(int id) {
        return persistencia.ObterResponsavelPorId(id);
    }

}
