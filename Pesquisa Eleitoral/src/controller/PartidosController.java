package controller;

import java.util.List;

import dao.PartidosDAO;
import model.Partidos;

public class PartidosController {
	
	public void salvar(Partidos partido) throws Exception{
		if (partido.getNomePartido() == null || partido.getNomePartido().length() < 3) {
			throw new Exception("Nome do Partido não encontrado");
		}
		PartidosDAO.getInstance().salvar(partido);
	}
	
	public void atualizar(Partidos partido) throws Exception{
		if (partido.getNomePartido() == null || partido.getNomePartido().length() < 3) {
			throw new Exception("Partido não identificado");
		}	
		PartidosDAO.getInstance().atualizar(partido);
		
	}
	
	public void excluir(int id_partido) throws Exception{
		if (id_partido == 0) {
			throw new Exception("Partido não identificado");
		}
		PartidosDAO.getInstance().excluir(id_partido);
	}
	
	public List<Partidos> listar(){
		return PartidosDAO.getInstance().listar();
	}
	
}
