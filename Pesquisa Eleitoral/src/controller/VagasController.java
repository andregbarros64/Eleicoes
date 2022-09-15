package controller;

import java.util.List;

import dao.VagasDAO;
import model.Vagas;

public class VagasController {
	
	public void salvar(Vagas vaga) throws Exception{
		if (vaga.getTipoVaga() == null || vaga.getTipoVaga().length() < 3) {
			throw new Exception("Vaga não encontrado");
		}
		VagasDAO.getInstance().salvar(vaga);
	}
	
	public void atualizar(Vagas vaga) throws Exception{
		if (vaga.getTipoVaga() == null || vaga.getTipoVaga().length() < 3) {
			throw new Exception("Vaga não identificada");
		}	
		VagasDAO.getInstance().atualizar(vaga);
		
	}
	
	
	public void excluir(int id_vaga) throws Exception{
		if (id_vaga == 0) {
			throw new Exception("Vaga não identificada");
		}
		VagasDAO.getInstance().excluir(id_vaga);
	}
	
	public List<Vagas> listar(){
		return VagasDAO.getInstance().listar();
	}
	
}
