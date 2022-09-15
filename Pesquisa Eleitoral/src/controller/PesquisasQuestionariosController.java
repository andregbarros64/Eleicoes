package controller;

import java.util.List;

import dao.PesquisasQuestionariosDAO;
import model.PesquisasQuestionarios;

public class PesquisasQuestionariosController {
	
	public void salvar(PesquisasQuestionarios pesquisaQuestionarios) throws Exception{
		if (pesquisaQuestionarios.getId_pesquisaQuestionario() == 0) {
			throw new Exception("Pesquisa não encontrado");
		}
		PesquisasQuestionariosDAO.getInstance().salvar(pesquisaQuestionarios);
	}
	
	public void atualizar(PesquisasQuestionarios pesquisaQuestionarios) throws Exception{
		if (pesquisaQuestionarios.getId_pesquisaQuestionario() == 0) {
			throw new Exception("Pesquisa não identificada");
		}	
		PesquisasQuestionariosDAO.getInstance().atualizar(pesquisaQuestionarios);
		
	}
	
	public void excluir(int id_pesquisaQuestionario) throws Exception{
		if (id_pesquisaQuestionario == 0) {
			throw new Exception("Pesquisa não identificada");
		}
		PesquisasQuestionariosDAO.getInstance().excluir(id_pesquisaQuestionario);
	}
	
	public List<PesquisasQuestionarios> listar(){
		return PesquisasQuestionariosDAO.getInstance().listar();
	}


}
