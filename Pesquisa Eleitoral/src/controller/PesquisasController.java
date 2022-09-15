package controller;

import java.util.List;

import dao.PesquisasDAO;
import model.Pesquisas;

public class PesquisasController {
	
	public void salvar(Pesquisas pesquisa) throws Exception{
		if (pesquisa.getId_Pesquisa() == 0) {
			throw new Exception("Pesquisa não encontrada");
		}
		PesquisasDAO.getInstance().salvar(pesquisa);
	}
	
	public void atualizar(Pesquisas pesquisa) throws Exception{
		if (pesquisa.getId_Pesquisa() == 0) {
			throw new Exception("Pesquisa não identificada");
		}	
		PesquisasDAO.getInstance().atualizar(pesquisa);
		
	}
	
	public void excluir(int id_partido) throws Exception{
		if (id_partido == 0) {
			throw new Exception("Pesquisa não identificada");
		}
		PesquisasDAO.getInstance().excluir(id_partido);
	}
	
	public List<Pesquisas> listar(){
		return PesquisasDAO.getInstance().listar();
	}

}
